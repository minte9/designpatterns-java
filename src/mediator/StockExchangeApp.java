package mediator;

/**
 * StockExchangeApp Class
 *
 * v1.0 - One stock Mediator and two brokers (concreate Colleagues)
 * v1.2 - Brokers sign in to StockExchange Market
 * v1.4 - Brokers buy/sell orders through Mediator
 * 
 * This should be the App Output:
 *
 * run:
     [java] Colleague GormanSlacks: Mediator signed me up - ID 1
     [java] Colleague JTPoorman: Mediator signed me up - ID 2
     [java] -- ElectronicBroker: JTPoorman
     [java] 100 shares of MSFT bought by colleague code 1
     [java] 50 shares of GOOG sold to colleague code 1
     [java] 100 shares of MSFT bought by colleague code 2
     [java] 10 shares of NRG sold to colleague code 2
     [java] 10 shares of NRG bought by colleague code 1
 */
public class StockExchangeApp {

    public static void main(String[] args) {
        
        StockMediator nyse = new StockMediator();
        
        FloorBroker broker1 = new FloorBroker("GormanSlacks", nyse);
        ElectronicBroker broker2 = new ElectronicBroker("JTPoorman", nyse);

        broker1.orderBuy("MSFT", 100);
        broker1.orderSell("GOOG", 50);

        broker2.orderBuy("MSFT", 100);
        broker2.orderSell("NRG", 10);

        broker1.orderBuy("NRG", 10);
    }
}