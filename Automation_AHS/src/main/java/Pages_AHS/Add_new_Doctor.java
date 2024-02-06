package Pages_AHS;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;

public class Add_new_Doctor extends BaseTest{

	

	@FindBy(xpath="//h5[normalize-space()='Add New Physician to your list']")
	
	WebElement Addnewpysician;
	
	
	@FindBy(xpath="//input[@name='filterDoctor']")
	
	WebElement Searchdoctor;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	
	WebElement Clickonsearch;
	
	@FindAll({@FindBy(xpath="//select[@multiple='multiple']/option")})
	
	List<WebElement> Alloptions;
	
	@FindAll({@FindBy(xpath="(//div[@class='record-picker']/ul)[1]/li")})
	List<WebElement> choosephysician;
	
	
	@FindBy(xpath="//button[@name='addBtn']")
	WebElement choosepysicianbtn;
	
	@FindBy(xpath="//*[text()=' Save ']")
	WebElement Clickonsave;
	
	@FindBy(xpath="//*[text()='OK']")
	WebElement ClickonOK;
	
	@FindBy(xpath="//*[text()=' Home Page']")
	WebElement ClickonHomepage;
	
	
	@FindBy(xpath="//*[text()='Your Doctor List ']")
	WebElement Clickonyourdoctorlist;

	
	@FindAll({@FindBy(xpath="//*[@id='DataTables_Table_0']/tbody/tr[*]/td[3]")})
	List<WebElement> Getphysiciannames;
	
	@FindBy(xpath="//select[@name='physicianPractice']")
	WebElement seelctthepractise;
	
	@FindBy(name = "delegate")
	WebElement delegate;

	public Add_new_Doctor() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public void SelectDoctor(String search,int k,String str, String del) throws InterruptedException, IOException {
		
		Helper help=new Helper();
		help.ClickAndWait(Addnewpysician);
		help.HandleDropDownByText(delegate, str);
		if(str.equals(del))
		{
			help.ClickAndWait(ClickonOK);
			help.sleep(2000);
		}
		help.HandleDropDown(seelctthepractise,1);
		Searchdoctor.sendKeys(search);
		Clickonsearch.click();
		Thread.sleep(2000);
		help.ClickOnbtn(5);
		help.ClickOnbtn(4);
		Clickonsave.click();
		help.ClickAndWait(ClickonOK);
		Thread.sleep(2000);
		help.Scrolldropdwon(Alloptions,k,driver);
	}	
	public void choosephysicians(int k) throws InterruptedException, IOException {
		
		Helper help=new Helper();
		choosepysicianbtn.isEnabled();
		help.Scrolldropdwon1(choosephysician,k,driver);
		choosepysicianbtn.click();
		Clickonsave.click();
		help.ClickAndWait(ClickonOK);
		help.ClickAndWait(ClickonOK);
		Thread.sleep(5000);
		ClickonHomepage.click();
		Thread.sleep(5000);
		help.ClickAndWait(ClickonOK);
	}
	public int GetalllistofPysiciannames() throws IOException, InterruptedException {
		
		Helper help=new Helper();
		Clickonyourdoctorlist.click();
		Thread.sleep(5000);
		return help.GetList(Getphysiciannames, driver);
	}
	public void ValidateNegativescenario(String search,int k,String str, String del) throws IOException, InterruptedException {
		Helper help=new Helper();
		Thread.sleep(2000);
		SelectDoctor(search,k,str,del);
		Thread.sleep(2000);
		choosepysicianbtn.click();
		help.ClickOnbtn(2);//select all
		Thread.sleep(2000);
		help.ClickOnbtn(3);//unselect all
		Thread.sleep(2000);
		choosepysicianbtn.isEnabled();
		Thread.sleep(2000);
		help.ClickOnbtn(2);
		choosepysicianbtn.click();
		Thread.sleep(2000);
		help.ClickOnbtn(5);
		help.ClickOnbtn(6);
		help.ClickOnbtn(4);
		help.ClickOnbtn(5);
		help.ClickOnbtn(4);
		Thread.sleep(2000);
	}
}