package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class Send_Email_Page extends BaseTest {

	Helper help = new Helper();

	@FindBy(xpath = "//*[text()=' PATIENT LIST+EXPERT 2']")
	WebElement patientList;

	@FindBy(xpath = "//*[@tooltip='Send E-Mail']")
	WebElement SendEmail;

	@FindBy(xpath = "/html/body/app-root/app-email2user/div/div/div/div/div/div/div[3]/form/div[2]/div/div/input")
	WebElement getEmail;

	@FindBy(name = "emailSubject")
	WebElement emailSubject;

	@FindBy(name = "fileDesTxt")
	WebElement enterMsg;

	@FindBy(name = "image1")
	WebElement chooseFile;

	@FindBy(xpath = "//*[text()=' Send Email ']")
	WebElement sendEmail;

	@FindBy(xpath = "//*[@id='swal2-html-container']")
	WebElement getAlertText;

	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickOK;
	
	@FindBy(name = "login")
	WebElement emailLogin;
	
	@FindBy(xpath="//*[@id='refreshbut']/button/i")
	WebElement arrow;
	
	@FindBy(name = "ifmail")
	WebElement switchFrame;
	
	@FindBy(xpath="//*[@id='mail']")
	WebElement getBody;
	
	@FindBy(xpath="//*[@style='margin:10px 5px 0px 8px;']")
	WebElement getSubject;
	
	@FindBy(xpath="//*[text()=' Subject is required. ']")
	WebElement subjectText;
	
	@FindBy(xpath="//*[text()=' Message is required. ']")
	WebElement msgText;

	public Send_Email_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void SendEmail(String image) throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(SendEmail);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to send this email?")) {
			help.ClickAndWait(ClickOK);
			help.sleep(5000);
			String email = getEmail.getAttribute("value");
			System.out.println("email: " + email);
			help.SendTextAndWait(emailSubject, "testing");
			help.sleep(3000);
			String sub = emailSubject.getAttribute("value");
			System.out.println("sub: " + sub);
			help.SendTextAndWait(enterMsg, "This is a testing email");
			String msg = enterMsg.getAttribute("value");
			System.out.println("msg: " + msg);
			String path = getFileLink(image);
			help.SendTextAndWait(chooseFile, path);
			help.ClickandWait(sendEmail);
			String text1 = help.getText(getAlertText);
			if (text1.equals("Are you sure you want to send this email?")) {
				help.ClickandWait(ClickOK);
				help.sleep(5000);
				String text2 = help.getText(getAlertText);
				System.out.println("text2: "+text2);
				if (text2.equals("Email successfully sent to the patient!")) {
					help.ClickandWait(ClickOK);
					help.switchToTab("https://yopmail.com/en/wm");
					help.sleep(3000);
					help.SendTextAndWait(emailLogin,email);
					help.ClickandWait(arrow);
					help.Switchframe(switchFrame, driver);
					String subject=getSubject.getText();
					System.out.println("subject: "+subject);
					String bodyText=getBody.getText();
					System.out.println("bodyText: "+bodyText);
					if(sub.equals(subject) && bodyText.contains(msg))
					{
						System.out.println("Email successfully sent to the patient!");
					}
					else {
						Assert.fail("Email not sent to the patient!");
					}
				}
			} else {
				Assert.fail("Text not matched");
			}

		} else {
			Assert.fail("Text not matched");
		}
	}

	
	public void SendEmailNegative() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(SendEmail);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to send this email?")) {
			help.ClickAndWait(ClickOK);
			help.ClickandWait(sendEmail);

		} else {
			Assert.fail("Text not matched");
		}
	}
	
	public String verifySubject()
	{
		String res=help.getText(subjectText);
		return res;	
	}
	
	public String verifyMessage()
	{
		String res=help.getText(msgText);
		return res;	
	}

}
