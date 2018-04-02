package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Location;

public class LocationExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
		//get location data from map object
		List<Location> locList=(List<Location>)map.get("locList");
		
		// create sheet 
		HSSFSheet sheet=book.createSheet();
		
		// create head part 
		
		showHead(sheet);
		
		// show Body 
		showBody(sheet, locList);
		// 
		
	}
	private void showHead(HSSFSheet sheet){
		int rowNumber=0;
		HSSFRow row=sheet.createRow(rowNumber);
		row.createCell(0).setCellValue("Location Id");
		row.createCell(1).setCellValue("Location Name");
		row.createCell(2).setCellValue("Location Type");
		
	}
	
	private void showBody(HSSFSheet sheet,List<Location> loclist){
		int rowNumber=1;
		for(Location loc:loclist){
			HSSFRow row=sheet.createRow(rowNumber++);
				row.createCell(0).setCellValue(loc.getLocId());
				row.createCell(1).setCellValue(loc.getLocName());
				row.createCell(2).setCellValue(loc.getLocType());
			}
		}

	

}
