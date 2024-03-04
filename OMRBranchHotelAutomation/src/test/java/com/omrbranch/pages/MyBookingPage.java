package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MyBookingPage extends BaseClass{
	public MyBookingPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@data-testid='username']")
	private WebElement ddnWelcome;
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement btnAccount;
	@FindBy(xpath="//h4[contains(text(),'Bookings')]")
	private WebElement txtBooking;
	@FindBy(xpath="//button[text()='My Booking']")
	private WebElement btnMyBooking;
	
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement txtSearchBox;
	@FindBy(xpath="//div[@class='room-code']")
	private WebElement searchOrderId;
	@FindBy(xpath="(//div[@class='room-code'])[1]")
	private WebElement firstOrderId;
	@FindBy(xpath="(//div[@class='room-code'])[2]")
	private WebElement existOrderId;
	@FindBy(xpath="//div[@class='fliter_box_inner mb-4']//h5") 
	private WebElement txtHotelName;
	@FindBy(xpath="//div[@class='fliter_box_inner mb-4']//strong")
	private WebElement txtPrice;
	@FindBy(xpath="//button[text()='Edit']")
	private WebElement btnEdit;
	@FindBy(xpath="//input[@name='check_in']")
	private WebElement chngDate;
	@FindBy(xpath="//button[text()='Confirm']")
	private WebElement btnConfirm;
	@FindBy(xpath="//li[contains(@class,'alertMsg')]")
	private WebElement txtSuccessMsg;
	
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement btnCancel;
	@FindBy(xpath="//li[contains(@class,'alertMsg')]")
	private WebElement txtSuccessMsg2;
	
	//edit booking
	public String getBookingSuccessMsg() {
		String txtSuccessMsg = elementGetText(txtBooking);
		return txtSuccessMsg;
	}
	
	public boolean verifySameOrderId() {
		String orderId = elementGetText(searchOrderId);
		String orderId2 = BookingConfirmPage.oldOrderId;
		boolean b = orderId.equals(orderId2);
		return b;
	}
      public boolean verifyHotelName() {
        String htlName = elementGetText(txtHotelName);
  		boolean b = htlName.equals(SelectHotelPage.firstHotelName);
		return b;
	}
       public boolean verifyHotelPrice() {
    	 String htlPrice = elementGetText(txtPrice);
   		boolean c = htlPrice.equals(SelectHotelPage.firstHotelPrice);
		return c;
	}
       public String getUpdatedSuccessMsg() {
	        String SuccessMsg = elementGetText(txtSuccessMsg);
			return SuccessMsg;        
	}
       
      
   	public String getSavedOrderId() {
   		String orderId =BookingConfirmPage.getOrderId();
   		String replaceText = orderId.replace("#","");
   		return replaceText;
   	}
       
       public String firstOrderId() {
		     String fOrderId = elementGetText(firstOrderId);
		     String replaceText2 = fOrderId.replace("#","");
			return replaceText2;
	}
       
       public String existOrderId() {
		     String eOrderId = elementGetText(existOrderId);
		     String replaceText3 = eOrderId.replace("#","");
			return replaceText3;
	}
	
	public void navigateToMyBookingPage() {
		elementClick(btnMyBooking);
	}
	public void searchOrderIdSaved() {
		elementSendKeys(txtSearchBox,getSavedOrderId());
		//insertValueAndEnter(txtSearchBox,getSavedOrderId());
	}
	public void editBooking(String checkIn) {
		elementlickJS(btnEdit);
		elementSendKeysJS(chngDate, checkIn);
		elementClick(btnConfirm);
	}
	public void navigateToMyBookingAfterLogin() {
		elementClick(ddnWelcome);
		elementClick(btnAccount);
	}
	public void searchFirstOrderId() {
        insertValueAndEnter(txtSearchBox,firstOrderId());
	}
	public void searchExistOrderId() {
        insertValueAndEnter(txtSearchBox,existOrderId());
	}
	

	
	//cancel booking
	
	public String bookingSuccessMsg() {
		String bookingSuccess = elementGetText(txtBooking);
		return bookingSuccess;
	}
	public String getUpdatedSuccessMsg2() {
        String SuccessMsg = elementGetText(txtSuccessMsg);
		return SuccessMsg;        
}
	  public String getCancellededSuccessMsg() {
	        String SuccessMsg = elementGetText(txtSuccessMsg2);
			return SuccessMsg;        
	    }
	//1.scenario
	public void cancelBookingCreatedOrderId(String checkInDate) {
		elementClick(btnMyBooking);
		insertValueAndEnter(txtSearchBox,getSavedOrderId());
		elementlickJS(btnEdit);
		elementSendKeysJS(chngDate, checkInDate);
		elementClick(btnConfirm);
		elementClick(btnCancel);
        alertClickOk();
	}
	
	public void cancelBookingFirstOrderId() {
		elementClick(ddnWelcome);
		elementClick(btnAccount);
		insertValueAndEnter(txtSearchBox,firstOrderId());
		elementClick(btnCancel);
		alertClickOk();
	}
	
	public void cancelExistOrderId() {
		elementClick(ddnWelcome);
		elementClick(btnAccount);
		insertValueAndEnter(txtSearchBox,existOrderId());
		elementClick(btnCancel);
		alertClickOk();
	}
		
}
