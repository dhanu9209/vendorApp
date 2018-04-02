package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.VDMSUser;
import com.app.service.IUserService;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.EmailUtil;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private CodeUtil codeUtil;
	
	@Autowired
	private CodecUtil codecUtil;
	
	@Autowired 
	private EmailUtil emailUtil;
	
	
	 @RequestMapping("/register")
		public String showUserLogin(){
			return "userRegister";
		}
	 
	 
	 @RequestMapping(value="/registerUser",method=RequestMethod.POST)
	 public String registerUser(@ModelAttribute("vDMSUser")VDMSUser user,ModelMap map){
		 
		 String pwd=codeUtil.genPassword();
				 
		 user.setPassword(codecUtil.doEncode(pwd));
		 try {
			userService.saveUser(user);
			
			if (user.getUserId()>0) {
				emailUtil.sendMail(user.getEmail(), "User Registed with VDMS as admin ", "dear sir/madam \n your user "
						+ "name is : "+user.getEmail() +"  \n your password is : "+pwd); 
				
				
				map.addAttribute("msgId", "success");
				map.addAttribute("msg", "User Register with Id:"+user.getUserId());
				
			}else{
				
					map.addAttribute("msgId", "warning");
					map.addAttribute("msg", "User not registered properly");
				
			}
			
		} catch (Exception e) {
			map.addAttribute("msgId", "warning");
			map.addAttribute("msg", "User id alaready exit");
		}
		 
		
		 
		 
		 return"userRegister";
	 }
	 
	 
	 
	 
}
