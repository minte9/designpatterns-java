package mediator;

/**
 * When a broker Collegue sales or buy shares
 * it lets the Meditor decide and do the job
 */
public abstract class Colleague {

	private Mediator mediator;
	private String brokerName;
	private int brokerId;

	public Colleague(String bn, Mediator m) {
		mediator = m;
		brokerName = bn;
		mediator.addColleague(this);
	}

	public void orderSell(String sym, int siz) {
		mediator.orderSell(sym, siz, brokerId); // Look Here
	}

	public void orderBuy(String sym, int siz) {
		mediator.orderBuy(sym, siz, brokerId);
	}

	public void setBrokerId(int bid) {
		brokerId = bid;
	}

	public void signUpMessage() {
		System.out.println("Colleague " + brokerName + ": " +
			"Mediator signed me up - ID " + brokerId
		);
	}
}		