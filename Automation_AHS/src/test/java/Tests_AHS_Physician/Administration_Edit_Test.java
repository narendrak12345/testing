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
import Pages_AHS_PHY.Administration_Edit_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Administration_Edit_Test extends BaseTest {

	public Login_Page login;
	public Administration_Edit_Page edit;
	public Physician_Login_test logintest;
	public Readdata data;

	public Administration_Edit_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		edit = new Administration_Edit_Page();
		logintest = new Physician_Login_test();
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Without Editing physician details clicking on update button")
	public void EditSameDetailsTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = edit.EditSameDetails(data.jsondata("searchtext"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Details are not updated");
	}

	@Test(priority = 2)
	@Description("Editing physician details")
	public void EditDetailsTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = edit.EditDetails(data.jsondata("searchtext"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Your details were updated successfully!");
	}

	@Test(priority = 3)
	@Description("Editing wrong physician details")
	public void EditWrongDetailsTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		edit.EditWrongDetails(data.jsondata("searchtext"));
		String actual = edit.VerifyInvalidName();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please Enter Valid Full Name.");
		String actual1 = edit.VerifyInvalidMobile();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual1, "Please Enter Valid Mobile Number.");
		String actual2 = edit.VerifyInvalidEmail();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual2, "Please Enter a Valid Email.");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}