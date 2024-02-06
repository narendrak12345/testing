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
import Pages_AHS_PHY.Doctor_To_Doctor_Email_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Doctor_To_Doctor_Email_Test extends BaseTest {

	public Login_Page login;
	public Doctor_To_Doctor_Email_Page doctorEmail;
	public Physician_Login_test logintest;
	public Readdata data;

	public Doctor_To_Doctor_Email_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		doctorEmail = new Doctor_To_Doctor_Email_Page();
		logintest = new Physician_Login_test();
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Sending doctor to doctor email by registered physician")
	public void NewDoctorToDoctorEmailByRegPhyTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = doctorEmail.NewDoctorToDoctorEmail(data.jsondata("doc_message"), data.jsondata("Doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Your email sent successfully!");
	}

	@Test(priority = 2)
	@Description("Sending doctor to doctor email by registered physician")
	public void NewDoctorToDoctorEmailBySearchPhyTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = doctorEmail.NewDoctorToDoctorEmailBySearchPhy(data.jsondata("firstName"),
				data.jsondata("lastName"), data.jsondata("doc_message"), data.jsondata("phyEmail"),
				data.jsondata("Doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Your email sent successfully!");
	}

	@Test(priority = 3)
	@Description("Sending doctor to doctor email by NPI number")
	public void NewDoctorToDoctorEmailByNPITest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = doctorEmail.NewDoctorToDoctorEmailByNPI(data.jsondata("NPINum"), data.jsondata("doc_message"),
				data.jsondata("phyEmail"), data.jsondata("Doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Your email sent successfully!");
	}

	@Test(priority = 4)
	@Description("Sending doctor to doctor email by NPI number")
	public void NewDoctorToDoctorEmailBySearchPhyNegativeTest()
			throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = doctorEmail.NewDoctorToDoctorEmailBySearchPhyNegative();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual,
				"Please enter a first name. You may also search for a physician by their NPI number");
	}

	@Test(priority = 5)
	@Description("Sending doctor to doctor email by NPI number")
	public void NewDoctorToDoctorEmailBySearchPhyNegative1Test()
			throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = doctorEmail.NewDoctorToDoctorEmailBySearchPhyNegative1(data.jsondata("invalifirstName"),
				data.jsondata("invalidLastName"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "No Records Found");
	}

	@Test(priority = 6)
	@Description("Sending doctor to doctor email by NPI number")
	public void NewDoctorToDoctorEmailBySearchPhyNegative2Test()
			throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = doctorEmail.NewDoctorToDoctorEmailBySearchPhyNegative2();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "No Records Found");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}