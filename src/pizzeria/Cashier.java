package pizzeria;

public class Cashier {
    private int revenue;

    public void checkPayment(int total, int paidAmount) {
        if (total <= 0) {
            throw new IllegalArgumentException("Total must be positive.");
        }
        if (paidAmount < total) {
            throw new IllegalArgumentException("Not enough money. Required: " + total + " KZT.");
        }
    }

    public int acceptPayment(int total, int paidAmount) {
        checkPayment(total, paidAmount);
        revenue += total;
        return paidAmount - total;
    }

    public int getRevenue() {
        return revenue;
    }
}
