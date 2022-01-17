package entity;

import java.util.Objects;

public class Suppliers {
    private long id;
    private String nameSupplier;
    private String contactTel;
    private String email;

    public Suppliers(long id, String nameSupplier, String contactTel, String email) {
        this.id = id;
        this.nameSupplier = nameSupplier;
        this.contactTel = contactTel;
        this.email = email;
    }

    public Suppliers() {
    }

    public Suppliers(int id) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "id=" + id +
                ", nameSupplier='" + nameSupplier + '\'' +
                ", contactTel='" + contactTel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suppliers suppliers = (Suppliers) o;
        return id == suppliers.id && Objects.equals(nameSupplier, suppliers.nameSupplier) && Objects.equals(contactTel, suppliers.contactTel) && Objects.equals(email, suppliers.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSupplier, contactTel, email);
    }
}
