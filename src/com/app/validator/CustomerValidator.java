package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.util.CodecUtil;

@Component
public class CustomerValidator {
	@Autowired
	private CodecUtil codecUtil;
	public boolean isPasswordAndTokenIsValid(String reqPassword,String reqToken,Customer customer){
return reqPassword.equalsIgnoreCase(codecUtil.doDecode(customer.getPassword())) && reqToken.equalsIgnoreCase(codecUtil.doDecode(customer.getAccTock()));
	}
	public boolean isCustTypeSeller(Customer customer){
		return customer.getCustType().equalsIgnoreCase("Seller");
	}
	public boolean isCustTypeConsumer(Customer customer){
		return customer.getCustType().equalsIgnoreCase("consumer");
	}

}
