package testCasesPackage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import driverPackage.BaseDriver;
import pageObjectPackage.P001_Currency_Exchange;

public class T001_BuyAndSell extends BaseDriver {

	@Test()
	public void buyAndSell() {

		P001_Currency_Exchange currency_Exchange = new P001_Currency_Exchange();
		
		currency_Exchange.sell("100");
		
		assertEquals(currency_Exchange.buytext(), "");
		
		currency_Exchange.buy("200");
		
		assertEquals(currency_Exchange.selltext(), "");

	}

}
