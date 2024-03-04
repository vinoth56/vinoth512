package com.omrbranch.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;



public class TC3_SelectHotelStep {
	PageObjectManager pom=new PageObjectManager();
	@Given("User is on the OMR Branch select hotel page")
	public void userIsOnTheOMRBranchSelectHotelPage() {
	  
	}
	@When("User Search Hotel {string},{string},{string},{string},{string},{string} and {string}")
	public void userSearchHotelAnd(String SelectState, String SelectCity, String SelectRoomType, String CheckIn, String CheckOut, String NoofRooms, String NoofAdults) throws InterruptedException, AWTException {
	pom.getExploreHotelpage().searchHotels2(SelectState, SelectCity, SelectRoomType, CheckIn, CheckOut, NoofRooms, NoofAdults);
	}
	
	@When("User should select first hotel name and save the hotel name and price")
	public void userShouldSelectFirstHotelNameAndSaveTheHotelNameAndPrice() {
	   pom.getSelectHotelPage().selectHotelFirst();
	}
	@When("User should accept the hotel book alert")
	public void userShouldAcceptTheHotelBookAlert() {
	   pom.getSelectHotelPage().acceptHotelBooking();
	}
	@Then("User should verify success message after select hotel {string}")
	public void userShouldVerifySuccessMessageAfterSelectHotel(String expBookHotelSuccessMsg) {
	  String actBookHotelSuccessMsg = pom.getBookHotelPage().getBookHotelSuccessMsg();
	  boolean contains = actBookHotelSuccessMsg.contains(expBookHotelSuccessMsg);
	  Assert.assertTrue("verify success message after select hotel", contains);
	}

	@When("User should dismiss the hotel book alert")
	public void userShouldDismissTheHotelBookAlert() {
	   pom.getSelectHotelPage().dismissHotelBooking();
	}
	
	@Then("User should verify success message after dismiss select hotel {string}")
	public void userShouldVerifySuccessMessageAfterDismissSelectHotel(String expSelectHotelSuccessMsg) {
	   String actSelectHotelSuccessMsg = pom.getSelectHotelPage().getSelectHotelSuccessMsg();
	   Assert.assertEquals("verify select hotel success message", expSelectHotelSuccessMsg, actSelectHotelSuccessMsg);
	}

	@Then("User should verify same filters are checked in and verify each hotel name ends with the given room type {string}")
	public void userShouldVerifySameFiltersAreCheckedInAndVerifyEachHotelNameEndsWithTheGivenRoomType(String SelectRoomType) {
	   pom.getSelectHotelPage().getAllHotelNameEndsWith();
	   String roomTypeHeaderMsg = pom.getSelectHotelPage().getRoomTypeHeaderMsg();
	   Assert.assertEquals("each hotel name ends with same room type", SelectRoomType, roomTypeHeaderMsg);
	}

	@When("User should click  radio button Price low to high")
	public void userShouldClickRadioButtonPriceLowToHigh() throws InterruptedException {
	pom.getSelectHotelPage().ckickLowToHigh();
	}
	@Then("User should verify the hotel price are listed in Ascending order")
	public void userShouldVerifyTheHotelPriceAreListedInAscendingOrder() {
	   pom.getSelectHotelPage().sortHotelPriceAsc();
	}

	@When("User should click radio button Name Descending")
	public void userShouldClickRadioButtonNameDescending() throws InterruptedException {
	    pom.getSelectHotelPage().clickNameDescending();
	}
	@Then("User should verify the hotel name are listed in Descending order")
	public void userShouldVerifyTheHotelNameAreListedInDescendingOrder() {
	   pom.getSelectHotelPage().sortHotelNameDesc();
	}
	


	






}
