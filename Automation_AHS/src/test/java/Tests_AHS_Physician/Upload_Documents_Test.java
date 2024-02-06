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
import Pages_AHS_PHY.Upload_Documents_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Upload_Documents_Test extends BaseTest {

	public Login_Page login;
	public Upload_Documents_Page doc;
	public Physician_Login_test logintest;
	public Readdata data;

	public Upload_Documents_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		doc = new Upload_Documents_Page();
		logintest = new Physician_Login_test();
		data = new Readdata();
	}

	@Test(priority = 1)
	@Description("Uploading documents")
	public void UploadDocumentTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		doc.UploadDocument(data.jsondata("doc1"));
	}

	@Test(priority = 2)
	@Description("Without choosing document trying to click on upload button.")
	public void UploadDocumentNegativeTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		Thread.sleep(5000);
		String actual = doc.UploadDocumentNegative();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please select at least one file.");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}