package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class PracticeDoc_NewDoc_Page extends BaseTest {
    
	Helper help = new Helper();

	
	@FindBy(xpath = "//h5[normalize-space()='Practice Documents']")
	WebElement practiceDoc;
	
	@FindBy(xpath="//*[text()=' New Document']")
	WebElement newDoc	;
	
	@FindBy(name="docName")
	WebElement docName;
	
	@FindBy(name = "docDescription")
	WebElement docDescription;
	
	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickOK;

	@FindBy(xpath="//*[@id='swal2-html-container']")
	WebElement getAlertText;

	@FindBy(xpath = "//*[@name='image']")
	WebElement chooseFile;
	
	@FindBy(name="confirmationStatus")
	WebElement requiredSign;
	
	@FindBy(xpath="//*[text()=' Add ']")
	WebElement addBtn;
	
	@FindBy(name="docMassage")
	WebElement docMassage;
	
	@FindBy(xpath="//*[text()=' Please Enter Doc Name. ']")
	WebElement docNameText;
	
	@FindBy(xpath="//*[text()=' Please Select Status. ']")
	WebElement statusText;
	

	public PracticeDoc_NewDoc_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String UploadNewDocInPracticeDoc(String Doc) throws IOException, InterruptedException {
		help.ClickandWait(practiceDoc);
		help.ClickandWait(newDoc);
		String text=help.getText(getAlertText);
		if(text.equals("Click to confirm you want to add a new document."))
		{
			help.ClickAndWait(ClickOK);
			String n=help.randomMethod();
			String name=n+" "+"Doc";
			help.SendTextAndWait(docName, name);
			String dec=name+" "+"Test";
			help.SendTextAndWait(docDescription, dec);
			String path=getFileLink(Doc);
			help.SendTextAndWait(chooseFile, path);
			help.HandleDropDownByIndex(requiredSign, 2);
			help.ClickAndWait(addBtn);
			String text1=help.getText(getAlertText);
			if(text1.equals("Are you sure you want to upload this file?"))
			{
				help.ClickAndWait(ClickOK);
			}
		}
		else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res=help.ChecklElementAndGettext(getAlertText, driver);
		log.info("res :"+res);
		help.ClickandWait(ClickOK);
		return res;
		
	}
	
	public String UploadNewDocInPracticeDoc1(String Doc,String doc_message) throws IOException, InterruptedException {
		help.ClickandWait(practiceDoc);
		help.ClickandWait(newDoc);
		String text=help.getText(getAlertText);
		if(text.equals("Click to confirm you want to add a new document."))
		{
			help.ClickAndWait(ClickOK);
			String n=help.randomMethod();
			String name=n+" "+"Doc";
			help.SendTextAndWait(docName, name);
			String dec=name+" "+"Test";
			help.SendTextAndWait(docDescription, dec);
			String path=getFileLink(Doc);
			help.SendTextAndWait(chooseFile, path);
			help.HandleDropDownByIndex(requiredSign, 1);
			help.SendTextAndWait(docMassage, doc_message);
			help.ClickAndWait(addBtn);
			String text1=help.getText(getAlertText);
			if(text1.equals("Are you sure you want to upload this file?"))
			{
				help.ClickAndWait(ClickOK);
			}
		}
		else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res=help.ChecklElementAndGettext(getAlertText, driver);
		log.info("res :"+res);
		help.ClickandWait(ClickOK);
		return res;
		
	}
	
	public String UploadNewDocInPracticeDoc_Negative() throws IOException, InterruptedException {
		help.ClickandWait(practiceDoc);
		help.ClickandWait(newDoc);
		String text=help.getText(getAlertText);
		if(text.equals("Click to confirm you want to add a new document."))
		{
			help.ClickAndWait(ClickOK);
			String n=help.randomMethod();
			String name=n+" "+"Doc";
			help.SendTextAndWait(docName, name);
			String dec=name+" "+"Test";
			help.SendTextAndWait(docDescription, dec);
			help.HandleDropDownByIndex(requiredSign, 2);
			help.ClickAndWait(addBtn);
		}
		else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res=help.ChecklElementAndGettext(getAlertText, driver);
		log.info("res :"+res);
		help.ClickandWait(ClickOK);
		return res;
		
	}
	
	public void UploadNewDocInPracticeDoc_Negative1() throws IOException, InterruptedException {
		help.ClickandWait(practiceDoc);
		help.ClickandWait(newDoc);
		String text=help.getText(getAlertText);
		if(text.equals("Click to confirm you want to add a new document."))
		{
			help.ClickandWait(ClickOK);
			help.ClickandWait(addBtn);
		}
		else {
			Assert.fail("Text not matched");
		}
	}
	
	public String VerifyInvalidName() throws IOException {
		 return help.ChecklElementAndGettext(docNameText, driver);
	}

	public String VerifyInvalidStatus() throws IOException {
		return help.ChecklElementAndGettext(statusText, driver);
	}
	
}
