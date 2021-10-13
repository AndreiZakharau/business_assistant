package entity;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private String telephoneNumber;
    private Role role;

    public Person(int id, String name, String lastName, String telephoneNumber, Role role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.role = role;
    }

    public Person(int id, int name, int necessary, double price, int shop) {
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", role=" + role +
                '}';
    }
}
