package com.app.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;


@Component
public class CodecUtil {
	public String doEncode(String nrmlString){
		byte[] array=Base64.encodeBase64(nrmlString.getBytes());
		return new String(array);
	}
	public String doDecode(String encString){
		byte[] array=Base64.decodeBase64(encString.getBytes());
		return new String(array);
	}
}
