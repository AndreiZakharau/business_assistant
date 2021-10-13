package dao.impl;

import connection.DBConnection;
import dao.DAO;
import entity.Shops;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO implements DAO<Shops> {


    public static ShopDAO getInstance;


    private static final String SQL_INSERT_SHOP = "INSERT INTO Shops(nameShop,address) VALUES (?,?)";
    private static final String SQL_SHOP_BY_DELETE ="DELETE FROM Shops WHERE id = ? OR nameShop = ? OR address = ?";
    private static final String SQL_SHOP_FIN_BY_ID ="SELECT * FROM Shops WHERE id = ?";
    private static final String SQL_SHOP_ALL_LIST ="SELECT * FROM Shops ";
    private static final String UPDATE_SHOP =" UPDATE Shops SET id = ? AND SET nameShop = ? AND SET address = ?";

    @Override
    public Shops add(Shops shops) {

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_SHOP)) {

            preparedStatement.setString(1, shops.getNameShop());
            preparedStatement.setString(2, shops.getAddress());

            preparedStatement.executeUpdate();
            System.out.println("Магазин создан");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shops;
    }
        @Override
    public boolean delete(Shops shops) {
            int rows = 0;
            try (Connection connect = DBConnection.getConnection()) {

                PreparedStatement preparedStatement = connect.prepareStatement(SQL_SHOP_BY_DELETE);
                preparedStatement.setInt(1, shops.getId());
                preparedStatement.setString(2, shops.getNameShop());
                preparedStatement.setString(3, shops.getAddress());


                rows = preparedStatement.executeUpdate();

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            return rows != 0;
    }

    @Override
    public Shops finByID(int id) {
        Shops shops = null;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SHOP_FIN_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String name = resultSet.getString("nameShop");
                String address = resultSet.getString("address");
                shops = new Shops(id,name,address );
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shops;
    }

    @Override
    public List<Shops> findAll() {
        List<Shops> shops = new ArrayList<>();
        try (Connection connect = DBConnection.getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SHOP_ALL_LIST);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameShop = resultSet.getString("nameShop");
                String address = resultSet.getString("address");

                shops.add(new Shops(id, nameShop, address));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return shops;
    }

    @Override
    public boolean update(Shops shops) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE_SHOP, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, shops.getId());
            statement.setString(2, shops.getNameShop());
            statement.setString(3, shops.getAddress());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }



}
