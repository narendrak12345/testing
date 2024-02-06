package Tests_AHS;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import ReadJsonData.Readdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import MainBase.BaseTest;
import Pages_AHS.Login_Page;
import Pages_AHS.Parent_Minor_Relation_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Parent_Minor_relation_Test extends BaseTest {

	public Parent_Minor_Relation_Page minor;
	public Login_Page login;
	public Readdata data;

	public Parent_Minor_relation_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		minor = new Parent_Minor_Relation_Page();
		login = new Login_Page();
		data = new Readdata(); 
	}
	@Test(priority=0)
	@Description("Creating parent minor relation")
	public void AddParentMinorRelation() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=minor.CreateParentMinorRelation(data.jsondata("minor"),data.jsondata("minor_email"),data.jsondata("minor_password"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Guardian-Minor relationship created successfully!");
	}
	
	@Test(priority=1)
	@Description("Remove parent minor relation")
	public void RemoveParentMinorRelation() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual=minor.RemoveParentMinorRelation(data.jsondata("minor"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Guardian-Minor relationship removed successfully!");
	}

	@Test(priority=2)
	@Description("Trying to add invalid minor")
	public void AddInvalidParentMinorRelation() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		minor.CreateInvalidParentMinorRelation(data.jsondata("invalid_minor"));
		String actual=minor.VerifyInvalidMinor();
		log.info("actual: "+actual);
		Assert.assertEquals(actual,"No Records Found");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}


