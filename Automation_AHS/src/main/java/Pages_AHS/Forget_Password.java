package Pages_AHS;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import Generic.Helper;
import MainBase.BaseTest;
import io.qameta.allure.Step;

public class Forget_Password extends BaseTest {
	Helper help;
	
	@FindBy(xpath = "//small[text()='Forget Password?']")

	WebElement Forgetlink;
	
	@FindBy(xpath = "//*[@name='emailOrNumber']")

	WebElement emailfield;
	
	@FindBy(xpath = "//button[text()='Reset Password']")

	WebElement ResetBtn;
	
	@FindBy(xpath = "//*[@id='login']")

	WebElement login;
	
	@FindBy(xpath = "//*[@id='refreshbut']/button/i")
	
	WebElement clickArrow;
	
	@FindBy(name = "ifmail")
	
	WebElement switchFrame;
	
	@FindBy(xpath= "//*[@placeholder='New Password']")
	
	WebElement password;

	@FindBy(xpath= "//*[@placeholder='Confirm New Password']")

	WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id='mail']/div/p[1]")
	
	WebElement txtURL;
	
	@FindBy(xpath = "//*[text()=' Change Password ']")
	
	WebElement changeBtn;
	
	@FindBy(xpath = "//*[text()='click here']")
	WebElement Clickhere;
	@FindBy(xpath = "//*[@class='alert alert-success']")
	WebElement Confirm;
	@FindBy(xpath = "//*[@class='alert alert-danger']")
	WebElement notreg;
	public String Reset_Password(String email, String yopmail, String pass ) throws IOException, InterruptedException
	{
		help = new Helper();
		help.ClickandWait(Forgetlink);
		help.SendTextAndWait(emailfield,email);
		help.ClickandWait(ResetBtn);
		System.out.println(yopmail);
		help.switchToTab(yopmail);
		help.SendTextAndWait(login, email);
		help.ClickandWait(clickArrow);
		help.Switchframe(switchFrame, driver);
		String txturl = help.getText(txtURL);
		driver.get(help.GetURL(txturl));
		help.SendTextAndWait(password, pass);
		help.SendTextAndWait(confirmPassword, pass);
		help.sleep(2000);
		help.ClickandWait(changeBtn);
		help.Gettext(Confirm);
		return help.Gettext(Confirm);
	}
	
	public String Reset_UnregistereEmail(String email) throws IOException, InterruptedException
	{
		help = new Helper();
		help.ClickandWait(Forgetlink);
		help.SendTextAndWait(emailfield,email);
		help.ClickandWait(ResetBtn);
		return help.Gettext(notreg);
	}
	public Forget_Password() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
