package Pages_AHS;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class Universal_State_Hippaa_Forms extends BaseTest {

	@FindBy(xpath = "/html/body/app-root/app-dashboard/div/div[3]/div/div/div/div/div[2]/div/div")

	WebElement UniversalStateHIPAAForms;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	WebElement PopUptext;

	@FindBy(xpath = "(//*[@class='col-sm-4']/input)[3]")
	WebElement NPI;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[9]/a")
	WebElement chooseselect;

	@FindBy(xpath = "//input[@name='altEmail']")
	WebElement Physicianemail;

	@FindBy(xpath = "//input[@name='cnfAltEmail']")
	WebElement Physicianemailalternate;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement generatebtn;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement searachphysicianbtn;
	
	@FindBy(xpath = "//select[@name='patient_signature']")
	WebElement selectsignature;
	
	@FindBy(xpath = "//*[@id='demographicPop']/div/div/div[2]/div/div/div/signature-pad/canvas")
	WebElement signit;
	
	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickonOK;
	
	@FindBy(xpath = "//*[@tooltip='Generate PDF']")
	WebElement GeneratePDF;
	
	@FindBy(name = "delegate")
	WebElement delegate;
	
	@FindBy(name = "physicianSearchFirstName")
	WebElement FName;
	
	@FindBy(name = "physicianSearchLastName")
	WebElement LName;
	
	@FindBy(name = "physicianSearchState")
	WebElement State;
	
	@FindBy(xpath = "//h6[text()='No Records Found']")
	WebElement Errormsg;
	
	@FindBy(name = "hipaaDoctor")
	WebElement hipaaDoctor;
	
	@FindBy(name = "requestedBy")
	WebElement requestedBy;
	
	@FindBy(xpath="//*[text()=' Generate ']")
	WebElement generateBtn;
	
	@FindBy(name = "patient_signature")
	WebElement patienSignature;
	
	@FindBy(xpath="//*[@style='touch-action: none;']")	
	WebElement sign;
	
	@FindBy(xpath="//*[text()='Save Signature']")
	WebElement saveSign;
	
	@FindBy(xpath="//*[@id='swal2-html-container']")
	WebElement getAlertText;
	
	@FindBy(xpath="//*[text()='OK']")
	WebElement cliclOK;
	
	@FindBy(xpath="/html/body/app-root/app-ushf/div/div/div/div/div/div/div[3]/div/div/form/div[1]/div/div[1]/div/label")
	WebElement labelText;

	public Universal_State_Hippaa_Forms() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void searchphysician(String str, String del) throws IOException, InterruptedException {

		Helper help = new Helper();
		help.ClickandWait(UniversalStateHIPAAForms);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(del))
		{
			help.ClickAndWait(ClickonOK);
			help.sleep(2000);
		}
		help.SendtextAndClick("Search Physicians");
	}

	public void searchbyNPI(String NPIID, String email, String reenteremail) throws IOException, InterruptedException {

		Helper help = new Helper();
		help.SendTextAndWait(NPI, NPIID);
		help.ClickandWait(searachphysicianbtn);
		help.ClickandWait(chooseselect);
		help.SendTextAndWait(Physicianemail, email);
		help.SendTextAndWait(Physicianemailalternate, reenteremail);
		help.ClickandWait(generatebtn);

	}
	
	public void searchbyNameState(String Fname, String Lname, String email, String reenteremail) throws IOException, InterruptedException {
		Helper help = new Helper();
		help.SendTextAndWait(FName, Fname);
		help.SendTextAndWait(LName, Lname);
		help.HandleDropDownByText(State, "New Jersey");
		help.ClickandWait(searachphysicianbtn);
		help.ClickandWait(chooseselect);
		help.SendTextAndWait(Physicianemail, email);
		help.SendTextAndWait(Physicianemailalternate, reenteremail);
		help.ClickandWait(generatebtn);
	}
	
	public String GenerateWithoutAlternateEmail(String Fname, String Lname) throws IOException, InterruptedException {
		Helper help = new Helper();
		help.SendTextAndWait(FName, Fname);
		help.SendTextAndWait(LName, Lname);
		help.HandleDropDownByText(State, "New Jersey");
		help.ClickandWait(searachphysicianbtn);
		help.ClickandWait(chooseselect);
		help.ClickandWait(generatebtn);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(PopUptext);	
	}

	
	public String Signthedocument() throws IOException, InterruptedException {
		
		Helper help = new Helper();
		help.HandleDropDown(selectsignature, 2);
		help.signature(signit);
		help.SendtextAndClick("Save Signature");
		help.ClickAndWait(ClickonOK);
		help.ClickandWait(GeneratePDF);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(PopUptext);
	}

	public String SearchPhysicianWithoutDetails() throws InterruptedException, IOException {
		Helper help = new Helper();
		help.ClickandWait(searachphysicianbtn);
		help.ClickAndWait(ClickonOK);
		return help.Gettext(PopUptext);	
	}

	public String SearchInvalidPhysician() throws InterruptedException, IOException {
		Helper help = new Helper();
		help.SendTextAndWait(FName, help.randomMethod());
		help.SendTextAndWait(LName, help.randomMethod());
		help.RandomDropDownselect(State);
		help.ClickandWait(searachphysicianbtn);
		help.sleep(2000);
		return help.Gettext(Errormsg);	
	}
	
	public void USHF() throws IOException, InterruptedException
	{
		Helper help = new Helper();
		String green="rgba(33, 37, 41, 1)";
		String color=UniversalStateHIPAAForms.getCssValue("color");
		System.out.println("color: "+color);
		if(color.equals(green))
		{
			help.ClickandWait(UniversalStateHIPAAForms);	
			help.HandleDropDownByIndex(hipaaDoctor, 1);
			String doctor=labelText.getText();
			System.out.println("doctor: "+doctor);
			if(doctor.contains("HIPAA For Doctor"))
			{
			help.HandleDropDownByIndex(requestedBy, 1);
			help.ClickandWait(generateBtn);	
			help.HandleDropDownByIndex(patienSignature, 2);
			help.signature(sign);	
			help.ClickandWait(saveSign);
			String text=help.getText(getAlertText);
			if(text.equals("Are you sure you want to replace your existing signature?"))
			{
				help.ClickandWait(cliclOK);
				help.ClickandWait(GeneratePDF);
				String text1=help.getText(getAlertText);
				if(text1.equals("Are you sure you want to submit this information to generate a State HIPAA Form?"))
				{
					help.ClickandWait(cliclOK);
					
				}
				else {
					Assert.fail("Text not matched.");
				}
			}
			else {
				Assert.fail("Text not matched.");
			}
			
		}
		
		else {
			Assert.fail("Doctor not matched.");
		}
		}
		else {
			Assert.fail("Color not matched.");
		}
		
	}
}
