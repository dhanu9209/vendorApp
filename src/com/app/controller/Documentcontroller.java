package com.app.controller;

import java.io.IOException;



import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.sevice.IDocumentService;

@Controller
public class Documentcontroller {
	@Autowired
	private IDocumentService documentservice;
	
	@RequestMapping("/regUpload")
	public String getUploadPage(ModelMap map){
		map.addAttribute("doclistobj", documentservice.getDocumentIdAndName());
		return "documentUpload";
	}
	@RequestMapping(value="/uploadDoc",method=RequestMethod.POST)
	public String documentUpload(@RequestParam("fileId")int fileId,@RequestParam("fileobj")
	CommonsMultipartFile fileobj,ModelMap map ){
		if (fileobj!=null) {
			Document doc=new Document();
			doc.setDocId(fileId);
			doc.setDocName(fileobj.getOriginalFilename());
			doc.setDocData(fileobj.getBytes());
			int number=documentservice.saveDocument(doc);
			map.addAttribute("msg", "Document Upladed successfully with Id :"+number);
		}
		map.addAttribute("doclistobj", documentservice.getDocumentIdAndName());
		return "documentUpload";
	}
	
	@RequestMapping("/downloadDoc")
	public void documentDownload(@RequestParam("docid")int docid,HttpServletResponse response){
		Document doc=documentservice.getDocumentById(docid);
		response.setHeader("Content-Disposition","attachment;filename="+doc.getDocName());
		try {
			FileCopyUtils.copy(doc.getDocData(), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
