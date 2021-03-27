package observer;

public class ExchangeRatesApp {
	
	public static void main(String[] args) {

		CentralBank feed = new CentralBank();

		Bank ing = new Bank("ING", feed);
		Bank bnp = new Bank("BNP", feed);

		feed.setRates();

		//System.out.println("Observers were notified!");
	}
}