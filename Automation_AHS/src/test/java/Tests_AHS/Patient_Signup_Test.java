package Tests_AHS;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Patient_Signup_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Patient_Signup_Test extends BaseTest {

	public Patient_Signup_Page signup;
	public Readdata data;

	public Patient_Signup_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		signup = new Patient_Signup_Page();
		data = new Readdata();
	}

	@Test(priority = 1, description = "Register new physician")
	public void RegisterPatientTest() throws InterruptedException, FileNotFoundException, IOException, ParseException {

		signup.RegisterPatient(data.jsondata("Pmobile"), data.jsondata("Pdob"), data.jsondata("pass"),
				data.jsondata("ans1"), data.jsondata("ans2"), data.jsondata("yopmail_url"));
	}

	@Test(priority = 2, description = "Without entering any details trying to register")
	public void RegisterInvalidPatientTest()
			throws InterruptedException, FileNotFoundException, IOException, ParseException {

		signup.RegisterInvalidPatient();
		String actual = signup.VerifyInvalidFName();
		log.info("actual: " + actual);
		Assert.assertEquals(actual, "First Name is required");
		String actual1 = signup.VerifyInvalidLName();
		log.info("actual1: " + actual1);
		Assert.assertEquals(actual1, "Last Name is required");
		String actual2 = signup.VerifyInvalidDob();
		log.info("actual2: " + actual2);
		Assert.assertEquals(actual2, "DOB is required");
		String actual3 = signup.VerifyInvalidEmail();
		log.info("actual3: " + actual3);
		Assert.assertEquals(actual3, "A valid Email address is required");
		String actual4 = signup.VerifyInvalidPas();
		log.info("actual4: " + actual4);
		Assert.assertEquals(actual4, "Password is required");
	}

	@Test(priority = 3, description = "Entering wrong details")
	public void RegisterInvalidRecordPatientTest()
			throws InterruptedException, FileNotFoundException, IOException, ParseException {

		signup.RegisterInvalidRecordPatient(data.jsondata("InFname"), data.jsondata("InLname"),
				data.jsondata("InMobile"), data.jsondata("InEmail"), data.jsondata("InPass"));
		String actual = signup.VerifyInvalidFirstName();
		log.info("actual: " + actual);
		Assert.assertEquals(actual, "Please Enter Valid First Name");
		String actual1 = signup.VerifyInvalidLastName();
		log.info("actual1: " + actual1);
		Assert.assertEquals(actual1, "Please Enter Valid Last Name");
		String actual2 = signup.VerifyInvalidMobile();
		log.info("actual2: " + actual2);
		Assert.assertEquals(actual2, "Please Enter Valid Mobile Number");
		String actual3 = signup.VerifyInvalidEm();
		log.info("actual3: " + actual3);
		Assert.assertEquals(actual3, "Email must be a valid email address");
		String actual4 = signup.VerifyInvalidPass();
		log.info("actual4: " + actual4);
		Assert.assertEquals(actual4,
				"Password must be 8 characters long and must contain at least one uppercase letter, one lowercase letter, one number, one special character");
		String actual5 = signup.VerifyInvalidConPass();
		log.info("actual5: " + actual5);
		Assert.assertEquals(actual5, "Passwords must match");
		String actual6 = signup.VerifyInvalidQue1();
		log.info("actual6: " + actual6);
		Assert.assertEquals(actual6, "Security Question 01 is required");
		String actual7 = signup.VerifyInvalidAns1();
		log.info("actual7: " + actual7);
		Assert.assertEquals(actual7, "Security Answer 01 is required");
		String actual8 = signup.VerifyInvalidQue2();
		log.info("actual8: " + actual8);
		Assert.assertEquals(actual8, "Security Question 02 is required");
		String actual9 = signup.VerifyInvalidAns2();
		log.info("actual9: " + actual9);
		Assert.assertEquals(actual9, "Security Answer 02 is required");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}