package observer;

import java.util.ArrayList;

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

	public void update(ArrayList rates) {

		feedRates = rates;
		
		System.out.println("Rates updated in " + name + " observer");
	}

	public String getName() { return name; }
}