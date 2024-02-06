package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;

public class New_Physician extends BaseTest {
	
	@FindBy(xpath="//h5[normalize-space()= 'ADMINISTRATORS']")
	WebElement ADMINISTRATORS;
	
	@FindBy(xpath="//a[text()=' New Physician']")
	WebElement  New_Phy;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	WebElement PopUptext;
	
	@FindBy(xpath="//*[text()='OK']")
	WebElement ClickonOK;
	
	@FindBy(name="fullName")
	WebElement Name;
	
	@FindBy(name="mobile")
	WebElement mobile;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(xpath="//*[text()=' Invite ']")
	WebElement Invite;
	
	@FindBy(xpath="//*[text()=' User Added Successfully. ']")
	WebElement confirm;
	
	@FindBy(xpath="//*[text()=' Email already registered. ']")
	WebElement exist;
	
	@FindBy(xpath="//*[text()=' Please Enter Full Name. ']")
	WebElement EntName;
	@FindBy(xpath="//*[text()='Please Enter Valid Full Name.']")
	WebElement ValidName;
	@FindBy(xpath="//*[text()=' Please Enter Mobile. ']")
	WebElement EntMob;
	@FindBy(xpath="//*[text()='Please Enter Valid Mobile Number.']")
	WebElement ValidMob;
	@FindBy(xpath="//*[text()=' Please Enter Email. ']")
	WebElement EntEmail;
	@FindBy(xpath="//*[text()=' Please Enter Valid Email Address. ']")
	WebElement ValidEmail;


	public New_Physician() throws IOException {
		PageFactory.initElements(driver, this);

	}
	
	public String InviteNewPhy() throws IOException, InterruptedException{	
		Helper help=new Helper();
		help.sleep(6000);
		NewPhysicianpage();
		String name= help.randomMethod();
		String Email = name + "@yopmail.com";
		help.SendTextAndWait(Name, name);
		help.SendTextAndWait(mobile, help.RandomNumber());
		help.SendTextAndWait(email, Email);
		help.ClickandWait(Invite);
		help.ClickandWait(ClickonOK);
		return help.Gettext(confirm);			
}

public void NewPhysicianpage() throws IOException, InterruptedException {
	Helper help=new Helper();

	help.scrolldown();
	help.ClickandWait(ADMINISTRATORS);
	help.ClickandWait(New_Phy);
	help.ClickandWait(ClickonOK);
	
}

public String InviteExistingAdmin(String Email) throws IOException, InterruptedException{	
	Helper help=new Helper();
	help.sleep(6000);
	NewPhysicianpage();
	String name= help.randomMethod();
	help.SendTextAndWait(Name, name);
	help.SendTextAndWait(mobile, help.RandomNumber());
	help.SendTextAndWait(email, Email);
	help.ClickandWait(Invite);
	help.ClickandWait(ClickonOK);
	return help.Gettext(exist);			
}

public String VerifyFullName() throws IOException, InterruptedException{	
	Helper help=new Helper();
	//help.sleep(6000);
	help.ClickandWait(Invite);
		return help.Gettext(EntName);
}
public String VerifyInvalidFullName(String invalidname) throws IOException, InterruptedException{
	Helper help=new Helper();
	//help.sleep(6000);
	help.SendTextAndWait(Name, invalidname);
	help.ClickandWait(Invite);
	return help.Gettext(ValidName);	
}
public String VerifyMobile() throws IOException, InterruptedException{	
	Helper help=new Helper();
	//help.sleep(6000);
	help.ClickandWait(Invite);
		return help.Gettext(EntMob);
}
public String VerifyInvalidMobile(String invalidmob) throws IOException, InterruptedException{
	Helper help=new Helper();
	//help.sleep(6000);
	help.SendTextAndWait(mobile, invalidmob);
	help.ClickandWait(Invite);
	return help.Gettext(ValidMob);	
}

public String VerifyEmail() throws IOException, InterruptedException{	
	Helper help=new Helper();
	//help.sleep(6000);
	help.ClickandWait(Invite);
		return help.Gettext(EntEmail);
}
public String VerifyInvalidEmail(String invalidEmail) throws IOException, InterruptedException{
	Helper help=new Helper();
	//help.sleep(6000);
	help.SendTextAndWait(email, invalidEmail);
	help.ClickandWait(Invite);
	return help.Gettext(ValidEmail);	
}


}
