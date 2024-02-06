package Pages_AHS;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;

public class Email_doctor_Page extends BaseTest {

	@FindBy(xpath = "//h5[normalize-space()='Email Doctors']")

	WebElement Emaildoctor;

	@FindBy(xpath = "//select[@name='practiceGrp']")

	WebElement practiceGrp;

	@FindBy(xpath = "//select[@name='practice']")

	WebElement practice;

	@FindBy(xpath = "//*[@name='emailLogTxt']")

	WebElement message;

	@FindBy(xpath = "//select[@name='docSet']")

	WebElement doctype;

	@FindAll({ @FindBy(xpath = "//*[@class='form-group']//table//tbody/tr[*]/td[1]/input") })
	List<WebElement> Documents;

	@FindBy(xpath = "//select[@name='attachmentDocment']")

	WebElement UploadHIPAA;

	@FindBy(xpath = "//input[@name='altEmail']")

	WebElement Physicianemail;

	@FindBy(xpath = "//input[@name='cnfAltEmail']")

	WebElement Physicianemailalternate;

	@FindBy(xpath = "//button[@class='btn btn-primary']")

	WebElement Sendbtn;

	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickonOK;

	@FindBy(xpath = "//div[text()='Email sent successfully!']")
	WebElement alerttext;

	@FindBy(xpath = "//div[@id='swal2-html-container']")
	WebElement emailtext;

	@FindBy(xpath = "(//*[@type='radio'])[2]")
	WebElement ClickNPIDatabase;

	@FindBy(xpath = "(//*[@class='col-sm-4']/input)[1]")
	WebElement Firstname;

	@FindBy(xpath = "(//*[@class='col-sm-4']/input)[2]")
	WebElement Lastname;

	@FindBy(xpath = "(//*[@class='col-sm-4']/input)[3]")
	WebElement NPI;

	@FindBy(xpath = "//*[@name='physicianSearchState']")
	WebElement state;

	@FindBy(xpath = "//*[contains(@id,'DataTables_Table_')]/tbody/tr/td[8]/a")
	WebElement chooseselect;
	
	@FindBy(name = "delegate")
	WebElement delegate;

	public Email_doctor_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String SendMailByElemrexRegisteredPhysician(String email, String reenteremail,String str, String del)
			throws IOException, InterruptedException {

		Helper help = new Helper();
		help.ClickAndWait(Emaildoctor);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(del))
		{
			help.ClickAndWait(ClickonOK);
			help.sleep(2000);
		}
		help.HandleDropDown(practiceGrp, 1);
		help.HandleDropDown(practice, 1);
		help.SendTextAndWait(message, "Test");
		help.HandleDropDown(doctype, 1);
		help.Scrolldropdwon1(Documents, 2, driver);
		help.HandleDropDown(UploadHIPAA, 2);
		help.SendTextAndWait(Physicianemail, email);
		help.SendTextAndWait(Physicianemailalternate, reenteremail);
		Sendbtn.click();
		Thread.sleep(5000);
		help.ClickAndWait(ClickonOK);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(emailtext);
	}

	public void SendemailbyNpidatabase(String str, String del) throws IOException, InterruptedException {

		Helper help = new Helper();
		help.ClickAndWait(Emaildoctor);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(del))
		{
			help.ClickAndWait(ClickonOK);
			help.sleep(2000);
		}
		ClickNPIDatabase.isDisplayed();
		ClickNPIDatabase.click();
		help.SendtextAndClick("Search Physicians");

	}

	public String SearchbyFirstLastState(String firstname, String lastname, String statename, String email,
			String reenteremail) throws IOException, InterruptedException {

		Helper help = new Helper();
		help.SendTextAndWait(Firstname, firstname);
		help.SendTextAndWait(Lastname, lastname);
		help.HandleDropDownByText(state, statename);
		help.SendtextAndClick(" Search Physicians ");
		help.ClickandWait(chooseselect);
		help.SendTextAndWait(message, "Test");
		help.HandleDropDown(doctype, 1);
		help.Scrolldropdwon1(Documents, 2, driver);
		help.HandleDropDown(UploadHIPAA, 2);
		help.SendTextAndWait(Physicianemail, email);
		help.SendTextAndWait(Physicianemailalternate, reenteremail);
		Sendbtn.click();
		Thread.sleep(5000);
		help.ClickAndWait(ClickonOK);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(emailtext);
	}

	public String SearchbyNPI(String NPIID, String email, String reenteremail)
			throws IOException, InterruptedException {

		Helper help = new Helper();
		help.SendTextAndWait(NPI, NPIID);
		help.SendtextAndClick(" Search Physicians ");
		help.ClickandWait(chooseselect);
		help.SendTextAndWait(message, "Test");
		help.HandleDropDown(doctype, 1);
		help.Scrolldropdwon1(Documents, 2, driver);
		help.HandleDropDown(UploadHIPAA, 2);
		help.SendTextAndWait(Physicianemail, email);
		help.SendTextAndWait(Physicianemailalternate, reenteremail);
		Sendbtn.click();
		Thread.sleep(5000);
		help.ClickAndWait(ClickonOK);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(emailtext);
	}
}