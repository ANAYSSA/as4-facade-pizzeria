package pizzeria;

import java.util.Map;

public class PizzeriaFacade {
    private final PizzaMenu menu = new PizzaMenu();
    private final IngredientStorage storage = new IngredientStorage();
    private final PizzaKitchen kitchen = new PizzaKitchen();
    private final Cashier cashier = new Cashier();

    public String getMenu() {
        return menu.getMenu();
    }

    public String orderPizza(String pizzaName, int quantity, int paidAmount) {
        kitchen.checkQuantity(quantity);
        int total = menu.getPrice(pizzaName) * quantity;
        Map<String, Integer> recipe = menu.getRecipe(pizzaName);

        // Check the order before taking ingredients or accepting payment.
        storage.checkAvailability(recipe, quantity);
        cashier.checkPayment(total, paidAmount);

        kitchen.preheat();
        storage.useIngredients(recipe, quantity);
        int change = cashier.acceptPayment(total, paidAmount);
        String result = kitchen.bake(pizzaName, quantity);

        return result + "\nTotal: " + total + " KZT. Change: " + change + " KZT.";
    }
}
