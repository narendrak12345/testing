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
import Pages_AHS_PHY.Review_demographics_PHY_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Review_demographics_PHY_Test extends BaseTest {

	public Login_Page login;
	public Review_demographics_PHY_Page demo;
	public Physician_Login_test logintest;
	public Readdata data;

	public Review_demographics_PHY_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		demo = new Review_demographics_PHY_Page();
		logintest = new Physician_Login_test();
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Without updating click on sumbit button")
	public void ReviewDemographicsNoChanges() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = demo.FillDemoGraphics();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Your profile has not been updated");
	}

	@Test(priority = 2)
	@Description("updating answer1 field")
	public void ReviewDemographicsChanges() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = demo.UpdateDemoGraphics();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Profile updated successfully!");
	}

	@Test
	@Description("Validating with invalid test data for patient")
	public void TestwithNegativescenario() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		demo.clickOnDemo();
		String actual1 = demo.Verifstreet();
		Assert.assertEquals(actual1, "Please Enter 1st Street.");
		String actual2 = demo.Verifcity();
		Assert.assertEquals(actual2, "Please Enter City/Town.");
		String actual3 = demo.Verifyzip();
		Assert.assertEquals(actual3, "Please Enter Zipcode");
		String actual4 = demo.Verifycellularphone();
		Assert.assertEquals(actual4, "Please Enter Office Phone.");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}