package observer;

import java.util.ArrayList;

/**
 * Bank Observer
 * The method update() is called in ...
 * Subject's notifyObservers() method
 *
 */

class Bank implements Observer {

	private String name;
	private Subject feed;
	private ArrayList<String> feedRates;
	
	public Bank(String name, Subject feed) {

		this.name = name;
		this.feed = feed;

		feed.subscribe(this);

		feedRates = new ArrayList<String>();
	}

	public void update(ArrayList rates) { // Look Here

		feedRates = rates;
		
		System.out.println("Observer (" + name + "): Rates updated");
	}

	@Override
	public String getName() { return name; }
}