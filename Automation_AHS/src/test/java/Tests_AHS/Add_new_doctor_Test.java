package Tests_AHS;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Add_new_Doctor;
import Pages_AHS.Login_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Add_new_doctor_Test extends BaseTest {

	public Add_new_Doctor newdoctor;
	public Login_Page login;
	public Readdata data;

	public Add_new_doctor_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		newdoctor = new Add_new_Doctor();
		login = new Login_Page();
		data = new Readdata();
	}
	@Test
	@Description("Selecting Multiple physicians for patient")
	public void Selectmultipledoctor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		newdoctor.SelectDoctor("princeton",7,"Yourself",  data.jsondata("minor_name"));
		newdoctor.choosephysicians(3);// here selcting no. of doctors are 7
		int size=newdoctor.GetalllistofPysiciannames();
		log.info("List of physicians selected " +size);
		Assert.assertEquals(size,3);
		}

	@Test
	@Description("Selecing single physician for patient")
	public void Selectphysician() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		newdoctor.SelectDoctor("princeton", 2,"Yourself",  data.jsondata("minor_name"));
		newdoctor.choosephysicians(1);// here selcting no. of doctors are 1
		int size=newdoctor.GetalllistofPysiciannames();
		log.info("List of physicians selected " +size);
		Assert.assertEquals(size,1);
	}
	
	@Test
	@Description("Testing with Negative scenarios for patient")
	public void CheckWithInvaliddata() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		newdoctor.ValidateNegativescenario("princeton",6,"Yourself",  data.jsondata("minor_name") );
		Thread.sleep(5000);
	}
	
	// Minor Test cases.
	
	@Test
	@Description("Selecting Multiple physicians for minor")
	public void Selectmultipledoctor_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		newdoctor.SelectDoctor("princeton",7," beth, mansvi ",  data.jsondata("minor_name"));
		newdoctor.choosephysicians(3);// here selcting no. of doctors are 7
		int size=newdoctor.GetalllistofPysiciannames();
		log.info("List of physicians selected " +size);
		Assert.assertEquals(size,3);
		}

	@Test
	@Description("Selecing single physician for minor")
	public void Selectphysician_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		newdoctor.SelectDoctor("princeton", 2," beth, mansvi ",  data.jsondata("minor_name"));
		newdoctor.choosephysicians(1);// here selcting no. of doctors are 1
		int size=newdoctor.GetalllistofPysiciannames();
		log.info("List of physicians selected " +size);
		Assert.assertEquals(size,1);
	}
	
	@Test
	@Description("Testing with Negative scenarios for minor")
	public void CheckWithInvaliddata_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		newdoctor.ValidateNegativescenario("princeton",6," beth, mansvi ",  data.jsondata("minor_name") );
		Thread.sleep(5000);
	}

	
	
	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
