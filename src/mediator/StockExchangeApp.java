package mediator;

public class StockExchangeApp {

    public static void main(String[] args) {
        
        StockMediator nyse = new StockMediator();

        System.out.println("Hello Mediator");

        //FloorBroker broker = new FloorBroker("GormanSlacks", nyse);
        //ElectronicBroker broker2 = new ElectronicBroker("JTPoorman", nyse);
    }
}