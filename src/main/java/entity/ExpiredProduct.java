package entity;

public class ExpiredProduct {  // Переделать сущьность и dao и таблицу
    private int id;
    private Products nameProductExpired;
    private Products balance;
    private Products purchasePrice;

    public ExpiredProduct(int id, Products nameProductExpired, Products balance, Products purchasePrice) {
        this.id = id;
        this.nameProductExpired = nameProductExpired;
        this.balance = balance;
        this.purchasePrice = purchasePrice;
    }

    public ExpiredProduct(int id, int name, int balance, double price) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
