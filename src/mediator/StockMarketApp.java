package mediator;

/**
 * StockMarketApp Class
 *
 * v1.0 - One stock Mediator and two brokers (concreate Colleagues)
 * v1.2 - Brokers sign in to StockExchange Market
 * v1.4 - Brokers buy/sell orders through Mediator
 * v1.6 - Add logic, buy/sell, error stock exceded
 *
 * This should be the App Output:
 *
 * run:
     [java] Colleague GormanSlacks: Mediator signed me up - ID 1
     [java] -- FloorBroker: GormanSlacks
     [java] Colleague JTPoorman: Mediator signed me up - ID 2
     [java] ** ElectronicBroker: JTPoorman
     [java] 
     [java] broker 1 sell 100 MSFT | MSFT:200 GOOG:100 
     [java] broker 2 buy 200 MSFT | MSFT:0 GOOG:100 
     [java] broker 2 buy 10 MSFT | Error: stock exceded! | MSFT:0 GOOG:100 
     [java] broker 2 sell 50 GOOG | MSFT:0 GOOG:150 
     [java] broker 1 buy 150 GOOG | MSFT:0 GOOG:0 
     [java] broker 1 buy 50 GOOG | Error: stock exceded! | MSFT:0 GOOG:0 

 */
public class StockMarketApp {

    public static void main(String[] args) {
        
        StockMediator nyse = new StockMediator();
        
        FloorBroker broker1 = new FloorBroker("GormanSlacks", nyse);
        ElectronicBroker broker2 = new ElectronicBroker("JTPoorman", nyse);

        broker1.orderSell("MSFT", 100);
        broker2.orderBuy("MSFT", 200);
        broker2.orderBuy("MSFT", 10);

        broker2.orderSell("GOOG", 50);
        broker1.orderBuy("GOOG", 150);
        broker1.orderBuy("GOOG", 50);
    }
}