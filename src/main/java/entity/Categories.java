package entity;

import java.util.Objects;

public class Categories {
    private int id;
    private String category;
    private double interest;

    public Categories(){}

    public Categories(int id, String category, double interest) {
        this.id = id;
        this.category = category;
        this.interest = interest;
    }

    public Categories(int id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", interest=" + interest +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return id == that.id && Double.compare(that.interest, interest) == 0 && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, interest);
    }
}
