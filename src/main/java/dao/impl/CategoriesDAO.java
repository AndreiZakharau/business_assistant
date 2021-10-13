package dao.impl;

import connection.DBConnection;
import dao.DAO;
import entity.Categories;
import entity.Shops;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO implements DAO <Categories> {

    private static CategoriesDAO instanceCat = new CategoriesDAO();

    public static CategoriesDAO getInstance() {
        return instanceCat;
    }

    private CategoriesDAO(){}

    private static final String SQL_INSERT_CATEGORIES = "INSERT INTO Categories(Categories) VALUES (?)";
    private static final String SQL_CATEGORIES_BY_DELETE ="DELETE FROM Categories WHERE id = ? OR categories = ? ";
    private static final String SQL_CATEGORIES_FIN_BY_ID ="SELECT * FROM Categories WHERE id = ?";
    private static final String SQL_CATEGORIES_ALL_LIST ="SELECT * FROM Categories ";
    private static final String UPDATE_CATEGORIES ="UPDATE Categories SET id = ? AND SET categories = ?";

    @Override
    public Categories add(Categories categories) {

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_CATEGORIES)) {

            preparedStatement.setString(1, categories.getCategory());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return categories;
    }
        @Override
    public boolean delete(Categories categories) {
            int rows = 0;
            try (Connection connect = DBConnection.getConnection()) {

                PreparedStatement preparedStatement = connect.prepareStatement(SQL_CATEGORIES_BY_DELETE);
                preparedStatement.setInt(1, categories.getId());
                preparedStatement.setString(2, categories.getCategory());


                preparedStatement.executeUpdate();

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            return rows != 0;
        }

    @Override
    public Categories finByID(int id) {
        Categories categories = null;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_CATEGORIES_FIN_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String nameC= resultSet.getString("categories");
                categories = new Categories(id,nameC);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Categories> findAll() {
        List<Categories> categories = new ArrayList<>();
        try (Connection connect = DBConnection.getConnection()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_CATEGORIES_ALL_LIST);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameC = resultSet.getString("categories");
                categories.add(new Categories(id, nameC));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return categories;
    }

    @Override
    public boolean update(Categories categories) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE_CATEGORIES, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, categories.getId());
            statement.setString(2, categories.getCategory());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
