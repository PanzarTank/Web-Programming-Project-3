package helpers;

import java.sql.*;
import models.User;

public class SQLHelper {

    private final static String HOSTNAME = "localhost";
    private final static String PORT = "8889";
    private final static String USER = "root";
    private final static String PWD = "root";
    private final static String DATABASE_NAME = "panthercart";

    private Connection conn;

    public SQLHelper() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE_NAME;
            this.conn = DriverManager.getConnection(URL, USER, PWD);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authUser(String username, String password) {
        boolean authenticated = false;
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username=\'"+ username + "\' AND password=\'" + password + "\'";
            ResultSet rs = stmt.executeQuery(query);
            authenticated = rs.next();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return authenticated;
    }

    public User getUserById(int id) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + id);
            while(rs.next()) {
                System.out.println(rs.getInt(0));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return new User(0, "test", "test", "test", "Test", "test");
    }

}
