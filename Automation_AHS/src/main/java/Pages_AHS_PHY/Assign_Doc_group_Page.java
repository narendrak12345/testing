package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class Assign_Doc_group_Page extends BaseTest {
    
	Helper help = new Helper();

	
	@FindBy(xpath = "//*[text()=' PATIENT LIST+EXPERT 2']")
	WebElement patientList;
	
	@FindBy(xpath="//*[@type='search']")
	WebElement searchText;
	
	@FindBy(xpath="//*[@tooltip='Document Group']")
	WebElement docGrp;
	
	@FindBy(xpath="//*[text()=' Assign ']")
	WebElement assignBtn;
	
	@FindBy(xpath="//*[@id='swal2-html-container']")
	WebElement getAlertText;
	
	@FindBy(xpath="//*[text()='OK']")
	WebElement ClickOK;
	
	@FindBy(name = "docGroupId")
	WebElement docGroup;
	
	@FindBy(xpath="//div[text()=' Please Select Document Group ']")
	WebElement documentText;
	
	public Assign_Doc_group_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String AssignDocGroup() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(docGrp);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure you want to assign this new Physician Group?"))
		{
			help.ClickAndWait(ClickOK);
			help.HandleDropDownByIndex(docGroup, 7);
			help.ClickandWait(assignBtn);
			String text1=help.getText(getAlertText);
			if(text1.equals("Are you sure you want to assign this document group?"))
			{
				help.ClickandWait(ClickOK);
			}
		}
		else {
			Assert.fail("Text not matched");
		}
		help.sleep(6000);
		String res=help.ChecklElementAndGettext(getAlertText, driver);
		log.info("res :"+res);
		help.ClickandWait(ClickOK);
		return res;	
	}
	
	public void AssignDocGroupNegative() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(docGrp);
		String text=help.getText(getAlertText);
		if(text.equals("Are you sure you want to assign this new Physician Group?"))
		{
			help.ClickAndWait(ClickOK);
			help.ClickandWait(assignBtn);
		}
		else {
			Assert.fail("Text not matched");
		}
	}
	
	public String verifyDocumentText()
	{
		String res=help.getText(documentText);
		return res;
	}
	
}
