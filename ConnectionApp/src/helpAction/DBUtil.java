package helpAction;

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static Connection connection;
    private static final String dburl = "jdbc:msql://localhost/";
    private static final String dbuser = "root";
    private static final String dbpass = "m1a2l3i4Q5i6";
    private static final String dbname = "test";
    private static final String dburlus = dburl + dbname;


    public static void dbConnect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);

        }catch (ClassNotFoundException e){
            System.out.println("Where is your msql JDBC Driver");
            e.printStackTrace();
            throw e;
        }
        System.out.println("JDBC Driver has been registered");

        try {
            connection = (Connection) DriverManager.getConnection(dburlus, dbuser, dbpass);
        } catch (SQLException e) {
            System.out.println("Connection Fail! Check output console " + e);
            throw e;
        }
    }

    public static void dbDisconnect() throws SQLException, IOException {
        try {
            if(connection != null && connection.isOpen()) {
                connection.close();
            }
        }catch (Exception e){
            throw e;
        }
    }


    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "m1a2l3i4Q5i6");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e);
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return c;
    }

    public class UserDAO {

        public Users checkLogin(String username, String password) throws SQLException, ClassNotFoundException, IOException {


            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection(dburlus, dbuser, dbpass);
            String sql = "SELECT * FROM users WHERE username = ? and password = ?";
            PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            Users users = null;

            if (result.next()) {
                users = new Users();
                users.setUsername(username);
                users.setPassword(password);
            }

            connection.close();

            return users;
        }
    }


}
