package pizzeria;

public class Main {
    public static void main(String[] args) {
        PizzeriaFacade pizzeria = new PizzeriaFacade();
        System.out.println(pizzeria.getMenu());

        placeOrder(pizzeria, "Margherita", 2, 5000);
        placeOrder(pizzeria, "Pepperoni", 1, 3000);
        placeOrder(pizzeria, "Margherita", 1, 1000);
        placeOrder(pizzeria, "Margherita", 3, 6000);
    }

    private static void placeOrder(PizzeriaFacade pizzeria, String pizzaName,
                                   int quantity, int paidAmount) {
        System.out.println("Order: " + quantity + " x " + pizzaName);
        try {
            System.out.println(pizzeria.orderPizza(pizzaName, quantity, paidAmount));
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Order rejected: " + e.getMessage());
        }
        System.out.println();
    }
}
