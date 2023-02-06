package helpers;

import java.util.concurrent.TimeUnit;

import base.BaseClass;

public class GeneralHelpers extends BaseClass {
	public void implicitWaitSecs(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
