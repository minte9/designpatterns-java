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

		this.mediator = m;
		this.brokerName = bn;

		mediator.addColleague(this);
	}

	public void saleOrder(String stock, int shares) {
		mediator.saleOrder(stock, shares, brokerId); // Look Here
	}

	public void buyOrder(String stock, int shares) {
		mediator.buyOrder(stock, shares, brokerId);
	}

	public void setBrokerId(int brokerId) {
		
		this.brokerId = brokerId;

		System.out.println(
			brokerName + ": I signed up, Mediator gave me brokerId: " + brokerId
		);
	}
}