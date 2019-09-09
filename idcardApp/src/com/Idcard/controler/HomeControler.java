package com.Idcard.controler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Idcard.bean.StudentBean;
import com.Idcard.services.StudentService;
import com.Idcard.services.StudentServiceImpl;

@Controller
public class HomeControler {

	@Autowired
	StudentService service;

	public HomeControler() {
		System.out.println(" in HC -> no arg constructor");
	}

	@RequestMapping({ "/InputDetails", "/" })
	public String showInput(Model model) {
		System.out.println("in HC -> show input");
		model.addAttribute("student", new StudentBean());

		return "InputDetails";
	}

	@RequestMapping("/Mydetails")
	public String ShowDetails(@ModelAttribute("student") @Valid StudentBean bean, BindingResult result, Model model) throws 
	Exception {

		System.out.println(bean.getName() + bean.getFname() + bean.getMname() + bean.getAdd());

		System.out.println("-----------" + result.hasErrors() + "-----------" + result.toString());
		if (result.hasErrors()) {
			// bean.setStatus("Failed");
			model.addAttribute("status", "Failed");
			return "InputDetails";
		} else {
			
			System.out.println(bean.getFile());
			System.out.println("Inside else--------------");
			String createStudent = service.createStudent(bean);
			//geting image path
			
			/*String rootpath = System.getProperty("catalina.home")+ File.separator+"images";
			
			File image = new File(rootpath, URLDecoder.decode(bean.getFileName(),"UTF-8"));
			model.addAttribute("imagepath", image);
			*/
			//System.out.println("-----------------------------"+image);
			/*String file_path= "C:/Users/Adarsh J/Music/NewWorkspace/StudentIdCardApp/WebContent/resources/images/"+bean.getFileName();
			
			FileOutputStream fos = new FileOutputStream("C:/Users/Adarsh J/Music/NewWorkspace/StudentIdCardApp/WebContent/resources/images/"+bean.getFileName());
			StudentServiceImpl s1 = new StudentServiceImpl();
			s1.resizeImage(file_path, bean.getFileName());
		    fos.write(bean.getImage());
		    fos.close();*/
			
			
			model.addAttribute("status", "Sucess");
			model.addAttribute("crud", "Registration");
			return "showdetails";
		}

	}

	@RequestMapping("/AllDetails")
	public ModelAndView ShowDetails() {

		String view;
		List<StudentBean> alldetails = service.getAllStudents();

		if (alldetails.size() <= 0) {
			System.out.println("---------------------------Inside All details IF");
			view = "InputDetails";
			return new ModelAndView(view, "student", new StudentBean());
		} else {

			System.out.println("---------------------------Inside All details  Else");
			view = "AllDetails";
			return new ModelAndView(view, "student", alldetails);
		}

	}
	
	@RequestMapping("/Delete")
	public String deleteStudent(Long sl, Model model){
		
		String deleteStudent = service.deleteStudent(sl);
		model.addAttribute("status", "Sucess");
		model.addAttribute("crud", "Delete");
		return"Success";
		
	}
	
	@RequestMapping("/Edit")
	public String editStudent(Long sl, Model model){
		
		StudentBean student = service.getStudent(sl);
		model.addAttribute("student", student);
		model.addAttribute("delete_status", "Sucess");
		return"Edit";
		
	}
	
	@RequestMapping("/Update")
	public String updateStudent(@ModelAttribute("student") @Valid StudentBean bean, BindingResult result, Model model) {

		
		System.out.println(bean.getName() + bean.getFname() + bean.getMname() + bean.getAdd() + bean.getSl());

		System.out.println("-----------" + result.hasErrors() + "-----------" + result.toString());
		if (result.hasErrors()) {
			// bean.setStatus("Failed");
			model.addAttribute("status", "Failed");
			return "Edit";
		} else {
			System.out.println("Inside else--------------");
			System.out.println("This is being updates   "+bean);
			service.editStudent(bean);
			model.addAttribute("status", "Sucess");
			model.addAttribute("crud", "Update");
			return "showdetails";
		}

	}
	
	
	@RequestMapping("/PrintCard")
	public ModelAndView StudentDetailsViewOnly() {

		String view;
		List<StudentBean> alldetails = service.getAllStudents();

		if (alldetails.size() <= 0) {
			System.out.println("---------------------------Inside All details IF");
			view = "InputDetails";
			return new ModelAndView(view, "student", new StudentBean());
		} else {

			System.out.println("---------------------------Inside All details  Else");
			view = "PrintView";
			return new ModelAndView(view, "student", alldetails);
		}

	}
	
	


}
