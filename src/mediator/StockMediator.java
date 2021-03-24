package mediator;

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