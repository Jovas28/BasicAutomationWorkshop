package controllers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseClass;
import helpers.GeneralHelpers;

public class UserCtrls extends BaseClass {
	final private GeneralHelpers _generalHelpers = new GeneralHelpers();
	// References for web controls    
	final private String _xpathUserBtn = "//a[@id='hrefUserIcon']";
	final private String _xpathCreateUserBtn = "//a[normalize-space()='CREATE NEW ACCOUNT']";
	final private String _nameUserNameTxt = "usernameRegisterPage";
	final private String _nameEmailTxt = "emailRegisterPage";
	final private String _namePassTxt = "passwordRegisterPage";
	final private String _nameConfPassTxt = "confirm_passwordRegisterPage";
	final private String _nameIAgreeCheck = "i_agree";
	final private String _idRegisterBtn = "register_btnundefined";
	final private String _xpathLoggedUserName = "//a[@id='menuUserLink']";
	final private String _xpathBtnSign = "//button[@id=\"sign_in_btnundefined\"]";
	// Web controls    
	public  WebElement _btnUser;
	private WebElement _btnNewUser;
	private WebElement _txtUserName;
	private WebElement _txtEmail;
	private WebElement _txtPass;
	private WebElement _txtPassAgain;
	private WebElement _checkIAgree;
	private WebElement _btnRegister;
	private WebElement _txtLoggedUserName;
	
	public void registrer() {
	    System.out.println("CreateAccount.Run() started");
	    //Loading main page       
	    _generalHelpers.waitMiliseconds(3000);
	    bindUI();   //Binding/Initializing controls for main page        
	    _btnUser.click();
	    _generalHelpers.waitMiliseconds(1000);
	    _btnNewUser.click();
	    //Loading register page        
	    _generalHelpers.implicitWaitSecs(3);
	    bindUI2();  //Binding/Initializing controls for register page        
	    _txtUserName.sendKeys(USER_NAME);    //Filling controls        
	    _txtEmail.sendKeys(EMAIL);
	    _txtPass.sendKeys(PASS);
	    _txtPassAgain.sendKeys(PASS);
	    _checkIAgree.click();
	    _generalHelpers.implicitWaitSecs(3); 
	    _btnRegister.click();
	    //ImplicitWaitSecs(3); //It doesn't work        
	    _generalHelpers.waitMiliseconds(3000);
	    //Loading main page again        
	    String loggedUser = _txtLoggedUserName.getText();
	    System.out.println("Current User has logged in: " + loggedUser);
	    Assert.assertEquals(USER_NAME, loggedUser);
	    System.out.println("CreateAccount.Run() finished");
	}
	
	public void bindUI() {
	    _btnUser = driver.findElement(By.xpath(_xpathUserBtn));
	    _btnNewUser = driver.findElement(By.xpath(_xpathCreateUserBtn));
	    _txtLoggedUserName = driver.findElement(By.xpath(_xpathLoggedUserName));
	 }
	
	public void bindUI2() {
	    _txtUserName = driver.findElement(By.name(_nameUserNameTxt));
	    _txtEmail = driver.findElement(By.name(_nameEmailTxt));
	    _txtPass = driver.findElement(By.name(_namePassTxt));
	    _txtPassAgain = driver.findElement(By.name(_nameConfPassTxt));
	    _checkIAgree = driver.findElement(By.name(_nameIAgreeCheck));
	    _btnRegister = driver.findElement(By.id(_idRegisterBtn));
	}
	
	public void login(){
	    driver.findElement(By.id("menuUser")).click(); // Click on user icon
	    // Input credentials
	    driver.findElement(By.name("username")).sendKeys(USER_NAME); 
	    driver.findElement(By.name("password")).sendKeys(PASS);
	    driver.findElement(By.xpath(_xpathBtnSign)).click(); // Click on Sign in
	    WebElement txtUserLogged = driver.findElement(
	    	By.xpath("//*[text()='" + USER_NAME+ "' and @class='hi-user containMiniTitle ng-binding']")
	    ); // Check if the user login was success full
	    Assert.assertEquals(USER_NAME, txtUserLogged.getText());
	}
}
