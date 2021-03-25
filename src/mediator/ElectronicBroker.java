package mediator;

/**
 * ElectronicBroker type Collegue
 * Super() method add Collegue brokerId to Mediator list ...
 * and send back login confirmation
 */

public class ElectronicBroker extends Colleague {
	
	public ElectronicBroker(String brokerName, Mediator mediator) {

		super(brokerName, mediator);
		
		System.out.println("-- ElectronicBroker: " + brokerName);
	}
}