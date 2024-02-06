package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class Doctor_To_Doctor_Email_Page extends BaseTest {
    
	Helper help = new Helper();

	
	@FindBy(xpath = "//*[text()=' PATIENT LIST+EXPERT 2']")
	WebElement patientList;
	
	@FindBy(xpath="//*[text()='New Doctor to Doctor Email']")
	WebElement newDoctorEmail	;
	
	@FindBy(name="practice")
	WebElement selectPractice;
	
	@FindBy(name = "physician")
	WebElement selectPhysician;
	
	@FindBy(name = "fileDesText")
	WebElement enterMsg;

	@FindBy(xpath="//*[@id='swal2-html-container']")
	WebElement getAlertText;

	@FindBy(xpath = "//*[@name='image1']")
	WebElement chooseFile;
	
	@FindBy(xpath="//*[text()='OK']")
	WebElement ClickOK;
	
	@FindBy(xpath="//*[text()=' Send Email ']")
	WebElement sendEmail;
	
	@FindBy(xpath="//input[@value='2']")
	WebElement npiDB;
	
	@FindBy(xpath="//*[text()='Search Physicians']")
	WebElement searchPhysicianLink	;
	
	@FindBy(name="physicianSearchFirstName")
	WebElement phyFirstName;
	
	@FindBy(name="physicianSearchLastName")
	WebElement phyLastName;
	
	@FindBy(name="physicianSearchState")
	WebElement phyState;
	
	@FindBy(xpath="//button[text()=' Search Physicians ']")
	WebElement searchPhysicianBtn;
	
	@FindBy(xpath="//*[text()=' Select ']")
	WebElement selectBtn;
	
	@FindBy(xpath="//*[text()=' Close ']")
	WebElement closeBtn;
	
	@FindBy(xpath="//*[@name='altEmail']")
	WebElement alternateEmail;
	
	@FindBy(xpath="//*[@name='cnfAltEmail']")
	WebElement cnfAltEmail;
	
	@FindBy(name="physicianSearchNPI")
	WebElement searchNpiNum;
	
	@FindBy(xpath="//*[text()='No Records Found']")
	WebElement noRecFoundText;

	public Doctor_To_Doctor_Email_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String NewDoctorToDoctorEmail(String doc_message,String Doc) throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(newDoctorEmail);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure, you want to send email to doctor?"))
		{
			help.ClickAndWait(ClickOK);
			help.HandleDropDownByIndex(selectPractice, 1);
			help.HandleDropDownByIndex(selectPhysician, 8);
			help.SendTextAndWait(enterMsg, doc_message);
			String path=getFileLink(Doc);
			help.SendTextAndWait(chooseFile, path);
			help.ClickandWait(sendEmail);
			String text1=help.getText(getAlertText);
			if(text1.equals("By clicking 'OK,' you are selecting at least one file to be shared by email."))
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
	
	public String NewDoctorToDoctorEmailBySearchPhy(String firstName,String lastName,String doc_message,String phyEmail,String Doc) throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(newDoctorEmail);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure, you want to send email to doctor?"))
		{
			help.ClickAndWait(ClickOK);
			help.ClickandWait(npiDB);
			help.ClickandWait(searchPhysicianLink);
			help.SendTextAndWait(phyFirstName, firstName);
			help.SendTextAndWait(phyLastName, lastName);
			help.HandleDropDownByText(phyState, " New Jersey ");
			help.ClickandWait(searchPhysicianBtn);
			help.ClickandWait(selectBtn);
			help.ClickandWait(closeBtn);
			help.SendTextAndWait(enterMsg, doc_message);
			help.SendTextAndWait(alternateEmail, phyEmail);
			help.SendTextAndWait(cnfAltEmail, phyEmail);
			String path=getFileLink(Doc);
			help.SendTextAndWait(chooseFile, path);
			help.ClickandWait(sendEmail);
			String text1=help.getText(getAlertText);
			if(text1.equals("By clicking 'OK,' you are selecting at least one file to be shared by email."))
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
	
	public String NewDoctorToDoctorEmailByNPI(String NPINum,String doc_message,String phyEmail,String Doc) throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(newDoctorEmail);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure, you want to send email to doctor?"))
		{
			help.ClickAndWait(ClickOK);
			help.ClickandWait(npiDB);
			help.ClickandWait(searchPhysicianLink);
			help.SendTextAndWait(searchNpiNum, NPINum);
			help.ClickandWait(searchPhysicianBtn);
			help.ClickandWait(selectBtn);
			help.ClickandWait(closeBtn);
			help.SendTextAndWait(enterMsg, doc_message);
			help.SendTextAndWait(alternateEmail, phyEmail);
			help.SendTextAndWait(cnfAltEmail, phyEmail);
			String path=getFileLink(Doc);
			help.SendTextAndWait(chooseFile, path);
			help.ClickandWait(sendEmail);
			String text1=help.getText(getAlertText);
			if(text1.equals("By clicking 'OK,' you are selecting at least one file to be shared by email."))
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
	
	public String NewDoctorToDoctorEmailBySearchPhyNegative() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(newDoctorEmail);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure, you want to send email to doctor?"))
		{
			help.ClickAndWait(ClickOK);
			help.ClickandWait(npiDB);
			help.ClickandWait(searchPhysicianLink);
			help.ClickandWait(searchPhysicianBtn);
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
	
	public String NewDoctorToDoctorEmailBySearchPhyNegative1(String invalifirstName,String invalidLastName) throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(newDoctorEmail);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure, you want to send email to doctor?"))
		{
			help.ClickAndWait(ClickOK);
			help.ClickandWait(npiDB);
			help.ClickandWait(searchPhysicianLink);
			help.SendTextAndWait(phyFirstName, invalifirstName);
			help.SendTextAndWait(phyLastName, invalidLastName);
			help.HandleDropDownByText(phyState, " New Jersey ");
			help.ClickandWait(searchPhysicianBtn);
		}
		else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res=help.ChecklElementAndGettext(noRecFoundText, driver);
		log.info("res :"+res);
		return res;		
	}
	
	public String NewDoctorToDoctorEmailBySearchPhyNegative2() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(newDoctorEmail);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure, you want to send email to doctor?"))
		{
			help.ClickAndWait(ClickOK);
			help.ClickandWait(npiDB);
			help.ClickandWait(searchPhysicianLink);
			String num=help.RandomNumber();
			help.SendTextAndWait(searchNpiNum, num);
			help.ClickandWait(searchPhysicianBtn);
		}
		else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res=help.ChecklElementAndGettext(noRecFoundText, driver);
		log.info("res :"+res);
		return res;		
	}
}
