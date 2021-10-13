package dao.impl;

import connection.DBConnection;
import dao.DAO;
import entity.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAO<Products> {

    private static ProductDAO instancePr = new ProductDAO();

    public static ProductDAO getInstance() {
        return instancePr;
    }

    private ProductDAO(){}

    private static final String SQL_PRODUCT_BY_DELETE = "DELETE FROM Products WHERE  id = ? OR nameProduct = ? OR count = ? " +
            "OR price = ? OR categories_id = ? OR suppliers_id = ? OR final_price = ? OR delivery = ? OR date_expiration = ? OR shop_id = ? ";

    private static final String UPDATE_PRODUCT = "UPDATE Products set id = ? AND set nameProduct = ? AND set count = ?  AND set price = ? AND set categories_id = ?" +
            " AND set suppliers_id = ? AND set final_price = ? AND set delivery = ? AND set date_expiration = ? AND set shop_id = ?";

    private static final String SQL_INSERT_PRODUCT = "INSERT INTO Products(nameProduct,count,price,categories_id,suppliers_id," +
            "final_price,delivery,date_expiration,shop_id) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_PRODUCT_FIN_BY_ID = "SELECT * FROM Products WHERE id = ?";

    private static final String SQL_PRODUCT_ALL_LIST = "SELECT * FROM Products";

    @Override
    public Products add(Products products) {


        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_PRODUCT)) {

            preparedStatement.setString(1, products.getNameProduct());
            preparedStatement.setInt(2, products.getCount());
            preparedStatement.setDouble(3, products.getPrice());
            preparedStatement.setInt(4, products.getCategories().getId());
            preparedStatement.setInt(5, products.getSuppliers().getId());
            preparedStatement.setDouble(6, products.getFinalPrice().getAndPrice());
            preparedStatement.setString(7, products.getDelivery().getLd().toString());
            preparedStatement.setString(8, products.getDateExpiration().getReformattedString());
            preparedStatement.setInt(9,products.getShop().getId());
           preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

        @Override
    public boolean delete(Products products) {
            int rows = 0;
            try (Connection connect = DBConnection.getConnection()) {

                PreparedStatement preparedStatement = connect.prepareStatement(SQL_PRODUCT_BY_DELETE);
                preparedStatement.setInt(1, products.getId());
                preparedStatement.setString(2, products.getNameProduct());
                preparedStatement.setInt(3, products.getCount());
                preparedStatement.setDouble(4, products.getPrice());
                preparedStatement.setInt(5, products.getCategories().getId());
                preparedStatement.setInt(6, products.getSuppliers().getId());
                preparedStatement.setDouble(7, products.getFinalPrice().getAndPrice());
                preparedStatement.setString(8, products.getDelivery().getLd().toString());
                preparedStatement.setString(9, products.getDateExpiration().getReformattedString());
                preparedStatement.setInt(10,products.getShop().getId());

                rows = preparedStatement.executeUpdate();

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            return rows != 0;
    }

    @Override
    public Products finByID(int id) {
        Products products = null;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_PRODUCT_FIN_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String name = resultSet.getString("nameProduct");
                int count = resultSet.getInt("count");
                double price = resultSet.getDouble("price");
                int categories = resultSet.getInt("categories_id");
                int supplier = resultSet.getInt("suppliers_id");
                double finalPrise = resultSet.getDouble("final_price");
                String dateDelivery = resultSet.getString("delivery");
                String dateExpiration = resultSet.getString("date_expiration");
                int shop = resultSet.getInt ("shop_id");

                products = new Products(id, name, count,price, categories,supplier,finalPrise,dateDelivery,dateExpiration,shop);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Products> findAll() {
        List<Products> products = new ArrayList<>();
        try (Connection connect = DBConnection.getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_PRODUCT_ALL_LIST);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nameProduct");
                int count = resultSet.getInt("count");
                double price = resultSet.getDouble("price");
                int categories = resultSet.getInt("categories_id");
                int supplier = resultSet.getInt("suppliers_id");
                double finalPrise = resultSet.getDouble("final_price");
                String dateDelivery = resultSet.getString("delivery");
                String dateExpiration = resultSet.getString("date_expiration");
                int shop = resultSet.getInt ("shop_id");

                products.add(new Products(id, name, count,price, categories,supplier,finalPrise,dateDelivery,dateExpiration,shop));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return products;
    }

    @Override
    public boolean update(Products products) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, products.getId());
            preparedStatement.setString(2, products.getNameProduct());
            preparedStatement.setInt(3, products.getCount());
            preparedStatement.setDouble(4, products.getPrice());
            preparedStatement.setInt(5, products.getCategories().getId());
            preparedStatement.setInt(6, products.getSuppliers().getId());
            preparedStatement.setDouble(7, products.getFinalPrice().getAndPrice());
            preparedStatement.setString(8, products.getDelivery().getLd().toString());
            preparedStatement.setString(9, products.getDateExpiration().getReformattedString());
            preparedStatement.setInt(10,products.getShop().getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
