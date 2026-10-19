package pizzeria;

public class IngredientStorage {
    private int portions = 5;

    public boolean hasIngredients() {
        return portions > 0;
    }

    public void useIngredients() {
        if (hasIngredients()) {
            portions--;
        }
    }
}
