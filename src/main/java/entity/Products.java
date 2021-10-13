package entity;


import servise.date.DateDelivery;
import servise.date.DateExpiration;
import servise.price.FinalPrice;

public class Products {
    private int id;
    private String nameProduct;
    private int count;
    private double price;
    private Categories categories;
    private Suppliers suppliers;
    private FinalPrice finalPrice;
    private DateDelivery delivery;
    private DateExpiration dateExpiration;
    private Shops shop;

    public Products(){
    }

    public Products(int id, String nameProduct, int count, double price,
                    Categories categories, Suppliers suppliers, FinalPrice finalPrice,
                    DateDelivery delivery, DateExpiration dateExpiration, Shops shop) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.count = count;
        this.price = price;
        this.categories = categories;
        this.suppliers = suppliers;
        this.finalPrice = finalPrice;
        this.delivery = delivery;
        this.dateExpiration = dateExpiration;
        this.shop = shop;
    }

    public Products(int id, String name, int count, double price, int categories, int supplier, double finalPrise, String dateDelivery, String dateExpiration, int shop) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public FinalPrice getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(FinalPrice finalPrice) {
        this.finalPrice = finalPrice;
    }

    public DateDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(DateDelivery delivery) {
        this.delivery = delivery;
    }

    public DateExpiration getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(DateExpiration dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Shops getShop() {
        return shop;
    }

    public void setShop(Shops shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", categories=" + categories +
                ", suppliers=" + suppliers +
                ", finalPrice=" + finalPrice +
                ", delivery=" + delivery +
                ", dateExpiration=" + dateExpiration +
                ", shop=" + shop +
                '}';
    }
}
