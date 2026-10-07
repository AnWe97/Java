package Observer_Pattern;
import java.util.ArrayList;

public class Stock {

    String stock_name;
    double price;

    ArrayList<Observer> observer_list = new ArrayList<Observer>();

    public Stock(double price) {
        this.price = price;
        this.stock_name = "DAA Aktie";
    }

    public void add_Observer(Observer o) {
        observer_list.add(o);
    }

    public void remove_Observer(Observer o) {
        observer_list.remove(o);
    }

    public void update_price(double price) {
        this.price = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observer_list) {
            o.update(this.price, this.stock_name);
        }
    }



}
