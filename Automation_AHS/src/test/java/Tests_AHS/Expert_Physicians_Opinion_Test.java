package Tests_AHS;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Expert_Physicians_Opinion;
import Pages_AHS.Login_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class Expert_Physicians_Opinion_Test extends BaseTest {
	
	public Login_Page login;
	public Expert_Physicians_Opinion expertopinion;
	public Readdata data;

	public Expert_Physicians_Opinion_Test() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		expertopinion = new Expert_Physicians_Opinion();
		login = new Login_Page();
		data = new Readdata();
	}
	
	@Test
	@Description("Expert Physician Opinion With Existing Hippa for patient")
	public void Expert_Physician_Opinion_With_ExistingHippa() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
        String actual= expertopinion.Expert_Physician_Opinion_With_ExistingHippa("Yourself", data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!","Message displayed is incorrect.");
	}
	
	@Test
	@Description("Expert Physician Opinion By generating new Hippa for patient")
	public void Expert_Physician_Opinion_By_Generate() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
        String actual= expertopinion.Expert_Physician_Opinion_By_Generate("Yourself", data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!","Message displayed is incorrect.");
	}
	
	@Test
	@Description("Negative test without selecting the document for patient")
	public void Without_Selecting_Doc() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
        String actual= expertopinion.Without_selecting_Doc("Yourself", data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Before clicking 'OK,' you must first select the matching State HIPAA Form that lists the doctor’s name and at least one file to be shared");
	}
	
	@Test
	@Description("Expert Physician Opinion By Uploading existing Hippa for patient")
	public void Expert_Physician_Opinion_By_UploadingHippa() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
        String actual= expertopinion.Expert_Physician_Opinion_By_UploadingHippa("Yourself",  data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}
	@Test
	@Description("Expert Physician Opinion By Uploading existing Hippa for patient")
	public void Expert_Physician_Opinion_By_unsupported_File() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
        String actual= expertopinion.Expert_Physician_Opinion_By_unsupported_File("Yourself",  data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "We're sorry; the selected HIPAA file format is not supported. Please convert it to a .png, .jpg, .jpeg. or .pdf");
	}
	
	
	// Minor Test Cases
	
	@Test
	@Description("Expert Physician Opinion With Existing Hippa for minor")
	public void Expert_Physician_Opinion_With_ExistingHippa_minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
        String actual= expertopinion.Expert_Physician_Opinion_With_ExistingHippa(" beth, mansvi ", data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!","Message displayed is incorrect.");
	}
	@Test
	@Description("Expert Physician Opinion By generating new Hippa for minor")
	public void Expert_Physician_Opinion_By_Generate_minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
        String actual= expertopinion.Expert_Physician_Opinion_By_Generate(" beth, mansvi ",  data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!","Message displayed is incorrect.");
	}
	
	@Test
	@Description("Negative test without selecting the document for minor")
	public void Without_Selecting_Doc_minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
        String actual= expertopinion.Without_selecting_Doc(" beth, mansvi ",  data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Before clicking 'OK,' you must first select the matching State HIPAA Form that lists the doctor’s name and at least one file to be shared");
	}
	
	@Test
	@Description("Expert Physician Opinion By Uploading existing Hippa for minor")
	public void Expert_Physician_Opinion_By_UploadingHippa_minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
        String actual= expertopinion.Expert_Physician_Opinion_By_UploadingHippa(" beth, mansvi ",  data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}
	@Test
	@Description("Expert Physician Opinion By Uploading existing Hippa for minor")
	public void Expert_Physician_Opinion_By_unsupported_File_minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
        String actual= expertopinion.Expert_Physician_Opinion_By_unsupported_File(" beth, mansvi ",  data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "We're sorry; the selected HIPAA file format is not supported. Please convert it to a .png, .jpg, .jpeg. or .pdf");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
	