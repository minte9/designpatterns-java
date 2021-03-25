package mediator;

public class Order {
	
	private String sym = "";
	private int brokerId = 0;

	public Order(String sym, int siz, int brokerId) {

		this.sym = sym;
		this.brokerId = brokerId;
	}

	public String getSym() { return this.sym; }
	public int getBrokerId() { return this.brokerId; }
}