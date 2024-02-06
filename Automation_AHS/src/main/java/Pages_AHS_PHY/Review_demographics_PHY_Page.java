package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class Review_demographics_PHY_Page extends BaseTest {

	
	@FindBy(xpath = "//h5[normalize-space()='Review Profile']")
	WebElement CheckReviewdemograph;
	
	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickonOK;

	@FindBy(className="swal2-html-container")
	WebElement getAlertText;

	@FindBy(xpath = "//*[text()=' Update ']")
	WebElement Accpetbtn;
	
	@FindBy(name="ans_01")
	WebElement ans1;
	
	@FindBy(name="zipCode")
	WebElement zipcode;
	
	@FindBy(name="officePhone")
	WebElement ofcPhone;
	

	public Review_demographics_PHY_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String FillDemoGraphics() throws IOException, InterruptedException {
		Helper help = new Helper();
		CheckReviewdemograph.click();
		String text=help.getText(getAlertText);
		log.info(text);
		if(text.equals("Are you sure you want to review and update your demographics?"))
		{
			help.ClickAndWait(ClickonOK);
		}
		else {
			Assert.fail("Text not matched");
		}
		help.ClickAndWait(Accpetbtn);
		String res=help.ChecklElementAndGettext(getAlertText, driver);
		help.ClickAndWait(ClickonOK);
		return res;	
	}
	
	public String UpdateDemoGraphics() throws IOException, InterruptedException {
		Helper help = new Helper();
		CheckReviewdemograph.click();
		String text=help.getText(getAlertText);
		log.info(text);
		if(text.equals("Are you sure you want to review and update your demographics?"))
		{
			help.ClickAndWait(ClickonOK);
			WebElement ele = help.GetBycommonText("ans_01");
			ele.click();
			ele.sendKeys(Keys.CONTROL+"a");
			ele.sendKeys(Keys.DELETE);
			String answer1=help.randomMethod();
			help.SendTextAndWait(ans1, answer1);
			WebElement ele1 = help.GetBycommonText("zipCode");
			ele1.sendKeys(Keys.CONTROL+"a");
			ele1.sendKeys(Keys.DELETE);
			String zipcode1=help.randomZipCodeMethod();
			help.SendTextAndWait(zipcode, zipcode1);
			WebElement ele2 = help.GetBycommonText("officePhone");
			ele2.click();
			ele2.sendKeys(Keys.CONTROL+"a");
			ele2.sendKeys(Keys.DELETE);
			String phone1=help.RandomNumber();
			help.SendTextAndWait(ofcPhone, phone1);
			help.ClickAndWait(Accpetbtn);
			String txt=help.getText(getAlertText);
			log.info(txt);
			if(txt.equals("Are you sure you want to make these changes?"))
			{
				help.ClickandWait(ClickonOK);
			}
			else {
				Assert.fail("Text not matched");
			}
		}
		else {
			log.info("Text not matched");
		}
		help.sleep(3000);
		String res=help.ChecklElementAndGettext(getAlertText, driver);
		System.out.println("res: "+res);
		help.ClickAndWait(ClickonOK);
		return res;	
	}

	public String Verifstreet() throws IOException, InterruptedException {

		Helper help = new Helper();
		WebElement ele = help.GetBycommonText("streeAddOne");
		Thread.sleep(2000);
		ele.click();
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		help.ClickAndWait(Accpetbtn);
		Thread.sleep(5000);
		WebElement text = help.GettextByCommontext("Please Enter 1st Street.");
		return text.getText();
	}

	public String Verifcity() throws IOException, InterruptedException {

		Helper help = new Helper();
		WebElement ele = help.GetBycommonText("city_town");
		Thread.sleep(3000);
		ele.click();
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		Thread.sleep(4000);
		help.ClickAndWait(Accpetbtn);
		WebElement text = help.GettextByCommontext("Please Enter City/Town.");
		return text.getText();
	}

	public String Verifyzip() throws IOException, InterruptedException {

		Helper help = new Helper();
		WebElement ele = help.GetBycommonText("zipCode");
		Thread.sleep(2000);
		ele.click();
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		help.ClickAndWait(Accpetbtn);
		WebElement text = help.GettextByCommontext("Please Enter Zipcode");
		return text.getText();
	}

	public String Verifycellularphone() throws IOException, InterruptedException {

		Helper help = new Helper();
		WebElement ele = help.GetBycommonText("officePhone");
		Thread.sleep(2000);
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.ARROW_LEFT + "a");
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		help.ClickAndWait(Accpetbtn);
		WebElement text = help.GettextByCommontext("Please Enter Office Phone.");
		return text.getText();
	}
	
	public void FillData(String street,String city,String zip,String cell) throws IOException, InterruptedException {
		
		Helper help = new Helper();
		WebElement e1 = help.GetBycommonText("streeAddOne");
		e1.clear();
		e1.sendKeys(street);
		WebElement e2 = help.GetBycommonText("city_town");
		e2.clear();
		e2.sendKeys(city);
		WebElement e3 = help.GetBycommonText("zipCode");
		e3.clear();
		e3.sendKeys(zip);    
		WebElement e4 = help.GetBycommonText("officePhone");
		e4.clear();
		e4.sendKeys(cell);
	}
	
	public void clickOnDemo() throws IOException, InterruptedException {
		Helper help = new Helper();
		CheckReviewdemograph.click();
		help.ClickAndWait(ClickonOK);
		Thread.sleep(2000);
		
	}
}
