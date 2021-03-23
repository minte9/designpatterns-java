
# Mediator

~~~java
package mediator;

/**
 * StockExchangeApp Class
 *
 * One stock Mediator and two broker Colleague(s)
 * Collegues sign in to StockExchange and ...
 * mediator send back confirmation
 */
public class StockExchangeApp {

    public static void main(String[] args) {
        
        StockMediator nyse = new StockMediator();
        
        FloorBroker broker1 = new FloorBroker("GormanSlacks", nyse);
        ElectronicBroker broker2 = new ElectronicBroker("JTPoorman", nyse);

        broker1.saleOrder("MSFT", 100);
        broker1.saleOrder("GOOG", 50);
        broker2.buyOrder("MSFT", 100);
        broker2.saleOrder("NRG", 10);
        broker1.buyOrder("NRG", 10);

        nyse.getStockOrders();
    }
}
~~~
