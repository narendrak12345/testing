package Tests_AHS;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Add_new_Doctor;
import Pages_AHS.Login_Page;
import Pages_AHS.Review_demographics_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Review_demographics_Test extends BaseTest {

	public Login_Page login;
	public Review_demographics_Page demo;
	public Login_test logintest;
	public Readdata data;

	public Review_demographics_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		demo = new Review_demographics_Page();
		logintest=new Login_test();
		data = new Readdata();
		}
	
	@Test
	@Description("Fields are not updating,simply clicking on Active button for patient")
	public void Updateexistprofile() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = demo.FillDemoGraphics("Yourself",  data.jsondata("minor_name"));
		log.info(actual);
		Assert.assertEquals(actual, "REVIEW DEMOGRAPHICS");
		}
	
	@Test
	@Description("Validating with invalid test data for patient")
	public void TestwithNegativescenario() throws InterruptedException, IOException, ParseException {

		
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		demo.clickOnDemo("Yourself",  data.jsondata("minor_name"));
		String actual1 = demo.Verifstreet();
		Assert.assertEquals(actual1, "Please Enter Street Address.");
		String actual2 = demo.Verifcity();
		Assert.assertEquals(actual2, "Please Enter City.");
		String actual3 = demo.Verifyzip();
		Assert.assertEquals(actual3, "Please Enter zip code.");
		String actual4 = demo.Verifycellularphone();
		Assert.assertEquals(actual4, "Please Enter Cellular Phone.");
		}
	
	@Test
	@Description("Fields are not updating,simply clicking on Active button")
	public void Updatprofile() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = demo.FillDemoGraphics("Yourself",  data.jsondata("minor_name"));
		log.info(actual);
		Assert.assertEquals(actual, "REVIEW DEMOGRAPHICS");
	}
	@Test
	@Description("Entering fields inputs and Click on Accpet button for Patient")
	public void TestwithValidTestDatawithoutsignupdate() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		demo.clickOnDemo("Yourself",  data.jsondata("minor_name"));
		demo.FillData("all 1","cables","234323","6142315231");
	}
	
	@Test
	@Description("Entering fields inputs and Click on Accpet button and sign for Patient")
	public void TestwithValidTestDatawithsignupdate() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		demo.clickOnDemo("Yourself",  data.jsondata("minor_name"));
		demo.FillDataToSign();
	}
	
	@Test
	@Description("Entering fields inputs and Click on Accpet button for Patient")
	public void TestwithValidTestDatabysignupdate() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		demo.clickOnDemo("Yourself",  data.jsondata("minor_name"));
		demo.FillData("all 1","cables","234323","6142315231");
	}
	
	
	// Minor Test cases.
	
	@Test
	@Description("Fields are not updating,simply clicking on Active button for minor")
	public void Updateexistprofile_minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = demo.FillDemoGraphics(" beth, mansvi ",  data.jsondata("minor_name"));
		log.info(actual);
		Assert.assertEquals(actual, "REVIEW DEMOGRAPHICS");
		}
	
	@Test
	@Description("Validating with invalid test data for minor")
	public void TestwithNegativescenario_minor() throws InterruptedException, IOException, ParseException {

		
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		demo.clickOnDemo(" beth, mansvi ",  data.jsondata("minor_name"));
		String actual1 = demo.Verifstreet();
		Assert.assertEquals(actual1, "Please Enter Street Address.");
		String actual2 = demo.Verifcity();
		Assert.assertEquals(actual2, "Please Enter City.");
		String actual3 = demo.Verifyzip();
		Assert.assertEquals(actual3, "Please Enter zip code.");
		String actual4 = demo.Verifycellularphone();
		Assert.assertEquals(actual4, "Please Enter Cellular Phone.");
		}
	
	@Test
	@Description("Entering fields inputs and Click on Accpet button for minor")
	public void TestwithValidTestData_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		demo.clickOnDemo(" beth, mansvi ",  data.jsondata("minor_name"));
		demo.FillData("all 1","cables","234323","6142315231");
	}
	
	@Test
	@Description("Entering fields inputs and Click on Accpet button and sign for minor")
	public void TestwithValidTestDatawithsignupdate_minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		demo.clickOnDemo(" beth, mansvi ",  data.jsondata("minor_name"));
		demo.FillDataToSign();
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}