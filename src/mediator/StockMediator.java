package mediator;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * StockMediator Class
 *
 * Mediator sales and buys orders on behalf of brokers Colleague(s)
 * Mediator can addCollegue() and this method is called in Collegues class
 * Stock data keeps initial exchange data stock
 */
class StockMediator implements Mediator {

	private ArrayList<Colleague> colleagues;
	private int brokerId = 0;
	private HashMap<String, Integer> stock;
	
	private final String RED = "\033[0;31m";
	private final String RESET = "\033[0m";

	public StockMediator() {

		colleagues = new ArrayList<Colleague>();
		stock = new HashMap<String, Integer>();
		stock.put("MSFT", 100);
		stock.put("GOOG", 100);
	}

	@Override
	public void addColleague(Colleague c) {

		colleagues.add(c);
		brokerId++; // or from database
		c.setBrokerId(brokerId); // Mediator -> Collegue
		c.signUpMessage();
	}

	private void showStock() {

		for(Map.Entry me : stock.entrySet()) {
			System.out.print(
				me.getKey() + ":" + me.getValue().toString() + " "
			);
		}
	}

	@Override
	public void orderBuy(String sym, int siz, int brokerId) {

		System.out.print("\nbroker " + brokerId +
			" buy " + siz + " " + sym + " | "
		);

		Order order = new Order(sym, siz, brokerId);
		this.trade(order, "buy");
		this.showStock();
	}

	@Override
	public void orderSell(String sym, int siz, int brokerId) {

		System.out.print("\nbroker " + brokerId +
			" sell " + siz + " " + sym + " | "
		);
		
		Order order = new Order(sym, siz, brokerId);
		this.trade(order, "sell");
		this.showStock();
	}

	private void trade(Order order, String position) {

		for(Map.Entry me : stock.entrySet()) {

			String sym = (String) me.getKey();
			int total = (int) me.getValue();

			if (sym == order.getSym()) {

				if (order.getSize() > total) {
					System.out.print(RED + 
							"Error: stock exceded! | " + 
						RESET
					);
					break;
				}

				if (position == "buy") { total = total - order.getSize(); }
				if (position == "sell") { total = total + order.getSize(); }

				stock.put(sym, total);

			}
		}
	}
}