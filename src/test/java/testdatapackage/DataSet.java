package testdatapackage;

import org.testng.annotations.DataProvider;

public class DataSet {

	@DataProvider(name = "countryBasedCurrency")
	public static Object dataset() {

		Object[][] obj = {

				{ "Latvia", "EUR", "1.089500" }, { "Estonia", "EUR", "1.089500" }, { "Bulgaria", "BGN", "0.511300" },
				{ "Spain", "EUR", "1.089500" }, { "Romania", "RON", "0.202000" }, { "Poland", "PLN", "0.201900" },
				{ "United Kingdom", "GBP", "1.210300" }, { "Germany", "EUR", "1.089500" },
				{ "Russia", "RUB", "0.006800" }, { "Algeria", "DZD", "0.006300" }, { "Albania", "ALL", "0.008200" },
				{ "Kosovo", "EUR", "1.089500" }, { "Ukraine", "UAH", "0.029700" }, { "France", "EUR", "1.089500" },
				{ "Another country", "EUR", "1.089500" }, { "Lithuania", "EUR", "1.089500" } };
		return obj;

	}

}
