package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Order {  //TODO Всё переделать что связано с Order
    private int number;
    private int id;
    private String product;
    private int quantum;
    private LocalDate localDate;
//    private LocalTime localTime;
    private double priceFinal;
    private double sum;
    private String nameSalesperson;
    private String nameShop;

    public Order(int number, int id, String product, int quantum, LocalDate localDate, double priceFinal, double sum, String nameSalesperson, String nameShop) {
        this.number = number;
        this.id = id;
        this.product = product;
        this.quantum = quantum;
        this.localDate = localDate;
//        this.localTime = localTime;
        this.priceFinal = priceFinal;
        this.sum = sum;
        this.nameSalesperson = nameSalesperson;
        this.nameShop = nameShop;
    }

    public Order(int number, String product, int quantum, LocalDate localDate, double priceFinal, double sum, String nameSalesperson, String nameShop) {
    }

    public Order() {

    }

    public Order(int number, double sum) {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

//    public LocalTime getLocalTime() {
//        return localTime;
//    }
//
//    public void setLocalTime(LocalTime localTime) {
//        this.localTime = localTime;
//    }

    public double getPriceFinal() {
        return priceFinal;
    }

    public void setPriceFinal(double priceFinal) {
        this.priceFinal = priceFinal;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getNameSalesperson() {
        return nameSalesperson;
    }

    public void setNameSalesperson(String nameSalesperson) {
        this.nameSalesperson = nameSalesperson;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", id=" + id +
                ", product='" + product + '\'' +
                ", quantum=" + quantum +
                ", localDate=" + localDate +
//                ", localTime=" + localTime +
                ", priceFinal=" + priceFinal +
                ", sum=" + sum +
                ", nameSalesperson='" + nameSalesperson + '\'' +
                ", nameShop='" + nameShop + '\'' +
                '}';
    }
}
