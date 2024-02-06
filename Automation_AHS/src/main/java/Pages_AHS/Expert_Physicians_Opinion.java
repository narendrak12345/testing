package Pages_AHS;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;

public class Expert_Physicians_Opinion extends BaseTest {
	Helper help;
	
	@FindBy(xpath = "//h5[normalize-space()='Expert Physician Opinion']")

	WebElement ExpertOpinion;
	
	@FindBy(xpath = "//select[@name='specialty']")

	WebElement specialty;

	@FindBy(xpath = "//select[@name='subspecialty']")

	WebElement subspecialty;

	@FindBy(xpath = "//*[@name='practicingCenter']")

	WebElement practicingCenter;
	
	@FindBy(xpath = "//*[@name='physician']")

	WebElement physician;
	
	@FindBy(xpath = "//*[@name='fileDesText']")

	WebElement message;
	
	@FindBy(xpath = "//*[@name='documentFolder']")

	WebElement documentFolder;
	
	@FindAll({ @FindBy(xpath = "//*[@class='form-group']//table//tbody/tr[*]/td[1]/input") })
	List<WebElement> Documents;
	
	@FindBy(xpath = "//select[@name='attachmentDocment']")

	WebElement UploadHIPAA;
	
	@FindBy(xpath = "//*[@name='hippaFileDesText']")

	WebElement HippaDetail;
	
	@FindBy(xpath = "//*[text()=' Request Expert Opinion ']")

	WebElement requestBtn;
	
	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickonOK;

	@FindBy(xpath = "//div[text()='Email sent successfully!']")
	WebElement alerttext;

	@FindBy(xpath = "//div[@id='swal2-html-container']")
	WebElement PopUptext;
	
	@FindBy(xpath = "//a[text()='Generate HIPAA Form']")
	WebElement GenerateHippa;
	
	@FindBy(name = "checkbox_01")
	WebElement checkbox_01;
	
	@FindBy(name = "checkbox_04")
	WebElement checkbox_04;
	
	@FindBy(name = "patient_signature")
	WebElement patient_signature;
	
	@FindBy(name = "image")
	WebElement UploadBtn;
	
	@FindBy(xpath = "//*[text()='Save Signature']")
	WebElement Save_Signature;
	
	@FindBy(xpath="//button[text()=' Generate PDF ']")
	WebElement GeneratePDF;
	
	@FindBy(name = "delegate")
	WebElement delegate;

