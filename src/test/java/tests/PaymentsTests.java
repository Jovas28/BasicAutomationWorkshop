package tests;

import org.testng.annotations.Test;

import controllers.PaymetsCtrl;

public class PaymentsTests {
	
	final private PaymetsCtrl _ctrl = new PaymetsCtrl(); 
	
	@Test
	public void addPaymentMethod() throws InterruptedException {
		_ctrl.addPaymentMethod();
	}

}
