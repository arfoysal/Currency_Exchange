package pageObjectPackage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
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

	@FindBy(xpath = "(//span[@data-ng-bind='$select.selected'][@class='ng-binding ng-scope'])[1]")
	public WebElement sellCurrency;

	@FindBy(xpath = "//div[@data-ng-model='currencyExchangeVM.filter.from']//i[@class='caret pull-right']")
	public WebElement currencyDropdown;

	@FindBy(xpath = "//span[@data-ng-bind='currency']")
	public List<WebElement> currencylist;

	@FindBy(css = "span[role='button']")
	public WebElement countryButton;

	@FindBy(id = "countries-dropdown")
	public WebElement countryDropdown;

	@FindBy(xpath = "//ul[@class='dropdown-menu']/li //a[not(contains(@class,'text-capitalize'))]")
	public List<WebElement> countryList;

	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
	public WebElement currencyRate;

	public void sell(String amount) {
		scrollToElement(sellInputField);
		sendText(sellInputField, amount);
	}

	public String buytext() {
		return buyInputField.getText();
	}

	public String selltext() {
		return sellInputField.getText();
	}

	public void buy(String amount) {
		scrollToElement(buyInputField);
		sendText(buyInputField, amount);
	}

	public void selectCountry(String countryName) {
		scrollToElement(countryButton);
		countryButton.click();
		countryDropdown.click();
		listitem(countryList, countryName);
	}

	public String currencyText() {

		scrollToElement(sellInputField);
		timeOut(7000);
		return sellCurrency.getText();
	}

	public String officialRate() {
		return currencyRate.getText();
	}

}
