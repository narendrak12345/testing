package Tests_AHS_Physician;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Login_Page;
import Pages_AHS_PHY.Send_Email_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Send_Email_Test extends BaseTest {

	public Login_Page login;
	public Send_Email_Page email;
	public Physician_Login_test logintest;
	
	public Readdata data;

	public Send_Email_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		email = new Send_Email_Page();
		logintest = new Physician_Login_test();
		
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Sending email to the patient.")
	public void SendEMailTest() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		email.SendEmail(data.jsondata("image"));
	}
	
	@Test(priority = 2)
	@Description("Without entering any details trying to send email.")
	public void Negative() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		email.SendEmailNegative();
	}

	
	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}