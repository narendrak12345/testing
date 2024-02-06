package Tests_AHS_Physician;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Login_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Physician_Login_test extends BaseTest {

	public Login_Page login;

	public Physician_Login_test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		log.info("Before method");
	}

	@Test(priority = 1, description = "Verify successful login with correct credentials")
	@Description("Test description:Once successful login check wether review Demographics module available are not")
	public void Testsuccessfullogin() throws InterruptedException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = login.phy_verify();
		log.info(actual);
		Assert.assertEquals(actual, "REVIEW PROFILE");
		log.info("Successful login");
	}

	@Test(priority = 2, description = "Verify Unsuccessful login with Incorrect credentials")
	@Description("Test description:Once Unsuccesful login check wether Invalid username or password is apppears on screen")
	public void TestUnsuccessfullogin() throws InterruptedException {

		login.checkloginIncorrectcrdentials(prop.getProperty("phy_Incorrectemail"),
				prop.getProperty("Incorrectpassword"));
		String actual = login.VerifyInvalidcredentials();
		log.info(actual);
		Assert.assertEquals(actual, "Invalid username or password");
	}

	@Test(priority = 3, description = "Verify That if Wrong otp enter")
	public void VerifyWrongOtpEnter() throws InterruptedException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("IncorrectOTP"));
		Thread.sleep(3000);
		String actual = login.verifywrongotp();
		log.info(actual);
		Assert.assertEquals(actual, "Invalid OTP");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}