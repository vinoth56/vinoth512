package com.omrbranch.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;


public class TC2_ExploreHotelStep extends BaseClass{
	PageObjectManager pom=new PageObjectManager();
	
	@Given("User is on the OMR Branch explore hotel page")
	public void userIsOnTheOMRBranchExploreHotelPage() {
	 
	}
	@When("User Search Hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userSearchHotelAnd(String SelectState, String SelectCity, String SelectRoomType, String CheckIn, String CheckOut, String NoofRooms, String NoofAdults, String NoofChildren) throws InterruptedException {
	   pom.getExploreHotelpage().searchHotels(SelectState, SelectCity, SelectRoomType, CheckIn, CheckOut, NoofRooms, NoofAdults, NoofChildren);
	}
	@Then("User should verify success message after search hotel {string}")
	public void userShouldVerifySuccessMessageAfterSearchHotel(String expSelectHotelSuccessMsg) {
	  String actSelectHotelSuccessMsg = pom.getSelectHotelPage().getSelectHotelSuccessMsg();
	  Assert.assertEquals("verify success message after search hotel", expSelectHotelSuccessMsg, actSelectHotelSuccessMsg);
	}
	
	@When("User Search Hotel {string},{string},{string},{string},{string} and {string}")
	public void userSearchHotelAnd(String SelectState, String SelectCity, String CheckIn, String CheckOut, String NoofRooms, String NoofAdults) throws InterruptedException {
	   pom.getExploreHotelpage().searchHotelMandatory(SelectState, SelectCity, CheckIn, CheckOut, NoofRooms, NoofAdults);
	}
	
	
	@When("User should click search button without enter any field")
	public void userShouldClickSearchButtonWithoutEnterAnyField() {
	pom.getExploreHotelpage().withoutEnterAnyFieldClickSearch();
	}
	
	@Then("User should verify all error message {string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAllErrorMessageAnd(String expStateErrorMsg, String expCityErrorMsg, String expCheckInDateErrorMsg, String expCheckOutDateErrorMsg, String expNoOfRoomsErrorMsg, String expNoOfAdultsErrorMsg) {
	   String actStateErrorMsg = pom.getExploreHotelpage().getStateErrorMsg();
	   String actCityErrorMsg = pom.getExploreHotelpage().getCityErrorMsg();
	   String actCheckInDateErrorMsg = pom.getExploreHotelpage().getCheckInDateErrorMsg();
	   String actCheckOutDateErrorMsg = pom.getExploreHotelpage().getCheckOutDateErrorMsg();
	   String actNoOfRoomsErrorMsg = pom.getExploreHotelpage().getNoOfRoomsErrorMsg();
	   String actNoOfAdultsErrorMsg = pom.getExploreHotelpage().getNoOfAdultsErrorMsg();
	   Assert.assertEquals("verify state error message", expStateErrorMsg, actStateErrorMsg);
	   Assert.assertEquals("verify city error message", expCityErrorMsg, actCityErrorMsg);
	   Assert.assertEquals("verify checkin date error message", expCheckInDateErrorMsg, actCheckInDateErrorMsg);
	   Assert.assertEquals("verify checkout date error message", expCheckOutDateErrorMsg, actCheckOutDateErrorMsg);
	   Assert.assertEquals("verify no of rooms error message", expNoOfRoomsErrorMsg, actNoOfRoomsErrorMsg);
	   Assert.assertEquals("verify no of adults error message", expNoOfAdultsErrorMsg, actNoOfAdultsErrorMsg);
	   
	}
	

	@Then("User should verify the header contain all the selected room type {string}")
	public void userShouldVerifyTheHeaderContainAllTheSelectedRoomType(String expRoomTypeHeaderMsg) {
	   String actRoomTypeHeaderMsg = pom.getSelectHotelPage().getRoomTypeHeaderMsg();
	   Assert.assertEquals("verify header contain all the selected room type", expRoomTypeHeaderMsg, actRoomTypeHeaderMsg);
	}
	
	
	@When("User Search Hotel {string},{string},{string},{string},{string},{string} and {string} with multiple room type")
	public void userSearchHotelAndWithMultipleRoomType(String SelectState, String SelectCity, String SelectRoomType, String CheckIn, String CheckOut, String NoofRooms, String NoofAdults) throws InterruptedException, AWTException {
		 pom.getExploreHotelpage().searchHotelsMultipleRoomType(SelectState, SelectCity, SelectRoomType, CheckIn, CheckOut, NoofRooms, NoofAdults);
	}
	



}
