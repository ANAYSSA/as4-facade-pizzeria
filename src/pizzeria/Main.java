package pizzeria;

public class Main {
    public static void main(String[] args) {
        OrderFacade order = new OrderFacade();
        order.executeOrder("Pepperoni", 3000);
    }
}
