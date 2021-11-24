package servise.price;


public class FinalPrice {
    private static double andPrice = Price.getPrice() + Percentage.getInterests();

    private static FinalPrice instance = new FinalPrice();
    public static FinalPrice getInstance(){return instance;}

    public FinalPrice() {
    }

    public static double getAndPrice() {
        return andPrice;
    }

    public static void setAndPrice(double andPrice) {
        FinalPrice.andPrice = andPrice;
    }
}
