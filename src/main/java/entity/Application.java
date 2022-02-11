package entity;

import java.util.Objects;

public class Application {  //TODO finalPrice?

    private long id;
    private Products name;
    private int necessaryQuantities;
    private Shops shop;


    public Application(long id, Products name, int necessaryQuantities, Shops shop) {
        this.id = id;
        this.name = name;
        this.necessaryQuantities = necessaryQuantities;
        ;
        this.shop = shop;

    }

    public Application(long id, long name, int necessary, long shop) {

    }

    public Application(long id, long name, long balance) {
    }

    public Application() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return id == that.id && necessaryQuantities == that.necessaryQuantities && Objects.equals(name, that.name) && Objects.equals(shop, that.shop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, necessaryQuantities, shop);
    }
}
