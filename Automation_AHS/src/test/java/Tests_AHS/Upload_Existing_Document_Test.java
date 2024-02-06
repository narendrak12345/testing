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
import Pages_AHS.Upload_Existing_Document_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Upload_Existing_Document_Test extends BaseTest {

	public Upload_Existing_Document_Page docs;
	public Login_Page login;
	public Readdata data;

	public Upload_Existing_Document_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		docs = new Upload_Existing_Document_Page();
		login = new Login_Page();
		data = new Readdata(); 
		log.info("Application started");
	}
	@Test(priority=1)
	@Description("Upload Existing Documents for patient")
	public void UploadExistingDocumentS_Patient() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingDocument("Yourself",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=2)
	@Description("Upload Existing Document in HIPPA Folder")
	public void UploadExistingHIPPADocumentS_Patient() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=docs.UploadExistingHIPPADocument("Yourself",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=3)
	@Description("Upload Existing Document in Image Folder")
	public void UploadExistingImageDocumentS_Patient() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=docs.UploadExistingImage("Yourself",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=4)
	@Description("Upload Existing Document in Video Folder")
	public void UploadExistingVideoDocumentS_Patient() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=docs.UploadExistingVideo("Yourself",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=5)
	@Description("Upload Existing Documents in upload folder in another practice")
	public void UploadExistingDocumentSInPractice_Patient() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingDocumentInPractice("Yourself",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=6)
	@Description("Upload Existing Documents in hippa folder in another practice")
	public void UploadNewHIPPASInPractice_Patient() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingHIPPADocumentInPractice("Yourself",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=7)
	@Description("Upload Existing Documents in image folder in another practice")
	public void UploadExistingIamgeInPractice_Patient() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingImageInPractice("Yourself",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=8)
	@Description("Upload Existing Documents in video folder in another practice")
	public void UploadNewVideoInPractice_Patient() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingVideoInPractice("Yourself",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=9)
	@Description("Selecting more than 5 documents")
	public void UploadNExistingDocumentNegative_Patient() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingDocumentNegative("Yourself",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "You cannot select more than 5 document files. You can share more by sending another email");
	}
	
	@Test(priority=10)
	@Description("Upload Existing Documents for minor")
	public void UploadExistingDocumentS_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingDocument(" beth, mansvi ",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	@Test(priority=11)
	@Description("Upload Existing Document in HIPPA Folder")
	public void UploadExistingHIPPADocumentS_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=docs.UploadExistingHIPPADocument(" beth, mansvi ",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=12)
	@Description("Upload Existing Document in Image Folder")
	public void UploadExistingImageDocumentS_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=docs.UploadExistingImage(" beth, mansvi ",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=13)
	@Description("Upload Existing Document in Video Folder")
	public void UploadExistingVideoDocumentS_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=docs.UploadExistingVideo(" beth, mansvi ",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=14)
	@Description("Upload Existing Documents in upload folder in another practice")
	public void UploadExistingDocumentSInPractice_Minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingDocumentInPractice(" beth, mansvi ",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=15)
	@Description("Upload Existing Documents in hippa folder in another practice")
	public void UploadNewHIPPASInPractice_Minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingHIPPADocumentInPractice(" beth, mansvi ",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=16)
	@Description("Upload Existing Documents in image folder in another practice")
	public void UploadExistingIamgeInPractice_Minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingImageInPractice(" beth, mansvi ",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=17)
	@Description("Upload Existing Documents in video folder in another practice")
	public void UploadNewVideoInPractice_Minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingVideoInPractice(" beth, mansvi ",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=18)
	@Description("Selecting more than 5 documents")
	public void UploadNExistingDocumentNegative_Minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=docs.UploadExistingDocumentNegative(" beth, mansvi ",data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "You cannot select more than 5 document files. You can share more by sending another email");
	}
	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}


