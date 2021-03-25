package mediator;

public class Order {
	
	private String sym = "";
	private int size = 0;
	private int brokerId = 0;

	public Order(String sym, int size, int brokerId) {

		this.sym = sym;
		this.size = size;
		this.brokerId = brokerId;
	}

	public String getSym() { return this.sym; }
	public int getSize() { return this.size; }
	public int getBrokerId() { return this.brokerId; }
}