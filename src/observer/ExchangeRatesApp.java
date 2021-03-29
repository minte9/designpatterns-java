package observer;

/**
 * Create the Subject object CentralBank
 * Instance variable feed will be used to subscribe banks
 *
 */

public class ExchangeRatesApp {
	
	public static void main(String[] args) {

		CentralBank feed = new CentralBank();

		Bank ing = new Bank("ING", feed);
		Bank bnp = new Bank("BNP", feed);

		feed.setRates();
	}
}