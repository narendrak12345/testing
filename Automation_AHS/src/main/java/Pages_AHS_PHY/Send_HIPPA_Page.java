package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class Send_HIPPA_Page extends BaseTest {

	Helper help = new Helper();

	@FindBy(xpath = "//*[text()=' PATIENT LIST+EXPERT 2']")
	WebElement patientList;

	@FindBy(xpath = "//*[@tooltip='Send HIPAA Form']")
	WebElement sendHIPPA;

	@FindBy(xpath = "//*[text()='Search Receiving Physicians']")
	WebElement searchPhy;

	@FindBy(name = "physicianSearchFirstName")
	WebElement firstName;

	@FindBy(name = "physicianSearchLastName")
	WebElement lastName;

	@FindBy(name = "physicianSearchState")
	WebElement selectState;

	@FindBy(xpath = "//*[@id='swal2-html-container']")
	WebElement getAlertText;

	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickOK;

	@FindBy(xpath = "//*[text()=' Search Physicians ']")
	WebElement searchPhysician;

	@FindBy(xpath = "//*[text()=' Select ']")
	WebElement selectBtn;

	@FindBy(name = "fileDesTxt")
	WebElement enterMsg;

	@FindBy(name = "altEmail")
	WebElement altMail;

	@FindBy(name = "cnfAltEmail")
	WebElement cnfMail;

	@FindBy(xpath = "//*[text()=' Send Email']")
	WebElement sendEmail;

	@FindBy(name = "physicianSearchNPI")
	WebElement npiNum;

	@FindBy(xpath = "//*[text()='No Records Found']")
	WebElement recordText;

	public Send_HIPPA_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void SendHIPPA(String doc_message, String phyEmail) throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(sendHIPPA);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to send a HIPAA form to this patient?")) {
			help.ClickAndWait(ClickOK);
			help.ClickandWait(searchPhy);
			help.SendTextAndWait(firstName, "jamie");
			help.SendTextAndWait(lastName, "watson");
			help.HandleDropDownByText(selectState, " Connecticut ");
			help.ClickandWait(searchPhysician);
			help.ClickandWait(selectBtn);
			help.SendTextAndWait(enterMsg, doc_message);
			help.SendTextAndWait(altMail, phyEmail);
			help.SendTextAndWait(cnfMail, phyEmail);
			help.ClickandWait(sendEmail);
			String text1 = help.getText(getAlertText);
			if (text1.equals("Are you sure?")) {
				help.ClickandWait(ClickOK);
				help.sleep(3000);
				String text2 = help.getText(getAlertText);
				System.out.println("text2 :" + text2);
				if (text2.equals(
						"HIPAA form was successfully sent. Do you want to send this same HIPAA form somewhere else?")) {
					help.ClickandWait(ClickOK);
				} else {
					Assert.fail("Text not matched");
				}
			} else {
				Assert.fail("Text not matched");
			}
		} else {
			Assert.fail("Text not matched");
		}
	}

	public void SendHIPPAByNPI(String npi, String doc_message, String phyEmail)
			throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(sendHIPPA);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to send a HIPAA form to this patient?")) {
			help.ClickAndWait(ClickOK);
			help.ClickandWait(searchPhy);
			help.SendTextAndWait(npiNum, npi);
			help.ClickandWait(searchPhysician);
			help.ClickandWait(selectBtn);
			help.SendTextAndWait(enterMsg, doc_message);
			help.SendTextAndWait(altMail, phyEmail);
			help.SendTextAndWait(cnfMail, phyEmail);
			help.ClickandWait(sendEmail);
			String text1 = help.getText(getAlertText);
			if (text1.equals("Are you sure?")) {
				help.ClickandWait(ClickOK);
				help.sleep(3000);
				String text2 = help.getText(getAlertText);
				System.out.println("text2 :" + text2);
				if (text2.equals(
						"HIPAA form was successfully sent. Do you want to send this same HIPAA form somewhere else?")) {
					help.ClickandWait(ClickOK);
				} else {
					Assert.fail("Text not matched");
				}
			} else {
				Assert.fail("Text not matched");
			}
		} else {
			Assert.fail("Text not matched");
		}
	}

	public String SendHIPPANegative() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(sendHIPPA);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to send a HIPAA form to this patient?")) {
			help.ClickandWait(ClickOK);
			help.ClickandWait(sendEmail);
		} else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res = help.ChecklElementAndGettext(getAlertText, driver);
		help.ClickandWait(ClickOK);
		return res;
	}

	public String SendHIPPANegative1() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(sendHIPPA);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to send a HIPAA form to this patient?")) {
			help.ClickandWait(ClickOK);
			help.ClickandWait(searchPhy);
			help.ClickandWait(searchPhysician);
		} else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res = help.ChecklElementAndGettext(getAlertText, driver);
		help.ClickandWait(ClickOK);
		return res;
	}

	public void SendHIPPANegative2() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(sendHIPPA);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to send a HIPAA form to this patient?")) {
			help.ClickandWait(ClickOK);
			help.ClickandWait(searchPhy);
			help.SendTextAndWait(firstName, "Rupali");
			help.SendTextAndWait(lastName, "Kongari");
			help.HandleDropDownByText(selectState, " Connecticut ");
			help.ClickandWait(searchPhysician);
		} else {
			Assert.fail("Text not matched");
		}
	}

	public String VerifyRecordText() {
		String res = help.getText(recordText);
		return res;
	}

	public void SendHIPPANegative3() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(sendHIPPA);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to send a HIPAA form to this patient?")) {
			help.ClickandWait(ClickOK);
			help.ClickandWait(searchPhy);
			help.SendTextAndWait(npiNum, "1234567890");
			help.ClickandWait(searchPhysician);
		} else {
			Assert.fail("Text not matched");
		}
	}

	public String VerifyRecordText1() {
		String res = help.getText(recordText);
		return res;
	}

	public String SendHIPPAByNPINegative3(String npi, String doc_message) throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(sendHIPPA);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to send a HIPAA form to this patient?")) {
			help.ClickAndWait(ClickOK);
			help.ClickandWait(searchPhy);
			help.SendTextAndWait(npiNum, npi);
			help.ClickandWait(searchPhysician);
			help.ClickandWait(selectBtn);
			help.SendTextAndWait(enterMsg, doc_message);
			help.ClickandWait(sendEmail);
		} else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res = help.ChecklElementAndGettext(getAlertText, driver);
		help.ClickandWait(ClickOK);
		return res;
	}

}
