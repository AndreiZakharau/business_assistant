package dao.impl;

import connection.DBConnection;
import dao.DAO;
import entity.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAO<Products> {

    private static ProductDAO instance = new ProductDAO();

    public static ProductDAO getInstance() {
        return instance;
    }

    public ProductDAO(){}

    private static final String SQL_PRODUCT_BY_DELETE = "DELETE FROM Products WHERE  id = ? ";
    private static final String UPDATE_PRODUCT = "UPDATE Products set id = ?, name = ?, count = ?, price = ?, categories_id = ?, suppliers_id = ?, delivery = ?, date_expiration = ?, shop_id = ? WHERE id = ?";
    private static final String SQL_INSERT_PRODUCT = "INSERT INTO Products(name,count,price,categories_id,suppliers_id,delivery,date_expiration,shop_id) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_PRODUCT_FIN_BY_ID = "SELECT * FROM Products WHERE id = ?";
    private static final String SQL_PRODUCT_ALL_LIST = "SELECT * FROM Products";
    private static final String SQL_PRODUCT_FIN_BY_NAME = "SELECT * FROM Products WHERE name = ?";
    private static final String SQL_PRODUCT_FIN_BY_NAME_SUPPLIER_SHOP = "SELECT * FROM Products WHERE name = ?,suppliers_id = ?, shop_id = ?";



    @Override
    public Products add(Products products) {


        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_PRODUCT)) {

            preparedStatement.setString(1, products.getName());
            preparedStatement.setInt(2, products.getCount());
            preparedStatement.setDouble(3, products.getPrice());
            preparedStatement.setInt(4, products.getCategories());
            preparedStatement.setInt(5, products.getSuppliers());
            preparedStatement.setString(6, String.valueOf(products.getLocalDate()));
            preparedStatement.setString(7, String.valueOf(products.getDate()));
            preparedStatement.setInt(8,products.getShop());
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
                String localDate = resultSet.getString("delivery");
                String date = resultSet.getString("date_expiration");
                int shop = resultSet.getInt ("shop_id");

                products = new Products(id,name,count,price,categories,supplier,localDate,date,shop);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }


    @Override
    public List<Products> findAll() {
        List<Products>products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_PRODUCT_ALL_LIST);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int count = resultSet.getInt("count");
                double price = resultSet.getDouble("price");
                int categories = resultSet.getInt("categories_id");
                int supplier = resultSet.getInt("suppliers_id");
                LocalDate localDate = LocalDate.parse(resultSet.getString("delivery"));
                Date date = resultSet.getDate("date_expiration");
                int shop = resultSet.getInt("shop_id");

                products.add(new Products(id,name,count,price,categories,supplier,localDate,date,shop));

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
            preparedStatement.setString(2, products.getName());
            preparedStatement.setInt(3, products.getCount());
            preparedStatement.setDouble(4, products.getPrice());
            preparedStatement.setInt(5, products.getCategories());
            preparedStatement.setInt(6, products.getSuppliers());
            preparedStatement.setString(7, String.valueOf(products.getLocalDate()));
            preparedStatement.setString(8, String.valueOf(products.getDate()));
            preparedStatement.setInt(9,products.getShop());
            preparedStatement.setInt(10,products.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Products finByName(String name) {
        Products products = new Products();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_PRODUCT_FIN_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                int count = resultSet.getInt("count");
                double price = resultSet.getDouble("price");
                int categories = resultSet.getInt("categories_id");
                int supplier = resultSet.getInt("suppliers_id");
                LocalDate localDate = LocalDate.parse(resultSet.getString("delivery"));
                Date date = resultSet.getDate("date_expiration");
                int shop = resultSet.getInt("shop_id");
                products.setId(id);
                products.setName(name1);
                products.setCount(count);
                products.setPrice(price);
                products.setCategories(categories);
                products.setSuppliers(supplier);
                products.setLocalDate(localDate);
                products.setDate(date);
                products.setShop(shop);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Products finByNameSuppliersShop(String name,int supplier,int shop) {
        Products products = new Products();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_PRODUCT_FIN_BY_NAME_SUPPLIER_SHOP);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2,supplier);
            preparedStatement.setInt(3,shop);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                int count = resultSet.getInt("count");
                double price = resultSet.getDouble("price");
                int categories = resultSet.getInt("categories_id");
                int supplier1 = resultSet.getInt("suppliers_id");
                LocalDate localDate = LocalDate.parse(resultSet.getString("delivery"));
                Date date = resultSet.getDate("date_expiration");
                int shop1 = resultSet.getInt("shop_id");
                products.setId(id);
                products.setName(name1);
                products.setCount(count);
                products.setPrice(price);
                products.setCategories(categories);
                products.setSuppliers(supplier1);
                products.setLocalDate(localDate);
                products.setDate(date);
                products.setShop(shop1);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
//    public Products findSortShopCategoryProduct() {
//        Products products = new Products();
//        try (Connection conn = DBConnection.getConnection()) {
//            PreparedStatement preparedStatement = conn.prepareStatement(SQL_PRODUCT_SORT_SHOP_CATEGORY_PRODUCT);
//            preparedStatement.setInt(1,products.getCategories());
//            preparedStatement.setString(2,products.getName());
//            preparedStatement.setInt(3,products.getShop());
//            preparedStatement.setInt(4,products.getCount());
//            preparedStatement.setDouble(5,products.getPrice());
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name1 = resultSet.getString("name");
//                int count = resultSet.getInt("count");
//                double price = resultSet.getDouble("price");
//                int categories = resultSet.getInt("categories_id");
//                int supplier1 = resultSet.getInt("suppliers_id");
//                LocalDate localDate = LocalDate.parse(resultSet.getString("delivery"));
//                Date date = resultSet.getDate("date_expiration");
//                int shop1 = resultSet.getInt("shop_id");
//                products.setId(id);
//                products.setName(name1);
//                products.setCount(count);
//                products.setPrice(price);
//                products.setCategories(categories);
//                products.setSuppliers(supplier1);
//                products.setLocalDate(localDate);
//                products.setDate(date);
//                products.setShop(shop1);
//
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return products;
//    }
    }
