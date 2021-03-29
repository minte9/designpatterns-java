package observer;

import java.util.ArrayList;

/** CentralBank Publisher (or Subject)
 *  Maintain a list of observers (add, remove)
 *  Foreach observers the Publisher uses ...
 *  observer's method update() for notification
 */

class CentralBank implements Subject {

	ArrayList<Observer> observers;
	ArrayList<String> rates;
	
	public CentralBank() {
		observers = new ArrayList<Observer>();
		rates = new ArrayList<String>();
	}

	public void setRates() {

		rates.add("EURUSD:1.2345");
		rates.add("EURGBP:0.9876");
		notifyObservers();
	}

	public void subscribe(Observer o) {
		observers.add(o);
	}

    public void unsubscribe(Observer o) {
    	observers.remove(o);
    }

	public void notifyObservers() {

		for(Observer o : observers) {
			
			System.out.println("Subject (CentralBank): " + o.getName() + " observer notified");

			o.update(rates); // Look Here
		}
	}
}