
# Mediator Pattern

- It is used to encapsulate comunications between related objects (named Colleagues).
- Colleagues don't need to know anything about each other.
- Collegues will send messages to the Mediator.
- Mediator will send back messages (if needeed) to the other colleques.

# Share stock exchange - Example

- Collegue is an abstract class, which represent all collegues that will be created.
- All collegues share the same methods (saleOffer, buyOffer).
- They will communicator through the use of these common methods.
- The App will communicate with both ConcreteMediator and ConcreteCollegues.

# Client

StockExchangeApp.java

~~~java
package mediator;

public class StockExchangeApp {

    public static void main(String[] args) {
        
        StockMediator nyse = new StockMediator();

        System.out.println("Hello Mediator");

        //FloorBroker broker = new FloorBroker("GormanSlacks", nyse);
        //ElectronicBroker broker2 = new ElectronicBroker("JTPoorman", nyse);
    }
}
~~~

# Mediator

StockMediator.java

~~~java
package mediator;

class StockMediator implements Mediator {

    public StockMediator() {}

    @Override
    public void addColleague(Colleague colleague) {

    }

    @Override
    public void saleOrder(String stock, int shares) {

    }

    @Override
    public void buyOrder(String stock, int shares) {
        
    }
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
package mediator;

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

# Pattern Code - v1.0

- https://github.com/minte9/designpatterns-java/tree/main/src/mediator

# Reference

Derek Banas:
- https://www.youtube.com/watch?v=8DxIpdKd41A&ab_channel=DerekBanas
- http://www.newthinktank.com/2012/10/mediator-design-pattern-tutorial
