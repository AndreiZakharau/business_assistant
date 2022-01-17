package entity;

import java.util.Objects;

public class ExpiredProduct {  // Переделать сущьность и dao и таблицу
    private long id;
    private Products nameProductExpired;
    private Products balance;
    private Products purchasePrice;

    public ExpiredProduct(int id, Products nameProductExpired, Products balance, Products purchasePrice) {
        this.id = id;
        this.nameProductExpired = nameProductExpired;
        this.balance = balance;
        this.purchasePrice = purchasePrice;
    }

    public ExpiredProduct(long id, long name, int balance, double price) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Products getNameProductExpired() {
        return nameProductExpired;
    }

    public void setNameProductExpired(Products nameProductExpired) {
        this.nameProductExpired = nameProductExpired;
    }

    public Products getBalance() {
        return balance;
    }

    public void setBalance(Products balance) {
        this.balance = balance;
    }

    public Products getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Products purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Override
    public String toString() {
        return "ExpiredProduct{" +
                "id=" + id +
                ", nameProductExpired=" + nameProductExpired +
                ", balance=" + balance +
                ", purchasePrice=" + purchasePrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpiredProduct that = (ExpiredProduct) o;
        return id == that.id && Objects.equals(nameProductExpired, that.nameProductExpired) && Objects.equals(balance, that.balance) && Objects.equals(purchasePrice, that.purchasePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProductExpired, balance, purchasePrice);
    }
}
