package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.EmailUtil;
import com.app.util.LocationUtil;


@Controller
public class LocationController {
	@Autowired
 private ILocationService ilocservice;
 @Autowired
	private ServletContext context;
 @Autowired
	private LocationUtil locUtil;
 @Autowired
private  EmailUtil emailUtil;
// show location 
// controller
	@RequestMapping("/showlocReg")
	public String showRegPage(){
//		boolean status=emailUtil.sendMail("dhanu9209@gmail.com", "Vendor Registration Process", "welcome to vendor management app .. Your vendor id is", null);
//		System.out.println("*********************************"+status+"**************************8888");
		return "locationReg";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveLocation(@ModelAttribute("location")Location loc,ModelMap map)
	{
		
		try {
			ilocservice.saveLocation(loc);
			map.addAttribute("msg","save done of Id:"+loc.getLocId());
			map.addAttribute("msgId", "success");
		} catch (Exception e) {
			e.getMessage().contains("ConstraintViolationException");
			map.addAttribute("msg","Location Id is already exit");
			map.addAttribute("msgId", "warning");
			
		}
		return "locationReg";	
	}
	
/** 3. get all the recorde by using ht.loadAll method()
 * 
 * 
 */
	@RequestMapping("/showLocs")
	public String showAllLocations(ModelMap modelmap){
		List<Location> locList=ilocservice.getAllLocations();
		modelmap.addAttribute("listObj", locList);
		return "LocationData";
	}
	
	
	/** 4 delete location method 
	 */
	 @RequestMapping("/deleteLoc")
	public String deleteLocation(@RequestParam("locid") int locId,ModelMap map){
		 ilocservice.deleteLocation(locId);
		 map.addAttribute("msg","delete done of Id :"+locId);
			map.addAttribute("listObj", ilocservice.getAllLocations());
			return "LocationData";
	 }	
	
	 @RequestMapping("/editLoc")
	 public String editLocation(@RequestParam("locid") int locId,ModelMap map){
		 Location location=ilocservice.getLocationById(locId);
		 map.addAttribute("locObj",location);
		return "locationDataEdit";
	}
	 
	 @RequestMapping(value="/updateLoc",method=RequestMethod.POST)
		public String updateLocation(@ModelAttribute("location")Location loc,ModelMap map)
		{
			ilocservice.updateLocation(loc);
			map.addAttribute("msg","Location is updated of  Id :"+loc.getLocId());
			map.addAttribute("listObj", ilocservice.getAllLocations());
			return "LocationData";
		}
	 @RequestMapping(value="/deletelLoc",method=RequestMethod.POST)
	 public String deleteSelectedLocation(@RequestParam("multi")List<Integer> vars,ModelMap map ){
		 for (Integer locd : vars) {
			ilocservice.deleteLocation(locd);
		}
		 List<Location> locList=ilocservice.getAllLocations();
		map.addAttribute("listObj", locList);
		 map.addAttribute("msg", "Selected Locations are deleted");
		 return "LocationData";
	 }
	 
	 
	 // this method is to export excel when clicking  anchor tag in show location data page 
	 
	 @RequestMapping(value="/locExportExcel")
	 public String exportExcel(ModelMap map){
		 List<Location> locList=ilocservice.getAllLocations();
		 map.addAttribute("locList", locList);
		 return "locExportExcel";
	 }
	 
	 
	 @RequestMapping(value="/locExportPDF")
	 public String exportPdf(ModelMap map){
		 List<Location> locList=ilocservice.getAllLocations();
		 map.addAttribute("locList", locList);
		 return "locExportPDF";
	 }
	 
	 
	 @RequestMapping(value="/locReport")
	 public String showReports(){
		 List<Object[]> loclist=ilocservice.getLocWiseCount();
		 String path=context.getRealPath("/");
		 locUtil.createPieChart(path, loclist);
		 locUtil.createBarChart(path, loclist);
		 return "locationReport";
	 }
	 
	 
	 
}
