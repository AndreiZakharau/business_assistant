package dao.impl;

import connection.ConnectionPool;
import dao.DAO;
import entity.Categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO implements DAO <Categories> {

    private static CategoriesDAO instance = new CategoriesDAO();

    public static CategoriesDAO getInstance() {
        return instance;
    }

    public CategoriesDAO(){}

    private static final String SQL_INSERT_CATEGORIES = "INSERT INTO categories(name,interest) VALUES (?,?)";
    private static final String SQL_CATEGORIES_BY_DELETE ="DELETE FROM categories WHERE id = ? OR name = ? OR interest = ?";
    private static final String SQL_CATEGORIES_FIN_BY_ID ="SELECT * FROM categories WHERE id = ?";
    private static final String SQL_CATEGORIES_ALL_LIST ="SELECT * FROM categories ";
    private static final String UPDATE_CATEGORIES ="UPDATE categories SET id = ?, name = ?, interest = ? WHERE id = ?";
    private static final String SQL_CATEGORY_FIN_BY_NAME ="SELECT * FROM categories WHERE name = ?";

    @Override
    public Categories add(Categories categories) {

        try (Connection conn = ConnectionPool.get();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_CATEGORIES)) {

            preparedStatement.setString(1, categories.getCategory());
            preparedStatement.setDouble(2,categories.getInterest());
            preparedStatement.executeUpdate();

        } catch (SQLException  throwables) {
            throwables.printStackTrace();
        }
        return categories;
    }


    public Categories finByName(String category) {
        Categories categories = new Categories();
        try(Connection conn = ConnectionPool.get()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_CATEGORY_FIN_BY_NAME);
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double interest = resultSet.getDouble("interest");
                categories.setId(id);
                categories.setCategory(name);
                categories.setInterest(interest);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  categories;
    }

    @Override
    public boolean delete(Categories categories) {
            int rows = 0;
            try (Connection connect = ConnectionPool.get()) {

                PreparedStatement preparedStatement = connect.prepareStatement(SQL_CATEGORIES_BY_DELETE);
                preparedStatement.setLong(1, categories.getId());
                preparedStatement.setString(2, categories.getCategory());
                preparedStatement.setDouble(3,categories.getInterest());
                rows = preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return rows != 0;
        }

    @Override
    public Categories finByID(long id) {
        Categories categories = null;
        try (Connection conn = ConnectionPool.get()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_CATEGORIES_FIN_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
                String nameC= resultSet.getString("name");
                double interest = resultSet.getDouble("interest");
                categories = new Categories(id,nameC,interest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Categories> findAll() {
        List<Categories> categories = new ArrayList<>();
        try (Connection connect = ConnectionPool.get()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_CATEGORIES_ALL_LIST);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nameC = resultSet.getString("name");
                double interest = resultSet.getDouble("interest");
                categories.add(new Categories(id, nameC,interest));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return categories;
    }

    @Override
    public boolean update(Categories categories) {
        try (Connection conn = ConnectionPool.get();
             PreparedStatement statement = conn.prepareStatement(UPDATE_CATEGORIES, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, categories.getId());
            statement.setString(2, categories.getCategory());
            statement.setDouble(3,categories.getInterest());
            statement.setLong(4,categories.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
