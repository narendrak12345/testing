package Pages_AHS;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;

public class Login_Page extends BaseTest {

	Helper help = new Helper();
	@FindBy(xpath = "//input[@id='email']")

	WebElement email;

	@FindBy(xpath = "//input[@id='password']")

	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")

	WebElement loginbtn;

	@FindBy(xpath = "//input[@id='otp']")

	WebElement otp;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement verifybtn;

	@FindBy(xpath = "//*[contains(text(),' Invalid OTP ')]")
	WebElement checkotp;
	
	@FindBy(xpath = "//*[contains(text(),'Review Demographics')]")
	
	WebElement checkhomepage;
	
	@FindBy(xpath = "//*[text()=' Review Profile ']")
	
	WebElement checkphyhomepage;

	@FindBy(xpath = "//div[text()=' Invalid username or password ']")

	WebElement validateinvalid;

	@FindBy(xpath = "//iframe[@name='a-odj8dgex1c4h']")
	WebElement Captcha;

	public Login_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void checklogin(String emailid, String pass, String otpp) throws InterruptedException {

		email.sendKeys(emailid);
		password.sendKeys(pass);
		loginbtn.click();
		otp.sendKeys(otpp);
		verifybtn.click();
	}

	public void checkloginIncorrectcrdentials(String emailid, String pass) throws InterruptedException {

		email.sendKeys(emailid);
		password.sendKeys(pass);
		loginbtn.click();
	}
	public String alert() throws InterruptedException {
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(4000);
		//alert.accept();
		return alert.getText();
	}
public void accpetalert() throws InterruptedException {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public String verify() {
		
		return help.ChecklElementAndGettext(checkhomepage, driver);
	}
	
	public String phy_verify() {
		
		return help.ChecklElementAndGettext(checkphyhomepage, driver);
	}


	public String VerifyInvalidcredentials() {

		return help.ChecklElementAndGettext(validateinvalid, driver);
	}
	public String verifywrongotp() {

		return help.ChecklElementAndGettext(checkotp, driver);
	}
}