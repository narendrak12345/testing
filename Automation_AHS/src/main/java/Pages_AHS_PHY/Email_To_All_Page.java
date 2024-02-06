package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class Email_To_All_Page extends BaseTest {
    
	Helper help = new Helper();

	
	@FindBy(xpath = "//*[text()=' PATIENT LIST+EXPERT 2']")
	WebElement patientList;
	
	@FindBy(xpath="//*[text()='Email to all']")
	WebElement emailToAll	;
	
	@FindBy(name="emailSubject")
	WebElement emailSubject;
	
	@FindBy(name = "fileDesTxt")
	WebElement enterMsg;

	@FindBy(xpath="//*[@id='swal2-html-container']")
	WebElement getAlertText;
	
	@FindBy(xpath="//*[text()='OK']")
	WebElement ClickOK;
	
	@FindBy(xpath="//*[text()=' Send Email ']")
	WebElement sendEmail;

	@FindBy(xpath = "//*[text()=' Message is required. ']")
	WebElement msgText;
	
	@FindBy(xpath="/html/body/app-root/app-email-all-patient/div/div/div/div/div/div/div[3]/form/div[1]/div/div/div/div")
	WebElement subText;
	
	
	public Email_To_All_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String EmailToAll(String eSubject,String doc_message) throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(emailToAll);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure you want to send this email?"))
		{
			help.ClickAndWait(ClickOK);
			help.SendTextAndWait(emailSubject, eSubject);
			help.SendTextAndWait(enterMsg, doc_message);
			help.ClickandWait(sendEmail);
			String text1=help.getText(getAlertText);
			if(text1.equals("Are you sure you want to send this email?"))
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
	
	public void EmailToAllNegative() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(emailToAll);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure you want to send this email?"))
		{
			help.ClickAndWait(ClickOK);
			help.ClickandWait(sendEmail);
		}
		else {
			Assert.fail("Text not matched");
		}
	}
	
	public String verifyEmailSubject() throws InterruptedException
	{
		String res=help.getText(subText);
		return res;
	}
	
	public String verifyEmailMessage() throws InterruptedException
	{
		String res=help.getText(msgText);
		return res;
	}	
}
