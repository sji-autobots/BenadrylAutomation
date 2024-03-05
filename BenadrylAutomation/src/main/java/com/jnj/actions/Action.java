/**
 * @author Goutam Naik
 * @date 27-Feb-24
 */

package com.jnj.actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.jnj.base.BaseClass;

public class Action extends BaseClass {

	public static void scrollUntilElementVisible(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public static void click(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}

	public static void pressEnter(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	public static void pressEsc(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).perform();
	}
	
    /**
     * Function to log and assert the actual and expected values
     *
     * @param actualResult   String representing the actual result
     * @param expectedResult String representing the expected result
     */
    public static void printAndAssert(Object actualResult, Object expectedResult) {
        extentInfoLog("Asserting actual result : ", actualResult);
        extentInfoLog("Expected Result : ", expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
    }

	public static boolean sendKeys(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}
		}
		return flag;
	}

	public static boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			// System.out.println("Location not found: "+locatorName);
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}

	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed");
			} else {
				System.out.println("The element is not Displayed");
			}
		} else {
			System.out.println("Not displayed ");
		}
		return flag;
	}

	public static boolean isSelected(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isSelected();
			if (flag) {
				System.out.println("The element is Selected");
			} else {
				System.out.println("The element is not Selected");
			}
		} else {
			System.out.println("Not selected ");
		}
		return flag;
	}

	public static boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				System.out.println("The element is Enabled");
			} else {
				System.out.println("The element is not Enabled");
			}
		} else {
			System.out.println("Not Enabled ");
		}
		return flag;
	}

	public static boolean selectBySendkeys(String value, WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the DropDown");
			} else {
				System.out.println("Not Selected value from the DropDown");
				// throw new ElementNotFoundException("", "", "")
			}
		}
	}

	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * 
	 */
	public static boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option not selected by Index");
			}
		}
	}

	/**
	 * select value from DD by using value
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param value       : Value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	public static boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}

	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	public static boolean selectByVisibleText(String visibletext, WebElement ele, String log) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				BaseClass.extentInfoLog(log, "");
			} else {
				BaseClass.extentInfoLog("Option not selected by VisibleText", "");
			}
		}
	}

	public static boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}
	}

	public static boolean JSClick(WebDriver driver, WebElement ele) throws Exception {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;
		} catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}

	public static boolean switchToFrameByIndex(WebDriver driver, int index) {
		boolean flag = false;
		try {
			// new WebDriverWait(driver,
			// 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame ID.
	 * 
	 * @param idValue : Frame ID wish to switch
	 * 
	 */
	public static boolean switchToFrameById(WebDriver driver, String idValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Id \"" + idValue + "\" is selected");
			} else {
				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame Name.
	 * 
	 * @param nameValue : Frame Name wish to switch
	 * 
	 */
	public static boolean switchToFrameByName(WebDriver driver, String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}

	public static boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!flag) {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}

	public static void mouseOverElement(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on");
			}
		}
	}

	public static boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			actions.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean mouseover(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;

		} catch (Exception e) {

			return false;

		} finally {
			if (flag) {
				System.out.println("Draggable Action is performed on \"" + source + "\"");
			} else if (!flag) {
				System.out.println("Draggable action is not performed on \"" + source + "\"");
			}
		}
	}

	public static boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action is performed");
			} else if (!flag) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}

	public static boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Slider Action is performed");
			} else {
				System.out.println("Slider Action is not performed");
			}
		}
	}

	public static boolean rightclick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}

	public static boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count - 1]);

			if (driver.getTitle().contains(windowTitle)) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			// flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
	}

	public static boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s = driver.getWindowHandles();
			Object popup[] = s.toArray();
			driver.switchTo().window(popup[1].toString());
			waitFor(2000);
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				BaseClass.extentInfoLog("Switched to new window : ", driver.getTitle());
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}

	public static boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s = driver.getWindowHandles();
			Object popup[] = s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				BaseClass.extentInfoLog("Switched to old tab : ", driver.getTitle());
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}

	public static int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}

	public static int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}

	/**
	 * Verify alert present or not
	 * 
	 * @return: Boolean (True: If alert preset, False: If no alert)
	 * 
	 */
	public static boolean Alert(WebDriver driver) {
		boolean presentFlag = false;
		org.openqa.selenium.Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");
			} else {
				System.out.println("There was no alert to handle");
			}
		}
		return presentFlag;
	}

	public static boolean launchUrl(WebDriver driver, String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched \"" + url + "\"");
			} else {
				System.out.println("Failed to launch \"" + url + "\"");
			}
		}
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	public String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is: \"" + text + "\"");
		}
		return text;
	}

	public static String getCurrentURL(WebDriver driver) {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: \"" + text + "\"");
		}
		return text;
	}

	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}

	public static void explicitWait(WebElement element, long i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void fluentWait(String waitType, WebElement element, int timeOut, int polling) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(polling)).ignoring(Exception.class);
			if (waitType.contains("elementToBeClickable")) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
			} else if (waitType.contains("visibilityOf")) {
				wait.until(ExpectedConditions.visibilityOf(element));
			} else if (waitType.contains("invisibilityOf")) {
				wait.until(ExpectedConditions.invisibilityOf(element));
			}
			// element.click();
		} catch (Exception e) {
		}
	}

	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

		// Split the filename using '_' to extract the suite name
		String[] filenameParts = filename.split("_");
		String suiteName = filenameParts[0];

		// Create a folder with the suite name if it doesn't exist
		String folderPath = System.getProperty("user.dir") + "\\ScreenShot\\" + suiteName;
		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String destination = folderPath + "\\" + filename + "_" + dateName + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}

		// This new path for Jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename
				+ "_" + dateName + ".png";
		return destination;
	}

	/**
	 * This function is used to perform an action on element after it is visible and
	 * log the event
	 * 
	 * @param ele
	 * @param action
	 * @param log
	 */
	public static void performActionwithExtentInfoLog(WebElement ele, String action, String log) {
		test.log(Status.INFO, log);
		try {
			if (action.equalsIgnoreCase("click")) {
				scrollIntoCenterUsingJS(driver, ele);
				ele.click();
			} else if (action.equalsIgnoreCase("jsclick")) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", ele);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to perform an action on element after it is visible and
	 * log the event
	 * 
	 * @param ele
	 * @param action
	 * @param log
	 */
	public static void performActionwithExtentInfoLog(WebElement ele, String action, String log, String keys) {
		test.log(Status.INFO, log);
		try {
			if (action.equalsIgnoreCase("sendkeys")) {
				scrollIntoCenterUsingJS(driver, ele);
				ele.sendKeys(keys);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function to wait for element to disappear
	 * 
	 * @param element pass the WebElement
	 * @param i       pass the number of seconds
	 */
	public static void explicitWaitForElementToDisappear(WebElement element, long i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Function to wait for element to be clickable
	 * 
	 * @param element pass the WebElement
	 * @param i       pass the number of seconds
	 */
	public static void explicitWaitForElementTobeclickable(WebElement element, long i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Function to wait for element to be clickable
	 * 
	 * @param sec pass the time
	 */
	public static void waitFor(long sec) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Function to scroll element to the nearest of view
	 * 
	 * @param driver pass driver object
	 * @param ele    pass webelement
	 */
	public void scrollIntoViewUsingJS(WebDriver driver, WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'nearest'});", ele);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function to scroll element to the center of view
	 * 
	 * @param driver pass driver object
	 * @param ele    pass webelement
	 */
	public static void scrollIntoCenterUsingJS(WebDriver driver, WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
	}

	/**
	 * Function to scroll to the bottom of the page.
	 */
	public static void scrollToBottom(WebDriver driver) {
		BaseClass.extentInfoLog("Scrolling to the ", "bottom of page.");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * Function to return a weblocator with specific text
	 * 
	 * @param tagName pass tag name as String
	 * @param text    pass text as string
	 * @return WebElement
	 */
	public static WebElement getElementWithText(String tagName, String text) {
		return driver.findElement(By.xpath("//" + tagName + "[text()='" + text + "']"));
	}

	/**
	 * Function to filter out characters that are Non alphanumeric
	 * 
	 * @param input pass input string
	 * @return String
	 */
	public static String removeNonAlphanumericASCII(String input) {
		String pattern = "[^a-zA-Z0-9 |.]+"; // Matches any character that is not a letter, digit, space, or |
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(input);
		String result = matcher.replaceAll(""); // Replace matches with an empty string
		return result;
	}

	/**
	 * Function to reload current tab contents
	 */
	public static void navigateRefresh() {
		driver.navigate().refresh();
		extentInfoLog("Reloading ", "current tab contents");
	}

	/**
	 * Function to accept javscript alerts
	 */
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	/**
	 * Function to check if a particular date is within the given start and end date
	 * 
	 * @param date      pass date to check
	 * @param startDate pass the start date
	 * @param endDate   pass end date
	 * @return boolean
	 */
	public static boolean isDateWithinRange(String date, String startDate, String endDate) {
		LocalDate dateObj = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		LocalDate startDateObj = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		LocalDate endDateObj = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		return dateObj.isAfter(startDateObj) || dateObj.isEqual(startDateObj) && dateObj.isBefore(endDateObj)
				|| dateObj.isEqual(endDateObj);
	}

	/**
	 * Function to check for a list of dates to see if any of those fall under a
	 * range of date
	 * 
	 * @param dates     pass and array od dates to check
	 * @param startDate pass start date for range
	 * @param endDate   pass end date for range
	 * @return boolean
	 */
	public static boolean isAnyDateWithinRangeAndPrint(ArrayList<String> dates, String startDate, String endDate) {
		LocalDate startDateObj = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		LocalDate endDateObj = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		boolean isAnyWithinRange = false;
		for (String date : dates) {
			date = date.replace("-", "/");
			LocalDate dateObj = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

			if (dateObj.isAfter(startDateObj) || dateObj.isEqual(startDateObj) && dateObj.isBefore(endDateObj)
					|| dateObj.isEqual(endDateObj)) {
				isAnyWithinRange = true;
				BaseClass.extentInfoLog("The date " + date + " falls within the range.", "");
			}
		}
		return isAnyWithinRange;
	}

	/**
	 * Function to genearte a date x days behind from today
	 * 
	 * @param days pass x number of days
	 * @return String
	 */
	public static String generateDateFromXDaysAgo(int days) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_MONTH, -days);
		Date dateFromXDaysAgo = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = formatter.format(dateFromXDaysAgo);
		formattedDate = formattedDate.replaceAll("^0", "");
		return formattedDate;
	}

	/**
	 * Function to send keys to an element using JS
	 * 
	 * @param element pass locator of an element
	 * @param keys    pass keys to send
	 */
	public static void sendKeysUsingJavaScriptExecutor(WebElement element, String keys) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]", element, keys);
	}

	/**
	 * Function to filter two arrays and return intersecting elements
	 * 
	 * @param array1 pass first array
	 * @param array2 pass second array
	 * @return string of common elements
	 */
	public static String filterArraysAndReturnIntersection(String[] array1, String[] array2) {
		// Create a Stream object for the first array.
		Stream<String> stream = Arrays.stream(array1);
		Stream<String> filteredStream = stream.filter(element -> Arrays.asList(array2).contains(element));
		String[] commonArray = filteredStream.collect(Collectors.toList()).toArray(new String[0]);
		return Arrays.toString(commonArray);
	}

	/**
	 * Navigates the web browser back to the previous page.
	 */
	public static void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * Navigates the web browser forward to the next page in the browser history.
	 */
	public static void navigateForward() {
		driver.navigate().forward();
	}
	
	/**
	 * Function to verify page url
	 * @param partialUrl pass partial url to verify
	 */
	public static void verifyPageUrl(String partialUrl) {
		String currentUrl = driver.getCurrentUrl().trim();
        extentInfoLog("Asserting current URL : ", currentUrl);
		String expectedUrl = baseURI + partialUrl;
		extentInfoLog("Expected URL : ", expectedUrl);
		Assert.assertEquals(currentUrl, expectedUrl);
	}
}
