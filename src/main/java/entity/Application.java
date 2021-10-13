package entity;

public class Application {

    private int id;
    private Products nameProduct;
    private int necessaryQuantities;
    private Products finalPrice;
    private Shops shop;


    public Application(int id, Products nameProduct, int necessaryQuantities, Products finalPrice, Shops shop) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.necessaryQuantities = necessaryQuantities;
        this.finalPrice = finalPrice;
        this.shop = shop;

    }

    public Application(int id, int name, int necessary, double price, int shop) {

    }

    public Application(int id, int name, int balance, double price) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Products getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(Products nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getNecessaryQuantities() {
        return necessaryQuantities;
    }

    public void setNecessaryQuantities(int necessaryQuantities) {
        this.necessaryQuantities = necessaryQuantities;
    }

    public Products getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Products finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Shops getShop() {
        return shop;
    }

    public void setShop(Shops shop) {
        this.shop = shop;
    }



    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", nameProduct=" + nameProduct +
                ", necessaryQuantities=" + necessaryQuantities +
                ", finalPrice=" + finalPrice +
                ", shop=" + shop + '}';
    }
}
