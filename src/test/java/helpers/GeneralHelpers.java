package helpers;

import java.util.concurrent.TimeUnit;

import base.BaseClass;

public class GeneralHelpers extends BaseClass {
	public void implicitWaitSecs(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
	
	public void waitMiliseconds(int milisec) {
	    //driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);        
	    try {
	        Thread.sleep(milisec);
	    } catch (InterruptedException e) {
	        // TODO Auto-generated catch block            e.printStackTrace();
	    }
	}
}
