package dao.impl;

import connection.ConnectionPool;
import dao.DAO;
import entity.Shops;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO implements DAO<Shops> {


    private static ShopDAO instance = new ShopDAO();

    public static ShopDAO getInstance() {
        return instance;
    }

    ShopDAO() {
    }


    private static final String SQL_INSERT_SHOP = "INSERT INTO Shops(nameShop,address) VALUES (?,?)";
    private static final String SQL_SHOP_BY_DELETE = "DELETE FROM Shops WHERE id = ? OR nameShop = ? OR address = ?";
    private static final String SQL_SHOP_FIN_BY_ID = "SELECT * FROM Shops WHERE id = ?";
    private static final String SQL_SHOP_ALL_LIST = "SELECT * FROM Shops ";
    private static final String UPDATE_SHOP = " UPDATE Shops SET id = ?, nameShop = ?, address = ? where id = ?";
    private static final String SQL_SHOP_FIN_BY_NAME = "SELECT * FROM Shops WHERE name = ?";

    @Override
    public Shops add(Shops shops) {

        try (Connection conn = ConnectionPool.get();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_SHOP)) {

            preparedStatement.setString(1, shops.getNameShop());
            preparedStatement.setString(2, shops.getAddress());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shops;
    }

    @Override
    public boolean delete(Shops shops) {
        int rows = 0;
        try (Connection connect = ConnectionPool.get()) {

            PreparedStatement preparedStatement = connect.prepareStatement(SQL_SHOP_BY_DELETE);
            preparedStatement.setLong(1, shops.getId());
            preparedStatement.setString(2, shops.getNameShop());
            preparedStatement.setString(3, shops.getAddress());


            rows = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows != 0;
    }

    @Override
    public Shops finByID(long id) {
        Shops shops = null;
        try (Connection conn = ConnectionPool.get()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SHOP_FIN_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String name = resultSet.getString("nameShop");
                String address = resultSet.getString("address");
                shops = new Shops(id, name, address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    @Override
    public List<Shops> findAll() {
        List<Shops> shops = new ArrayList<>();
        try (Connection connect = ConnectionPool.get()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SHOP_ALL_LIST);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nameShop = resultSet.getString("nameShop");
                String address = resultSet.getString("address");

                shops.add(new Shops(id, nameShop, address));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return shops;
    }

    @Override
    public boolean update(Shops shops) {
        try (Connection conn = ConnectionPool.get();
             PreparedStatement statement = conn.prepareStatement(UPDATE_SHOP, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, shops.getId());
            statement.setString(2, shops.getNameShop());
            statement.setString(3, shops.getAddress());
            statement.setLong(4, shops.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public Shops finByName(String nameShop) {
        Shops shops = new Shops();
        try (Connection connection = ConnectionPool.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SHOP_FIN_BY_NAME);
            preparedStatement.setString(1, nameShop);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                shops.setId(id);
                shops.setNameShop(name);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shops;
    }
}
