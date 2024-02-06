package Generic;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import MainBase.BaseTest;

public class Helper extends BaseTest {

	private FluentWait<WebDriver> wait;
	
	public Helper() throws IOException {
        super();
        // Assuming 'driver' is already initialized in the BaseTest constructor
        wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(Exception.class);
    }


	public void ClickAndWait(WebElement ele) {
		ele.isDisplayed();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(ele)).click();
	}

	public void CheckVisibiltyOfText(WebElement ele) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele));
	}

	public String ChecklElementAndGettext(WebElement ele, WebDriver driver) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele));
		return ele.getText();
	}

	public void HandleDropDown(WebElement ele, int i) throws InterruptedException {

		Select sc = new Select(ele);
		Thread.sleep(2000);
		List<WebElement> eles = sc.getOptions();
		log.info(eles.size());
		sc.selectByIndex(i);
		Thread.sleep(2000);
	}
	public void RandomDropDownselect(WebElement ele) throws InterruptedException {

		Select sc = new Select(ele);
		Thread.sleep(2000);
		List<WebElement> eles = sc.getOptions();
		Random random = new Random();
        int randomIndex = random.nextInt(eles.size());
		log.info(eles.size());
		sc.selectByIndex(randomIndex);
		Thread.sleep(2000);
	}
	public void HandleDropDownByText(WebElement ele,String text) throws InterruptedException {

		Select sc = new Select(ele);
		Thread.sleep(2000);
		List<WebElement> eles = sc.getOptions();
		log.info(eles.size());
		sc.selectByVisibleText(text);
		Thread.sleep(2000);
	}
	
	public void HandleDropDownByIndex(WebElement ele, int index) throws InterruptedException {
	    Select sc = new Select(ele);
	    Thread.sleep(2000);
	    List<WebElement> options = sc.getOptions();
	    
	    if (index >= 0 && index < options.size()) {
	        sc.selectByIndex(index);
	        Thread.sleep(2000);
	    } else {
	        throw new IllegalArgumentException("Invalid index provided for dropdown selection.");
	    }
	}


	public WebElement GetBycommonText(String text) {

		return driver.findElement(By.xpath("//input[@name='" + text + "']"));
	}
	
	public void SendtextAndClick(String text) {

		driver.findElement(By.xpath("//*[text()='"+text+"']")).click();
	}

	public void WaitForSomeTime(int i) throws InterruptedException {

		Thread.sleep(1000 * i);
	}

	public WebElement GettextByCommontext(String text) {

		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ele);
		return ele;
	}
	
	public void ClickandWait(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele)).click();
		Thread.sleep(2000);
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(ele)).click();	
	}
	
	public void SendTextAndWait(WebElement ele, String text) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(text);
	}
	
	public void Switchframe(WebElement ele, WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(ele);
	}
	
	public void alert(WebElement ele, WebDriver driver) throws InterruptedException {
		
		Alert alert = driver.switchTo().alert();
		//alert.getText();
		alert.accept();
	}

	public void sendvalues(WebElement ele, String text) {

		ele.sendKeys(text);
	}
	public String Gettext(WebElement ele) {

		return ele.getText();
	}

	public void ClickAndWait(WebElement ele, String text) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(ele)).click();
	}

	public void Scrolldropdwon(List<WebElement> alloptions, int j, WebDriver driver) throws InterruptedException {

		List<WebElement> m = alloptions;
		for (WebElement text : m) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", text);
			System.out.println(text.getText());
		}
		for (int i = 1; i <= j; i++) {
			Thread.sleep(2000);
			m.get(i).click();
			Thread.sleep(3000);
			m.get(i).click();
		}
	}

	public void ClickOnbtn(int index) throws InterruptedException {

		WebElement ele = driver.findElement(By.xpath("(//*[@type='button'])[" + index + "]"));
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.moveToElement(ele).click().build().perform();
		ele.click();
		Thread.sleep(3000);
	}

	public int GetList(List<WebElement> alloptions, WebDriver driver) {

		List<WebElement> m = alloptions;
		int size = 0;
		for (WebElement text : m) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", text);
			log.info(text.getText());
			size = m.size();
			//log.info("No. of added physicians are " + size);
		}
		return size;
	}

	public void Scrolldropdwon1(List<WebElement> alloptions, int j, WebDriver driver) throws InterruptedException {

		List<WebElement> m = alloptions;
		for (WebElement text : m) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", text);
			System.out.println(text.getText());
		}
		for (int i = 1; i <= j; i++) {
			Thread.sleep(2000);
			m.get(i).click();
		}
	}
	
	public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
	
	public void switchToTab(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open('" + url + "');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
	
	 public void switchToParentTab(WebDriver driver, String parentHandle) {
	        driver.switchTo().window(parentHandle);
	    }
	 public void signature(WebElement element)
	 {
		 Action action = new Actions(driver).click(element)
	                .moveToElement(element, 3, 3).clickAndHold(element)
	                .moveByOffset(50, 50).moveByOffset(-50, 50)
	                .moveByOffset(-60,-50).moveByOffset(-100,59).release(element)
	                .moveByOffset(30,-130)
	                .build();
	        action.perform();
	 }

	 public String randomMethod() {
	        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        final java.util.Random rand = new java.util.Random();
	        final Set<String> identifiers = new HashSet<String>();

	        StringBuilder builder = new StringBuilder();
	        while (builder.toString().length() == 0) {
	            int length = rand.nextInt(5) + 5;
	            for (int i = 0; i < length; i++) {
	                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	            }
	            if (identifiers.contains(builder.toString())) {
	                builder = new StringBuilder();
	            }
	        }
	        return builder.toString();
	    }
		
		public WebElement getElementByTextXpath(String text) {
		    String xpath = "//*[text()='" + text + "']";
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		    return driver.findElement(By.xpath(xpath));
		}
//		public void waitForEnterKey() {
//	        Scanner scanner = new Scanner(System.in);
//	        log.info("Press Enter to continue...");
//	        scanner.nextLine();
//		}
		
	 public String GetURL(String txt) {
		 String url = null;
	        Pattern urlPattern = Pattern.compile("http[s]?://(?:[a-zA-Z]|[0-9]|[$-_@.&+]|[!*\\\\(\\\\),]|(?:%[0-9a-fA-F][0-9a-fA-F]))+");
	        Matcher matcher = urlPattern.matcher(txt);
	        while (matcher.find()) {
	            url = matcher.group();
	            System.out.println(url);    
	        }
			return url;
	    } 
	 
	 public void scrolldown()
	 {
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,250)");
	 }
	 public String RandomNumber()
	 {
	        Random random = new Random();
	        long lowerBound = 1000000000L;
	        long upperBound = 9999999999L;  
	        long randomNum = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound + 1));
	        String randomNumString = String.valueOf(randomNum);
	        return randomNumString;
	 }
	 public String randomZipCodeMethod() {
	        final String lexicon = "0123456789";
	        final java.util.Random rand = new java.util.Random();
	        final Set<String> identifiers = new HashSet<String>();

	        StringBuilder builder = new StringBuilder();
	        while (builder.toString().length() == 0) {
	            int length = rand.nextInt(5) + 5;
	            for (int i = 0; i < length; i++) {
	                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	            }
	            if (identifiers.contains(builder.toString())) {
	                builder = new StringBuilder();
	            }
	        }
	        return builder.toString();
	    }
}
