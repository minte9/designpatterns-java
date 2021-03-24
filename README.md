
# Mediator Pattern

- It is used to encapsulate comunications between related objects (named Colleagues).
- Colleagues don't need to know anything about each other.
- Collegues will send messages to the Mediator.
- Mediator will send back messages (if needeed) to the other colleques.

# Share stock exchange - Example

- Collegue is an abstract class, which represent all collegues that will be created.
- All collegues share the same methods (saleOffer, buyOffer).
- They will communicator through the use of these common methods.
- The Client App will communicate with both ConcreteMediator and ConcreteCollegues.

# Client

StockExchangeApp.java

~~~java
package mediator;

/**
 * StockExchangeApp Class
 *
 * One stock Mediator and two broker Colleague(s)
 * Collegues sign in to StockExchange
 */
public class StockExchangeApp {

    public static void main(String[] args) {
        
        StockMediator nyse = new StockMediator();
        
        FloorBroker broker1 = new FloorBroker("GormanSlacks", nyse);
        ElectronicBroker broker2 = new ElectronicBroker("JTPoorman", nyse);

        /* Next:

        broker1.saleOrder("MSFT", 100);
        broker1.saleOrder("GOOG", 50);

        broker2.buyOrder("MSFT", 100);
        broker2.saleOrder("NRG", 10);

        broker1.buyOrder("NRG", 10);

        nyse.getStockOrders();
        */
    }
}
~~~

# Mediator

StockMediator.java

~~~java
package mediator;

import java.util.ArrayList;

/**
 * StockMediator Class
 *
 * Mediator sales and buys orders on behalf of brokers Colleague(s)
 * Mediator can addCollegue() and this method is called in Collegues class
 */
class StockMediator implements Mediator {

    private ArrayList<Colleague> colleagues;
    private int brokerId = 0; // or DB

    public StockMediator() {

        colleagues = new ArrayList();
    }

    @Override
    public void addColleague(Colleague c) {

        colleagues.add(c);

        brokerId++; // or from database
        c.setBrokerId(brokerId); // Mediator -> Collegue

    }

    @Override
    public void saleOrder(String stock, int shares, int brokerId) {

    }

    @Override
    public void buyOrder(String stock, int shares, int brokerId) {

    }

    public void getStockOrders() {

    }
}
~~~

Mediator.java

~~~java
package mediator;

public interface Mediator {

    public void addColleague(Colleague colleague);
    public void saleOrder(String stock, int shares, int brokerId);
    public void buyOrder(String stock, int shares, int brokerId);
}
~~~

# Colleague

Colleague.java

~~~java
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
~~~

# Concreate Colleagues

FloorBroker.java

~~~java
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
~~~

ElectronicBroker.java

~~~java
package mediator;

/**
 * ElectronicBroker type Collegue
 * Super() method add Collegue brokerId to Mediator list ...
 * and send back login confirmation
 */

public class ElectronicBroker extends Colleague {
    
    public ElectronicBroker(String brokerName, Mediator mediator) {

        super(brokerName, mediator);

        System.out.println(
            "ElectronicBroker: " + brokerName + " signed up with the stockexchange!"
        );
    }
}
~~~


# Code

v1.0 - Basic Skeleton
- https://github.com/minte9/designpatterns-java/tree/v1.0/src/mediator

v1.2 - Colleagues sing up / Mediator assign ids
- https://github.com/minte9/designpatterns-java/tree/v1.2/src/mediator


# Reference

Derek Banas:
- https://www.youtube.com/watch?v=8DxIpdKd41A&ab_channel=DerekBanas
- http://www.newthinktank.com/2012/10/mediator-design-pattern-tutorial

Minte9:
- https://www.minte9.com/pages/1216/java-design-patterns-mediator
