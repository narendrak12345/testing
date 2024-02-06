package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class SecondOpinion_Without_PHI_Page extends BaseTest {

	Helper help = new Helper();

	@FindBy(xpath = "//*[text()=' PATIENT LIST+EXPERT 2']")
	WebElement patientList;

	@FindBy(xpath = "//*[text()=' Opinion w/o PHI']")
	WebElement secondOpinion;

	@FindBy(name = "specialty")
	WebElement specialty;

	@FindBy(name = "subspecialty")
	WebElement subspecialty;

	@FindBy(xpath = "//*[@id='swal2-html-container']")
	WebElement getAlertText;

	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickOK;

	@FindBy(name = "practicingCenter")
	WebElement practicingCenter;

	@FindBy(name = "physician")
	WebElement physician;

	@FindBy(xpath = "//*[@value='1']")
	WebElement radio1;

	@FindBy(xpath = "//*[@value='2']")
	WebElement radio2;

	@FindBy(xpath = "//*[@value='3']")
	WebElement radio3;

	@FindBy(name = "fileDesText")
	WebElement enterMsg;

	@FindBy(name = "image1")
	WebElement chooseFile;

	@FindBy(xpath = "//div[text()=' Please select Specialty ']")
	WebElement specialtyText;

	@FindBy(xpath = "//div[text()=' Please Select Subspecialites. ']")
	WebElement subspecialtyText;

	@FindBy(xpath = "//div[text()=' Please select Center of Excellence ']")
	WebElement practicingCenterText;

	@FindBy(xpath = "//div[text()=' Please Select Physician. ']")
	WebElement physicianText;

	@FindBy(xpath = "//div[text()=' Message is required. ']")
	WebElement enterMsgText;

	@FindBy(xpath = "//*[text()=' Request 2nd Opinion ']")
	WebElement sendReqBtn;

	public SecondOpinion_Without_PHI_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String SecondOpinionWithoutPHI_Urgent(String doc_message, String Doc)
			throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(secondOpinion);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to request a 2nd Opinion?")) {
			help.ClickAndWait(ClickOK);
			help.HandleDropDownByIndex(specialty, 1);
			help.HandleDropDownByIndex(subspecialty, 1);
			help.HandleDropDownByIndex(practicingCenter, 1);
			help.HandleDropDownByIndex(physician, 1);
			help.ClickandWait(radio1);
			String path = getFileLink(Doc);
			help.SendTextAndWait(chooseFile, path);
			help.SendTextAndWait(enterMsg, doc_message);
			help.ClickandWait(sendReqBtn);
		} else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res = help.ChecklElementAndGettext(getAlertText, driver);
		log.info("res :" + res);
		help.ClickandWait(ClickOK);
		return res;
	}

	public String SecondOpinionWithoutPHI_24Hours(String doc_message, String Doc)
			throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(secondOpinion);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to request a 2nd Opinion?")) {
			help.ClickAndWait(ClickOK);
			help.HandleDropDownByIndex(specialty, 1);
			help.HandleDropDownByIndex(subspecialty, 1);
			help.HandleDropDownByIndex(practicingCenter, 1);
			help.HandleDropDownByIndex(physician, 1);
			help.ClickandWait(radio2);
			String path = getFileLink(Doc);
			help.SendTextAndWait(chooseFile, path);
			help.SendTextAndWait(enterMsg, doc_message);
			help.ClickandWait(sendReqBtn);
		} else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res = help.ChecklElementAndGettext(getAlertText, driver);
		log.info("res :" + res);
		help.ClickandWait(ClickOK);
		return res;
	}

	public String SecondOpinionWithoutPHI_48Hours(String doc_message, String Doc)
			throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(secondOpinion);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to request a 2nd Opinion?")) {
			help.ClickAndWait(ClickOK);
			help.HandleDropDownByIndex(specialty, 1);
			help.HandleDropDownByIndex(subspecialty, 1);
			help.HandleDropDownByIndex(practicingCenter, 1);
			help.HandleDropDownByIndex(physician, 1);
			help.ClickandWait(radio3);
			String path = getFileLink(Doc);
			help.SendTextAndWait(chooseFile, path);
			help.SendTextAndWait(enterMsg, doc_message);
			help.ClickandWait(sendReqBtn);
		} else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res = help.ChecklElementAndGettext(getAlertText, driver);
		log.info("res :" + res);
		help.ClickandWait(ClickOK);
		return res;
	}

	public void SecondOpinionWithoutPHI_Negative() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(secondOpinion);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to request a 2nd Opinion?")) {
			help.ClickAndWait(ClickOK);
			help.ClickandWait(sendReqBtn);
		} else {
			Assert.fail("Text not matched");
		}
	}

	public String verifyspecialtyText() throws InterruptedException {
		String res = help.getText(specialtyText);
		return res;
	}

	public String verifysubspecialtyText() throws InterruptedException {
		String res = help.getText(subspecialtyText);
		return res;
	}

	public String verifypracticingCenterText() throws InterruptedException {
		String res = help.getText(practicingCenterText);
		return res;
	}

	public String verifyphysicianText() throws InterruptedException {
		String res = help.getText(physicianText);
		return res;
	}

	public String verifyenterMsgText() throws InterruptedException {
		String res = help.getText(enterMsgText);
		return res;
	}

}
