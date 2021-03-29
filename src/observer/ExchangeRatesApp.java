package observer;

/**
 * CentralBank is the Publisher (or Subject)
 * Subject Instance variable (feed) pass as parameter
 * Observer (banks) subscriber themselves (using feed object)
 * CentralBank set rates (and notify observers)
 *
 * run:
     [java] CentralBank [Rates updated] ---
     [java] 
     [java] CentralBank [ING notified]
     [java] ING: EURUSD:1.2222 EURGBP:0.3333 
     [java] CentralBank [BNP notified]
     [java] BNP: EURUSD:1.2222 EURGBP:0.3333 
     [java] 
     [java] BNP: I've unsubscribed from Rates Feed!
     [java] 
     [java] CentralBank [Rates updated] ---
     [java] 
     [java] CentralBank [ING notified]
     [java] ING: EURUSD:1.4444 EURGBP:0.6666 

 */

public class ExchangeRatesApp {
	
	public static void main(String[] args) {

		CentralBank feed = new CentralBank();

		Bank ing = new Bank("ING", feed);
		Bank bnp = new Bank("BNP", feed);

		feed.updateRates("first_time");
		
		bnp.leave(); // observer unsubscribe

		feed.updateRates("second_time");
	}
}