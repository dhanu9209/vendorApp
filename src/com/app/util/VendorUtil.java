package com.app.util;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class VendorUtil {

	public void createAndSavePieChart(String path,List<Object[]>vendorList){
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] obj:vendorList){
			dataset.setValue(obj[0].toString(), Double.parseDouble(obj[1].toString()));
		}
		
		JFreeChart jfreeChart=ChartFactory.createPieChart3D("Vendor type wise Pie chart", dataset, true, true, false);
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/vendorPie.jpg"), jfreeChart, 450, 450);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createAndSaveBarChart(String path,List<Object[]>vendorList){
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] obj:vendorList){
			dataset.addValue(Double.parseDouble(obj[1].toString()), obj[0].toString(), "");
		}
		
		JFreeChart jfreeChart=ChartFactory.createBarChart3D("Vendor Type Wise Bar Chart", "Vendor Type", "count", dataset);
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/vendorBar.jpg"), jfreeChart, 450, 450);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
