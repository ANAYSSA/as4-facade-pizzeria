package pizzeria;

public class OrderFacade {
    private PizzaMenu menu = new PizzaMenu();
    private IngredientStorage storage = new IngredientStorage();
    private Cashier cashier = new Cashier();
    private PizzaKitchen kitchen = new PizzaKitchen();

    public void executeOrder(String pizza, int money) {
        int price = menu.getPrice(pizza);
        if (price == 0) {
            System.out.println("This pizza is not on the menu.");
            return;
        }
        if (!storage.hasIngredients()) {
            System.out.println("Not enough ingredients.");
            return;
        }
        if (!cashier.pay(price, money)) {
            return;
        }
        storage.useIngredients();
        kitchen.preheat();
        kitchen.bake(pizza);
        System.out.println("Order is ready!");
    }
}
