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
import Pages_AHS_PHY.COE_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class COE_Test extends BaseTest {

	public Login_Page login;
	public COE_Page coe;
	public Physician_Login_test logintest;
	public Readdata data;

	public COE_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		coe = new COE_Page();
		logintest = new Physician_Login_test();
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Disabling COE")
	public void DisableCOETest() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = coe.DisableCOE(data.jsondata("searchtext"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Center of Excellence status successfully changed!");
	}

	@Test(priority = 2)
	@Description("Enabling COE")
	public void EnableCOETest() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = coe.EnableCOE(data.jsondata("searchtext"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Center of Excellence status successfully changed!");
	}

	@Test(priority = 3)
	@Description("Enabling OR Disabling COE")
	public void EnableOrDisableCOETest() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = coe.EnableOrDisableCOE(data.jsondata("searchtext"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Center of Excellence status successfully changed!");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}