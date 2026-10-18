package pizzeria;

import java.util.LinkedHashMap;
import java.util.Map;

public class PizzaMenu {
    private final Map<String, Integer> prices = new LinkedHashMap<>();

    public PizzaMenu() {
        prices.put("Margherita", 2000);
        prices.put("Pepperoni", 2500);
    }

    public int getPrice(String pizzaName) {
        Integer price = prices.get(pizzaName);
        if (price == null) {
            throw new IllegalArgumentException("Pizza is not on the menu: " + pizzaName);
        }
        return price;
    }

    public Map<String, Integer> getRecipe(String pizzaName) {
        getPrice(pizzaName);
        Map<String, Integer> recipe = new LinkedHashMap<>();
        recipe.put("dough", 1);
        recipe.put("tomato sauce", 1);
        recipe.put("cheese", 1);
        if (pizzaName.equals("Pepperoni")) {
            recipe.put("pepperoni", 1);
        }
        return recipe;
    }

    public String getMenu() {
        StringBuilder menu = new StringBuilder("Pizza menu:\n");
        for (Map.Entry<String, Integer> item : prices.entrySet()) {
            menu.append(item.getKey()).append(" - ")
                    .append(item.getValue()).append(" KZT\n");
        }
        return menu.toString();
    }
}
