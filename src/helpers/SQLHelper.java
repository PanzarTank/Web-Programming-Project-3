package helpers;

import java.sql.*;
import models.User;

public class SQLHelper {

    private final static String HOSTNAME = "codd.cs.gsu.edu";
    private final static String PORT = "3306";
    private final static String USER = "skim161";
    private final static String PWD = "skim161";
    private final static String DBNAME = "skim161";

    private Connection conn;

    public SQLHelper() {
        try {
            String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DBNAME;
            this.conn = DriverManager.getConnection(URL, USER, PWD);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authUser(String username, String password) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username="+ username + " AND password=" + password);
            while(rs.next()) {
                System.out.println(rs.getInt(0));
                closeConnection();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserById(int id) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + id);
            while(rs.next()) {
                System.out.println(rs.getInt(0));
                closeConnection();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return new User(0, "test", "test", "test", "Test", "test");
    }

}
