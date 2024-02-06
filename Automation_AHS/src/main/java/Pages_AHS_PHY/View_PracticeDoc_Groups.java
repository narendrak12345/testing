package Pages_AHS_PHY;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;

public class View_PracticeDoc_Groups extends BaseTest {

	@FindBy(xpath = "//h5[normalize-space()= 'Practice Documents']")
	WebElement PractDoc;

	@FindBy(xpath = "//a[text()=' View Groups']")
	WebElement View_Groups;

	@FindBy(xpath = "//div[@id='swal2-html-container']")
	WebElement PopUptext;

	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickonOK;

	@FindBy(xpath = "//*[@name='groupName']")
	WebElement newGrp;

	@FindBy(tagName = "ul")
	WebElement DocList;

	@FindBy(xpath = "//*[text()='Create New Group']")
	WebElement createGroup;

	@FindBy(name = "groupName")
	WebElement NewGrpName;

	@FindBy(xpath = "(//*[@class='record-picker']/ul)[1]/li")
	List<WebElement> docList;

	@FindBy(xpath = "(//*[@class='record-picker']/ul)[2]/li")
	List<WebElement> removeDocList;

	@FindBy(name = "addBtn")
	WebElement AddDoc;

	@FindBy(name = "removeBtn")
	WebElement RevBtn;

	@FindBy(xpath = "(//*[text()='Select all'])[2]")
	WebElement SelectAll;

	@FindBy(name = "groupTypeId")
	WebElement DefaultGrp;

	@FindBy(xpath = "//*[text()=' Save ']")
	WebElement saveBtn;

	@FindBy(xpath = "//*[text()=' HXSBY(5) ']")
	WebElement dropdown;

	public static Helper help;

	public View_PracticeDoc_Groups() throws IOException {
		PageFactory.initElements(driver, this);
		help = new Helper();
	}

	public void gotoViewGroup() throws InterruptedException {
		help.ClickandWait(PractDoc);
		help.sleep(6000);
		help.ClickandWait(View_Groups);
		help.ClickandWait(ClickonOK);
	}

	public String Practice_View_Group(int k) throws InterruptedException {
		gotoViewGroup();
		help.ClickandWait(createGroup);
		help.SendTextAndWait(NewGrpName, help.randomMethod());
		help.Scrolldropdwon1(docList, k, driver);
		help.ClickandWait(AddDoc);
		help.ClickandWait(SelectAll);
		help.HandleDropDown(DefaultGrp, 2);
		help.ClickandWait(saveBtn);
		help.ClickandWait(ClickonOK);
		help.sleep(3000);
		String msg = help.Gettext(PopUptext);
		help.ClickandWait(ClickonOK);
		return msg;
	}

	public String Nochanges_Group() throws InterruptedException {
		gotoViewGroup();
		help.ClickandWait(dropdown);
		help.ClickandWait(saveBtn);
		help.sleep(3000);
		String msg = help.Gettext(PopUptext);
		help.ClickandWait(ClickonOK);
		return msg;
	}

	public String Change_Grp(int k) throws InterruptedException {
		gotoViewGroup();
		help.ClickandWait(dropdown);
		help.GetList(removeDocList, driver);
		help.ClickandWait(SelectAll);
		// help.Scrolldropdwon1(removeDocList,k,driver);
		help.ClickandWait(RevBtn);
		help.Scrolldropdwon1(docList, k, driver);
		help.ClickandWait(AddDoc);
		help.ClickandWait(saveBtn);
		help.ClickandWait(ClickonOK);
		help.sleep(3000);
		String msg = help.Gettext(PopUptext);
		help.ClickandWait(ClickonOK);
		return msg;
	}

}
