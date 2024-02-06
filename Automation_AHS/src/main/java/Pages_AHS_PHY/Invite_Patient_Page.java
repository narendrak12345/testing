package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class Invite_Patient_Page extends BaseTest {
    
	Helper help = new Helper();

	
	@FindBy(xpath = "//*[text()=' PATIENT LIST+EXPERT 2']")
	WebElement patientList;
	
	@FindBy(xpath="//*[text()='Invite Patient']")
	WebElement invitePatient	;
	
	@FindBy(name="fullName")
	WebElement fullName;
	
	@FindBy(name = "mobile")
	WebElement mobile;

	@FindBy(xpath="//*[@id='swal2-html-container']")
	WebElement getAlertText;
	
	@FindBy(xpath="//*[text()='OK']")
	WebElement ClickOK;
	
	@FindBy(name="email")
	WebElement email;

	@FindBy(name = "docGroupId")
	WebElement docGroup;
	
	@FindBy(xpath="//*[text()='Invite']")
	WebElement InviteBtn;
	
	@FindBy(xpath="//*[text()='Please Enter Full Name.']")
	WebElement nameText	;
	
	@FindBy(xpath="//*[text()='Please Enter Mobile.']")
	WebElement mobileText;
	
	@FindBy(xpath="//*[text()='Please Enter Email.']")
	WebElement emailText;
	
	@FindBy(xpath="//*[text()=' Please Select Document Group ']")
	WebElement documentText;
	
	@FindBy(xpath="//*[text()='Please Enter Valid Full Name.']")
	WebElement nameText1	;
	
	@FindBy(xpath="//*[text()='Please Enter Valid Mobile Number. ']")
	WebElement mobileText1;
	
	@FindBy(xpath="//*[text()='Please Enter Valid Email Address.']")
	WebElement emailText1;
	

	public Invite_Patient_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String InvitePatient() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(invitePatient);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure you want to invite a new patient?"))
		{
			help.ClickAndWait(ClickOK);
			String n=help.randomMethod();
			String name=n+" "+"Test";
			String mob=help.RandomNumber();
			String em=n+"@yopmail.com";
			help.SendTextAndWait(fullName, name);
			help.SendTextAndWait(mobile, mob);
			help.SendTextAndWait(email, em);
			help.HandleDropDownByIndex(docGroup, 3);
			help.ClickandWait(InviteBtn);
			String text1=help.getText(getAlertText);
			if(text1.equals("Are you sure you want to send your patient an invitation to register for AHS Elemrex?"))
			{
				help.ClickandWait(ClickOK);
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
	
	public void InvitePatientNegative() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(invitePatient);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure you want to invite a new patient?"))
		{
			help.ClickAndWait(ClickOK);
			help.ClickandWait(InviteBtn);
		}
		else {
			Assert.fail("Text not matched");
		}
	}
	
	public String verifyFullName() throws InterruptedException
	{
		String res=help.getText(nameText);
		return res;
	}
	
	public String verifyMobile() throws InterruptedException
	{
		String res=help.getText(mobileText);
		return res;
	}	
	
	public String verifyEmail() throws InterruptedException
	{
		String res=help.getText(emailText);
		return res;
	}
	
	public String verifyDocumentGroup() throws InterruptedException
	{
		String res=help.getText(documentText);
		return res;
	}	
	
	public void InvitePatientNegative1() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(invitePatient);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure you want to invite a new patient?"))
		{
			help.ClickAndWait(ClickOK);
			String n=help.randomMethod();
			String name=n+" "+"Test";
			String mob=help.RandomNumber();
			help.SendTextAndWait(fullName, mob);
			help.SendTextAndWait(mobile, name);
			help.SendTextAndWait(email, mob);
			help.HandleDropDownByIndex(docGroup, 3);
			help.ClickandWait(InviteBtn);
		}
		else {
			Assert.fail("Text not matched");
		}	
	}
	
	public String verifyFullName1() throws InterruptedException
	{
		String res=help.getText(nameText1);
		return res;
	}	
	
	public String verifyMobile1() throws InterruptedException
	{
		String res=help.getText(mobileText1);
		return res;
	}	
	
	public String verifyEmail1() throws InterruptedException
	{
		String res=help.getText(emailText1);
		return res;
	}	
	
//	public void EmailToAllNegative() throws IOException, InterruptedException {
//		help.ClickandWait(patientList);
//		help.ClickandWait(emailToAll);
//		String text=help.getText(getAlertText);
//		if(text.equals("Are you sure you want to send this email?"))
//		{
//			help.ClickAndWait(ClickOK);
//			help.ClickandWait(sendEmail);
//		}
//		else {
//			Assert.fail("Text not matched");
//		}
//	}
//	
//	public String verifyEmailSubject() throws InterruptedException
//	{
//		String res=help.getText(subText);
//		return res;
//	}
//	
//	public String verifyEmailMessage() throws InterruptedException
//	{
//		String res=help.getText(msgText);
//		return res;
//	}	
}
