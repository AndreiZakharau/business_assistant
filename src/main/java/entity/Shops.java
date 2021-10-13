package entity;

public class Shops {
    private int id;
    private String nameShop;
    private String address;

    public Shops(int id, String nameShop, String address) {
        this.id = id;
        this.nameShop = nameShop;
        this.address = address;
    }
    public Shops(){}

    public Shops(String nameShop, String address) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
