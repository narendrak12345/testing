package Tests_AHS;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Forget_Password;
import Pages_AHS.Login_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class Forget_Password_Test extends BaseTest {
	
	public Forget_Password forgetpassword;
	public Login_Page login ;
	public Readdata data;

	public Forget_Password_Test() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		forgetpassword = new Forget_Password();
		login = new Login_Page();
		data = new Readdata(); 
	}
	
	@Test
	@Description("Reset password")
	public void Reset_password() throws InterruptedException, IOException, ParseException {
		String actual = forgetpassword.Reset_Password(prop.getProperty("email"),data.jsondata("yopmail"),data.jsondata("Resetpass"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "Password reset successfully, click here to login.");
	}
	
	@Test
	@Description("Enter the Unregistered Email and reset the password")
	public void Reset_UnregistereEmail() throws IOException, InterruptedException
	{
		String actual = forgetpassword.Reset_UnregistereEmail(prop.getProperty("Incorrectemail"));
		System.out.println(prop.getProperty("Incorrectemail"));
		log.info("Text value is >>>> " + actual);
		Assert.assertEquals(actual, "You are not registered with AHS.");
	}
	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
