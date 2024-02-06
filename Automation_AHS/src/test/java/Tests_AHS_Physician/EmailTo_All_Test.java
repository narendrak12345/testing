package Tests_AHS_Physician;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Login_Page;
import Pages_AHS_PHY.Email_To_All_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class EmailTo_All_Test extends BaseTest {

	public Login_Page login;
	public Email_To_All_Page emailAll;
	public Physician_Login_test logintest;
	public Readdata data;

	public EmailTo_All_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		emailAll = new Email_To_All_Page();
		logintest = new Physician_Login_test();
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Sending email to all")
	public void EmailToAllTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = emailAll.EmailToAll(data.jsondata("eSubject"), data.jsondata("doc_message"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email successfully sent to all patients!");
	}

	@Test(priority = 2)
	@Description("Sending doctor to doctor email by registered physician")
	public void EmailToAllNegativeTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		emailAll.EmailToAllNegative();
		String actual = emailAll.verifyEmailSubject();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Subject is required.");
		String actual1 = emailAll.verifyEmailMessage();
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Message is required.");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}