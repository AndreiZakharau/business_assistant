package entity;

import java.time.LocalDate;
import java.util.Objects;

public class ExpiredProduct {
    private long id;
    private long nameProductExpired;
    private int balance;
    private double purchasePrice;
    private LocalDate localDate;

    public ExpiredProduct() {
    }

    public ExpiredProduct(long id, long nameProductExpired, int balance, double purchasePrice, LocalDate localDate) {
        this.id = id;
        this.nameProductExpired = nameProductExpired;
        this.balance = balance;
        this.purchasePrice = purchasePrice;
        this.localDate = localDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNameProductExpired() {
        return nameProductExpired;
    }

    public void setNameProductExpired(long nameProductExpired) {
        this.nameProductExpired = nameProductExpired;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpiredProduct that = (ExpiredProduct) o;
        return id == that.id && balance == that.balance && Double.compare(that.purchasePrice, purchasePrice) == 0 && Objects.equals(nameProductExpired, that.nameProductExpired) && Objects.equals(localDate, that.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProductExpired, balance, purchasePrice, localDate);
    }

    @Override
    public String toString() {
        return "ExpiredProduct{" +
                "id=" + id +
                ", nameProductExpired=" + nameProductExpired +
                ", balance=" + balance +
                ", purchasePrice=" + purchasePrice +
                ", localDate=" + localDate +
                '}';
    }
}
