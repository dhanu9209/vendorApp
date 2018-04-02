package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.EmailUtil;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService icustService;
	@Autowired
	private IItemService iItemService;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CodecUtil codecUtil;
	@Autowired
	private EmailUtil emailUtil;
	
	@RequestMapping("/showCustReg")
	public String showCustomerReg(){
		return"customerReg";
	}
	@RequestMapping(value="/insertust",method=RequestMethod.POST)
	public String insertCustomerData(@ModelAttribute("customer") Customer cust,ModelMap modelmap){
	
		String password=codeUtil.genPassword();
		String token=codeUtil.genToken();	
		cust.setPassword(codecUtil.doEncode(password));
		cust.setAccTock(codecUtil.doEncode(token));
		
		int custId=icustService.saveCustomer(cust);
		modelmap.addAttribute("msg", "Customer data saved successfully with Id :"+custId);
		boolean status= emailUtil.sendMail(cust.getCustaMail(), "You Are Register as a("+cust.getCustType()+")", "  Your customer Id :"+cust.getCustId()+" user name :"+cust.getCustaMail()+" Password :"+password+" Access Token :"+token);
		return "customerReg";
	}

	
//	writing anchor  method to show all the  custmordata
//	by using anchor tag
	@RequestMapping("/showCusts")
	public String showAllCustomers(ModelMap modelMap){
		List<Customer> custlist=icustService.getAllCustomers();
		modelMap.addAttribute("custListObj", custlist);
		return "customerData";
	}
	
	//delete customer data method by sending the delete success message also
	@RequestMapping("/deleteCust")
	public String deleteCustomerRecord(@RequestParam("cusid")int custId ,ModelMap modelMap){
		icustService.deleteCustomerById(custId);
		modelMap.addAttribute("msg", "Customer data deleted, Id of :"+custId);
		List<Customer> custlist=icustService.getAllCustomers();
		modelMap.addAttribute("custListObj", custlist);
		return"customerData";
	}
	
	@RequestMapping("/editCust")
	public String editCustomer(@RequestParam("cusid")int custId ,ModelMap modelMap){
		Customer customer=icustService.getCustomerById(custId);
		modelMap.addAttribute("custObj", customer);
		return"customerDataEdit";
	}
	@RequestMapping("/updateCust")
	public String updateCustomerData(@ModelAttribute("customer") Customer cust,ModelMap modelmap){
		icustService.updateCustomer(cust);
		modelmap.addAttribute("msg", "Customer data updated successfully with Id :"+cust.getCustId());
		List<Customer> custlist=icustService.getAllCustomers();
		modelmap.addAttribute("custListObj", custlist);
		return "customerData";
	}
	
	@RequestMapping("/showCustItems")
	public String showCustomerItems(@RequestParam("cusid")int custId,ModelMap modelMap){
		List<Item> itemList=iItemService.getItemsByCustId(custId);
		modelMap.addAttribute("itemListObj", itemList);
		return "custItems";
	}
	
	
}
