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
public class LoginPage extends BaseClass{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	 private WebElement txtEmail;
	 @FindBy(id="pass")
	 private WebElement txtPass;
	 @FindBy(xpath="//button[@value='login']")
	 private WebElement btnLogin;
	 @FindBy(xpath="//div[@id='errorMessage']")
	 private WebElement txtLoginError;
	 
	 public void login(String username,String password) {
		elementSendKeys(txtEmail, username);
		elementSendKeys(txtPass, password);
		elementClick(btnLogin);
     }
	 public void loginEnterKey(String username,String password) throws AWTException {
		elementSendKeys(txtEmail, username);
		elementSendKeys(txtPass, password);
		enterKey();
	}
	 
	 public String getLoginErrorMsg() {
		String elementGetText = elementGetText(txtLoginError);
		return elementGetText;
      }
}
