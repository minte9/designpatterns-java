package observer;

public class ExchangeRatesApp {
	
	public static void main(String[] args) {

		CentralBank feed = new CentralBank();

		Bank ing = new Bank("ING");
		Bank bnp = new Bank("BNP");

		feed.subscribe(ing);
		feed.subscribe(bnp);
		feed.setRates();
		feed.notifyObservers(); // Look Here

		System.out.println("Observers were notified!");
	}
}