package servise.price;


public class FinalPrice {
    private static double andPrice = Price.getPrice() + Percentage.getInterests();

    public FinalPrice() {
    }

    public static double getAndPrice() {
        return andPrice;
    }

    public static void setAndPrice(double andPrice) {
        FinalPrice.andPrice = andPrice;
    }
}
