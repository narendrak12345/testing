package Pages_AHS_PHY;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Helper;
import MainBase.BaseTest;

public class Upload_Documents_Page extends BaseTest {

	Helper help = new Helper();

	@FindBy(xpath = "//*[text()=' PATIENT LIST+EXPERT 2']")
	WebElement patientList;

	@FindBy(name = "docType1Txt")
	WebElement selectFolder;

	@FindBy(xpath = "//*[@tooltip='Upload Documents']")
	WebElement uploadDoc;

	@FindBy(name = "image")
	WebElement chooseFile;

	@FindBy(xpath = "//*[@id='swal2-html-container']")
	WebElement getAlertText;

	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickOK;

	@FindBy(xpath = "/html/body/div/div/div[6]/button[3]")
	WebElement ClickCancel;

	@FindBy(xpath = "//*[text()=' Upload ']")
	WebElement uploadBtn;

	@FindBy(xpath = "//div[text()=' Please Select Document Group ']")
	WebElement documentText;

	public Upload_Documents_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void UploadDocument(String doc1) throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(uploadDoc);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to upload these documents?")) {
			help.ClickAndWait(ClickOK);
			String path = getFileLink(doc1);
			help.SendTextAndWait(chooseFile, path);
			help.HandleDropDownByIndex(selectFolder, 2);
			help.ClickandWait(uploadBtn);
			String text1 = help.getText(getAlertText);
			if (text1.equals("Are you sure you want to upload this file?")) {
				help.ClickandWait(ClickOK);
				help.sleep(3000);
				String text2 = help.getText(getAlertText);
				System.out.println("text2 :" + text2);
				if (text2.equals("Do you want to upload any additional files?")) {
					help.ClickandWait(ClickCancel);
				} else {
					Assert.fail("Text not matched");
				}
			} else {
				Assert.fail("Text not matched");
			}
		} else {
			Assert.fail("Text not matched");
		}
	}

	public String UploadDocumentNegative() throws IOException, InterruptedException {
		help.ClickandWait(patientList);
		help.ClickandWait(uploadDoc);
		String text = help.getText(getAlertText);
		if (text.equals("Are you sure you want to upload these documents?")) {
			help.ClickAndWait(ClickOK);
			help.ClickandWait(uploadBtn);
		} else {
			Assert.fail("Text not matched");
		}
		String res = help.getText(getAlertText);
		help.ClickandWait(getAlertText);
		return res;
	}

}
