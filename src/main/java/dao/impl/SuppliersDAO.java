package dao.impl;

import connection.DBConnection;
import dao.DAO;
import entity.Shops;
import entity.Suppliers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class SuppliersDAO implements DAO <Suppliers> {

    private static SuppliersDAO instanceSu = new SuppliersDAO();

    public static SuppliersDAO getInstance() {
        return instanceSu;
    }

    public SuppliersDAO(){}

    private static final String SQL_SUPPLIERS_BY_DELETE = "DELETE FROM Suppliers WHERE  id = ? OR name = ? OR contact_tel = ? OR email = ? ";
    private static final String SQL_UPDATE_SUPPLIERS = "UPDATE Suppliers set id = ?, name = ?, contact_tel  = ?, email = ? Where id = ?";
    private static final String SQL_INSERT_SUPPLIERS = "INSERT INTO Suppliers(name,contact_tel,email) VALUES (?,?,?)";
    private static final String SQL_SUPPLIERS_FIN_BY_ID = "SELECT * FROM Suppliers WHERE id = ?";
    private static final String SQL_SUPPLIERS_ALL_LIST = "SELECT * FROM Suppliers";

    @Override
    public Suppliers add(Suppliers suppliers) {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_SUPPLIERS)) {
            preparedStatement.setString(1,suppliers.getNameSupplier());
            preparedStatement.setString(2,suppliers.getContactTel());
            preparedStatement.setString(3,suppliers.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    @Override
    public boolean delete(Suppliers suppliers) {
        int rows = 0;
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_SUPPLIERS_BY_DELETE)) {
            ps.setInt(1,suppliers.getId());
            ps.setString(2,suppliers.getNameSupplier());
            ps.setString(3,suppliers.getContactTel());
            ps.setString(4,suppliers.getEmail());
            rows = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rows != 0;
    }

    @Override
    public Suppliers finByID(int id) {
        Suppliers suppliers = null;
        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_SUPPLIERS_FIN_BY_ID);
            ps.setInt(1,suppliers.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String contact = resultSet.getString("contact_tel");
                String email = resultSet.getString("email");
                suppliers = new Suppliers(id,name,contact,email);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    @Override
    public List<Suppliers> findAll() {
        List<Suppliers>suppliersList = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SUPPLIERS_ALL_LIST);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String contact = resultSet.getString("contact_tel");
                String email = resultSet.getString("email");
                suppliersList.add(new Suppliers(id, name, contact, email));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return suppliersList;
    }

    @Override
    public boolean update(Suppliers suppliers) {
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_SUPPLIERS,Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1,suppliers.getId());
            ps.setString(2,suppliers.getNameSupplier());
            ps.setString(3,suppliers.getContactTel());
            ps.setString(4,suppliers.getEmail());
            ps.setInt(5,suppliers.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }
}
