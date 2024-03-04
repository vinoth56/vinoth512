package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC4_ChangeBookingStep {
	PageObjectManager pom=new PageObjectManager();

	@Given("User is on the OMR Branch My Booking page")
	public void userIsOnTheOMRBranchMyBookingPage() {
	   
	}
	@Then("User should verify same hotel name is booked")
	public void userShouldVerifySameHotelNameIsBooked() {
     pom.getBookingConfirmPage().getBookedHotelName();
	}
	@When("user navigate to my booking page")
	public void userNavigateToMyBookingPage() {
	pom.getMyBookingPage().navigateToMyBookingPage();
	}
	@Then("User should verify the success message {string} after navigate to booking page")
	public void userShouldVerifyTheSuccessMessageAfterNavigateToBookingPage(String expBookingSuccessMsg) {
	String actBookingSuccessMsg = pom.getMyBookingPage().getBookingSuccessMsg();
	boolean contains = actBookingSuccessMsg.contains(expBookingSuccessMsg);
	Assert.assertTrue("verify success message after navigate to my booking page", contains);
	}
	@When("User search the orderId with saved orderId")
	public void userSearchTheOrderIdWithSavedOrderId() {
	pom.getMyBookingPage().searchOrderIdSaved();
	}
	@Then("User should verify the same orderId is present successfully")
	public void userShouldVerifyTheSameOrderIdIsPresentSuccessfully() {
	pom.getMyBookingPage().verifySameOrderId();
	}
	@Then("User should verify the same hotel name is present successfully")
	public void userShouldVerifyTheSameHotelNameIsPresentSuccessfully() {
	pom.getMyBookingPage().verifyHotelName();
	}
	@Then("User should verify the same hotel price is present successfully")
	public void userShouldVerifyTheSameHotelPriceIsPresentSuccessfully() {
	pom.getMyBookingPage().verifyHotelPrice();
	}
	@When("User edit the booking by changing the checkInDate {string}")
	public void userEditTheBookingByChangingTheCheckInDate(String checkIn) {
	pom.getMyBookingPage().editBooking(checkIn);
	}
	@Then("User should verify after editing the checkindate success message {string}")
	public void userShouldVerifyAfterEditingTheCheckindateSuccessMessage(String expUpdatedSuccessMsg) {
	String actUpdatedSuccessMsg = pom.getMyBookingPage().getUpdatedSuccessMsg();
	Assert.assertEquals("verify success message after edit booking", expUpdatedSuccessMsg, actUpdatedSuccessMsg);
	}
	
	@When("user navigate to my booking page after login")
	public void userNavigateToMyBookingPageAfterLogin() {
	   pom.getMyBookingPage().navigateToMyBookingAfterLogin();
	}
	
	@When("User should modify the first order id")
	public void userShouldModifyTheFirstOrderId() {
	   pom.getMyBookingPage().searchFirstOrderId();
	}
	
	@When("User should modify the existing order id")
	public void userShouldModifyTheExistingOrderId() {
	pom.getMyBookingPage().searchExistOrderId();
	}


}
