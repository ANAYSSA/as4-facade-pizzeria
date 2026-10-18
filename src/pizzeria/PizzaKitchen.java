package pizzeria;

public class PizzaKitchen {
    private static final int MAX_BATCH_SIZE = 3;
    private static final int BAKING_TEMPERATURE = 250;
    private int temperature;

    public void checkQuantity(int quantity) {
        if (quantity < 1 || quantity > MAX_BATCH_SIZE) {
            throw new IllegalArgumentException("Order from 1 to " + MAX_BATCH_SIZE + " pizzas.");
        }
    }

    public void preheat() {
        temperature = BAKING_TEMPERATURE;
    }

    public String bake(String pizzaName, int quantity) {
        checkQuantity(quantity);
        if (temperature < BAKING_TEMPERATURE) {
            throw new IllegalStateException("Preheat the oven before baking.");
        }
        return quantity + " x " + pizzaName + " baked at " + temperature + " C.";
    }
}
