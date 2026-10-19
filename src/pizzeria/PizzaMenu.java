package pizzeria;

public class PizzaMenu {
    public int getPrice(String pizza) {
        if ("Margherita".equals(pizza)) {
            return 2000;
        }
        if ("Pepperoni".equals(pizza)) {
            return 2500;
        }
        return 0;
    }
}
