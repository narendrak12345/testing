
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
import Pages_AHS.Email_doctor_Page;
import Pages_AHS.Login_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Email_doctor_Test extends BaseTest {

	public Login_Page login;
	public Email_doctor_Page emaildoct;
	public Readdata data;

	public Email_doctor_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		emaildoct = new Email_doctor_Page();
		login = new Login_Page();
		data = new Readdata();
	}

	@Test
	@Description("Search By Elemrex Registered Physician or Provider For patient")
	public void SearchbyElemrexRegisteredPhysician() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = emaildoct.SendMailByElemrexRegisteredPhysician(data.jsondata("email"),
				data.jsondata("reenteremail"),"Yourself", data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}

	@Test
	@Description("Search By NPI Database using Search by NPI number for patient")
	public void SearchByNPIUsingNPINumber() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		emaildoct.SendemailbyNpidatabase("Yourself", data.jsondata("minor_name"));
		String actual = emaildoct.SearchbyNPI(data.jsondata("NPINumber"), data.jsondata("email"),
				data.jsondata("reenteremail"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}

	@Test
	@Description("Search By NPI Database using Search by First Name, Last Name and State for patient")
	public void SearchByNPI() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		emaildoct.SendemailbyNpidatabase("Yourself", data.jsondata("minor_name"));
		String actual = emaildoct.SearchbyFirstLastState(data.jsondata("firstname"), data.jsondata("lastname"),
				data.jsondata("state"), data.jsondata("email"), data.jsondata("reenteremail"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}
	
	
	// Minor Test Cases
	
	@Test
	@Description("Search By Elemrex Registered Physician or Provider For minor")
	public void SearchbyElemrexRegisteredPhysician_minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = emaildoct.SendMailByElemrexRegisteredPhysician(data.jsondata("email"),
				data.jsondata("reenteremail")," beth, mansvi ", data.jsondata("minor_name"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}
	
	@Test
	@Description("Search By NPI Database using Search by NPI number for minor")
	public void SearchByNPIUsingNPINumber_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		emaildoct.SendemailbyNpidatabase(" beth, mansvi ", data.jsondata("minor_name"));
		String actual = emaildoct.SearchbyNPI(data.jsondata("NPINumber"), data.jsondata("email"),
				data.jsondata("reenteremail"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}

	@Test
	@Description("Search By NPI Database using Search by First Name, Last Name and State for minor")
	public void SearchByNPI_Minor() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		emaildoct.SendemailbyNpidatabase(" beth, mansvi ", data.jsondata("minor_name"));
		String actual = emaildoct.SearchbyFirstLastState(data.jsondata("firstname"), data.jsondata("lastname"),
				data.jsondata("state"), data.jsondata("email"), data.jsondata("reenteremail"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Email sent successfully!");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
