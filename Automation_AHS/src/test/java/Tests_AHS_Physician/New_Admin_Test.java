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
import Pages_AHS_PHY.New_Admin;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)

public class New_Admin_Test extends BaseTest {
	public New_Admin NewPhy;
	public Login_Page login;
	public Readdata data;

	public New_Admin_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		NewPhy = new New_Admin();
		login = new Login_Page();
		data = new Readdata();
	}

	@Test
	@Description("Invite a Admin to the Portal ")
	public void InvitePHY() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = NewPhy.InviteNewPhy();
		log.info("actual: " + actual);
		Assert.assertEquals(actual, "User Added Successfully.");
	}

	@Test
	@Description("Invite a existing Admin to the Portal")
	public void InviteExistingPHY() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual= NewPhy.InviteExistingAdmin(data.jsondata("Admin_email"));
		log.info("actual: "+actual);
		Assert.assertEquals(actual, "Email already registered.");
	}

	@Test
	@Description("Required fields check")
	public void RequiredFieldCheck() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		NewPhy.Newadminpage();
		String actual = NewPhy.VerifyFullName();
		log.info("actual: " + actual);
		Assert.assertEquals(actual, "Please Enter Full Name.");
		String actual1 = NewPhy.VerifyInvalidFullName(data.jsondata("InLname"));
		log.info("actual1: " + actual1);
		Assert.assertEquals(actual1, "Please Enter Valid Full Name.");
		String actual2 = NewPhy.VerifyMobile();
		log.info("actual2: " + actual2);
		Assert.assertEquals(actual2, "Please Enter Mobile.");
		String actual3 = NewPhy.VerifyInvalidMobile(data.jsondata("InMobile"));
		log.info("actual3: " + actual3);
		Assert.assertEquals(actual3, "Please Enter Valid Mobile Number.");
		String actual4 = NewPhy.VerifyEmail();
		log.info("actual4: " + actual4);
		Assert.assertEquals(actual4, "Please Enter Email.");
		String actual5 = NewPhy.VerifyInvalidEmail(data.jsondata("InEmail"));
		log.info("actual5: " + actual5);
		Assert.assertEquals(actual5, "Please Enter Valid Email Address.");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
