package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class Administration_Edit_Page extends BaseTest {
    
	Helper help = new Helper();

	
	@FindBy(xpath = "//h5[normalize-space()='ADMINISTRATORS']")
	WebElement ADMINISTRATORS;
	
	@FindBy(xpath="//*[@type='search']")
	WebElement search;
	
	@FindBy(xpath="//*[@tooltip='Edit']")
	WebElement editBtn;
	
	@FindBy(xpath = "//*[text()='Ok']")
	WebElement ClickonOK;
	
	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickOK;

	@FindBy(xpath="//*[@id='swal2-html-container']")
	WebElement getAlertText;

	@FindBy(xpath = "//*[text()='Update']")
	WebElement updatebtn;
	
	@FindBy(name="fullName")
	WebElement fullname;
	
	@FindBy(name="mobile")
	WebElement mobile;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(xpath="//div[text()='Please Enter Valid Full Name.']")
	WebElement nameText;
	
	@FindBy(xpath="//div[text()='Please Enter Valid Mobile Number.']")
	WebElement mobileText;
	
	@FindBy(xpath="//div[text()='Please Enter a Valid Email.']")
	WebElement emailText;
	

	public Administration_Edit_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String EditSameDetails(String searchtext) throws IOException, InterruptedException {
		help.ClickandWait(ADMINISTRATORS);
		help.SendTextAndWait(search, searchtext);
		help.ClickandWait(editBtn);
		String text=help.getText(getAlertText);
		log.info(text);
		if(text.equals("Are you sure you want to edit this administrator's profile?"))
		{
			help.ClickAndWait(ClickOK);
		}
		else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		help.ClickAndWait(updatebtn);
		String res=help.ChecklElementAndGettext(getAlertText, driver);
		System.out.println("res: "+res);
		help.ClickAndWait(ClickOK);
		return res;	
	}
	
	public String EditDetails(String searchtext) throws IOException, InterruptedException {
		help.ClickandWait(ADMINISTRATORS);
		help.SendTextAndWait(search, searchtext);
		help.ClickandWait(editBtn);
		String text=help.getText(getAlertText);
		log.info(text);
		if(text.equals("Are you sure you want to edit this administrator's profile?"))
		{
			help.ClickAndWait(ClickOK);
			String n=help.randomMethod();
			String name=n+" "+"test";
			String mob=help.RandomNumber();
			String em=n+"@yopmail.com";
			fullname.clear();
			help.SendTextAndWait(fullname, name);
			mobile.clear();
			help.SendTextAndWait(mobile, mob);
			email.clear();
			help.SendTextAndWait(email, em);
			help.ClickAndWait(updatebtn);
			String txt=help.getText(getAlertText);
			System.out.println("txt: "+txt);
			if(txt.equals("Are you sure you want to make these changes"))
			{
				help.ClickandWait(ClickonOK);
			}
		}
		else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res=help.ChecklElementAndGettext(getAlertText, driver);
		System.out.println("res: "+res);
		help.ClickAndWait(ClickOK);
		return res;	
	}
	
	public void EditWrongDetails(String searchtext) throws IOException, InterruptedException {
		help.ClickandWait(ADMINISTRATORS);
		help.SendTextAndWait(search, searchtext);
		help.ClickandWait(editBtn);
		String text=help.getText(getAlertText);
		log.info(text);
		if(text.equals("Are you sure you want to edit this administrator's profile?"))
		{
			help.ClickAndWait(ClickOK);
			String name=help.RandomNumber();
			System.out.println("name: "+name);
			String mob=help.randomMethod();
			System.out.println("mob: "+mob);
			help.sleep(3000);
			fullname.clear();
			help.sleep(3000);
			help.SendTextAndWait(fullname, name);
			help.sleep(3000);
			mobile.clear();
			help.sleep(3000);
			help.SendTextAndWait(mobile, mob);
			help.sleep(3000);
			email.clear();
			help.sleep(3000);
			help.SendTextAndWait(email, name);
			help.sleep(3000);
			help.ClickAndWait(updatebtn);
		}
		else {
			Assert.fail("Text not matched");
		}
	}
	
	public String VerifyInvalidName() throws IOException {
		 return help.ChecklElementAndGettext(nameText, driver);
	}

	public String VerifyInvalidMobile() throws IOException {
		return help.ChecklElementAndGettext(mobileText, driver);
	}

	public String VerifyInvalidEmail() throws IOException {
		return help.ChecklElementAndGettext(emailText, driver);
	}
	
}
