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
import Pages_AHS_PHY.Invite_Patient_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Invite_Patient_Test extends BaseTest {

	public Login_Page login;
	public Invite_Patient_Page invitePatient;
	public Physician_Login_test logintest;
	public Readdata data;

	public Invite_Patient_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		invitePatient = new Invite_Patient_Page();
		logintest = new Physician_Login_test();
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Sending invitation to the patient")
	public void InvitePatientTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = invitePatient.InvitePatient();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Invitation successfully sent!");
	}

	@Test(priority = 2)
	@Description("Sending invitation to the patient Negative")
	public void InvitePatientNegativeTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		invitePatient.InvitePatientNegative();
		String actual = invitePatient.verifyFullName();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please Enter Full Name.");
		String actual1 = invitePatient.verifyMobile();
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Please Enter Mobile.");
		String actual2 = invitePatient.verifyEmail();
		log.info("Text value is >>>> " + actual2);
		Assert.assertEquals(actual2, "Please Enter Email.");
		String actual3 = invitePatient.verifyDocumentGroup();
		log.info("Text value is >>>> " + actual3);
		Assert.assertEquals(actual3, "Please Select Document Group");
	}

	@Test(priority = 3)
	@Description("Sending invitation to the patient Negative")
	public void InvitePatientNegativeTest1() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		invitePatient.InvitePatientNegative1();
		String actual = invitePatient.verifyFullName1();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please Enter Valid Full Name.");
		String actual1 = invitePatient.verifyMobile1();
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Please Enter Valid Mobile Number.");
		String actual2 = invitePatient.verifyEmail1();
		log.info("Text value is >>>> " + actual2);
		Assert.assertEquals(actual2, "Please Enter Valid Email Address.");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}