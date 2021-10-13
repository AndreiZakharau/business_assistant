package servise.price;



public class Price {
    private static double price;


    public Price(double price) {
        this.price = price;
    }

    public static double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

