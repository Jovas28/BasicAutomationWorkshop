package controllers;

import base.BaseClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContactCtrls extends BaseClass {
	private String _textMessage = "Hello";
    private String _expectedResponseMessage = "Thank you for contacting Advantage support.";
    private String _comments = "Hola que tal";
    public void Chat() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(30000));
        driver.findElement(By.xpath("//a[normalize-space()='CONTACT US']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chatLogo")));
        driver.findElement(By.id("chatLogo")).click();
        String parent=driver.getWindowHandle();
        Set<String> window=driver.getWindowHandles(); //the window variable will have the whole windows opened 
        Iterator<String> I1= window.iterator();
        /*In the following code the window variable is iterated and compared with the parent window in order to
          focus in the child window
        */
        while(I1.hasNext()) {
        String child_window=I1.next();
        if(!parent.equals(child_window))        {
        driver.switchTo().window(child_window);
        }
        }
        driver.findElement(By.id("textMessage")).sendKeys(_textMessage);//replace with a variable
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSender")));
        driver.findElement(By.id("btnSender")).click();
    }
    
    public void Contact() throws InterruptedException {
        /*In the following code the Contact us button is clicked to display this page
          then the drop-down is handled using clicks and explicit waits
        */
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(30000));
        String message = "";
        String email2 = "Tester123@gmail.com";
        driver.findElement(By.xpath("//a[normalize-space()='CONTACT US']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("categoryListboxContactUs")));
        driver.findElement(By.name("categoryListboxContactUs")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='object:59']")));
        driver.findElement(By.xpath("//*[@value='object:59']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("productListboxContactUs")));
        driver.findElement(By.name("productListboxContactUs")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@label='HP Chromebook 14 G1(ENERGY STAR)']")));
        driver.findElement(By.xpath("//option[@label='HP Chromebook 14 G1(ENERGY STAR)']")).click();
        driver.findElement(By.name("emailContactUs")).sendKeys(email2);
        driver.findElement(By.name("subjectTextareaContactUs")).sendKeys(_comments);//
        driver.findElement(By.id("send_btnundefined")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='roboto-regular successMessage ng-binding']")));
        message=driver.findElement(By.xpath("//p[@class='roboto-regular successMessage ng-binding']")).getText();
        Assert.assertEquals(message, _expectedResponseMessage);
    }
}
