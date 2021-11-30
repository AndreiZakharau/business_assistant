package dao.impl;

import connection.ConnectionPool;
import dao.DAO;
import entity.Application;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO implements DAO<Application> {  //TODO finalPrice?

    private static ApplicationDAO instanceAp = new ApplicationDAO();

    public static ApplicationDAO getInstance() {
        return instanceAp;
    }


    private ApplicationDAO() {
    }

    private static final String SQL_INSERT_APPLICATION = "INSERT INTO Application(product_id,necessary,shop_id) Value(?,?,?)";
    private static final String SQL_DELETE_APPLICATION = "DELETE FROM Application WHERE id = ? OR product_id =? OR necessary = ?  OR shop_id = ?";
    private static final String SQL_APPLICATION_FIN_BY_ID = "SELECT * FROM Application WHERE id = ?";
    private static final String SQL_APPLICATION_ALL = "SELECT * FROM Application";
    private static final String SQL_UPDATE_APPLICATION = "UPDATE Application SET id =?, product_id =?, necessary = ?, shop_id = ? WHERE id = ?";


    @Override
    public Application add(Application application) {

        try (Connection conn = ConnectionPool.get();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_APPLICATION)) {

            preparedStatement.setLong(1, application.getName().getId());
            preparedStatement.setInt(2, application.getNecessaryQuantities());
            preparedStatement.setLong(3, application.getShop().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return application;
    }

    @Override
    public boolean delete(Application application) {
        int rows = 0;
        try (Connection connect = ConnectionPool.get()) {

            PreparedStatement preparedStatement = connect.prepareStatement(SQL_DELETE_APPLICATION);
            preparedStatement.setLong(1, application.getId());
            preparedStatement.setLong(2, application.getName().getId());
            preparedStatement.setInt(3, application.getNecessaryQuantities());
            preparedStatement.setLong(4, application.getShop().getId());
            rows = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows != 0;
    }

    @Override
    public Application finByID(long id) {
        Application application = null;
        try (Connection conn = ConnectionPool.get()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_APPLICATION_FIN_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
                long name = resultSet.getLong("product_id");
                int necessary = resultSet.getInt("necessary");
                long shop = resultSet.getLong("shop_id");
                application = new Application(id, name, necessary, shop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return application;
    }

    @Override
    public List<Application> findAll() {
        List<Application> applicationList = new ArrayList<>();
        try (Connection connect = ConnectionPool.get()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_APPLICATION_ALL);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long name = resultSet.getLong("product_id");
                int necessary = resultSet.getInt("necessary");
                long shop = resultSet.getLong("shop_id");
                applicationList.add(new Application(id, name, necessary, shop));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return applicationList;
    }

    @Override
    public boolean update(Application application) {
        try (Connection conn = ConnectionPool.get();
             PreparedStatement statement = conn.prepareStatement(SQL_UPDATE_APPLICATION, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, application.getId());
            statement.setLong(2, application.getName().getId());
            statement.setInt(3, application.getNecessaryQuantities());
            statement.setLong(4, application.getShop().getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public Application finByName(String name) {
        Application application = new Application();
//        try (Connection connection = ConnectionPool.get()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_APPLICATION_FIN_BY_NAME);
//            preparedStatement.setString(1, name);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                Products names = resultSet.getString("name");
//                application.setId(id);
//                application.setName(names);
//
//            }
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }
        return application;
    }
}

