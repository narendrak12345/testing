package Pages_AHS;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;

public class Parent_Minor_Relation_Page extends BaseTest {

	@FindBy(xpath = "//h5[text()='Parent Minor/Dependant Relation ']")

	WebElement parentMinorRelation;

	@FindBy(xpath = "//a[text()=' Search Minors / Dependants']")

	WebElement searchMinor;

	@FindBy(name = "minorSearchText")

	WebElement enterSearchText;

	@FindBy(xpath = "//button[text()=' Search Minors / Dependants ']")

	WebElement searchBtn;

	@FindBy(xpath = "//a[text()='Select']")

	WebElement selectBtn;
	
	@FindBy(id="swal2-html-container")
	WebElement getAlerttext;

	@FindBy(xpath = "//button[text()='OK']")

	WebElement okBtn;

	@FindBy(xpath = "//button[text()='Cancel']")

	WebElement cancelBtn;

	@FindBy(name = "email")

	WebElement minorEmail;

	@FindBy(name = "password")
	WebElement minorPassword;

	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement loginBtn;

	@FindBy(name = "login")
	WebElement emailLogin;

	@FindBy(xpath = "//*[@id='refreshbut']/button/i")
	WebElement clickArrow;

	@FindBy(name = "ifmail")
	WebElement switchFrame;

	@FindBy(xpath = "//*[@id='mail']/div/p[1]")
	WebElement otp;

	@FindBy(name = "otp")
	WebElement enterOtp;

	@FindBy(xpath = "//button[text()=' Verify ']")
	WebElement verify;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchText;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[5]/div/button")
	WebElement removeBtn;

	@FindBy(xpath = "//div[text()='No Records Found']")
	WebElement invalidMinor;
	
	@FindBy(xpath="//div[text()='Guardian-Minor relationship created successfully!']")
	WebElement minorAddedText;
	
	@FindBy(xpath="//div[text()='Guardian-Minor relationship removed successfully!']")
	WebElement removedText;

	private String code;
	public static Helper help;

	public Parent_Minor_Relation_Page() throws IOException {
		PageFactory.initElements(driver, this);
		help=new Helper();
	}

	public String CreateParentMinorRelation(String minor, String minor_email, String minor_password)
			throws IOException, InterruptedException {
		String parentHandle = driver.getWindowHandle();
		help.ClickAndWait(parentMinorRelation);
		help.ClickAndWait(searchMinor);
		help.SendTextAndWait(enterSearchText, minor);
		help.ClickAndWait(searchBtn);
		help.ClickAndWait(selectBtn);
		String text = help.getText(getAlerttext);
		log.info("text: " + text);
		if (text.equals("Are you sure you want to start managing this minor's/dependant's information?")) 
		{
			help.ClickAndWait(okBtn);
			help.SendTextAndWait(minorEmail, minor_email);
			help.SendTextAndWait(minorPassword, minor_password);
			help.ClickAndWait(loginBtn);
			String text1 = help.getText(getAlerttext);
			log.info("text1: " + text1);
			if (text1.equals("Are you sure you want to make these changes to your demographic information?")) {
				help.ClickAndWait(okBtn);
				help.switchToTab("https://yopmail.com/en/");
				help.SendTextAndWait(emailLogin, minor_email);
				help.ClickAndWait(clickArrow);
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
			} 
		} 
		else {
			Assert.fail("Test not match");
		}
		String res=help.ChecklElementAndGettext(minorAddedText, driver);
		help.ClickAndWait(okBtn);
		return res;

	}
	
	public String RemoveParentMinorRelation(String minor) throws IOException, InterruptedException {
		help.ClickAndWait(parentMinorRelation);
		help.SendTextAndWait(searchText, minor);
		help.ClickAndWait(removeBtn);
		String text3=help.getText(getAlerttext);
		log.info("text3 :"+text3);
		if(text3.equals("Are you sure you want to stop managing this minor's information?"))
		{
			help.ClickAndWait(okBtn);
			String actual=help.ChecklElementAndGettext(removedText, driver);
			log.info("actual: "+actual);
			
			Assert.assertEquals(actual, "Guardian-Minor relationship removed successfully!");			
		}
		else {
			help.ClickAndWait(cancelBtn);
		}
		String res=help.ChecklElementAndGettext(removedText, driver);
		help.ClickAndWait(okBtn);
		return res;
	}

	public void CreateInvalidParentMinorRelation(String invalid_minor) throws IOException, InterruptedException {
		help.ClickAndWait(parentMinorRelation);
		help.ClickAndWait(searchMinor);
		help.SendTextAndWait(enterSearchText, invalid_minor);
		help.ClickAndWait(searchBtn);
	}

	public String VerifyInvalidMinor() throws IOException {
		return help.ChecklElementAndGettext(invalidMinor, driver);
	}

}