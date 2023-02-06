package tests;

import org.testng.annotations.Test;
import controllers.UserCtrls;

public class UsersTests {
	final private UserCtrls _ctrl = new UserCtrls();
	
	@Test ( priority=1 )
	public void registrerUser() {
		_ctrl.registrer();
	}
	
	@Test ( priority=2 )
	public void loginUser() {
		_ctrl.login();
	}
}
