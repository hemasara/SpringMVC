package com.hema.logistics.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hema.ProjectService;
import com.hema.logistics.model.Logistics;
import com.hema.logistics.model.Project;

@Controller
public class LogisticsController {
	
	@Autowired 
	ProjectService ps;
	
	@RequestMapping(value="/findAll")
	public ModelAndView displayAllLogisticsDetails(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alllogistics");
		mv.addObject("listlogistics",ps.getLogisticCollection());
		return mv;
	}
	
	@RequestMapping(value="/show")
	@ResponseBody
	public String getShow(){
		return "Welcome to Spring MVC";
	}
	

	@RequestMapping(value="/index")
	public String getIndex(){
		return "index";
	}
	
	@RequestMapping(value="/URITemplate/{logName}")
	public String getURITemplate(@PathVariable(value="logName") String logNameHema){
		System.out.println(logNameHema);
		return "index";
	}
	
	@RequestMapping(value="/URITemplateMV/{logName}")
	public ModelAndView getURITemplateMV(@PathVariable(value="logName") String logNameHema){
		/*System.out.println(logNameHema);*/
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index");
		mv.addObject("logisticsName", logNameHema);
		
		return mv;
	}
	
	@RequestMapping(value="/findLogistic/{logId}")
	public ModelAndView findLogistic(@PathVariable(value="logId") String logisticId){
		/*System.out.println(logNameHema);*/
		
		Logistics l1 = new Logistics(101, "Hathway", 101.1f);
		Logistics l2 = new Logistics(102, "Amazon", 102.1f);
		Logistics l3 = new Logistics(103, "Fireway", 103.1f);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("findlogistics");
		switch (Integer.parseInt(logisticId)) {
		case 101:
			mv.addObject("logisticData", l1);
			break;			
		case 102:
			mv.addObject("logisticData", l2);
			break;			
		case 103:
			mv.addObject("logisticData", l3);
			break;
		default:
			break;
		}
				
		return mv;
	}
	
	@RequestMapping(value="/open", method=RequestMethod.GET)
	public String addProject(){
		return  "addProject";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public ModelAndView saveProject(){
		ModelAndView mv = new ModelAndView("addSpringProject", "project", new Project(1,"h","m",new BigDecimal(12),2));
		return  mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String submitProject(@ModelAttribute Project project){
		boolean b = ps.saveProject(project);
		System.out.println(project.toString());
		return  "addSpringProject";
	}
	

	
}
