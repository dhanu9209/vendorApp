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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Location;
import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.EmailUtil;
import com.app.util.LocationUtil;
import com.app.util.VendorUtil;

@Controller
public class VendorController {
	@Autowired
	private IVendorService ivendorsvc;
	@Autowired
	private LocationUtil locutil;
	@Autowired
	private VendorUtil vendorUtil;
	@Autowired
	private ServletContext context;
	@Autowired
	private EmailUtil emailUtil;
	
	
	
	
	@RequestMapping("/venReg")
	public String showVendorReg(ModelMap map){
		List<Location> loclist=locutil.getAllLocations();
		map.addAttribute("loclistObj", loclist);
		return "vendorReg";
	}
	
	@RequestMapping(value="/insertVendor",method=RequestMethod.POST)
	public String saveVendorData(@ModelAttribute("vendor")Vendor vend,ModelMap map,@RequestParam("document")CommonsMultipartFile file){
		map.addAttribute("msg", "Vendor Data Added successsfully of Id :"+ivendorsvc.saveVendor(vend));
		List<Location> loclist=locutil.getAllLocations();
		map.addAttribute("loclistObj", loclist);
		
		boolean status=emailUtil.sendMail(vend.getVendorMail(), "Vendor Registration Process", "welcome to vendor management app .. Your vendor id is"+vend.getVendorId(), file);
		//System.out.println("*********************************"+status+"**************************8888");
		return "vendorReg";
	}
	
	
	@RequestMapping(value="/showAllVen")
	public String showAllenData(ModelMap map){
		map.addAttribute("venList", ivendorsvc.getAllVendors());
		return "vendorData";
	}
	
	@RequestMapping(value="/deleteVen")
	public String DeleteVendor(@RequestParam("venid")int venId,ModelMap map){
		ivendorsvc.deleteVendorById(venId);
		map.addAttribute("msg", "Vendor Data delete successsfully of Id :"+venId);	
		map.addAttribute("venList", ivendorsvc.getAllVendors());
		return "vendorData";
	}
	
	@RequestMapping(value="/editVen")
	public String editVendor(@RequestParam("venid")int venId,ModelMap map){
		Vendor ven=ivendorsvc.getVendorById(venId);
		map.addAttribute("venObject", ven);
		List<Location> loclist=locutil.getAllLocations();
		map.addAttribute("loclistObj", loclist);
		return "vendorDataEdit";
	}
	@RequestMapping(value="/updateVen",method=RequestMethod.POST)
	public String Deleteendor(@ModelAttribute("vendor")Vendor vendor,ModelMap map){
		ivendorsvc.updateVendor(vendor);
		map.addAttribute("msg", "Vendor Data updated successsfully of Id :"+vendor.getVendorId());	
		map.addAttribute("venList", ivendorsvc.getAllVendors());
		return "vendorData";
	}
	 @RequestMapping(value="/venReport")
	 public String showReports(){
		 List<Object[]> loclist=ivendorsvc.getVendorTypewiseount();
		 String path=context.getRealPath("/");
		 vendorUtil.createAndSavePieChart(path, loclist);
		 vendorUtil.createAndSaveBarChart(path, loclist);
		 return "vendorReport";
	 }
	 
}
