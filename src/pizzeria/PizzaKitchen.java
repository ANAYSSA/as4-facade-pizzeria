package pizzeria;

public class PizzaKitchen {
    private boolean ovenReady;

    public void preheat() {
        ovenReady = true;
        System.out.println("Heating the oven.");
    }

    public void bake(String pizza) {
        if (!ovenReady) {
            System.out.println("Heat the oven first.");
            return;
        }
        System.out.println("Baking " + pizza + " pizza.");
        ovenReady = false;
    }
}
