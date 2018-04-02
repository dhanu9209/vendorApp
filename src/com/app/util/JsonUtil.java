package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {
public String convetObjectToJSon(Object Obj){
	String json=null;
	try {
		ObjectMapper om= new ObjectMapper();
		json=om.writeValueAsString(Obj);
	} catch (Exception e) {
		System.out.println(e);
	}
	return json;
}

public Object convertJsonToObject(String json,Class cls){
	Object obj=null;
	try {
		ObjectMapper om=new ObjectMapper();
		obj=om.readValue(json, cls);
		
	} catch (Exception e) {
		System.out.println(e);
	}
	return obj;
}

}
