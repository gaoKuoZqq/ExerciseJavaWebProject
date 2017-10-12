package com.mall.front.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mall.pojo.Cart;
import com.mall.pojo.Location;
import com.mall.pojo.Order;
import com.mall.pojo.Order_item;
import com.mall.pojo.Product;
import com.mall.pojo.Shipping;
import com.mall.service.CartService;
import com.mall.service.LocationService;
import com.mall.service.OrderService;
import com.mall.service.Order_itemService;
import com.mall.service.ProductService;
import com.mall.service.ShippingService;
import com.mall.service.UserService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Resource(name="cartService")
	CartService cartService;
	@Resource(name="locationService")
	LocationService locationService;
	@Resource(name="userService")
	UserService userService;
	@Resource(name="shippingService")
	ShippingService shippingService;
	@Resource(name="productService")
	ProductService productService;
	@Resource(name="orderService")
	OrderService orderService;
	@Resource(name="order_itemService")
	Order_itemService order_itemService;
	
	@RequestMapping("goadd")
	public ModelAndView goAddOrder(String cart_ids,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		if (cart_ids == null || cart_ids.trim().equals("")) {
			modelAndView.setViewName("redirect:/home/gohome.shtml");
			return modelAndView;
		}
		//添加该用户的收货地址
		HttpSession session = request.getSession(true);
		if (session.getAttribute("username") == null) {
			modelAndView.setViewName("login");
			return modelAndView;
		}
		String username = (String) session.getAttribute("username");
		Integer user_id = userService.queryUser_idByUsername(username);
		List<Shipping> shippingsList = shippingService.findShippingByUser_id(user_id);
		modelAndView.addObject("shippingsList",shippingsList);
		
		String[] idsList = cart_ids.split(" ");
		Set<Integer> cart_idsSet = new HashSet<Integer>();
		for (String idStr : idsList) {
			cart_idsSet.add(Integer.parseInt(idStr));
		}
		//添加已被勾选的cart,这里还要考虑一下再service使用循环是否合理
		List<Cart> cartsList = cartService.findCartByCartIdSet(cart_idsSet);
		//因为展示需要,往里面塞了个product,但是同时塞了很多没用的东西,因为懒
		Double payment = 0.0;
		for (Cart cart : cartsList) {
			Product product = productService.findProductById(cart.getProduct_id());
			payment = payment + product.getPrice() * cart.getQuantity();
			cart.setProduct(product);
		}
		modelAndView.addObject("payment",payment);
		modelAndView.addObject("cartsList",cartsList);
		//在这里添加省份表,用以添加收货地址,也可以在点击添加时ajax,但是数据量较小,直接传过去了
		List<Location> provinceslist = locationService.findProvince();
		modelAndView.addObject("provinceslist",provinceslist);
		
		//把cart_ids发过去,下面的add还要用
		modelAndView.addObject("cart_ids",cart_ids);
		
		modelAndView.setViewName("order");
		return modelAndView;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ModelAndView addOrder(String cart_ids,Integer shipping_id,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		//检验登录状态
		if (session.getAttribute("username") == null) {
			modelAndView.setViewName("login");
			return modelAndView;
		}
		if (cart_ids == null || cart_ids.trim().equals("") || 
				shipping_id == null) {
			modelAndView.setViewName("redirect:/home/gohome.shtml");
			return modelAndView;
		}
		//先搞一个order
		Order order = new Order();
		//得到用户id
		String username = (String) session.getAttribute("username");
		Integer user_id = userService.queryUser_idByUsername(username);
		//生成订单号
		String order_no = UUID.randomUUID().toString().replace("-", "");
		
		//获得所选商品id,得到cart列表,根据数量计算总价
		String[] idsList = cart_ids.split(" ");
		Set<Integer> cart_idsSet = new HashSet<Integer>();
		for (String idStr : idsList) {
			cart_idsSet.add(Integer.parseInt(idStr));
		}
		List<Cart> cartsList = cartService.findCartByCartIdSet(cart_idsSet);
		Double payment = 0.0;
		//生成order_item
		Order_item order_item = new Order_item();
		for (Cart cart : cartsList) {
			Product product = productService.findProductById(cart.getProduct_id());
			//设置order_item的内容并添加
			order_item.setOrder_no(order_no);
			order_item.setUser_id(user_id);
			order_item.setProduct_id(product.getId());
			order_item.setProduct_name(product.getName());
			order_item.setProduct_image(product.getMain_image());
			order_item.setCurrent_unit_price(product.getPrice());
			order_item.setQuantity(cart.getQuantity());
			order_item.setTotal_price(product.getPrice() * cart.getQuantity());
			order_itemService.addOrder_item(order_item);
			//计算order总金额
			payment = payment + product.getPrice() * cart.getQuantity();
			
			//生成订单完成后,product.stock减去对应数量,product废物利用
			product.setStock(product.getStock() - cart.getQuantity());
			productService.modifyProductStock(product);
			
			//删除对应cart
			cartService.deleteCart(cart.getId());
		}
		order.setUser_id(user_id);
		order.setOrder_no(order_no);
		order.setShipping_id(shipping_id);
		order.setPayment(payment);
		order.setPayment_type(1);
		order.setPostage(0);//暂时不考虑运费
		order.setStatus(10);
		Boolean isSuccess = orderService.addOrder(order);
		if (isSuccess) {
			//把总金额和收货地址发送到付款成功界面
			modelAndView.addObject("payment",payment);
			Shipping shipping = shippingService.findShippingById(shipping_id);
			modelAndView.addObject("shipping",shipping);
			modelAndView.setViewName("payment_success");
		}else{
			modelAndView.setViewName("home");
		}
		return modelAndView;
	}
}
