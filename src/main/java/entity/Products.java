package entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Products {
    private int id;
    private String name;
    private int count;
    private double price;
    private int categories;
    private int suppliers;
    private LocalDate localDate;
    private Date date;
    private int shop;

    public Products(int id, String name, int count, double price, int categories, int suppliers, LocalDate localDate, Date date, int shop) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.categories = categories;
        this.suppliers = suppliers;
        this.localDate = localDate;
        this.date = date;
        this.shop = shop;
    }

    public Products(int id, String name, int count, double price, int categories, int supplier, String localDate, String date, int shop) {
    }


    public Products() {

    }

    public Products(int id) {
    }

    public Products(String name, int count, double price, int categories, int suppliers, LocalDate localDate, java.sql.Date date, int shops) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCategories() {
        return categories;
    }

    public void setCategories(int categories) {
        this.categories = categories;
    }

    public int getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(int suppliers) {
        this.suppliers = suppliers;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getShop() {
        return shop;
    }

    public void setShop(int shop) {
        this.shop = shop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id && count == products.count && Double.compare(products.price, price) == 0 && categories == products.categories && suppliers == products.suppliers && shop == products.shop && Objects.equals(name, products.name) && Objects.equals(localDate, products.localDate) && Objects.equals(date, products.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, count, price, categories, suppliers, localDate, date, shop);
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", categories=" + categories +
                ", suppliers=" + suppliers +
                ", localDate=" + localDate +
                ", date=" + date +
                ", shop=" + shop +
                '}';
    }
}
