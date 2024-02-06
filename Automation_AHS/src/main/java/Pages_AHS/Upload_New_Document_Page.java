package Pages_AHS;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Generic.Helper;
import MainBase.BaseTest;

public class Upload_New_Document_Page extends BaseTest {

	@FindBy(xpath = "//h5[text()='Upload / Share Your Documents ']")

	WebElement uploadDocBtn;

	@FindBy(xpath = "//input[@name='image']")

	WebElement uploadDocument;

	@FindBy(name = "practiceInfo1")

	WebElement selectPractice;

	@FindBy(name = "isHippByAdmin1")

	WebElement selectFolder;
	
	@FindBy(name = "physicianInfo1")
	WebElement selectPhysician;

	@FindBy(xpath = "//button[text()=' Add ']")

	WebElement addBtn;
	
	@FindBy(id="swal2-html-container")
	WebElement getAlerttext;

	@FindBy(xpath = "//button[text()='OK']")

	WebElement okBtn;

	@FindBy(xpath = "//button[text()='Cancel']")

	WebElement cancelBtn;

	@FindBy(xpath = "//button[text()=' Upload ']")

	WebElement uploadBtn;

	@FindBy(xpath = "//div[text()='Documents are successfully uploaded']")
	WebElement uploadedText;
	
	@FindBy(xpath="//div[text()='You cannot select more than 5 document files. You can share more by sending another email']")
	WebElement errorText;
	
	@FindBy(name="delegate")
	WebElement delegate;

	public static Helper help;

