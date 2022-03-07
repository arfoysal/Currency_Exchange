package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import io.qameta.allure.Step;
import utilitiesPackage.CommonMethods;

public class P001_Currency_Exchange extends CommonMethods {
	public P001_Currency_Exchange() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(xpath = "(//input[contains(@class,'form-control')])[1]")
	public WebElement sellInputField;

	@FindBy(xpath = "(//input[contains(@class,'form-control')])[3]")
	public WebElement buyInputField;

	@FindBy(xpath = "//button[normalize-space()='Filter']")
	public WebElement filterButton;

	@FindBy(xpath = "//span[contains(text(),'EUR')]")
	public WebElement sellCurrency;
	

	public void sell(String amount) {
		scrollToElement(sellInputField);
		sendText(sellInputField, amount);
	}
	
	public String buytext() {
		String text = buyInputField.getText();
		return text;
	}
	
	public String selltext() {
		String text = sellInputField.getText();
		return text;
	}
	
	public void buy(String amount) {
		scrollToElement(buyInputField);
		sendText(buyInputField, amount);
	}
	

}
