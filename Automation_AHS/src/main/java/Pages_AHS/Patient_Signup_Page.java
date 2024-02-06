package Pages_AHS;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;

public class Patient_Signup_Page extends BaseTest {

	Helper help = new Helper();
	@FindBy(xpath = "//a[text()='New Patient? Signup Here']")

	WebElement signUpBtn;

	@FindBy(name = "firstName")

	WebElement fname;

	@FindBy(name = "middleName")

	WebElement mname;

	@FindBy(name = "lastName")

	WebElement lname;

	@FindBy(name = "mobile")
	WebElement mobile;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "dob")
	WebElement dob;

	@FindBy(name = "Password")
	WebElement password;

	@FindBy(name = "confirm Password")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//select[@formcontrolname='que1Id']")
	WebElement question1;
	
	@FindBy(xpath = "//input[@formcontrolname='ans1']")
	WebElement answer1;
	
	@FindBy(xpath = "//select[@formcontrolname='que2Id']")
	WebElement question2;
	
	@FindBy(xpath = "//input[@formcontrolname='ans2']")
	WebElement answer2;
	
	@FindBy(xpath = "//select[@formcontrolname='companySlug']")
	WebElement choosePractice;
	
	@FindBy(xpath = "//*[@id='form-login']/button")
	WebElement registerBtn;
	
	@FindBy(name = "login")
	WebElement login;
	
	@FindBy(xpath = "//*[@id='refreshbut']/button/i")
	WebElement arrow;
	
	@FindBy(name = "ifmail")
	WebElement switchFrame;

	@FindBy(xpath = "//*[@id='mail']/div/p[1]")
	WebElement otp;
	
	@FindBy(name = "otp")
	WebElement enterOtp;
	
	@FindBy(xpath = "//button[text()='Verify ']")
	WebElement verify;
	
	@FindBy(xpath = "//div[text()='First Name is required']")
	WebElement invalidFirstName;
	
	@FindBy(xpath = "//div[text()='Last Name is required']")
	WebElement invalidLastName;
	
	@FindBy(xpath = "//div[text()='A valid Email address is required']")
	WebElement invalidEm;
	
	@FindBy(xpath = "//div[text()='Please Enter Valid First Name']")
	WebElement invalidFname;
	
	@FindBy(xpath = "//div[text()='Please Enter Valid Last Name']")
	WebElement invalidlname;
	
	@FindBy(xpath = "//div[text()='Email must be a valid email address']")
	WebElement invalidEmail;
	
	@FindBy(xpath = "//div[text()='Please Enter Valid Mobile Number']")
	WebElement invalidMobile;
	
	@FindBy(xpath = "//div[text()='DOB is required ']")
	WebElement invalidDob;
	
	@FindBy(xpath = "//div[text()='Password must be 8 characters long and must contain at least one uppercase letter, one lowercase letter, one number, one special character ']")
	WebElement invalidPass;
	
	@FindBy(xpath = "//div[text()='Password is required']")
	WebElement invalidPassword;
	
	@FindBy(xpath = "//div[text()='Passwords must match']")
	WebElement invalidConPass;
	
	@FindBy(xpath = "//div[text()='Security Question 01 is required ']")
	WebElement invalidQue1;
	
	@FindBy(xpath = "//div[text()='Security Answer 01 is required']")
	WebElement invalidAns1;
	
	@FindBy(xpath = "//div[text()='Security Question 02 is required ']")
	WebElement invalidQue2;
	
	@FindBy(xpath = "//div[text()='Security Answer 02 is required']")
	WebElement invalidAns2;

	private String code;

	public Patient_Signup_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void RegisterPatient(String Pmobile, String Pdob, String pass, String ans1, String ans2, String yopmail_url)
			throws InterruptedException {
		String parentHandle = driver.getWindowHandle();
		help.ClickandWait(signUpBtn);
		String fname1 = help.randomMethod();
		String mname1 = help.randomMethod();
		String lname1 = help.randomMethod();
		String emailAdd = fname1 + "@yopmail.com";
		help.SendTextAndWait(fname, fname1);
		help.SendTextAndWait(mname, mname1);
		help.SendTextAndWait(lname, lname1);
		help.SendTextAndWait(mobile, Pmobile);
		help.SendTextAndWait(email, emailAdd);
		help.ClickandWait(dob);
		help.SendTextAndWait(dob, Pdob);
		help.SendTextAndWait(password, pass);
		help.SendTextAndWait(confirmPassword, pass);
		help.HandleDropDownByIndex(question1, 1);
		help.SendTextAndWait(answer1, ans1);
		help.HandleDropDownByIndex(question2, 1);
		help.SendTextAndWait(answer2, ans2);
		help.HandleDropDownByIndex(choosePractice, 2);
		help.ClickAndWait(registerBtn);
		help.switchToTab(yopmail_url);
		help.SendTextAndWait(login, emailAdd);
		help.ClickandWait(arrow);
		help.Switchframe(switchFrame, driver);
		String Otp = help.getText(otp);
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(Otp);
		if (matcher.find()) {
			this.code = matcher.group();
			log.info(this.code);
		}
		help.switchToParentTab(driver, parentHandle);
		help.SendTextAndWait(enterOtp, this.code);
		help.ClickAndWait(verify);
		help.sleep(3000);
	}

	public void RegisterInvalidPatient() throws InterruptedException {
		help.ClickandWait(signUpBtn);

		help.ClickandWait(registerBtn);
		help.sleep(3000);

	}

	public String VerifyInvalidFName() throws IOException {
		return help.ChecklElementAndGettext(invalidFirstName, driver);
	}

	public String VerifyInvalidLName() throws IOException {
		return help.ChecklElementAndGettext(invalidLastName, driver);
	}

	public String VerifyInvalidEmail() throws IOException {
		return help.ChecklElementAndGettext(invalidEm, driver);
	}

	public String VerifyInvalidDob() throws IOException {
		return help.ChecklElementAndGettext(invalidDob, driver);
	}

	public String VerifyInvalidPas() throws IOException {
		return help.ChecklElementAndGettext(invalidPassword, driver);
	}

	public void RegisterInvalidRecordPatient(String InFname, String InLname, String InEmail, String Inmobile,
			String InPass) throws InterruptedException {
		help.ClickandWait(signUpBtn);
		help.SendTextAndWait(fname, InFname);
		help.SendTextAndWait(lname, InLname);
		help.SendTextAndWait(mobile, Inmobile);
		help.SendTextAndWait(email, InEmail);
		help.SendTextAndWait(password, InPass);
		help.ClickandWait(registerBtn);
		help.sleep(3000);

	}

	public String VerifyInvalidFirstName() throws IOException {
		return help.ChecklElementAndGettext(invalidFname, driver);
	}

	public String VerifyInvalidLastName() throws IOException {
		return help.ChecklElementAndGettext(invalidlname, driver);
	}

	public String VerifyInvalidMobile() throws IOException {
		return help.ChecklElementAndGettext(invalidMobile, driver);
	}

	public String VerifyInvalidEm() throws IOException {
		return help.ChecklElementAndGettext(invalidEmail, driver);
	}

	public String VerifyInvalidPass() throws IOException {
		return help.ChecklElementAndGettext(invalidPass, driver);
	}

	public String VerifyInvalidConPass() throws IOException {
		return help.ChecklElementAndGettext(invalidConPass, driver);
	}

	public String VerifyInvalidQue1() throws IOException {
		return help.ChecklElementAndGettext(invalidQue1, driver);
	}

	public String VerifyInvalidAns1() throws IOException {
		return help.ChecklElementAndGettext(invalidAns1, driver);
	}

	public String VerifyInvalidQue2() throws IOException {
		return help.ChecklElementAndGettext(invalidQue2, driver);
	}

	public String VerifyInvalidAns2() throws IOException {
		return help.ChecklElementAndGettext(invalidAns2, driver);
	}
}