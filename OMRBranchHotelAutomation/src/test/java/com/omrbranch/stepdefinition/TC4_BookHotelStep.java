package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC4_BookHotelStep {
	PageObjectManager pom=new PageObjectManager();
	
	@Given("User is on the OMR Branch Book hotel page")
	public void userIsOnTheOMRBranchBookHotelPage() {
	
	}
	@When("User add the guest details click Myself radio button and Enter {string},{string},{string},{string} and {string}")
	public void userAddTheGuestDetailsClickMyselfRadioButtonAndEnterAnd(String SelectSalutation, String FirstName, String LastName, String MobileNo, String Email) {
	    pom.getBookHotelPage().addGuestDetails(SelectSalutation, FirstName, LastName, MobileNo, Email);
	}
	@When("User add GST details {string},{string} and {string}")
	public void userAddGSTDetailsAnd(String EnterRegistrationNo, String EnterCompanyName, String EnterCompanyAddress) {
	   pom.getBookHotelPage().addGstDetails(EnterRegistrationNo, EnterCompanyName, EnterCompanyAddress);
	}
	@When("User add the special request {string}")
	public void userAddTheSpecialRequest(String SpecialRequest) {
	   pom.getBookHotelPage().addSpecialRequest(SpecialRequest);
	}

	@Then("User should verify success message after booking hotel {string} and save the orderid")
	public void userShouldVerifySuccessMessageAfterBookingHotelAndSaveTheOrderid(String expBookinSuccessMsg) {
	String actBookinSuccessMsg = pom.getBookingConfirmPage().getBookinSuccessMsg();
	boolean contains = actBookinSuccessMsg.contains(expBookinSuccessMsg);
	Assert.assertTrue("verify success message after booking hotel", contains);
	//Assert.assertEquals("verify success message after booking hotel", expBookinSuccessMsg, actBookinSuccessMsg);
	
	}

	@When("User click next without add special request")
	public void userClickNextWithoutAddSpecialRequest() {
	   pom.getBookHotelPage().withoutAddSpecialRequest();
	}

	@When("User add the guest details click Myself radio button and Enter {string},{string},{string},{string} and {string} click next")
	public void userAddTheGuestDetailsClickMyselfRadioButtonAndEnterAndClickNext(String SelectSalutation, String FirstName, String LastName, String MobileNo, String Email) {
	   pom.getBookHotelPage().addGuestDetailsWithoutGst(SelectSalutation, FirstName, LastName, MobileNo, Email);
	}
	
	@When("User click submit without enter any field")
	public void userClickSubmitWithoutEnterAnyField() {
	   pom.getBookHotelPage().submitWithoutEnterPayment();
	}
	@Then("User should verify all error messages {string},{string},{string},{string},{string} and {string} at payment")
	public void userShouldVerifyAllErrorMessagesAndAtPayment(String expPayTypeErrorMsg, String expCardTypeErrorMsg, String expCardNoErrorMsg, String expCardNameErrorMsg, String expCardMonthErrorMsg, String expCvvErrorMsg) {
	String actPayTypeErrorMsg = pom.getBookHotelPage().getPayTypeErrorMsg();
	String actCardTypeErrorMsg = pom.getBookHotelPage().getCardTypeErrorMsg();
	String actCardNoErrorMsg = pom.getBookHotelPage().getCardNoErrorMsg();
	String actCardNameErrorMsg = pom.getBookHotelPage().getCardNameErrorMsg();
	String actCardMonthErrorMsg = pom.getBookHotelPage().getCardMonthErrorMsg();
	String actCvvErrorMsg = pom.getBookHotelPage().getCvvErrorMsg();
	Assert.assertEquals("verify error message of pay type", expPayTypeErrorMsg, actPayTypeErrorMsg);
	Assert.assertEquals("verify card type error message", expCardTypeErrorMsg, actCardTypeErrorMsg);
	Assert.assertEquals("verify card number error message", expCardNoErrorMsg, actCardNoErrorMsg);
	Assert.assertEquals("verify card name error message", expCardNameErrorMsg, actCardNameErrorMsg);
	Assert.assertEquals("verify card month error message", expCardMonthErrorMsg, actCardMonthErrorMsg);
	Assert.assertEquals("verify error message of cvv", expCvvErrorMsg, actCvvErrorMsg);
	
	}

	
	@When("User Enter payment Details,proceed with card type {string}")
	public void userEnterPaymentDetailsProceedWithCardType(String cardType, io.cucumber.datatable.DataTable dataTable) {
	   pom.getBookHotelPage().addPaymentDetails(cardType, dataTable);
	}



	



}
