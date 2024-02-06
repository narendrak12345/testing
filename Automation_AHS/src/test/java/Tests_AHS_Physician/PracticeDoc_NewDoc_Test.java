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
import Pages_AHS_PHY.PracticeDoc_NewDoc_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class PracticeDoc_NewDoc_Test extends BaseTest {

	public Login_Page login;
	public PracticeDoc_NewDoc_Page practice;
	public Physician_Login_test logintest;
	public Readdata data;

	public PracticeDoc_NewDoc_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		practice = new PracticeDoc_NewDoc_Page();
		logintest = new Physician_Login_test();
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Adding new document in practice document with No sign required.")
	public void UploadNewDocInPracticeTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = practice.UploadNewDocInPracticeDoc(data.jsondata("Doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Document uploaded successfully!");
	}

	@Test(priority = 2)
	@Description("Adding new document in practice document with sign required.")
	public void UploadNewDocInPracticeTest1() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = practice.UploadNewDocInPracticeDoc1(data.jsondata("Doc"), data.jsondata("doc_message"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Document uploaded successfully!");
	}

	@Test(priority = 3)
	@Description("Without adding document try to add")
	public void UploadNewDocInPracticeNegativeTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = practice.UploadNewDocInPracticeDoc_Negative();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Document is missing!");
	}

	@Test(priority = 4)
	@Description("Without adding any document  details try to add")
	public void UploadNewDocInPracticeNegativeTest1() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		practice.UploadNewDocInPracticeDoc_Negative1();
		String actual = practice.VerifyInvalidName();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please Enter Doc Name.");
		String actual1 = practice.VerifyInvalidStatus();
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Please Select Status.");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}