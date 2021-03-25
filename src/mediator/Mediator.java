package mediator;

public interface Mediator {

	public void addColleague(Colleague colleague);
	public void orderSell(String sym, int siz, int brokerId);
	public void orderBuy(String sym, int siz, int brokerId);
}