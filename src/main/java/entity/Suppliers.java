package entity;

public class Suppliers {
    private int id;
    private String nameSupplier;
    private String contactTel;
    private String email;

    public Suppliers(int id, String nameSupplier, String contactTel, String email) {
        this.id = id;
        this.nameSupplier = nameSupplier;
        this.contactTel = contactTel;
        this.email = email;
    }

    public Suppliers() {
    }

    public Suppliers(int id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
