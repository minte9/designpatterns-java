package mediator;

import java.util.ArrayList;

/**
 * StockMediator Class
 *
 * Mediator sales and buys orders on behalf of brokers Colleague(s)
 * Mediator can addCollegue() and this method is called in Collegues class
 */
class StockMediator implements Mediator {

	private ArrayList<Colleague> colleagues;
	private int brokerId = 0;
	private ArrayList<Order> buyOrders;
	private ArrayList<Order> sellOrders;

	public StockMediator() {

		colleagues = new ArrayList<Colleague>();
		buyOrders = new ArrayList<Order>();
		sellOrders = new ArrayList<Order>();
	}

	@Override
	public void addColleague(Colleague c) {

		colleagues.add(c);

		brokerId++; // or from database
		c.setBrokerId(brokerId); // Mediator -> Collegue
		c.signUpMessage();
	}

	@Override
	public void orderSell(String sym, int siz, int brokerId) {
		
		Order newOrder = new Order(sym, siz, brokerId);

		sellOrders.add(newOrder); // Look Here
		
		System.out.println( siz + " shares of " + sym + 
			" sold to colleague code " + newOrder.getBrokerId()
		);
	}

	@Override
	public void orderBuy(String sym, int siz, int brokerId) {

		Order newOrder = new Order(sym, siz, brokerId);

		buyOrders.add(newOrder); // Look Here
		
		System.out.println( siz + " shares of " + sym + 
			" bought by colleague code " + newOrder.getBrokerId()
		);
	}
}