package observer;

import java.util.ArrayList;

class CentralBank implements Subject {
	
	public CentralBank() {}

	public void setRates() {

		notifyObservers();
	}

	public void subscribe(Observer o) {}
    public void unsubscribe(Observer o) {}
	public void notifyObservers() {}
}