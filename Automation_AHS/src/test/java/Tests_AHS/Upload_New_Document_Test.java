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
import Pages_AHS.Upload_New_Document_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Upload_New_Document_Test extends BaseTest {

	public Upload_New_Document_Page doc;
	public Login_Page login;
	public Readdata data;

	public Upload_New_Document_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		doc = new Upload_New_Document_Page();
		login = new Login_Page();
		data = new Readdata(); 
	}
	@Test(priority=1)
	@Description("Upload Documents for patient")
	public void UploadNewDocumentS_Patient() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadNewDocument("Yourself",data.jsondata("minor_name"),data.jsondata("doc"),data.jsondata("minor_doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	@Test(priority=2)
	@Description("Upload Document in HIPPA Folder")
	public void UploadNewHIPPADocumentS_Patient() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=doc.UploadNewHIPPADocument("Yourself",data.jsondata("minor_name"),data.jsondata("hippa"),data.jsondata("minor_hippa"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=3)
	@Description("Upload Document in Image Folder")
	public void UploadNewImageDocumentS_Patient() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=doc.UploadNewImage("Yourself",data.jsondata("minor_name"),data.jsondata("image"),data.jsondata("minor_image"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=4)
	@Description("Upload Document in Video Folder")
	public void UploadNewVideoDocumentS_Patient() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=doc.UploadNewVideo("Yourself",data.jsondata("minor_name"),data.jsondata("video"),data.jsondata("minor_video"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=5)
	@Description("Upload Documents in upload folder in another practice")
	public void UploadNewDocumentSInPractice_Patient() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadNewDocumentInPractice("Yourself",data.jsondata("minor_name"),data.jsondata("doc1"),data.jsondata("minor_doc1"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=6)
	@Description("Upload Documents in hippa folder in another practice")
	public void UploadNewHIPPASInPractice_Patient() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadNewHIPPADocumentInPractice("Yourself",data.jsondata("minor_name"),data.jsondata("hippa1"),data.jsondata("minor_hippa1"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=7)
	@Description("Upload Documents in image folder in another practice")
	public void UploadNewIamgeInPractice_Patient() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadNewImageInPractice("Yourself",data.jsondata("minor_name"),data.jsondata("image1"),data.jsondata("minor_image1"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=8)
	@Description("Upload Documents in video folder in another practice")
	public void UploadNewVideoInPractice_Patient() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadNewVideoInPractice("Yourself",data.jsondata("minor_name"),data.jsondata("video1"),data.jsondata("minor_video1"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=9)
	@Description("Uploading more than 5 documents")
	public void UploadNewDocumentNegative_Patient() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadDocumentsNegative("Yourself",data.jsondata("minor_name"),data.jsondata("Doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "You cannot select more than 5 document files. You can share more by sending another email");
	}
	@Test(priority=10)
	@Description("Upload Documents for minor")
	public void UploadNewDocumentS_minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadNewDocument(" beth, mansvi ",data.jsondata("minor_name"),data.jsondata("doc"),data.jsondata("minor_doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	@Test(priority=11)
	@Description("Upload Document in HIPPA Folder")
	public void UploadNewHIPPADocumentS_minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=doc.UploadNewHIPPADocument(" beth, mansvi ",data.jsondata("minor_name"),data.jsondata("hippa"),data.jsondata("minor_hippa"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=12)
	@Description("Upload Document in Image Folder")
	public void UploadNewImageDocuments_minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=doc.UploadNewImage(" beth, mansvi ",data.jsondata("minor_name"),data.jsondata("image"),data.jsondata("minor_image"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=13)
	@Description("Upload Document in Video Folder")
	public void UploadNewVideoDocumentS_minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual1=doc.UploadNewVideo(" beth, mansvi ",data.jsondata("minor_name"),data.jsondata("video"),data.jsondata("minor_video"));
		log.info("Text value is >>>> " + actual1);
		Assert.assertEquals(actual1, "Documents are successfully uploaded");
	}
	
	@Test(priority=14)
	@Description("Upload Documents in upload folder in another practice")
	public void UploadNewDocumentSInPractice_minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadNewDocumentInPractice(" beth, mansvi ",data.jsondata("minor_name"),data.jsondata("doc1"),data.jsondata("minor_docs"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=15)
	@Description("Upload Documents in hippa folder in another practice")
	public void UploadNewHIPPASInPractice_minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadNewHIPPADocumentInPractice(" beth, mansvi ",data.jsondata("minor_name"),data.jsondata("hippa1"),data.jsondata("minor_hippas"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=16)
	@Description("Upload Documents in image folder in another practice")
	public void UploadNewIamgeInPractice_minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadNewImageInPractice(" beth, mansvi ",data.jsondata("minor_name"),data.jsondata("image1"),data.jsondata("minor_images"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=17)
	@Description("Upload Documents in video folder in another practice")
	public void UploadNewVideoInPractice_minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadNewVideoInPractice(" beth, mansvi ",data.jsondata("minor_name"),data.jsondata("video1"),data.jsondata("minor_videos"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Documents are successfully uploaded");
	}
	
	@Test(priority=18)
	@Description("Uploading more than 5 documents")
	public void UploadNewDocumentNegative_minor() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=doc.UploadDocumentsNegative(" beth, mansvi ",data.jsondata("minor_name"),data.jsondata("Doc"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "You cannot select more than 5 document files. You can share more by sending another email");
	}
	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}


