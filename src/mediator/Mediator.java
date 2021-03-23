package mediator;

public interface Mediator {

	public void addColleague(Colleague colleague);
	public void saleOrder(String stock, int shares, int brokerId);
	public void buyOrder(String stock, int shares, int brokerId);
}