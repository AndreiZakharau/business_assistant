package dao.impl;

import connection.DBConnection;
import dao.DAO;
import entity.Application;
import entity.Shops;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO implements DAO<Application> {

    private static ApplicationDAO instanceAp = new ApplicationDAO();

    public static ApplicationDAO getInstance() {
        return instanceAp;
    }

    private ApplicationDAO(){}

    private static final String SQL_INSERT_APPLICATION ="INSERT INTO Application(product_id,necessary,final_price,shop_id) Value(?,?,?,?)";
    private static final String SQL_DELETE_APPLICATION ="DELETE FROM Application WHERE id = ? OR product_id =?" +
            " OR necessary = ? OR final_price = ? OR shop_id = ?";
    private static final String SQL_APPLICATION_FIN_BY_ID = "SELECT * FROM Application WHERE id = ?";
    private static final String SQL_APPLICATION_ALL ="SELECT * FROM Application";
    private static final String SQL_UPDATE_APPLICATION = "UPDATE Application SET id =? AND SET product_id =?" +
            "AND SET necessary = ? AND SET final_price = ? AND SET shop_id = ? ";


    @Override
    public Application add(Application application) {
        int rows = 0;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_APPLICATION)) {

            preparedStatement.setInt(1, application.getNameProduct().getId());
            preparedStatement.setInt(2, application.getNecessaryQuantities());
            preparedStatement.setDouble(3, application.getFinalPrice().getFinalPrice().getAndPrice());
            preparedStatement.setInt(4, application.getShop().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return application;
    }

    @Override
    public boolean delete(Application application) {
        int rows = 0;
        try (Connection connect = DBConnection.getConnection()) {

            PreparedStatement preparedStatement = connect.prepareStatement(SQL_DELETE_APPLICATION);
            preparedStatement.setInt(1, application.getId());
            preparedStatement.setInt(2,application.getNameProduct().getId());
            preparedStatement.setInt(3, application.getNecessaryQuantities());
            preparedStatement.setDouble(4, application.getFinalPrice().getFinalPrice().getAndPrice());
            preparedStatement.setInt(5,application.getShop().getId());
            rows = preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return rows != 0;
    }

    @Override
    public Application finByID(int id) {
        Application application = null;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_APPLICATION_FIN_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
               int name = resultSet.getInt("product_id");
               int necessary = resultSet.getInt("necessary");
               double price = resultSet.getDouble("final_price");
               int shop = resultSet.getInt("shop_id");
                application = new Application(id, name, necessary,price,shop);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return application;
    }

    @Override
    public List<Application> findAll() {
        List<Application> applicationList = new ArrayList<>();
        try (Connection connect = DBConnection.getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_APPLICATION_ALL);
            while (resultSet.next()) {
                 int id = resultSet.getInt("id");
                int name = resultSet.getInt("product_id");
                int necessary = resultSet.getInt("necessary");
                double price = resultSet.getDouble("final_price");
                int shop = resultSet.getInt("shop_id");
                applicationList.add( new Application(id, name, necessary,price,shop));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return applicationList;
    }

    @Override
    public boolean update(Application application) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_UPDATE_APPLICATION, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, application.getId());
            statement.setInt(2, application.getNameProduct().getId());
            statement.setInt(3, application.getNecessaryQuantities());
            statement.setDouble(4, application.getFinalPrice().getFinalPrice().getAndPrice());
            statement.setInt(5,application.getShop().getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
