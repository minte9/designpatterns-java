package observer;

class Bank implements Observer {
	
	public Bank(String name, Subject feed) {

		feed.subscribe(this);
	}

	public void update() {} // Look Here
}