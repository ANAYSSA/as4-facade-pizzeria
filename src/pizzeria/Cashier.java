package pizzeria;

public class Cashier {
    public boolean pay(int price, int money) {
        if (price <= 0 || money < price) {
            System.out.println("Payment rejected.");
            return false;
        }
        int change = money - price;
        System.out.println("Payment accepted. Change: " + change + " KZT");
        return true;
    }
}
