package Test_Cases;

import org.testng.annotations.Test;

public class SIGN_UP extends config.Configuration {

	@Test
	public void navigate_to_singup() throws InterruptedException {

		dashbaord.click_login_signup();
		Thread.sleep(2000);
		dashbaord.click_login_signup_link();

	}

}
