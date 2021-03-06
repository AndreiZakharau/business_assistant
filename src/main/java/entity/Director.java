package entity;

import java.util.Objects;

public class Director {
    private long id;
    private String login;
    private String password;

    public Director(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Director() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return id == director.id && Objects.equals(login, director.login) && Objects.equals(password, director.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }


}