	public Expert_Physicians_Opinion() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public String Expert_Physician_Opinion_With_ExistingHippa(String str, String del)
			throws IOException, InterruptedException, ParseException {
		help = new Helper();
		help.sleep(3000);
		help.ClickAndWait(ExpertOpinion);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(del))
		{
			help.ClickAndWait(ClickonOK);
			help.sleep(2000);
		}
		help.HandleDropDown(specialty, 1);
		help.HandleDropDown(subspecialty, 1);
		help.HandleDropDown(practicingCenter, 1);
		help.HandleDropDown(physician, 1);
		help.SendTextAndWait(message, "Test");
		help.HandleDropDown(documentFolder, 1);
		help.Scrolldropdwon1(Documents, 2, driver);
		help.HandleDropDown(UploadHIPAA, 2);
		help.SendTextAndWait(HippaDetail, "Test");
		requestBtn.click();
		help.sleep(5000);
		String actual =help.Gettext(PopUptext);
		String Expected = "By clicking 'OK,' you are selecting at least one file to be shared by email.";
        Assert.assertEquals(actual,Expected , "Message displayed is incorrect.");
		help.ClickAndWait(ClickonOK);
		help.sleep(5000);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(PopUptext);
	}
	
	public String Expert_Physician_Opinion_By_Generate(String str, String del)
			throws IOException, InterruptedException {
		help = new Helper();
		help.ClickAndWait(ExpertOpinion);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(del))
		{
			help.ClickAndWait(ClickonOK);
			help.sleep(2000);
		}
		help.HandleDropDown(specialty, 1);
		help.HandleDropDown(subspecialty, 1);
		help.HandleDropDown(practicingCenter, 1);
		help.HandleDropDown(physician, 1);
		help.ClickandWait(GenerateHippa);
		help.ClickandWait(checkbox_01);
		help.ClickandWait(checkbox_04);
		help.HandleDropDown(patient_signature, 2);
		help.signature(patient_signature);
		help.ClickandWait(Save_Signature);
		help.ClickAndWait(ClickonOK);
		help.sleep(2000);
		help.ClickandWait(GeneratePDF);
		help.ClickAndWait(ClickonOK);
		help.SendTextAndWait(message, "Test");
		help.HandleDropDown(documentFolder, 1);
		help.Scrolldropdwon1(Documents, 2, driver);
		help.SendTextAndWait(HippaDetail, "Test");
		requestBtn.click();
		help.sleep(5000);
		String actual =help.Gettext(PopUptext);
		String Expected = "By clicking 'OK,' you are selecting at least one file to be shared by email.";
        Assert.assertEquals(actual,Expected , "Message displayed is incorrect.");
		help.ClickAndWait(ClickonOK);
		help.sleep(5000);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(PopUptext);
	}
	public String Without_selecting_Doc(String str, String del)
			throws IOException, InterruptedException {
		help = new Helper();
		help.sleep(3000);
		help.ClickAndWait(ExpertOpinion);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(del))
		{
			help.ClickAndWait(ClickonOK);
			help.sleep(2000);
		}
		help.HandleDropDown(specialty, 1);
		help.HandleDropDown(subspecialty, 1);
		help.HandleDropDown(practicingCenter, 1);
		help.HandleDropDown(physician, 1);
		help.SendTextAndWait(message, "Test");
		help.HandleDropDown(UploadHIPAA, 2);
		help.SendTextAndWait(HippaDetail, "Test");
		requestBtn.click();
		help.sleep(5000);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(PopUptext);
	}
	
	public String Expert_Physician_Opinion_By_UploadingHippa(String str, String del)
			throws IOException, InterruptedException {
		help = new Helper();
		help.sleep(3000);
		help.ClickAndWait(ExpertOpinion);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(del))
		{
			help.ClickAndWait(ClickonOK);
			help.sleep(2000);
		}
		help.HandleDropDown(specialty, 1);
		help.HandleDropDown(subspecialty, 1);
		help.HandleDropDown(practicingCenter, 1);
		help.HandleDropDown(physician, 1);
		help.SendTextAndWait(message, "Test");
		help.HandleDropDown(documentFolder, 1);
		help.Scrolldropdwon1(Documents, 2, driver);
		help.SendTextAndWait(HippaDetail, "Test");
		requestBtn.click();
		help.sleep(5000);
		String actual =help.Gettext(PopUptext);
		String Expected = "By clicking 'OK,' you are selecting at least one file to be shared by email.";
        Assert.assertEquals(actual,Expected , "Message displayed is incorrect.");
		help.ClickAndWait(ClickonOK);
		help.sleep(5000);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(PopUptext);

	}
	public String Expert_Physician_Opinion_By_unsupported_File(String str, String del)
			throws IOException, InterruptedException {
		help = new Helper();
		help.sleep(3000);
		help.ClickAndWait(ExpertOpinion);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(del))
		{
			help.ClickAndWait(ClickonOK);
			help.sleep(2000);
		};
		help.HandleDropDown(specialty, 1);
		help.HandleDropDown(subspecialty, 1);
		help.HandleDropDown(practicingCenter, 1);
		help.HandleDropDown(physician, 1);
		help.SendTextAndWait(message, "Test");
		help.HandleDropDown(documentFolder, 1);
		help.Scrolldropdwon1(Documents, 2, driver);
		help.SendTextAndWait(UploadBtn,getFileLink("Demo(0208).docx"));
		help.SendTextAndWait(HippaDetail, "Test");
		requestBtn.click();
		help.sleep(5000);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(PopUptext);
	}
	
}
