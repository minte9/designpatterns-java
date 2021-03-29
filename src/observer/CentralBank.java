package observer;

import java.util.ArrayList;
import java.util.Arrays;

/** CentralBank Publisher (or Subject)
 *  Maintain a list of observers (add, remove)
 *  Foreach observers the Publisher uses ...
 *  observer's method update() for notification
 */

class CentralBank implements Subject {

	ArrayList<Observer> observers;
	ArrayList<String> rates;
	String[] times;
	
	public CentralBank() {

		observers = new ArrayList<Observer>();
		rates = new ArrayList<String>();
	}

	public void updateRates(String time) { // Rates feed

		rates.clear();

		if (time == "first_time") {
			add("EURUSD:1.2222");
			add("EURGBP:0.3333");
		}

		if (time == "second_time") {
			add("EURUSD:1.4444");
			add("EURGBP:0.6666");
		}

		System.out.println("\nCentralBank [Rates updated] ---\n");

		notifyObservers();
	}

	private void add(String rate) {
		if (! Arrays.asList(rates).contains(rate)) {
			rates.add(rate);
		}
	}

	public void subscribe(Observer o) {
		observers.add(o);
	}

    public void unsubscribe(Observer o) {
    	observers.remove(o);
    }

	public void notifyObservers() {

		for(Observer o : observers) {
			
			System.out.println("CentralBank [" + o.getName() + " notified]");

			o.update(rates); // Look Here
		}
	}
}