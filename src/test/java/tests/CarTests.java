package tests;

import org.testng.annotations.Test;

import controllers.CarCtrls;

public class CarTests {
	final private CarCtrls _ctrl = new CarCtrls();
	
	@Test
	public void CarCtrls() {
		_ctrl.Buy();
	}

}
