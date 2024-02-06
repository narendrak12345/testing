package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class COE_Page extends BaseTest {
    
	Helper help = new Helper();

	
	@FindBy(xpath = "//h5[text()=' ADMINISTRATORS ']")
	WebElement ADMINISTRATORS;
	
	@FindBy(xpath="//*[@type='search']")
	WebElement search;
	
	@FindBy(xpath="//*[@tooltip='Disable COE']")
	WebElement coeBtn;
	
	@FindBy(xpath="//*[@tooltip='Enable COE']")
	WebElement coeBtn1;
	
	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickonOK;

	@FindBy(className="swal2-html-container")
	WebElement getAlertText;	

	public COE_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String DisableCOE(String searchtext) throws IOException, InterruptedException {
		help.sleep(3000);
		help.ClickandWait(ADMINISTRATORS);
		help.SendTextAndWait(search, searchtext);
		String c1=coeBtn.getText();
		System.out.println("c1: "+c1);
		String c2=coeBtn1.getText();
		System.out.println("c2: "+c2);
		if(coeBtn.isDisplayed() || coeBtn1.isDisplayed())
		{
			help.ClickandWait(coeBtn);
			String text=help.getText(getAlertText);
			log.info(text);
			if(text.equals("Are you sure you want to change the status of this Center of Excellence?")) {
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
	
	
	public String EnableCOE(String searchtext) throws IOException, InterruptedException
	{
		help.ClickandWait(ADMINISTRATORS);
		help.SendTextAndWait(search, searchtext);
		if(coeBtn.isDisplayed())
		{
			help.ClickandWait(coeBtn);
			String text=help.getText(getAlertText);
			log.info(text);
			if(text.equals("Are you sure you want to change the status of this Center of Excellence?"))
			{
				help.ClickandWait(ClickonOK);
			}
			else {
				Assert.fail("Text not matched");
			}
		}
		else {
			Assert.fail("Text not matched");
		}
		help.sleep(3000);
		String res=help.ChecklElementAndGettext(getAlertText, driver);
		System.out.println("res: "+res);
		help.ClickAndWait(ClickonOK);
		return res;				
	}
	
	
	public String EnableOrDisableCOE(String searchtext) throws IOException, InterruptedException {
		help.ClickandWait(ADMINISTRATORS);
		help.SendTextAndWait(search, searchtext);
		if(coeBtn.isEnabled())
		{
			help.ClickandWait(coeBtn);
			String text=help.getText(getAlertText);
			log.info(text);
			if(text.equals("Are you sure you want to change the status of this Center of Excellence?")) {
				help.ClickandWait(ClickonOK);
			}
			else {
				Assert.fail("Text not matched");
			}
		}
		else {
			help.ClickandWait(coeBtn1);
			String text=help.getText(getAlertText);
			log.info(text);
			if(text.equals("Are you sure you want to change the status of this Center of Excellence?"))
			{
				help.ClickandWait(ClickonOK);
			}
			else {
				Assert.fail("Text not matched");
			}
		}
		help.sleep(3000);
		String res=help.ChecklElementAndGettext(getAlertText, driver);
		System.out.println("res: "+res);
		help.ClickAndWait(ClickonOK);
		return res;
		
	}
}
