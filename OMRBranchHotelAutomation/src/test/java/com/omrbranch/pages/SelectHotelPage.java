package com.omrbranch.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SelectHotelPage extends BaseClass{
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h5[text()='Select Hotel']")
	private WebElement txtHotel;
	@FindBy(xpath="//div[@class='col-md-5 hotel-suites']//h5[1]")
	private WebElement txtHotelName;
	@FindBy(xpath="//strong[@class='total-prize'][1]")
	private WebElement txtHotelPrice;
	@FindBy(xpath="//a[text()='Continue'][1]")
	private WebElement btnContinue;
	@FindBy(xpath="//a[@id='room_type']")
	private WebElement roomHeader;
	@FindBy(xpath="//select[@id='no_rooms']")
	private WebElement ddnRoom;
	@FindBy(xpath="//label[@for='value_pltoh']")
	private WebElement sortPrice;
	@FindBy(xpath="//strong[@class='total-prize']")
	private List<WebElement> allHotelPrice;
	@FindBy(xpath="//label[@for='value_ndesc']")
	private WebElement sortNameDescending;
	@FindBy(xpath="//div[@class='col-md-5 hotel-suites']//h5")
	private List<WebElement> allHotelName;
	
	
	public static String firstHotelName;
	public static String firstHotelPrice;
	
	public String getSelectHotelSuccessMsg() {
		String getText = elementGetText(txtHotel);
		return getText;
	}
	public String getRoomTypeHeaderMsg() {
		String getText = elementGetText(roomHeader);
		return getText;
	}
	public void selectHotelFirst() {
		String txtFirstHotelName = elementGetText(txtHotelName);
		String txtFirstHotelPrice = elementGetText(txtHotelPrice);
	     firstHotelName = txtFirstHotelName;
	     firstHotelPrice=txtFirstHotelPrice;
	     elementClick(btnContinue);
	}
	public void acceptHotelBooking() {
		alertClickOk();
	}
	public void dismissHotelBooking() {
		alertClickCancel();
	}
	public void ckickLowToHigh() throws InterruptedException {
		 elementClick(sortPrice);
		  Thread.sleep(1000);
   }
    public void clickNameDescending() throws InterruptedException {
    	elementClick(sortNameDescending);
    	Thread.sleep(1000);
	}
    
public void sortHotelPriceAsc()  {
  List<String>exp=new ArrayList<String>();
	 
  for ( WebElement allPrice : allHotelPrice) {
   exp.add(allPrice.getText());
}

System.out.println(exp);

List<String>act=new ArrayList<String>();

act.addAll(exp);
Collections.sort(act);
System.out.println(act);

if(exp.equals(act)) {
	System.out.println("True");
		    }else {
		    	System.out.println("False");
	  }
}

public void sortHotelNameDesc() {
	
	 List<String>exp=new ArrayList<String>();
	  
     for ( WebElement allNames : allHotelName) {
      exp.add(allNames.getText());
	}
   
   System.out.println(exp);
   
   List<String>act=new ArrayList<String>();
   
   act.addAll(exp);
   Collections.sort(act);
  Collections.reverse(act);
   System.out.println(act);
   
   if(exp.equals(act)) {
   	System.out.println("True");
   		    }else {
   		    	System.out.println("False");
   		 }
}

public void getAllHotelNameEndsWith() {
	String roomType = getRoomTypeHeaderMsg();

	List<String> hotel = new ArrayList<String>();

	for (WebElement eachHotel : allHotelName) {
		hotel.add(eachHotel.getText());
	}
	List<Boolean> firsttHotelRes = new ArrayList<Boolean>();
	List<String> act = new ArrayList<String>();
	act.addAll(hotel);
	for (String each : act) {
		boolean b = each.endsWith(roomType);
		firsttHotelRes.add(b);
	}
	System.out.println(firsttHotelRes);

	boolean b = firsttHotelRes.contains(false);
	System.out.println(b);
	
}



	
}
