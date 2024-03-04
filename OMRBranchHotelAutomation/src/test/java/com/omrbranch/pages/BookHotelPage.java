package com.omrbranch.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

import io.cucumber.datatable.DataTable;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BookHotelPage extends BaseClass{
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[contains(text(),'Book Hotel')]")
	private WebElement txtBookHotel;
	@FindBy(xpath="//input[@value='own']")
	private WebElement rdoMySelf;
	@FindBy(xpath="//select[@id='user_title']")
	private WebElement ddnSalutation;
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement txtFirstName;
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement txtLastName;
	@FindBy(xpath="//input[@id='user_phone']")
	private WebElement txtMobile;
	@FindBy(xpath="//input[@id='user_email']")
	private WebElement txtEmail;
	@FindBy(xpath="//input[@id='gst']")
	private WebElement rdoGst;
	@FindBy(xpath="//input[@id='gst_registration']")
	private WebElement txtGstRegNo;
	@FindBy(xpath="//input[@id='company_name']")
	private WebElement txtCompanyName;
	@FindBy(xpath="//input[@id='company_address']")
	private WebElement txtCompanyAddress;
	@FindBy(xpath="//button[@id='step1next']")
	private WebElement btnNext;
	
	//special request
	@FindBy(xpath="//input[@value='Large bed']")
	private WebElement rdoSpecialRequest;
	@FindBy(xpath="//textarea[@name='other_request']")
	private WebElement txtOtherRequest;
	@FindBy(xpath="//button[@id='step2next']")
	private WebElement btnNext2;
	
	//payment
	@FindBy(xpath="//div[@class='credit-card pm']")
	private WebElement sltDebit;
	@FindBy(xpath="//select[@id='payment_type']")
	private WebElement ddnPayType;
	@FindBy(xpath="//select[@id='card_type']")
	private WebElement ddnCardType;
	@FindBy(xpath="//input[@id='card_no']")
	private WebElement txtCardNo;
	@FindBy(xpath="//input[@id='card_name']")
	private WebElement txtCardName;
	@FindBy(xpath="//select[@id='card_month']")
	private WebElement ddnCardMonth;
	@FindBy(xpath="//select[@id='card_year']")
	private WebElement ddnCardYear;
	@FindBy(xpath="//input[@name='cvv']")
	private WebElement txtCvv;
	@FindBy(xpath="//button[@id='submitBtn']")
	private WebElement btnSubmit;
	
	//Error msg
	@FindBy(xpath="//div[text()='Please select your card type']")
	private WebElement txtErrorPaytype;
	@FindBy(xpath="//div[@id='invalid-card_type']")
	private WebElement txtErrorCardtype;
	@FindBy(id="invalid-card_no")
	private WebElement txtErrorCardno;
	@FindBy(id="invalid-card_name")
	private WebElement txtErrorCardName;
	@FindBy(id="invalid-card_month")
	private WebElement txtErrorMonth;
	@FindBy(id="invalid-cvv")
	private WebElement txtErrorCvv;
	
	
	public String getBookHotelSuccessMsg() {
	String getText = elementGetText(txtBookHotel);
	return getText;
	}
	public void addGuestDetails(String SelectSalutation,String FirstName,String LastName,String MobileNo,String Email) {
		elementlickJS(rdoMySelf);
		elementSendKeys(ddnSalutation, SelectSalutation);
		elementSendKeys(txtFirstName, FirstName);
		elementSendKeys(txtLastName, LastName);
		elementSendKeys(txtMobile, MobileNo);
		elementSendKeys(txtEmail, Email);
	}
	public void addGuestDetailsWithoutGst(String SelectSalutation,String FirstName,String LastName,String MobileNo,String Email) {
		elementlickJS(rdoMySelf);
		elementSendKeys(ddnSalutation, SelectSalutation);
		elementSendKeys(txtFirstName, FirstName);
		elementSendKeys(txtLastName, LastName);
		elementSendKeys(txtMobile, MobileNo);
		elementSendKeys(txtEmail, Email);
		elementClick(btnNext);
	}
	public void addGstDetails(String EnterRegistrationNo,String EnterCompanyName,String EnterCompanyAddress) {
		elementClick(rdoGst);
		elementSendKeys(txtGstRegNo, EnterRegistrationNo);
		elementSendKeys(txtCompanyName, EnterCompanyName);
		elementSendKeys(txtCompanyAddress, EnterCompanyAddress);
		elementClick(btnNext);
	}
	public void addSpecialRequest(String SpecialRequest) {
	elementClick(rdoSpecialRequest);
	elementSendKeys(txtOtherRequest,SpecialRequest);
	elementClick(btnNext2);
	}
	public void withoutAddSpecialRequest() {
		elementClick(btnNext2);
		}
	public void addPaymentDetails(String cardType,DataTable dataTable) {
		implicitWait();
		elementClick(sltDebit);
		selectOptionByValue(ddnPayType, cardType);
		List<Map<String, String>> maps = dataTable.asMaps();
		Map<String, String> s = maps.get(0);
		selectOptionByValue(ddnCardType, s.get("SelectCard"));
		elementSendKeys(txtCardNo, s.get("CardNo"));
		elementSendKeys(txtCardName, s.get("CardName"));
		selectOptionByText(ddnCardMonth, s.get("Month"));
		//selectOptionByValue(ddnCardMonth, s.get("Month"));
		selectOptionByValue(ddnCardYear, s.get("Year"));
		elementSendKeys(txtCvv, s.get("Cvv"));
		elementClick(btnSubmit);
	}
	public void submitWithoutEnterPayment() {
		elementClick(sltDebit);
		elementClick(btnSubmit);
	}
	public String getPayTypeErrorMsg() {
		String getText = elementGetText(txtErrorPaytype);
		return getText;
	}
	public String getCardTypeErrorMsg() {
		String getText = elementGetText(txtErrorCardtype);
		return getText;
	}
	public String getCardNoErrorMsg() {
		String getText = elementGetText(txtErrorCardno);
		return getText;
	}
	public String getCardNameErrorMsg() {
		String getText = elementGetText(txtErrorCardName);
		return getText;
	}
	public String getCardMonthErrorMsg() {
		String getText = elementGetText(txtErrorMonth);
		return getText;
	}
	public String getCvvErrorMsg() {
		String getText = elementGetText(txtErrorCvv);
		return getText;
	}
}
