package pizzeria;

import java.util.HashMap;
import java.util.Map;

public class IngredientStorage {
    private final Map<String, Integer> stock = new HashMap<>();

    public IngredientStorage() {
        stock.put("dough", 5);
        stock.put("tomato sauce", 5);
        stock.put("cheese", 5);
        stock.put("pepperoni", 3);
    }

    public void checkAvailability(Map<String, Integer> recipe, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        for (Map.Entry<String, Integer> ingredient : recipe.entrySet()) {
            int portions = ingredient.getValue();
            if (portions <= 0) {
                throw new IllegalArgumentException("Ingredient portions must be positive.");
            }
            long needed = (long) portions * quantity;
            if (stock.getOrDefault(ingredient.getKey(), 0) < needed) {
                throw new IllegalStateException("Not enough " + ingredient.getKey() + ".");
            }
        }
    }

    public void useIngredients(Map<String, Integer> recipe, int quantity) {
        checkAvailability(recipe, quantity);
        for (Map.Entry<String, Integer> ingredient : recipe.entrySet()) {
            String name = ingredient.getKey();
            stock.put(name, stock.get(name) - ingredient.getValue() * quantity);
        }
    }
}
