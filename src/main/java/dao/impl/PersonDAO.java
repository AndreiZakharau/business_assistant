package dao.impl;

import connection.DBConnection;
import dao.DAO;
import entity.Person;
import entity.Role;
import entity.Shops;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements DAO<Person> {

    private static PersonDAO instancePers = new PersonDAO();

    public static PersonDAO getInstance() {
        return instancePers;
    }

    private PersonDAO(){}


    private static final String SQL_PERSON_BY_DELETE = "DELETE FROM Persons WHERE  id = ? OR name = ? OR lastName = ? OR telephoneNumber = ? ";
    private static final String UPDATE_PERSON = "UPDATE Persons set id = ? AND set name = ? AND set lastName  = ? AND set telephoneNumber = ? AND set role = ?";
    private static final String SQL_INSERT_PERSONS = "INSERT INTO Persons(name,lastName,telephoneNumber) VALUES (?,?,?)";
    private static final String SQL_PERSONS_FIN_BY_ID = "SELECT * FROM Persons WHERE id = ?";
    private static final String SQL_PERSONS_ALL_LIST = "SELECT * FROM Persons";

    @Override
    public boolean delete(Person person) {
        int rows = 0;
        try (Connection connect = DBConnection.getConnection()) {

            PreparedStatement preparedStatement = connect.prepareStatement(SQL_PERSON_BY_DELETE);
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getTelephoneNumber());
            rows = preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return rows != 0;
    }

    @Override
    public Person finByID(int id) {
        Person person = null;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_PERSONS_FIN_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                String telephone = resultSet.getString("telephoneNumber");
                Role role = Role.valueOf(resultSet.getString("role"));
                person = new Person(id, name, lastName, telephone, role);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        try (Connection connect = DBConnection.getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_PERSONS_ALL_LIST);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                String telephone = resultSet.getString("telephoneNumber");
                Role role = Role.valueOf(resultSet.getString("role"));

                people.add(new Person(id, name, lastName, telephone, role));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

    @Override
    public boolean update(Person person) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE_PERSON, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, person.getId());
            statement.setString(2, person.getName());
            statement.setString(3, person.getLastName());
            statement.setString(4, person.getTelephoneNumber());
            statement.setString(5, person.getRole().name());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Person add(Person person) {


        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_PERSONS)) {

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getTelephoneNumber());
            preparedStatement.setString(4, person.getRole().name());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;

    }
}