	public Upload_New_Document_Page() throws IOException {
		PageFactory.initElements(driver, this);
		help=new Helper();
	}
	public String UploadNewDocument(String str,String name,String doc,String minor_doc)
			throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
			String minor_doc_test=minor_doc+" "+"test";
			System.out.println("minor_doc_test: "+minor_doc_test);
			String path=getFileLink(minor_doc_test);
//			log.info("path: "+path);
			System.out.println(path);
			help.SendTextAndWait(uploadDocument,path);
		}
		else {
			
			String path1=getFileLink(doc);
			log.info("path: "+path1);
			String doc_test="test"+" "+path1;
			System.out.println("doc_test :"+doc_test);
			help.SendTextAndWait(uploadDocument,doc_test);
		}
		help.HandleDropDownByIndex(selectPractice, 1);
		help.HandleDropDownByIndex(selectFolder, 1);
			help.ClickandWait(uploadBtn);
			String text1=help.getText(getAlerttext);
			log.info("text1: "+text1);
			if(text1.equals("Are you sure you want to upload these files?"))
			{
				help.ClickandWait(okBtn);		
			}
			else {
				help.ClickandWait(cancelBtn);
				Assert.fail("Text not matched");
			}
		String result=help.ChecklElementAndGettext(uploadedText, driver);
		help.ClickandWait(okBtn);
		return result;
	}
	
	public String UploadNewHIPPADocument(String str,String name,String hippa,String minor_hippa) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
			String path=getFileLink(minor_hippa);
			log.info("path: "+path);
			help.SendTextAndWait(uploadDocument,path);
		}
		else {
		String path=getFileLink(hippa);
		log.info("path: "+path);
		help.SendTextAndWait(uploadDocument,path);
		}
		help.HandleDropDownByIndex(selectPractice, 1);
		help.HandleDropDownByIndex(selectFolder, 2);;
			help.ClickandWait(uploadBtn);
			String text1=help.getText(getAlerttext);
			log.info("text1: "+text1);
			if(text1.equals("Are you sure you want to upload these files?"))
			{
				help.ClickandWait(okBtn);
				String actual=help.ChecklElementAndGettext(uploadedText, driver);			
			}
			else {
				help.ClickandWait(cancelBtn);
				Assert.fail("Text not matched");
			}
		String result=help.ChecklElementAndGettext(uploadedText, driver);
		help.ClickandWait(okBtn);
		return result;
	}
	public String UploadNewImage(String str,String name,String image,String minor_image) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
			String path=getFileLink(minor_image);
			log.info("path: "+path);
			help.SendTextAndWait(uploadDocument,path);
		}
		else {
		String path=getFileLink(image);
		log.info("path: "+path);
		help.SendTextAndWait(uploadDocument,path);
		}
		help.HandleDropDownByIndex(selectPractice, 1);
		help.HandleDropDownByIndex(selectFolder, 3);
			help.ClickandWait(uploadBtn);
			String text1=help.getText(getAlerttext);
			log.info("text1: "+text1);
			if(text1.equals("Are you sure you want to upload these files?"))
			{
				help.ClickandWait(okBtn);	
			}
			else {
				help.ClickandWait(cancelBtn);
				Assert.fail("Text not matched");
			}
		String result=help.ChecklElementAndGettext(uploadedText, driver);
		help.ClickandWait(okBtn);
		return result;
	}
	
	public String UploadNewVideo(String str,String name,String video,String minor_video) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
			help.sleep(5000);
			String path=getFileLink(minor_video);
			log.info("path: "+path);
			help.SendTextAndWait(uploadDocument,path);
		}	
		else {
		String path=getFileLink(video);
		log.info("path: "+path);
		help.SendTextAndWait(uploadDocument,path);
		}
		help.sleep(5000);
		help.HandleDropDownByIndex(selectPractice, 1);
		help.sleep(5000);
		help.HandleDropDownByIndex(selectFolder, 4);
		help.sleep(5000);
			help.ClickandWait(uploadBtn);
			String text1=help.getText(getAlerttext);
			log.info("text1: "+text1);
			if(text1.equals("Are you sure you want to upload these files?"))
			{
				help.ClickandWait(okBtn);			
			}
			else {
				help.ClickandWait(cancelBtn);
				Assert.fail("Text not matched");
			}
		String result=help.ChecklElementAndGettext(uploadedText, driver);
		help.ClickandWait(okBtn);
		return result;
	}
	
	public String UploadNewDocumentInPractice(String str,String name,String doc1,String minor_docs)
			throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
			String path=getFileLink(minor_docs);
			log.info("path: "+path);
			help.SendTextAndWait(uploadDocument,path);
		}
		else {
		String path=getFileLink(doc1);
		log.info("path: "+path);
		help.SendTextAndWait(uploadDocument,path);
		}
		help.HandleDropDownByIndex(selectPractice, 2);
		help.HandleDropDownByIndex(selectPhysician, 1);
		help.HandleDropDownByText(selectFolder, "Upload");
		help.ClickandWait(addBtn);
		String text=help.getText(getAlerttext);
		log.info("text: "+text);
		if(text.equals("Are you sure you want to add this physician to your list of Approved Providers? This decision will be permanent to maintain an accurate log of all document sharing, but this provider can be archived on your profile in the future."))
		{
			help.ClickandWait(okBtn);
			help.ClickandWait(uploadBtn);
			String text1=help.getText(getAlerttext);
			log.info("text1: "+text1);
			if(text1.equals("Are you sure you want to upload these files?"))
			{
				help.ClickandWait(okBtn);		
			}
			else {
				help.ClickandWait(cancelBtn);
				Assert.fail("Text not matched");
			}
		}
		else {
			help.ClickandWait(cancelBtn);
			Assert.fail("Text Not Matchedx");
		}
		String result=help.ChecklElementAndGettext(uploadedText, driver);
		help.ClickandWait(okBtn);
		return result;
	}
	
	public String UploadNewHIPPADocumentInPractice(String str,String name,String hippa1,String minor_hippas) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
			String path=getFileLink(minor_hippas);
			log.info("path: "+path);
			help.SendTextAndWait(uploadDocument,path);
		}
		else {
		String path=getFileLink(hippa1);
		log.info("path: "+path);
		help.SendTextAndWait(uploadDocument,path);
		}
		help.HandleDropDownByIndex(selectPractice, 2);
		help.HandleDropDownByIndex(selectPhysician, 1);
		help.HandleDropDownByText(selectFolder, "HIPAA");
		help.ClickandWait(addBtn);
		String text=help.getText(getAlerttext);
		log.info("text: "+text);
		if(text.equals("Are you sure you want to add this physician to your list of Approved Providers? This decision will be permanent to maintain an accurate log of all document sharing, but this provider can be archived on your profile in the future."))
		{
			help.ClickandWait(okBtn);
			help.ClickandWait(uploadBtn);
			String text1=help.getText(getAlerttext);
			log.info("text1: "+text1);
			if(text1.equals("Are you sure you want to upload these files?"))
			{
				help.ClickandWait(okBtn);
				String actual=help.ChecklElementAndGettext(uploadedText, driver);			
			}
			else {
				help.ClickandWait(cancelBtn);
				Assert.fail("Text not matched");
			}
		}
		else {
			help.ClickandWait(cancelBtn);
			Assert.fail("Text Not Matchedx");
		}
		String result=help.ChecklElementAndGettext(uploadedText, driver);
		help.ClickandWait(okBtn);
		return result;
	}
	
	public String UploadNewImageInPractice(String str,String name,String image1,String minor_images) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
			String path=getFileLink(minor_images);
			log.info("path: "+path);
			help.SendTextAndWait(uploadDocument,path);
		}
		else {
		String path=getFileLink(image1);
		log.info("path: "+path);
		help.SendTextAndWait(uploadDocument,path);
		}
		help.HandleDropDownByIndex(selectPractice, 2);
		help.HandleDropDownByIndex(selectPhysician, 1);
		help.HandleDropDownByText(selectFolder, "Image");
		help.ClickandWait(addBtn);
		String text=help.getText(getAlerttext);
		log.info("text: "+text);
		if(text.equals("Are you sure you want to add this physician to your list of Approved Providers? This decision will be permanent to maintain an accurate log of all document sharing, but this provider can be archived on your profile in the future."))
		{
			help.ClickandWait(okBtn);
			help.ClickandWait(uploadBtn);
			String text1=help.getText(getAlerttext);
			log.info("text1: "+text1);
			if(text1.equals("Are you sure you want to upload these files?"))
			{
				help.ClickandWait(okBtn);	
			}
			else {
				help.ClickandWait(cancelBtn);
				Assert.fail("Text not matched");
			}
		}
		else {
			help.ClickandWait(cancelBtn);
			Assert.fail("Text Not Matchedx");
		}
		String result=help.ChecklElementAndGettext(uploadedText, driver);
		help.ClickandWait(okBtn);
		return result;
	}
	
	public String UploadNewVideoInPractice(String str,String name,String video1,String minor_videos) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
			String path=getFileLink(minor_videos);
			log.info("path: "+path);
			help.SendTextAndWait(uploadDocument,path);
		}
		else {
		String path=getFileLink(video1);
		log.info("path: "+path);
		help.SendTextAndWait(uploadDocument,path);
		}
		help.sleep(15000);
		help.HandleDropDownByIndex(selectPractice, 2);
		help.HandleDropDownByIndex(selectPhysician, 1);
		help.HandleDropDownByText(selectFolder, "Video");
		help.ClickandWait(addBtn);
		String text=help.getText(getAlerttext);
		log.info("text: "+text);
		if(text.equals("Are you sure you want to add this physician to your list of Approved Providers? This decision will be permanent to maintain an accurate log of all document sharing, but this provider can be archived on your profile in the future."))
		{
			help.ClickandWait(okBtn);
			help.ClickandWait(uploadBtn);
			String text1=help.getText(getAlerttext);
			log.info("text1: "+text1);
			if(text1.equals("Are you sure you want to upload these files?"))
			{
				help.ClickandWait(okBtn);			
			}
			else {
				help.ClickandWait(cancelBtn);
				Assert.fail("Text not matched");
			}
		}
		else {
			help.ClickandWait(cancelBtn);
			Assert.fail("Text Not Matchedx");
		}
		String result=help.ChecklElementAndGettext(uploadedText, driver);
		help.ClickandWait(okBtn);
		return result;
	}
	
	public String UploadDocumentsNegative(String str,String name,String Doc) throws InterruptedException
	{
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
		}	
	    for (int i = 0; i < 6; i++) {
	    	String path=getFileLink(Doc);
			log.info("path: "+path);
			help.SendTextAndWait(uploadDocument,path);
	        help.HandleDropDownByText(selectPractice, "Upload to my folder");
	        help.HandleDropDownByText(selectFolder, "Upload");
	    }
	    help.ClickandWait(okBtn);
	    return help.ChecklElementAndGettext(errorText, driver);
	}

}