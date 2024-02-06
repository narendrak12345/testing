package Tests_AHS_Physician;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Login_Page;
import Pages_AHS_PHY.View_PracticeDoc_Groups;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)

public class View_PracticeDoc_Groups_Test extends BaseTest {

	public View_PracticeDoc_Groups ViewDocGrp;
	public Login_Page login;
	public Readdata data;

	public View_PracticeDoc_Groups_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		ViewDocGrp = new View_PracticeDoc_Groups();
		login = new Login_Page();
		data = new Readdata();
	}

	@Test
	@Description("creating a new Document Group")
	public void CreateNewGroup() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = ViewDocGrp.Practice_View_Group(4);
		log.info("actual: " + actual);
		Assert.assertEquals(actual, "Document Group successfully saved!");
	}

	@Test
	@Description("Negative test for no change in the existing group")
	public void NochangeExistingGRP() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = ViewDocGrp.Nochanges_Group();
		log.info("actual: " + actual);
		Assert.assertEquals(actual, "No changes were made to the document group.");
	}

	@Test
	@Description("Documents change in document group")
	public void Change_GRP() throws InterruptedException, IOException, ParseException {
		login.checklogin(prop.getProperty("phy_email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = ViewDocGrp.Change_Grp(5);
		log.info("actual: " + actual);
		Assert.assertEquals(actual, "Document Group successfully saved!");
	}

	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
