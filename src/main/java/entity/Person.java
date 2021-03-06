package entity;

import java.util.Objects;

public class Person {
    private long id;
    private String name;
    private String lastName;
    private String telephoneNumber;
    private Role role;
    private long shop;

    public Person() {
    }

    public Person(long id, String name, String lastName, String telephoneNumber, Role role, long shop) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.role = role;
        this.shop = shop;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        Person person = (Person) o;
        return id == person.id && shop == person.shop && Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName) && Objects.equals(telephoneNumber, person.telephoneNumber) && role == person.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, telephoneNumber, role, shop);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", role=" + role +
                ", shop=" + shop +
                '}';
    }
}
