
# Design Patterns

1. [Mediator Pattern](#mediator-pattern)
2. [Strategy Pattern](#strategy-pattern)



## Mediator Pattern

- It is used to encapsulate comunications between related objects (named Colleagues).
- Colleagues don't need to know anything about each other.
- Collegues will send messages to the Mediator.
- Mediator will send back messages (if needeed) to the other colleques.

## Share stock exchange - Example

- Colleague is an abstract class, which represent all collegues that will be created.
- All collegues share the same methods (saleOffer, buyOffer).
- They will communicator through the use of these common methods.
- The Client App will communicate with both ConcreteMediator and ConcreteCollegues.

## Client

StockExchangeApp.java

~~~java
package mediator;

public class StockExchangeApp {

    public static void main(String[] args) {
        
        StockMediator nyse = new StockMediator();

        System.out.println("Hello Mediator"); 
    }
}
~~~

## Mediator

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

## Colleague

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


## Code

- [v1.0 - Basic Skeleton](https://github.com/minte9/designpatterns-java/tree/v1.0/src/mediator)
- [v1.2 - Colleagues are signing up and Mediator assign broker Ids](https://github.com/minte9/designpatterns-java/tree/v1.2/src/mediator)
- [v1.4 - Collegues sale and buy orders, Order object added](https://github.com/minte9/designpatterns-java/tree/v1.4/src/mediator)
- [v1.6 - Add logic, buy/sell, error stock exceded](https://github.com/minte9/designpatterns-java/tree/v1.6/src/mediator)



## References

Derek Banas:
- https://www.youtube.com/watch?v=8DxIpdKd41A&ab_channel=DerekBanas
- https://www.newthinktank.com/2012/10/mediator-design-pattern-tutorial

Minte9:
- https://www.minte9.com/pages/1216/java-design-patterns-mediator


#
#


## Strategy Pattern

- You use this pattern if you need to dynamically change an object behavior at run time.
- The pattern allows you to eliminate code duplication. 
- It separates behavior from super and subclasses.


## Knowledge App - Example

- Insteed of using an interface for Speak we use an instance variable (speakType).
- It is a subclass of interface Speak.
- Human abstract class doesn't konw what speakType does.
- It just knows that the behavior is available to its subclasses.
- This is known as Composition.
- It allows you to change the capabilities of objects at run time!

## App

KnowledgeApp.java

~~~java
package strategy;

/**
 * run:
     [java] Socrate: I can only raise questions.
     [java] Alcibiades: I can answer!
 */
public class KnowledgeApp {
    
    public static void main(String[] args) {
        
        Human master = new Master("Socrate");
        Human pupil = new Pupil("Alcibiades");

        System.out.println( 
            master.getName() + ": " + master.speak() 
        );

        System.out.println( 
            pupil.getName() + ": " + pupil.speak() 
        );
    }
}
~~~

## Humans

Master.java

~~~java
package strategy;

public class Master extends Human {

    public Master (String name) {

        super(name);
        
        speakType = new AskCapable(); // He can raise questions
    }
}
~~~

Pupil.java

~~~java
package strategy;

public class Pupil extends Human {

    public Pupil (String name) {
        
        super(name);

        speakType = new AskIncapable(); // He knows everything
    }
}
~~~

Human.java

~~~java
package strategy;

public abstract class Human {

    private String name;

    public Speak speakType; // Look Here

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String speak() {
        return speakType.speak(); // Look Here
    }
}
~~~

## Code

- [v2.0 - Human objects can have different speak capabilities](https://github.com/minte9/designpatterns-java/tree/v2.0/src/strategy)


## References

Derek Banas:
- https://www.youtube.com/watch?v=-NCgRD9-C6o&ab_channel=DerekBanas
- http://www.newthinktank.com/2012/08/strategy-design-pattern-tutorial/

Minte9:
- https://www.minte9.com/pages/1201/java-design-patterns-strategy