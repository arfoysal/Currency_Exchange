package testCasesPackage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import driverPackage.BaseDriver;
import pageObjectPackage.P001_Currency_Exchange;
import testdatapackage.DataSet;

public class T002_CountrySelect extends BaseDriver {

	@Test(dataProvider = "countryBasedCurrency", dataProviderClass = DataSet.class)
	public void countrySelect(String countryName, String currencyName, String currencyRate) {
		P001_Currency_Exchange currency_Exchange = new P001_Currency_Exchange();
		
		currency_Exchange.selectCountry(countryName);
		currency_Exchange.waitForPageLoad();
		assertEquals(currency_Exchange.currencyText(), currencyName);
		assertEquals(currency_Exchange.officialRate(), currencyRate);
	}

}
