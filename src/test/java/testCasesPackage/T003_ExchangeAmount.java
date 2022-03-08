package testCasesPackage;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import driverPackage.BaseDriver;
import pageObjectPackage.P001_Currency_Exchange;

public class T003_ExchangeAmount extends BaseDriver {

	@Test
	public void exchangeAmount() {
		P001_Currency_Exchange currency_Exchange = new P001_Currency_Exchange();
		List<Double> actualloss = currency_Exchange.callectActualloss();
		List<Double> expectedloss = currency_Exchange.lossCalculation();

		for (int i = 0; i < actualloss.size(); i++) {
			assertEquals(actualloss.get(i), expectedloss.get(i));
		}
		

	}
}
