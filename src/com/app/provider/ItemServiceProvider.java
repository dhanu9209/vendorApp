package com.app.provider;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/item")
public class ItemServiceProvider {
	
	@Autowired
	private ICustomerService custService;
	@Autowired
	private CustomerValidator CustomerValidator;
	@Autowired
	private IItemService iItemService; 
	
	
	@Autowired
	private JsonUtil JsonUtil;
	
	@Path("/saveItem")
	@POST
	public String saveItem(@HeaderParam("userName") String userName,@HeaderParam("password") String password,@HeaderParam("acessToken") String token,String jsonItem){
		/** null or emptyness check for inputs */
		Customer customer;
		try {
			if(userName==null || "".equals(userName.trim())){
				return "UserName can't be empty";
			}
			
			 if(password==null || "".equals(password.trim())){
				return "Password can't be empty";
			}
			 
			 if(token==null || "".equals(token.trim())){
				return "Access Token can't be empty";
			}
			 
			 if(jsonItem==null || "".equals(jsonItem.trim())){
					return "JsonItem data can't be empty";
				}
			 
			customer=custService.getcustomerByEmail(userName);
			
			if(customer!=null ){
				
	         if((CustomerValidator.isPasswordAndTokenIsValid(password, token, customer))==true){
	        	 
	        	 if((CustomerValidator.isCustTypeSeller(customer))==true){
	        		 
	        		 Item item=(Item)JsonUtil.convertJsonToObject(jsonItem, Item.class);
	        		 if (item!=null) {
						
	        			 item.setCustomer(customer);
	        			 
	        			 if(iItemService.saveitem(item)>0){
	        				 return "Item saved successfully with ItemId :"+item.getItemId();
	        			 }else{
	        				 return "Item is not saved";
	        			 }
	        			 
					}else{
						return "Given Json format is not correct ";
					}
	        		 
	        		 
	        	 }else{
	        		 return "Given Customer is not seller";
	        	 }
	        	 
	        	 
	         }else{
	        	 return "Given Password,Access Token is not valid";
	         }
				
				
				
				
				
			}else{
				return "With given UserName User is not exit in the System";
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return "done";
	}
}
