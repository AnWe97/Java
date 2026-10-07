package Observer_Pattern;

public class Main {

    public static void main(String[] args) {

        StockUser a = new StockUser("A");
        StockUser b = new StockUser("B");
        StockUser c = new StockUser("C");

        Stock stock = new Stock(25.43);

        stock.add_Observer(a);
        stock.add_Observer(b);
        stock.add_Observer(c);

        stock.update_price(22.65);
        stock.update_price(2.65);

    }
}
