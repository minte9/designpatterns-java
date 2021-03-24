package mediator;

/**
 * FloorBroker type Collegue
 * Super() method add Collegue brokerId to Mediator list ...
 * and send back login confirmation
 */
public class FloorBroker extends Colleague {
	
	public FloorBroker(String brokerName, Mediator mediator) {

		super(brokerName, mediator);
		
		System.out.println(
			"FloorBroker: " + brokerName + " signed up with the stockexchange!\n"
		);
	}
}