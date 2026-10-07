package Observer_Pattern;

public class StockUser implements Observer {

    String name;

    public StockUser(String name) {
        this.name = name;
    }

    @Override
    public void update(double new_number, String stock_name) {
        System.out.println(this.name + "'s Update: " + stock_name + " now at " +  new_number);

    }

}
