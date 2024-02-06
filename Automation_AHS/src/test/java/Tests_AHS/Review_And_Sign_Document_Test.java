package Tests_AHS;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import ReadJsonData.Readdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import MainBase.BaseTest;
import Pages_AHS.Login_Page;
import Pages_AHS.Review_And_Sign_Document_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Review_And_Sign_Document_Test extends BaseTest {

	public Review_And_Sign_Document_Page signDoc;
	public Login_Page login;
	public Readdata data;

	public Review_And_Sign_Document_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		signDoc = new Review_And_Sign_Document_Page();
		login = new Login_Page();
		data = new Readdata(); 
	}
	@Test(priority=0)
	@Description("Review and sign assigned documents in assigned group")
	public void ReviewAndSignDocumentTest() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=signDoc.ReviewAndSignDocument();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Demographics successfully submitted!");
	}
	
	

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}


