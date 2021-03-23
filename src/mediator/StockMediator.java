package mediator;

import java.util.ArrayList;

/**
 * StockMediator Class
 *
 * Sales and buys orders on behalf of brokers Colleague(s)
 * Add Collegue (method used by Collegues) and ...
 * send back message that all is ok
 */
class StockMediator implements Mediator {

	private ArrayList<Colleague> colleagues;
	private int brokerId = 0; // or DB

	public StockMediator() {

		colleagues = new ArrayList();
	}

	@Override
	public void addColleague(Colleague c) {

		colleagues.add(c);

		brokerId++; // or from database
		c.setBrokerId(brokerId); // Mediator -> Collegue

	}

	@Override
	public void saleOrder(String stock, int shares, int brokerId) {

	}

	@Override
	public void buyOrder(String stock, int shares, int brokerId) {

	}

	public void getStockOrders() {

	}
}