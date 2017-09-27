package com.mall.controller.back;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mall.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	@Resource(name="studentService")
	StudentService studentService;
	@RequestMapping(value="/test")
	public ModelAndView test(){
		System.out.println("Test.testInclude()");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("back/test");
		System.out.println(studentService.test());
		return modelAndView;
	}
}
