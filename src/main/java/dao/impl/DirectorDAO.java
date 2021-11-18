package dao.impl;

import connection.DBConnection;
import dao.DAO;
import entity.Director;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAO implements DAO<Director> {

    private static DirectorDAO instance = new DirectorDAO();
    public static DirectorDAO getInstance() {return instance;}
    DirectorDAO(){}

    private static final String SQL_INSERT_DIRECTOR = "INSERT INTO Director(login,password) VALUES (?,?)";



    private static final String SQL_DIRECTOR_LIST = "SELECT * FROM Director";
    private static final String UPDATE_DIRECTOR = "UPDATE Director SET id = ?, login = ?, password = ? where id = ?";
    private static final String SQL_DIRECTOR_BY_LOGIN_AND_PASSWORD = "SELECT * FROM Director WHERE login = ? AND password = ?";


    @Override
    public Director add(Director director) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_DIRECTOR)) {
            preparedStatement.setString(1, director.getLogin());
            preparedStatement.setString(2, director.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return director;
    }

    @Override
    public boolean delete(Director director) {
        return false;
    }

    @Override
    public Director finByID(int id) {
        return null;
    }

    @Override
    public List<Director> findAll() {
        List<Director> list = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DIRECTOR_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                list.add(new Director(id,login,password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(Director director) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE_DIRECTOR, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1,director.getId());
            statement.setString(2, director.getLogin());
            statement.setString(3, director.getPassword());
            statement.setInt(4,director.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Director finDirectorByLoginAndPassword(String login,String password) {
        Director director = new Director();
        try(Connection connection = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DIRECTOR_BY_LOGIN_AND_PASSWORD);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login1 = resultSet.getString("login");
                String password1 = resultSet.getString("password");
                director.setId(id);
                director.setLogin(login1);
                director.setPassword(password1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return director;
    }

    @Override
    public Director finByName(String t) {
        return null;
    }
}
