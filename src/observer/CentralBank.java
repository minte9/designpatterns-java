package observer;

import java.util.ArrayList;

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
			
			o.update(rates); // Look Here
			//System.out.println(o.getName() + " notified");
		}
	}
}