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
import Pages_AHS_PHY.SecondOpinion_Without_PHI_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class SecondOpinion_Without_PHI_Test extends BaseTest {

	public Login_Page login;
	public SecondOpinion_Without_PHI_Page opinion;
	public Physician_Login_test logintest;
	public Readdata data;

	public SecondOpinion_Without_PHI_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		opinion = new SecondOpinion_Without_PHI_Page();
		logintest = new Physician_Login_test();
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Sending request for second opinion without PHI")
	public void SecondOpinionWithoutPHIUrgentTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = opinion.SecondOpinionWithoutPHI_Urgent(data.jsondata("doc_message"), data.jsondata("Doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}

	@Test(priority = 2)
	@Description("Sending request for second opinion without PHI")
	public void SecondOpinionWithoutPHI24HoursTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = opinion.SecondOpinionWithoutPHI_24Hours(data.jsondata("doc_message"), data.jsondata("Doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}

	@Test(priority = 3)
	@Description("Sending request for second opinion without PHI")
	public void SecondOpinionWithoutPHI48HoursTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = opinion.SecondOpinionWithoutPHI_48Hours(data.jsondata("doc_message"), data.jsondata("Doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}

	@Test(priority = 4)
	@Description("Sending request for second opinion without PHI Negative")
	public void SecondOpinionWithoutPHINegativeTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		opinion.SecondOpinionWithoutPHI_Negative();
		String actual = opinion.verifyspecialtyText();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please select Specialty");
		String actual1 = opinion.verifysubspecialtyText();
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Please Select Su		bspecialites.");
		String actual2 = opinion.verifypracticingCenterText();
		log.info("Text value is >>>> " + actual2);
		Assert.assertEquals(actual2, "Please select Center of Excellence");
		String actual3 = opinion.verifyphysicianText();
		log.info("Text value is >>>> " + actual3);
		Assert.assertEquals(actual3, "Please Select Physician.");
		String actual4 = opinion.verifyenterMsgText();
		log.info("Text value is >>>> " + actual4);
		Assert.assertEquals(actual4, "Message is required.");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}