package observer;

public class ExchangeRatesApp {
	
	public static void main(String[] args) {

		CentralBank feed = new CentralBank();

		Bank bankING = new Bank("ING");
		Bank bankBNP = new Bank("BNP");

		feed.subscribe(bankING);
		feed.subscribe(bankBNP);
		feed.setRates();
		feed.notifyObservers(); // Look Here

		System.out.println("Observers were notified!");
	}
}