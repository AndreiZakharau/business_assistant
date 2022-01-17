package dao.impl;

import connection.ConnectionPool;
import dao.DAO;
import entity.ExpiredProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpiredProductDAO implements DAO<ExpiredProduct> {// Переделать как и сущьность и таблицу

    private static ExpiredProductDAO instance = new ExpiredProductDAO();


    public static ExpiredProductDAO getInstance() {
        return instance;
    }

    private ExpiredProductDAO(){}
    private static final String SQL_INSERT_OVERDUE ="INSERT INTO Expiredproduct(name_overdue,balance,price) Value(?,?,?)";
    private static final String SQL_DELETE_OVERDUE ="DELETE FROM Expiredproduct WHERE id = ? OR name_overdue =? OR balance = ? OR price = ?";
    private static final String SQL_OVERDUE_FIN_BY_ID = "SELECT * FROM Expiredproduct WHERE id = ?";
    private static final String SQL_OVERDUE_ALL ="SELECT * FROM Expiredproduct";
    private static final String SQL_UPDATE_OVERDUE = "UPDATE Expiredproduct SET id =?, name_overdue =?, balance = ?, price = ? WHERE id = ?";


    @Override
    public ExpiredProduct add(ExpiredProduct expiredProduct) {

        try (Connection conn = ConnectionPool.get();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_OVERDUE)) {

            preparedStatement.setLong(1, expiredProduct.getNameProductExpired().getId());
            preparedStatement.setInt(2, expiredProduct.getBalance().getCount());
            preparedStatement.setDouble(3, expiredProduct.getPurchasePrice().getPrice());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return expiredProduct;
    }

    @Override
    public boolean delete(ExpiredProduct expiredProduct) {
        int rows = 0;
        try (Connection connect = ConnectionPool.get()) {

            PreparedStatement preparedStatement = connect.prepareStatement(SQL_DELETE_OVERDUE);
            preparedStatement.setLong(1, expiredProduct.getId());
            preparedStatement.setLong(2, expiredProduct.getNameProductExpired().getId());
            preparedStatement.setInt(3, expiredProduct.getBalance().getCount());
            preparedStatement.setDouble(4, expiredProduct.getPurchasePrice().getPrice());
            rows = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows != 0;
    }

    @Override
    public ExpiredProduct finByID(long id) {
        ExpiredProduct overdue= null;
        try (Connection conn = ConnectionPool.get()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_OVERDUE_FIN_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
                long name = resultSet.getLong("name_overdue");
                int balance = resultSet.getInt("balance");
                double price = resultSet.getDouble("price");
                overdue= new ExpiredProduct(id, name, balance,price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return overdue;
    }

    @Override
    public List<ExpiredProduct> findAll() {
        List<ExpiredProduct> overdueList = new ArrayList<>();
        try (Connection connect = ConnectionPool.get()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_OVERDUE_ALL);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long name = resultSet.getLong("name_overdue");
                int balance = resultSet.getInt("balance");
                double price = resultSet.getDouble("price");
                overdueList.add( new ExpiredProduct(id, name, balance,price));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return overdueList;
    }

    @Override
    public boolean update(ExpiredProduct expiredProduct) {
        try (Connection conn = ConnectionPool.get();
             PreparedStatement statement = conn.prepareStatement(SQL_UPDATE_OVERDUE, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, expiredProduct.getId());
            statement.setLong(2, expiredProduct.getNameProductExpired().getId());
            statement.setInt(3, expiredProduct.getBalance().getCount());
            statement.setDouble(4, expiredProduct.getPurchasePrice().getPrice());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public ExpiredProduct finByName(String t) {
        return null;
    }
}
