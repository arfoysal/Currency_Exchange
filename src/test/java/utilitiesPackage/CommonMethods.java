package utilitiesPackage;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverPackage.PageDriver;

public class CommonMethods {
	
	/************************
	 * Get Current Page URL * 
	 * **********************
	 */

	public String currentPageUrl() {
		return PageDriver.getCurrentDriver().getCurrentUrl();
	}
	
	/**************************
	 * Get Current Page Title * 
	 * ************************
	 */
	
	public String getTitle() {
		return PageDriver.getCurrentDriver().getTitle();
	}
	
	/**************************
	 * Write in a input field 
	 * @param element This is the target element where to write
	 * @param value what to write
	 * ************************
	 */

	public void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	

	//text to number
	public double textToDecemal(String valueString) {
		valueString = valueString.replace("(", "");
		valueString = valueString.replace(")", "");
		valueString = valueString.replace(",", "");
		double amountValue = Double.parseDouble(valueString);
		return Double.parseDouble(new DecimalFormat("##.##").format(amountValue));
	}
	
	public double decemalPrecesion(double number) {
		return Double.parseDouble(new DecimalFormat("##.##").format(number));
	}
	
	// Perform click action on a element where visible Text match from an elements list 
	public void listitem(List<WebElement> elements, String visibleText) {
		for (WebElement element : elements) {
			if (element.getText().equals(visibleText)) {
				element.click();
				break;
			}
		}
	}
	

	/*********************************************
	 * Scroll to an element
	 * @param element This is the target element * 
	 * *******************************************
	 */
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	/****************************
	 * Handle Wait Related Task * 
	 * **************************
	 */
	public void timeOut(int duretionMS) {
		try {
			Thread.sleep(duretionMS);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/********************************************
	 * Wait for completely load current web page* 
	 * ******************************************
	 */
	WebDriverWait wait;
	public void waitForPageLoad() {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState;").equals("complete"));
	}
}
