package dao.impl;


import connection.ConnectionPool;
import dao.DAO;
import entity.Person;
import entity.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements DAO<Person> {

    private static PersonDAO instance = new PersonDAO();

    public static PersonDAO getInstance() {
        return instance;
    }

    public PersonDAO() {
    }


    private static final String SQL_PERSON_BY_DELETE = "DELETE FROM Persons WHERE  id = ? OR name = ? OR lastName = ? OR telephoneNumber = ? ";
    private static final String UPDATE_PERSON = "UPDATE Persons set id = ?, name = ?, lastName  = ?, telephoneNumber = ?, role_role = ?, id_shop = ? WHERE id = ?";
    private static final String SQL_INSERT_PERSONS = "INSERT INTO Persons(name,lastName,telephoneNumber,role_role,id_shop) VALUES (?,?,?,?,?)";
    private static final String SQL_PERSONS_FIN_BY_ID = "SELECT * FROM Persons WHERE id = ?";
    private static final String SQL_PERSONS_ALL_LIST = "SELECT * FROM Persons";
    private static final String SQL_PERSONS_FIN_BY_NAME_AND_PHONE = "SELECT * FROM Persons WHERE name = ? AND lastName = ? AND telephoneNumber = ?";
    private static final String SQL_PERSONS_FIN_BY_NAME = "SELECT * FROM Persons WHERE name = ?";

    @Override
    public boolean delete(Person person) {
        int rows = 0;
        try (Connection connect = ConnectionPool.get()) {
            PreparedStatement preparedStatement = connect.prepareStatement(SQL_PERSON_BY_DELETE);
            preparedStatement.setLong(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getTelephoneNumber());
            rows = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows != 0;
    }


    @Override
    public Person finByID(long id) {
        Person person = null;
        try (Connection conn = ConnectionPool.get()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_PERSONS_FIN_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                String telephone = resultSet.getString("telephoneNumber");
                Role role = Role.valueOf(resultSet.getString("role_role"));
                long shop = resultSet.getLong("id_shop");
                person = new Person(id, name, lastName, telephone, role, shop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        try (Connection connect = ConnectionPool.get()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_PERSONS_ALL_LIST);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                String telephone = resultSet.getString("telephoneNumber");
                Role role = Role.valueOf(resultSet.getString("role_role"));
                long shop = resultSet.getLong("id_shop");

                people.add(new Person(id, name, lastName, telephone, role, shop));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

    @Override
    public boolean update(Person person) {
        try (Connection conn = ConnectionPool.get();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_PERSON, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getTelephoneNumber());
            preparedStatement.setString(5, person.getRole().name());
            preparedStatement.setLong(6, person.getShop());
            preparedStatement.setLong(7, person.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public Person add(Person person) {


        try (Connection conn = ConnectionPool.get();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_PERSONS)) {

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getTelephoneNumber());
            preparedStatement.setString(4, person.getRole().name());
            preparedStatement.setLong(5, person.getShop());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;

    }

    public Person findByNamesAndPhone(String name, String lastName, String tel) {
        Person person = new Person();
        try (Connection conn = ConnectionPool.get()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_PERSONS_FIN_BY_NAME_AND_PHONE);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, tel);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long indef = resultSet.getLong("id");
                String name1 = resultSet.getString("name");
                String lastN = resultSet.getString("lastName");
                String telephone = resultSet.getString("telephoneNumber");
                Role roles = Role.valueOf(resultSet.getString("role_role"));
                long shop = resultSet.getLong("id_shop");
                person = new Person(indef, name1, lastN, telephone, roles, shop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person finByName(String name) {
        Person person = new Person();
        try (Connection conn = ConnectionPool.get()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_PERSONS_FIN_BY_NAME);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long indef = resultSet.getLong("id");
                String name1 = resultSet.getString("name");
                String lastN = resultSet.getString("lastName");
                String telephone = resultSet.getString("telephoneNumber");
                Role roles = Role.valueOf(resultSet.getString("role_role"));
                long shop = resultSet.getLong("id_shop");
                person = new Person(indef, name1, lastN, telephone, roles, shop);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return person;
    }
}
