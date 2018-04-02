package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
 private String genString(int length){
	 
	 return UUID.randomUUID().toString().replaceAll("_", "").substring(0, length);
 }
	
	public String genPassword(){
		return genString(6);
	}
	public String genToken(){
		return genString(8);
	}
}
