package com.mall.pojo;

import java.sql.Date;

public class Order_item {
	Integer id;//订单子表id
	Integer user_id;
	String order_no;//订单号
	Integer product_id;//商品id
	String product_name;
	String product_image;//商品图片地址
	double current_unit_price;//生成订单时的商品单价
	Integer quantity;//数量
	double total_price;//总价
	//这里我直接使用了java.sql的Date,构造方法有改动,添加了java.util.Date的set
	Date create_time;
	Date update_time;
	public Order_item() {
		super();
	}
	public Order_item(Integer id, Integer user_id, String order_no, Integer product_id, String product_name,
			String product_image, double current_unit_price, Integer quantity, double total_price, java.util.Date create_time,
			java.util.Date update_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.order_no = order_no;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.current_unit_price = current_unit_price;
		this.quantity = quantity;
		this.total_price = total_price;
		this.create_time = new Date(create_time.getTime());
		this.update_time = new Date(update_time.getTime());
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public double getCurrent_unit_price() {
		return current_unit_price;
	}
	public void setCurrent_unit_price(double current_unit_price) {
		this.current_unit_price = current_unit_price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	//写一个用来设置时间的方法,是俩
	public void setCreate_time_javaUtil(java.util.Date create_time) {
		this.create_time = new java.sql.Date(create_time.getTime());
	}
	public void setUpdate_time_javaUtil(java.util.Date update_time) {
		this.update_time = new java.sql.Date(update_time.getTime());
	}
}
