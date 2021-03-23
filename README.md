
# Mediator

It is used to encapsulate comunications between related objects (named Colleagues).
Colleagues don't need to know anything about each other.
Collegues will send messages to the Mediator.
Mediator will send back messages (if needeed) to the other colleques.

Reference: https://www.youtube.com/watch?v=8DxIpdKd41A&ab_channel=DerekBanas

# Client

StockExchangeApp.java

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

# Mediator

StockMediator.java

~~~java
package learning;

class StockMediator implements Mediator {

    public StockMediator() {}

    @Override
    public void addColleague(Colleague colleague) {}
    @Override
    public void saleOrder(String stock, int shares) {}
    @Override
    public void buyOrder(String stock, int shares) {}
}

interface Mediator {

    public void addColleague(Colleague colleague);
    public void saleOrder(String stock, int shares);
    public void buyOrder(String stock, int shares);
}
~~~

# Colleague

Colleague.java

~~~java
package learning;

public abstract class Colleague {

    private Mediator mediator;
    private String brokerId;

    public Colleague(String b, Mediator m) {

        mediator = m;
        brokerId = b;
        mediator.addColleague(this);
    }

    public void saleOrder(String stock, int shares) {
        mediator.saleOrder(stock, shares); // Look Here
    }

    public void butyOrder(String stock, int shares) {
        mediator.buyOrder(stock, shares); // Look Here
    }
}
~~~
