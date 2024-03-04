package com.omrbranch.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass{
	PageObjectManager pom=new PageObjectManager();

	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage() throws FileNotFoundException, IOException {
		 
	}
	
	@When("User Login {string} and {string}")
	public void userLoginAnd(String username, String password) {
		 pom.getLoginPage().login(username, password);
	}
	
	@Then("User should verify success message after Login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String expLoginSuccessMsg) {
		 String actLoginSuccessMsg = pom.getExploreHotelpage().getLoginSuccessMsg();
		   Assert.assertEquals("verify login success message", expLoginSuccessMsg, actLoginSuccessMsg);
	}
	
	@When("User Login {string} and {string} with ENTER key")
	public void userLoginAndWithENTERKey(String username, String password) throws AWTException {
		 pom.getLoginPage().loginEnterKey(username, password);
	}
	
	@Then("User should verify error message after Login {string}")
	public void userShouldVerifyErrorMessageAfterLogin(String expLoginErrorMsg) {
		 String actLoginErrorMsg = pom.getLoginPage().getLoginErrorMsg();
		 boolean b = actLoginErrorMsg.contains(expLoginErrorMsg);
		 Assert.assertTrue("verify after login error message",b);
	}

}
