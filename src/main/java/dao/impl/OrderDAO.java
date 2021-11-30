package dao.impl;

import connection.DBConnection;
import dao.DAO;
import entity.Order;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements DAO<Order> {

    private static OrderDAO instance = new OrderDAO();
    public static OrderDAO getInstance(){return instance;}
    public OrderDAO(){}

    private static final String SQL_ADD_ORDER = "INSERT INTO Orders (number,id,product,quantum,localDate,priceFinal,sum,nameSalesperson,nameShop) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_ALL_LIST_ORDER = "SELECT * FROM Orders";
    private static final String SQL_UPDATE_ORDER = "UPDATE Orders SET number = ?, id = ?, product = ?,quantum = ?,localDate = ?,priceFinal = ?,sum = ?,nameSalesperson = ?,nameShop = ? WHERE id = ?";


    @Override
    public Order add(Order order) {
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_ORDER)){
            preparedStatement.setInt(1,order.getNumber());
            preparedStatement.setInt(2,order.getId());
            preparedStatement.setString(3,order.getProduct());
            preparedStatement.setInt(4,order.getQuantum());
            preparedStatement.setString(5, String.valueOf(order.getLocalDate()));
            preparedStatement.setDouble(6,order.getPriceFinal());
            preparedStatement.setDouble(7,order.getSum());
            preparedStatement.setString(8,order.getNameSalesperson());
            preparedStatement.setString(9, order.getNameShop());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean delete(Order order) {
        return false;
    }

    @Override
    public Order finByName(String k) {
        return null;
    }

    @Override
    public Order finByID(int id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        List<Order>orders = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_ALL_LIST_ORDER);
            while (resultSet.next()){
                int number = resultSet.getInt("number");
                int id = resultSet.getInt("id");
                String product = resultSet.getString("product");
                int quantum = resultSet.getInt("quantum");
                LocalDate localDate = LocalDate.parse(resultSet.getString("localDate"));
//                LocalTime localTime = LocalTime.parse(resultSet.getString("localTime"));
                double priceFinal = resultSet.getDouble("priceFinal");
                double sum = resultSet.getDouble("sum");
                String nameSalesperson = resultSet.getString("nameSalesperson");
                String nameShop = resultSet.getString("nameShop");
                orders.add(new Order(number,id,product,quantum,localDate,priceFinal,sum,nameSalesperson,nameShop));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean update(Order order) {
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ORDER,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1,order.getNumber());
            preparedStatement.setInt(2,order.getId());
            preparedStatement.setString(3,order.getProduct());
            preparedStatement.setInt(4,order.getQuantum());
            preparedStatement.setString(5, String.valueOf(order.getLocalDate()));
//            preparedStatement.setString(6,String.valueOf(order.getLocalTime()));
            preparedStatement.setDouble(6,order.getPriceFinal());
            preparedStatement.setDouble(7,order.getSum());
            preparedStatement.setString(8,order.getNameSalesperson());
            preparedStatement.setString(9,order.getNameShop());
            preparedStatement.setInt(10,order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
