package controllers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class CarCtrls extends BaseClass {
	final private String _speakersCategoryXPath = "//*[@id='speakersImg']";
	final private String _speakerImgXPath = "//*[@id='20']";
	final private String _addToCartXPath = "//*[@name='save_to_cart']";
	final private String _menuCartXPath = "//*[@id='menuCart']";
	final private String _checkOutXPath = "//*[@id='checkOutButton']";
	final private String _usernameXPath = "//*[@name='usernameInOrderPayment']";
	final private String _passwordXPath = "//*[@name='passwordInOrderPayment']";
	final private String _loginBtnXPath = "//*[@id=\"login_btnundefined\"]";
	final private String _nextBtnXPath = "//*[@id='next_btn']";
	final private String _safepayUserXPath = "//*[@name='safepay_username']";
	final private String _safepayPassXPath = "//*[@name='safepay_password']";
	final private String _payNowBtnXPath = "//*[@id='pay_now_btn_SAFEPAY']";
	
	public void Buy() {
		WebElement speakersCategory = driver.findElement(By.xpath(_speakersCategoryXPath));
		speakersCategory.click();
		
		WebElement speakerImg = driver.findElement(By.xpath(_speakerImgXPath));
		speakerImg.click();
		
		WebElement addToCart = driver.findElement(By.xpath(_addToCartXPath));
		addToCart.click();
		
		WebElement menuCart = driver.findElement(By.xpath(_menuCartXPath));
		menuCart.click();
		
		WebElement checkOut = driver.findElement(By.xpath(_checkOutXPath));
		checkOut.click();
		
		WebElement username = driver.findElement(By.xpath(_usernameXPath));
		username.sendKeys(USER_NAME);
		
		WebElement password = driver.findElement(By.xpath(_passwordXPath));
		password.sendKeys(PASS);
		
		WebElement loginBtn = driver.findElement(By.xpath(_loginBtnXPath));
		loginBtn.click();
		
		WebElement nextBtn = driver.findElement(By.xpath(_nextBtnXPath));
		nextBtn.click();
		
		WebElement safePayUsername = driver.findElement(By.xpath(_safepayUserXPath));
		safePayUsername.clear();
		safePayUsername.sendKeys(USER_NAME);
		
		WebElement safePayPassword = driver.findElement(By.xpath(_safepayPassXPath));
		safePayPassword.clear();
		safePayPassword.sendKeys(PASS);
		
		WebElement payNow = driver.findElement(By.xpath(_payNowBtnXPath));
		payNow.click();
	}
}
