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
import Pages_AHS.Review_And_Sign_Document_Page;
import Pages_AHS_PHY.Assign_Doc_group_Page;
import ReadJsonData.Readdata;
import Tests_AHS.Review_And_Sign_Document_Test;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Assign__Doc_Group_Test extends BaseTest {

	public Login_Page login;
	public Assign_Doc_group_Page assignDoc;
	public Physician_Login_test logintest;
	public Readdata data;
	public Review_And_Sign_Document_Test reviewDoc;
	public Review_And_Sign_Document_Page reviewDocPage;

	public Assign__Doc_Group_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		assignDoc = new Assign_Doc_group_Page();
		logintest = new Physician_Login_test();
		data = new Readdata();
		reviewDocPage = new Review_And_Sign_Document_Page();
		reviewDoc = new Review_And_Sign_Document_Test();
	}

	@Test(priority = 1)
	@Description("Assigning document group to the patient for sign")
	public void AssignDocGroupTEst() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = assignDoc.AssignDocGroup();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Document Group assigned successfully!");
//		Thread.sleep(3000);
//		reviewDoc.ReviewAndSignDocumentTest();
	}

	@Test(priority = 2)
	@Description("Review and Signthe assigned documents")
	public void AssignDocGroupTEst1() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = reviewDocPage.ReviewAndSignDocument();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Demographics successfully submitted!");
	}

	@Test(priority = 3)
	@Description("Witout selecting documemnt group trying to assign")
	public void AssignDocGroupNeagtiveTEst() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		assignDoc.AssignDocGroupNegative();
		String actual = assignDoc.verifyDocumentText();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please Select Document Group");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}