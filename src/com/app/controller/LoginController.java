package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.VDMSUser;
import com.app.service.IUserService;
import com.app.util.CodecUtil;

@Controller
public class LoginController {
	@Autowired
	private IUserService userservice;
	@Autowired
	private CodecUtil codecUtil;
	
    @RequestMapping("/login")
	public String showUserLogin(){
		return "userLogin";
	}
	
    @RequestMapping(value="/loginUser",method=RequestMethod.POST)
   	public String loginUser(@RequestParam("userName")String userName,@RequestParam("password") String passsword,ModelMap map,HttpServletRequest req){
    	
    	String pageName=null;
		VDMSUser user=userservice.getUserByUsername(userName);
		if (user!=null ) {
			if( !passsword.equalsIgnoreCase(codecUtil.doDecode(user.getPassword()))){
				map.addAttribute("msg","UserName or password is invalid..");
				pageName="userLogin"; 
				map.addAttribute("msgId","warning");
			}else{
				//create http Session
				HttpSession ses=req.getSession();
				ses.setAttribute("username", user.getUserName());
				pageName="locationReg";
			}
		}else{
			map.addAttribute("msg","UserName  is invalid..");
			map.addAttribute("msgId","error");
			pageName="userLogin";
			
		}
		
   		return pageName;
   	}
    
  //5. logout
  	@RequestMapping("/logout")
  	public String userLogout(HttpServletRequest req,ModelMap map){
  		HttpSession ses=req.getSession(false);
  		ses.setAttribute("username", null);
  		ses.invalidate();
  		map.addAttribute("msg","Logout successful");
  		map.addAttribute("msgId","info");
  		return "userLogin";
  	}

    
    
    
    
}
