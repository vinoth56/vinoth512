package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BookingConfirmPage extends BaseClass{
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//strong[contains(text(),'#')]")
	private static WebElement txtOrderId;
	@FindBy(xpath="//h2[contains(text(),'Booking is Confirmed')]")
	private WebElement txtBookingHotel;
	@FindBy(xpath="//div[@class='seccess-box text-center']//p")
    private WebElement txtHotelName;
	
	public static String oldOrderId;
	
public static String getOrderId() {
	String getOrder = elementGetText(txtOrderId);
         String oldOrderId=getOrder;
		return oldOrderId;         
}
public String getBookinSuccessMsg() {
	String getText = elementGetText(txtBookingHotel);
	return getText;
}
public String getBookedHotelName() {
  String getText = elementGetText(txtHotelName);
  return getText;
}


}
