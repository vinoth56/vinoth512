package com.omrbranch.pages;



import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ExploreHotelPage extends BaseClass{
	public ExploreHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//a[contains(@data-testid,'username')]")
private WebElement txtWelcome;
@FindBy(id="state")
private WebElement ddnState;
@FindBy(xpath="//span[@role='presentation']")
private WebElement ddnCity;
@FindBy(xpath="//input[@role='searchbox']")
private WebElement ddnCity2;
@FindBy(xpath="//textarea[@role='searchbox']")
private WebElement ddnRoomType;
@FindBy(xpath="//input[@name='check_in']")
private WebElement sltCheckIn;
@FindBy(xpath="//input[@name='check_out']")
private WebElement sltCheckOut;
@FindBy(xpath="//select[@id='no_rooms']")
private WebElement ddnRoom;
@FindBy(xpath="//select[@name='no_adults']")
private WebElement ddnAdult;
@FindBy(xpath="//input[@name='no_child']")
private WebElement ddnChild;
@FindBy(xpath="//button[text()='Search']")
private WebElement btnSearch;

//error msg
@FindBy(id="invalid-state")
private WebElement txtStateError;
@FindBy(id="invalid-city")
private WebElement txtErrorCity;
@FindBy(id="invalid-check_in")
private WebElement txtErrorCheckin;
@FindBy(id="invalid-check_out")
private WebElement txtErrorCheckout;
@FindBy(id="invalid-no_rooms")
private WebElement txtErrorRoom;
@FindBy(id="invalid-no_adults")
private WebElement txtErrorAdult;


@FindBy(xpath="//a[@id='room_type']")
private WebElement roomHeader;

public String getLoginSuccessMsg() {
	String elementGetText = elementGetText(txtWelcome);
	return elementGetText;
}
public void searchHotels(String SelectState, String SelectCity, String SelectRoomType, String CheckIn, String CheckOut, String NoofRooms, String NoofAdults, String NoofChildren) throws InterruptedException {
	implicitWait();
	selectOptionByValue(ddnState, SelectState);
	Thread.sleep(1000);
	elementClick(ddnCity);
	insertValueAndEnter(ddnCity2, SelectCity);
	insertValueAndEnter(ddnRoomType, SelectRoomType);
	elementSendKeysJS(sltCheckIn, CheckIn);
	elementSendKeysJS(sltCheckOut, CheckOut);
	elementSendKeys(ddnRoom, NoofRooms);
    elementSendKeys(ddnAdult, NoofAdults);
	elementSendKeys(ddnChild, NoofChildren);
    switchFrameById("hotelsearch_iframe");
    elementClick(btnSearch);
}

public void searchHotelMandatory(String SelectState, String SelectCity, String CheckIn, String CheckOut, String NoofRooms, String NoofAdults) throws InterruptedException {
	selectOptionByValue(ddnState, SelectState);
	Thread.sleep(1000);
	elementClick(ddnCity);
	insertValueAndEnter(ddnCity2, SelectCity);
	elementSendKeysJS(sltCheckIn, CheckIn);
    elementSendKeysJS(sltCheckOut, CheckOut);
    elementSendKeys(ddnRoom, NoofRooms);
    elementSendKeys(ddnAdult, NoofAdults);
	switchFrameById("hotelsearch_iframe");
    elementClick(btnSearch);
}

public void searchHotelsMultipleRoomType(String SelectState, String SelectCity, String SelectRoomType, String CheckIn, String CheckOut, String NoofRooms, String NoofAdults) throws InterruptedException, AWTException {
	selectOptionByValue(ddnState, SelectState);
	Thread.sleep(1000);
	elementClick(ddnCity);
	insertValueAndEnter(ddnCity2, SelectCity);
	selectRoomType(SelectRoomType);
	elementSendKeysJS(sltCheckIn, CheckIn);
	elementSendKeysJS(sltCheckOut, CheckOut);
	elementSendKeys(ddnRoom, NoofRooms);
    elementSendKeys(ddnAdult, NoofAdults);
    switchFrameById("hotelsearch_iframe");
    elementClick(btnSearch);
}
public void searchHotels2(String SelectState, String SelectCity, String SelectRoomType, String CheckIn, String CheckOut, String NoofRooms, String NoofAdults) throws InterruptedException, AWTException {
	implicitWait();
	selectOptionByValue(ddnState, SelectState);
	Thread.sleep(1000);
	elementClick(ddnCity);
	insertValueAndEnter(ddnCity2, SelectCity);
	insertValueAndEnter(ddnRoomType, SelectRoomType);
	elementSendKeysJS(sltCheckIn, CheckIn);
	elementSendKeysJS(sltCheckOut, CheckOut);
	elementSendKeys(ddnRoom, NoofRooms);
    elementSendKeys(ddnAdult, NoofAdults);
    tabAndEnterKey();
//    switchFrameById("hotelsearch_iframe");
//    elementClick(btnSearch);
}



public void selectRoomType(String roomType) throws AWTException {
	String[] split = roomType.split("/");
	 for (int i = 0; i < split.length; i++) {
		 insertValueAndEnter(ddnRoomType, split[i]);
         elementSendKeys(ddnRoomType, "\t");
	}
}

public void withoutEnterAnyFieldClickSearch() {
	switchFrameById("hotelsearch_iframe");
	elementClick(btnSearch);
	frameToWindow();

}

public String getStateErrorMsg() {
    String text = elementGetText(txtStateError);
	return text;
}
public String getCityErrorMsg() {
	String getText = elementGetText(txtErrorCity);
	return getText;
}
public String getCheckInDateErrorMsg() {
	String getText = elementGetText(txtErrorCheckin);
	return getText;
}
public String getCheckOutDateErrorMsg() {
	String getText = elementGetText(txtErrorCheckout);
	return getText;
}
public String getNoOfRoomsErrorMsg() {
	String getText = elementGetText(txtErrorRoom);
	return getText;
}
public String getNoOfAdultsErrorMsg() {
	String getText = elementGetText(txtErrorAdult);
	return getText;
}






}

