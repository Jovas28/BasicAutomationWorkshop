package tests;

import org.testng.annotations.Test;

import controllers.ContactCtrls;

public class ContactTest {
	final private ContactCtrls _ctrl = new ContactCtrls();
	@Test
	public void main() throws InterruptedException {
		_ctrl.Chat();
	}
	
	public void contact() throws InterruptedException {
		_ctrl.Contact();
	}

}
