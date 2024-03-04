package com.omrbranch.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.base.BaseClass;
import com.omrbranch.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@Edit",dryRun=false,snippets=SnippetType.CAMELCASE,plugin= {"json:target\\index.json"},features="src\\test\\resources\\Features",glue="com.omrbranch.stepdefinition")

public class TestRunnerClass extends BaseClass{
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJvmReport(getProjectPath()+getPropertyFileValue("jsonpath"));

	}

}
