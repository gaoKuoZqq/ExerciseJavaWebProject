package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.PageBean;
import service.StudentService;
import vo.Vo;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@RequestMapping("find")
	public ModelAndView findStudentsPage() {
		PageBean pageBean = new PageBean();
		pageBean.setPageIndex(1);
		pageBean.setPageSize(30);
		pageBean.setLimitStart((pageBean.getPageIndex() - 1) * pageBean.getPageSize());
		ModelAndView modelAndView = new ModelAndView("home");
		pageBean = studentService.findStudentPage(pageBean);
		return modelAndView;
	}
	@RequestMapping("list")
	@ResponseBody
	public Vo StidentsList(Integer page,Integer rows,PageBean pageBean) {
		Vo vo = new Vo();
		if (page < 1) {
			page = 1;
		}
		pageBean.setPageIndex(page);
		pageBean.setPageSize(rows);
		pageBean.setLimitStart((pageBean.getPageIndex() - 1) * pageBean.getPageSize());
		pageBean = studentService.findStudentPage(pageBean);
		vo.setTotal(pageBean.getTotalObjects());
		vo.setRows(pageBean.getObjectsList());
		/*ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		StringWriter stringWriter = new StringWriter();
	    try {
			objectMapper.writeValue(stringWriter, vo);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return vo;
	}
}
