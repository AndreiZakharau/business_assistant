package entity;

import jdk.jshell.Snippet;

import java.util.Objects;

public class Shops {
    private long id;
    private String nameShop;
    private String address;

    public Shops(long id, String nameShop, String address) {
        this.id = id;
        this.nameShop = nameShop;
        this.address = address;
    }
    public Shops(){}

    public Shops(String nameShop, String address) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Shops{" +
                "id=" + id +
                ", nameShop='" + nameShop + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shops shops = (Shops) o;
        return id == shops.id && Objects.equals(nameShop, shops.nameShop) && Objects.equals(address, shops.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameShop, address);
    }
}
