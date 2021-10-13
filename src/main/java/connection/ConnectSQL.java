package connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectSQL {
    public static void main(String[] args) {

            try (Connection connection = DBConnection.getConnection()) {
                System.out.println("Connection successful");
            } catch (SQLException | ClassNotFoundException throwables) {
                System.out.println("Connection unsuccessful");
                throwables.printStackTrace();
            }

    }
}
