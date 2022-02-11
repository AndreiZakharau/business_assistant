package dao.impl;

import connection.ConnectionPool;
import dao.DAO;
import entity.Suppliers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SuppliersDAO implements DAO<Suppliers> {

    private static SuppliersDAO instanceSu = new SuppliersDAO();

    public static SuppliersDAO getInstance() {
        return instanceSu;
    }

    public SuppliersDAO() {
    }


    private static final String SQL_SUPPLIERS_BY_DELETE = "DELETE FROM Suppliers WHERE  id = ? OR name = ? OR contact_tel = ? OR email = ? ";
    private static final String SQL_UPDATE_SUPPLIERS = "UPDATE Suppliers set id = ?, name = ?, contact_tel  = ?, email = ? Where id = ?";
    private static final String SQL_INSERT_SUPPLIERS = "INSERT INTO Suppliers(name,contact_tel,email) VALUES (?,?,?)";
    private static final String SQL_SUPPLIERS_FIN_BY_ID = "SELECT * FROM Suppliers WHERE id = ?";
    private static final String SQL_SUPPLIERS_ALL_LIST = "SELECT * FROM Suppliers";
    private static final String SQL_SUPPLIERS_FIN_BY_NAME = "SELECT * FROM Suppliers WHERE name = ?";


    @Override
    public Suppliers add(Suppliers suppliers) {

        try (Connection connection = ConnectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_SUPPLIERS)) {
            preparedStatement.setString(1, suppliers.getNameSupplier());
            preparedStatement.setString(2, suppliers.getContactTel());
            preparedStatement.setString(3, suppliers.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return suppliers;
    }

    @Override
    public boolean delete(Suppliers suppliers) {
        int rows = 0;
        try (Connection connection = ConnectionPool.get();
             PreparedStatement ps = connection.prepareStatement(SQL_SUPPLIERS_BY_DELETE)) {
            ps.setLong(1, suppliers.getId());
            ps.setString(2, suppliers.getNameSupplier());
            ps.setString(3, suppliers.getContactTel());
            ps.setString(4, suppliers.getEmail());
            rows = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows != 0;
    }

    @Override
    public Suppliers finByID(long id) {
        Suppliers suppliers = null;
        try (Connection conn = ConnectionPool.get()) {
            PreparedStatement ps = conn.prepareStatement(SQL_SUPPLIERS_FIN_BY_ID);
            ps.setLong(1, suppliers.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String contact = resultSet.getString("contact_tel");
                String email = resultSet.getString("email");
                suppliers = new Suppliers(id, name, contact, email);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return suppliers;
    }

    @Override
    public List<Suppliers> findAll() {
        List<Suppliers> suppliersList = new ArrayList<>();
        try (Connection conn = ConnectionPool.get()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SUPPLIERS_ALL_LIST);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String contact = resultSet.getString("contact_tel");
                String email = resultSet.getString("email");
                suppliersList.add(new Suppliers(id, name, contact, email));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return suppliersList;
    }

    @Override
    public boolean update(Suppliers suppliers) {
        try (Connection connection = ConnectionPool.get();
             PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_SUPPLIERS, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, suppliers.getId());
            ps.setString(2, suppliers.getNameSupplier());
            ps.setString(3, suppliers.getContactTel());
            ps.setString(4, suppliers.getEmail());
            ps.setLong(5, suppliers.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public Suppliers finByName(String nameSupplier) {
        Suppliers suppliers = new Suppliers();
        try (Connection conn = ConnectionPool.get()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SUPPLIERS_FIN_BY_NAME);
            preparedStatement.setString(1, nameSupplier);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                suppliers.setId(id);
                suppliers.setNameSupplier(name);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return suppliers;
    }
}
