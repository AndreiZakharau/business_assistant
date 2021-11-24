package servise.price;

public class Percentage extends Price {
    private static final int rate = 15;
    private static final double interests = ((getPrice() * rate) / 100);

    public Percentage(double price) {
        super(price);
    }

    public static int getRate() {
        return rate;
    }

    public static double getInterests() {
        return interests;
    }

}
