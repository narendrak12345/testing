package Pages_AHS;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Generic.Helper;
import MainBase.BaseTest;
import ReadJsonData.Readdata;

public class Upload_Existing_Document_Page extends BaseTest {

	@FindBy(xpath = "//h5[text()='Upload / Share Your Documents ']")

	WebElement uploadDocBtn;

	@FindBy(xpath = "//span[@class='dropdown-btn']")

	WebElement dropdownList;

	@FindBy(xpath = "//div[text()='minor_doc.pdf']")

	WebElement selectHippaDOc;
	
	@FindBy(xpath = "//div[text()='Demo(0208).docx']")

	WebElement selectDOc;	
	
	@FindBy(xpath = "//div[text()='lungs.jpg']")
	WebElement selectDOc1;
	
	@FindBy(xpath = "//div[text()='minor_doc.pdf']")

	WebElement selectDOc2;
	
	@FindBy(xpath = "//div[text()='sampleVideo1.mp4']")

	WebElement selectDOc3;
	
	@FindBy(xpath = "//div[text()='Demo(0208) 1.docx']")

	WebElement selectDOc4;
	
	@FindBy(xpath = "//div[text()='Nevada-HIPAA-Release-Form (1)']")

	WebElement selectDOc5;
	
	@FindBy(xpath = "//div[text()='lungs.jpg']")
	WebElement selectImage;
	
	@FindBy(xpath = "//div[text()='sampleVideo1.mp4']")

	WebElement selectVideo;
	
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
	
	@FindBy(name="delegate")
	WebElement delegate;
	

	public static Helper help;
	public Readdata data;

	public Upload_Existing_Document_Page() throws IOException {
		PageFactory.initElements(driver, this);
		help=new Helper();
		data = new Readdata(); 
	}

	public String UploadExistingDocument(String str,String name)
			throws IOException, InterruptedException, ParseException {
		help.sleep(3000);
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		System.out.println("str: "+str);
		System.out.println("minor_name: "+name);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
		}

		help.ClickandWait(dropdownList);
		help.ClickandWait(selectDOc);
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

	public String UploadExistingHIPPADocument(String str,String name) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		System.out.println("str: "+str);
		System.out.println("minor_name: "+name);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
		}
		help.ClickandWait(dropdownList);
		help.ClickandWait(selectHippaDOc);
		help.HandleDropDownByIndex(selectPractice, 1);
		help.HandleDropDownByIndex(selectFolder, 2);
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
	
	public String UploadExistingImage(String str,String name) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		System.out.println("str: "+str);
		System.out.println("minor_name: "+name);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
		}
		help.ClickandWait(dropdownList);
		help.ClickandWait(selectImage);
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
	
	public String UploadExistingVideo(String str,String name) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		System.out.println("str: "+str);
		System.out.println("minor_name: "+name);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
		}
		help.ClickandWait(dropdownList);
		help.ClickandWait(selectVideo);
		help.HandleDropDownByIndex(selectPractice, 1);
		help.HandleDropDownByIndex(selectFolder, 4);
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
	
	public String UploadExistingDocumentInPractice(String str,String name)
			throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		System.out.println("str: "+str);
		System.out.println("minor_name: "+name);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
		}
		help.ClickandWait(dropdownList);
		help.ClickandWait(selectDOc);
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
	
	public String UploadExistingHIPPADocumentInPractice(String str,String name) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		System.out.println("str: "+str);
		System.out.println("minor_name: "+name);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
		}
		help.ClickandWait(dropdownList);
		help.ClickandWait(selectHippaDOc);
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
	
	public String UploadExistingImageInPractice(String str,String name) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		System.out.println("str: "+str);
		System.out.println("minor_name: "+name);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
		}
		help.ClickandWait(dropdownList);
		help.ClickandWait(selectImage);
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
	
	public String UploadExistingVideoInPractice(String str,String name) throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		System.out.println("str: "+str);
		System.out.println("minor_name: "+name);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
		}
		help.ClickandWait(dropdownList);
		help.ClickandWait(selectVideo);
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
	
	public String UploadExistingDocumentNegative(String str,String name)
			throws IOException, InterruptedException {
		help.ClickandWait(uploadDocBtn);
		help.HandleDropDownByText(delegate, str);
		System.out.println("str: "+str);
		System.out.println("minor_name: "+name);
		if(str.equals(name))
		{
			help.ClickandWait(okBtn);
		}
		help.ClickandWait(dropdownList);
		help.ClickandWait(selectDOc);
		help.sleep(5000);
		help.ClickandWait(selectDOc1);
		help.sleep(5000);
		help.ClickandWait(selectDOc2);
		help.sleep(5000);
		help.ClickandWait(selectDOc3);
		help.sleep(5000);
		help.ClickandWait(selectDOc4);
		help.sleep(5000);
		help.ClickandWait(selectDOc5); 	
		String result=help.getText(getAlerttext);
		help.ClickandWait(okBtn);
		return result;
	}
}