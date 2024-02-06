package Tests_AHS;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Login_Page;
import Pages_AHS.Universal_State_Hippaa_Forms;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class Universal_State_Hipaa_Forms_Test extends BaseTest {

	public Login_Page login;
	public Readdata data;
	public Universal_State_Hippaa_Forms hippaform;

	public Universal_State_Hipaa_Forms_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		data = new Readdata();
		hippaform = new Universal_State_Hippaa_Forms();
	}

	@Test
	@Description("Search By NPI number hipaa form for patient")
	public void Searchbynpinumber() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.searchphysician("Yourself",  data.jsondata("minor_name"));
		hippaform.searchbyNPI(data.jsondata("NPINumber"), data.jsondata("email"), data.jsondata("reenteremail"));
		Thread.sleep(3000);
		String actual= hippaform.Signthedocument();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Are you sure you want to submit this information to generate a State HIPAA Form?");
	}
	
	@Test
	@Description("Search By Name state number hipaa form for patient")
	public void SearchbyNameState() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.searchphysician("Yourself",  data.jsondata("minor_name"));
		hippaform.searchbyNameState(data.jsondata("Fname"),data.jsondata("Lname"), data.jsondata("email"), data.jsondata("reenteremail"));
		Thread.sleep(3000);
		String actual= hippaform.Signthedocument();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Are you sure you want to submit this information to generate a State HIPAA Form?");
	}
	
	@Test
	@Description("Clicking on Generate without entering the Alternate Emails for patient")
	public void Genratewithoutalternateemail() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.searchphysician("Yourself",  data.jsondata("minor_name"));
		String actual= hippaform.GenerateWithoutAlternateEmail(data.jsondata("Fname"),data.jsondata("Lname"));
		Thread.sleep(3000);
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please enter an alternate email address");
	}
	
	@Test
	@Description("Searching for the physician without entering any details for patient")
	public void Searchphysicianwithoutdetails() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.searchphysician("Yourself",  data.jsondata("minor_name"));
		String actual= hippaform.SearchPhysicianWithoutDetails();
		Thread.sleep(3000);
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please enter a first name. You may also search for a physician by their NPI number");
	}

	@Test
	@Description("Searching for the Invalid physician for patient")
	public void InvalidPhysiciansearch() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.searchphysician("Yourself",  data.jsondata("minor_name"));
		String actual= hippaform.SearchInvalidPhysician();
		Thread.sleep(3000);
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "No Records Found");
	}
	
	// Minor test cases
	
	@Test
	@Description("Search By NPI number hipaa form for minor")
	public void Searchbynpinumber_minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.searchphysician(" beth, mansvi ", data.jsondata("minor_name"));
		hippaform.searchbyNPI(data.jsondata("NPINumber"), data.jsondata("email"), data.jsondata("reenteremail"));
		Thread.sleep(3000);
		String actual= hippaform.Signthedocument();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Are you sure you want to submit this information to generate a State HIPAA Form?");
	}
	
	@Test
	@Description("Search By Name state number hipaa form for minor")
	public void SearchbyNameState_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.searchphysician(" beth, mansvi ", data.jsondata("minor_name"));
		hippaform.searchbyNameState(data.jsondata("Fname"),data.jsondata("Lname"), data.jsondata("email"), data.jsondata("reenteremail"));
		Thread.sleep(3000);
		String actual= hippaform.Signthedocument();
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Are you sure you want to submit this information to generate a State HIPAA Form?");
	}
	
	@Test
	@Description("Clicking on Generate without entering the Alternate Emails for minor")
	public void Genratewithoutalternateemail_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.searchphysician(" beth, mansvi ",  data.jsondata("minor_name"));
		String actual= hippaform.GenerateWithoutAlternateEmail(data.jsondata("Fname"),data.jsondata("Lname"));
		Thread.sleep(3000);
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please enter an alternate email address");
	}
	
	@Test
	@Description("Searching for the physician without entering any details for minor")
	public void Searchphysicianwithoutdetails_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.searchphysician(" beth, mansvi ",  data.jsondata("minor_name"));
		String actual= hippaform.SearchPhysicianWithoutDetails();
		Thread.sleep(3000);
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Please enter a first name. You may also search for a physician by their NPI number");
	}
	
	@Test
	@Description("Searching for the Invalid physician for minor")
	public void InvalidPhysiciansearch_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		hippaform.searchphysician(" beth, mansvi ",  data.jsondata("minor_name"));
		String actual= hippaform.SearchInvalidPhysician();
		Thread.sleep(3000);
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "No Records Found");
	}
	
	@Test
//	@Description("Signing asigned HIPPA")
//	public void USHFTest() throws InterruptedException, IOException, ParseException {
//
//		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
//		hippaform.USHF();
////		hippaform.searchbyNPI(data.jsondata("NPINumber"), data.jsondata("email"), data.jsondata("reenteremail"));
////		Thread.sleep(3000);
////		String actual= hippaform.Signthedocument();
////		log.info("Text value is >>>> " + actual);
////		Assert.assertEquals(actual, "Are you sure you want to submit this information to generate a State HIPAA Form?");
//	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	} 
}
	