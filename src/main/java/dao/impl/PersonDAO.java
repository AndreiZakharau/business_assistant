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

    private static PersonDAO instance = new PersonDAO();

    public static PersonDAO getInstance() {
        return instance;
    }

    public PersonDAO(){}


    private static final String SQL_PERSON_BY_DELETE = "DELETE FROM Persons WHERE  id = ? OR name = ? OR lastName = ? OR telephoneNumber = ? ";
    private static final String UPDATE_PERSON = "UPDATE Persons set id = ?, name = ?, lastName  = ?, telephoneNumber = ?, role_role = ? WHERE id = ?";
    private static final String SQL_INSERT_PERSONS = "INSERT INTO Persons(name,lastName,telephoneNumber,role_role) VALUES (?,?,?,?)";
    private static final String SQL_PERSONS_FIN_BY_ID = "SELECT * FROM Persons WHERE id = ?";
    private static final String SQL_PERSONS_ALL_LIST = "SELECT * FROM Persons";
    private static final String SQL_PERSONS_FIN_BY_ALL_PARAMETERS = "SELECT * FROM Persons WHERE name = ? AND lastName = ? AND telephoneNumber = ?";

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
                Role role = Role.valueOf(resultSet.getString("role_role"));
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
                Role role = Role.valueOf(resultSet.getString("role_role"));

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
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_PERSON, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getTelephoneNumber());
            preparedStatement.setString(5, person.getRole().name());
            preparedStatement.setInt(6,person.getId());
            preparedStatement.executeUpdate();

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
//            System.out.println("Person создан");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;

    }

    public Person findByAllParameters(String name, String lastName, String tel){
        Person person = new Person();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_PERSONS_FIN_BY_ALL_PARAMETERS);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,tel);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int indef = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String lastN = resultSet.getString("lastName");
                String telephone = resultSet.getString("telephoneNumber");
                Role roles = Role.valueOf(resultSet.getString("role_role"));
                person.setId(indef);
                person.setName(name1);
                person.setLastName(lastN);
                person.setTelephoneNumber(telephone);
                person.setRole(roles);
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }
}
