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
import Pages_AHS.Universal_State_Hippaa_Forms;
import Pages_AHS_PHY.Send_HIPPA_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Send_HIPPA_Test extends BaseTest {

	public Login_Page login;
	public Send_HIPPA_Page hippa;
	public Physician_Login_test logintest;
	public Universal_State_Hippaa_Forms hippaform;
	public Readdata data;

	public Send_HIPPA_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		hippa = new Send_HIPPA_Page();
		logintest = new Physician_Login_test();
		hippaform = new Universal_State_Hippaa_Forms();
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Send HIPPA by searching physician with name and state.")
	public void SendHIPPA() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		hippa.SendHIPPA(data.jsondata("doc_message"), data.jsondata("phyEmail"));
	}

	@Test(priority = 2, dependsOnMethods = "SendHIPPA")
	@Description("Signing asigned HIPPA")
	public void USHFTest() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.USHF();
	}

	@Test(priority = 3, dependsOnMethods = "USHFTest")
	@Description("Send HIPPA by searching physician with NPI number.")
	public void SendHIPPAByNPI() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		hippa.SendHIPPAByNPI(data.jsondata("npi"), data.jsondata("doc_message"), data.jsondata("phyEmail"));
		Thread.sleep(3000);
	}

	@Test(priority = 4, dependsOnMethods = "SendHIPPAByNPI")
	@Description("Running USHFTest again after SendHIPPAByNPI.")
	public void USHFTestAfterSendHIPPAByNPI() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.USHF();
	}

	@Test(priority = 5)
	@Description("Without selecting HIPPA trying to send email.")
	public void SendHIPPANegativeTest() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = hippa.SendHIPPANegative();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "No HIPAA form can be found for this state");
	}

	@Test(priority = 5)
	@Description("Direct trying to choose physician.")
	public void SendHIPPANegativeTest1() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = hippa.SendHIPPANegative1();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual,
				"Please enter a first name. You may also search for a physician by their NPI number");
	}

	@Test(priority = 6)
	@Description("Without entering name and state trying to select physician.")
	public void SendHIPPANegativeTest2() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		hippa.SendHIPPANegative2();
		String actual = hippa.VerifyRecordText();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "No Records Found");
	}

	@Test(priority = 7)
	@Description("Without entering NPI trying to select physician.")
	public void SendHIPPANegativeTest3() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		hippa.SendHIPPANegative3();
		String actual = hippa.VerifyRecordText1();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "No Records Found");
	}

	@Test(priority = 8)
	@Description("Without selecting HIPPA trying to send email.")
	public void SendHIPPANegativeTest4() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = hippa.SendHIPPAByNPINegative3(data.jsondata("npi"), data.jsondata("doc_message"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual,
				"Selected Physician has no email, please contact your administrator to get it, and enter in 'Physician Alternate Email' inpit box.");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}