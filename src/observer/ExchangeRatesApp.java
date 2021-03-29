package observer;

/**
 * CentralBank is the Publisher (or Subject)
 * Subject Instance variable (feed) pass as parameter
 * Observer (banks) subscriber themselves (using feed object)
 * CentralBank set rates (and notify observers)
 *
 * run:
     [java] Subject (CentralBank): ING observer notified
     [java] Observer (ING): Rates updated
     [java] Subject (CentralBank): BNP observer notified
     [java] Observer (BNP): Rates updated
 */

public class ExchangeRatesApp {
	
	public static void main(String[] args) {

		CentralBank feed = new CentralBank();

		Bank ing = new Bank("ING", feed);
		Bank bnp = new Bank("BNP", feed);

		feed.setRates();
	}
}