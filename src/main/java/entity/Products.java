package entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Products {
    private long id;
    private String name;
    private int count;
    private double price;
    private long categories;
    private long suppliers;
    private LocalDate localDate;
    private Date date;
    private long shop;

    public Products(long id, String name, int count, double price, long categories, long suppliers, LocalDate localDate, Date date, long shop) {
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


    public Products() {

    }

    public Products(long id, String name, int count, double price, long categories, long supplier, String localDate, String date, long shop) {
    }

    public Products(String name, int count, double price, long categories, long suppliers, LocalDate localDate, java.sql.Date date, long shops) {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getCategories() {
        return categories;
    }

    public void setCategories(long categories) {
        this.categories = categories;
    }

    public long getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(long suppliers) {
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

    public long getShop() {
        return shop;
    }

    public void setShop(long shop) {
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
