package entity;

public class Application {  //TODO finalPrice?

    private int id;
    private Products name;
    private int necessaryQuantities;
    private Shops shop;


    public Application(int id, Products name, int necessaryQuantities, Shops shop) {
        this.id = id;
        this.name = name;
        this.necessaryQuantities = necessaryQuantities;;
        this.shop = shop;

    }

    public Application(int id, int name, int necessary, int shop) {

    }

    public Application(int id, int name, int balance) {
    }

    public Application() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Products getName() {
        return name;
    }

    public void setName(Products name) {
        this.name = name;
    }

    public int getNecessaryQuantities() {
        return necessaryQuantities;
    }

    public void setNecessaryQuantities(int necessaryQuantities) {
        this.necessaryQuantities = necessaryQuantities;
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
                ", nameProduct=" + name +
                ", necessaryQuantities=" + necessaryQuantities +
                ", shop=" + shop + '}';
    }
}
