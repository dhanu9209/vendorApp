package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.service.ILocationService;

@Component
public class LocationUtil {
@Autowired
	private ILocationService locationService;
	
 public List<Location> getAllLocations(){
	return locationService.getAllLocations();	
}
 
 public void createPieChart(String path,List<Object[]> locList){
//	 step1
//	 covert list to data set
	 DefaultPieDataset dataset=new DefaultPieDataset();
    for(Object[] obj:locList){
    	dataset.setValue(obj[0].toString(), Double.parseDouble(obj[1].toString()));
    }
//step 2
//convert dataset to Jfree object by using Jfree util
	 JFreeChart jfreechart= ChartFactory.createPieChart3D("Location Type wise Pie chart", dataset, true, true, false);
	 
	 
	 //step3 
	// save this chart to the particular image format and location
	 
	 
	 try {
		ChartUtilities.saveChartAsJPEG(new File(path+"/locationPie.jpg"), jfreechart, 450, 450);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 
 public void createBarChart(String path,List<Object[]> locList){
	 DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	  for(Object[] obj:locList){
		  dataset.setValue(Double.parseDouble(obj[1].toString()), obj[0].toString(), "");
	  }
	  
	  JFreeChart jfreechart=ChartFactory.createBarChart3D("Location Type wise Bar Chart", "Locations", "count", dataset);
	  
		 try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/locationBar.jpg"), jfreechart, 450, 450);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
 
	 
 }
 
 

