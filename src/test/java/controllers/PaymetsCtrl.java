package controllers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseClass;
import helpers.GeneralHelpers;

public class PaymetsCtrl extends BaseClass {
	
	final private GeneralHelpers _generalHelpers = new GeneralHelpers();
	
	final private String _menuUserTxt = "//input[@name='username']";
	final private String _userInputTxt = "//input[@name='username']"; 
	final private String _passwordInputTxt= "//input[@name='password']";
	final private String _btnSignInTxt = "//*[@id=\"sign_in_btnundefined\"]";
	final private String _userMenuTxt = "//a[@id='menuUserLink']";
	final private String _btnMyAccountTxt = "//label[@role='link'][normalize-space()='My account']";
	final private String _btnEditTxt = "//a[@href='#/accountPaymentEdit']";
	final private String _usrPayInputTxt = "//input[@name='safepay_username']";
	final private String _pswPayInputTxt = "//input[@name='safepay_password']";
	final private String _btnCreatePayTxt = "//*[@id=\"save_btnundefined\"]";
	final private String _txtSafePayXPath = "//span[@class='ng-binding'][normalize-space()='JoseDLC01']";

	private WebElement _userInput; 
	private WebElement _passwordInput;
	private WebElement _userMenu;
	private WebElement _btnMyAccount;
	private WebElement _btnEdit;
	private WebElement _usrPayInput;
	private WebElement _pswPayInput;
	private WebElement _btnCreatePay;
	private WebElement _txtSafePay;
	
	public void addPaymentMethod() throws InterruptedException {
	    //Enter to the page making login        
	    driver.findElement(By.id("menuUser")).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_menuUserTxt)));
	    _userInput = driver.findElement(By.xpath(_userInputTxt));
	    _userInput.click();
	    _userInput.sendKeys(USER_NAME);
	    _passwordInput = driver.findElement(By.xpath(_passwordInputTxt));
	    _passwordInput.click();
	    _passwordInput.sendKeys(PASS);
	    _generalHelpers.waitMiliseconds(1000);  
	    driver.findElement(By.xpath(_btnSignInTxt)).click();
	    _generalHelpers.waitMiliseconds(2000);
	    //Click on button menu for users        
	    _userMenu= driver.findElement(By.xpath(_userMenuTxt));
	    _userMenu.click();
	    _generalHelpers.waitMiliseconds(800);
	    //Go to My Account        
	    _btnMyAccount = driver.findElement(By.xpath(_btnMyAccountTxt));
	    _btnMyAccount.click();
	    _generalHelpers.implicitWaitSecs(3);
	    //Go to Edit payment method        
	    _btnEdit = driver.findElement(By.xpath(_btnEditTxt));
	    _btnEdit.click();
	    _generalHelpers.implicitWaitSecs(3);
	    //SafePay register        
	    _usrPayInput = driver.findElement(By.xpath(_usrPayInputTxt));
	    _usrPayInput.clear();
	    _usrPayInput.click();
	    _usrPayInput.sendKeys(USER_NAME);
	    _pswPayInput = driver.findElement(By.xpath(_pswPayInputTxt));
	    _pswPayInput.click();
	    _pswPayInput.sendKeys(PASS);
	    _generalHelpers.waitMiliseconds(1000);
	    _btnCreatePay = driver.findElement(By.xpath(_btnCreatePayTxt));
	    _btnCreatePay.click();
	    //Check if the saved account is the same        
	    _generalHelpers.implicitWaitSecs(8);
	    _txtSafePay = driver.findElement(By.xpath(_txtSafePayXPath));
	    Assert.assertEquals(_txtSafePay.getText(), USER_NAME);
	}
	
}
