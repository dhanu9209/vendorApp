package com.app.util;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class EmailUtil {
 @Autowired
	private JavaMailSender mailsender;
 
 public boolean sendMail(String toAdd,String subject,String text, final CommonsMultipartFile file ){
	 boolean status=false;
	
	 try {
		 MimeMessage message=mailsender.createMimeMessage();
		MimeMessageHelper healper= new MimeMessageHelper(message, true);
		healper.setSubject(subject);
		healper.setTo(toAdd);
		healper.setFrom("dhanu9209@gmail.com");
		healper.setText(text);
		
		if(file!=null){
			healper.addAttachment(file.getOriginalFilename(), new InputStreamSource() {
				
				@Override
				public InputStream getInputStream() throws IOException {
					// TODO Auto-generated method stub
					return file.getInputStream();
				}
			});
		}
		mailsender.send(message);
		status=true;
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return status;
 }
 public boolean sendMail(String toAdd,String subject,String text){
	 return sendMail(toAdd, subject, text, null );
 }
 
 
}
