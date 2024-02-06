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

public class Review_And_Sign_Document_Page extends BaseTest {

	@FindBy(xpath = "//h5[text()='Your Doctor List ']")

	WebElement yourDoctorList;

	@FindBy(xpath = "//button[@tooltip='Review and Sign Docments']")

	WebElement reviewDocBtn;

	@FindBy(xpath = "//*[@id='selectAll']")

	WebElement selectAll;

	@FindBy(xpath = "//*[@value='I Accept']")

	WebElement acceptBtn;

	@FindBy(xpath = "//*[@style='touch-action: none;']")

	WebElement sign;
	
	@FindBy(id="swal2-html-container")
	WebElement getAlerttext;

	@FindBy(xpath = "//button[text()='OK']")

	WebElement okBtn;

	@FindBy(xpath = "//button[text()='Cancel']")

	WebElement cancelBtn;

	@FindBy(xpath = "/html/body/app-root/app-signature-waiver/div/div/div/div/div/div/div[2]/div/div[2]/div/a[3]")

	WebElement doneBtn;

	@FindBy(xpath = "//*[@tooltip='Submit your consent.']")
	WebElement submitBtn;
	public static Helper help;

	public Review_And_Sign_Document_Page() throws IOException {
		PageFactory.initElements(driver, this);
		help=new Helper();
	}

	public String ReviewAndSignDocument()
			throws IOException, InterruptedException {

		help.ClickAndWait(yourDoctorList);
		if(reviewDocBtn.isEnabled())
		{
			help.ClickandWait(reviewDocBtn);
			String text=help.getText(getAlerttext);
			if(text.equals("Are you ready to review and complete the forwarded practice documents?"))
			{
				help.ClickandWait(okBtn);
				help.ClickandWait(selectAll);
				String text1=help.getText(getAlerttext);
				if(text1.equals("Are you sure you want to select all? Doing this will skip the requirement to review each document individually."))
				{
					help.ClickandWait(okBtn);
					help.ClickandWait(acceptBtn);
					String text2=help.getText(getAlerttext);
					if(text2.equals("Are you sure you want to go to the signature page?"))
					{
						help.ClickandWait(okBtn); 
						help.signature(sign);
						help.ClickandWait(doneBtn);
						String text3=help.getText(getAlerttext);
						if(text3.equals("Select 'OK' to sign the document and review it."))
						{
							help.ClickandWait(okBtn);
							help.ClickandWait(submitBtn);
							String text4=help.getText(getAlerttext);
							if(text4.equals("Clicking 'Submit' will forward copies of the document(s) to your email."))
							{
								help.ClickandWait(okBtn);
							}
							else {
								Assert.fail("Text not matched");
							}
						}
						else {
							Assert.fail("Text not matched");
						}
					}
					else {
						Assert.fail("Text not matched");
					}
				}
				else {
					Assert.fail("Text not matched");
				}
				
			}
			else {
				Assert.fail("Text not matched");
			}
			
		}
		else {
			Assert.fail("Button is not enabled");
		}
		help.sleep(3000);
		String res=help.getText(getAlerttext);
		help.ClickAndWait(okBtn);
		return res;
	}
	
}

