package com.omrbranch.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.omrbranch.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass{
	public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {
		File file=new File(getProjectPath()+getPropertyFileValue("jvmpath"));
		Configuration configuration=new Configuration(file,"OMRBranchAutomation");
	    configuration.addClassifications("OS","WIN 11"); 
	    configuration.addClassifications("Browser","Chrome"); 
	    configuration.addClassifications("Browser version","119"); 
	    configuration.addClassifications("Sprint","34"); 
	    configuration.addClassifications("Testing","Reg"); 
		
		List<String> jsonFiles=new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder=new ReportBuilder(jsonFiles,configuration);
		
		builder.generateReports();	
		
}
}
