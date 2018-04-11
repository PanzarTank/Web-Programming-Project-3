package helpers;

import java.sql.*;
import java.util.ArrayList;

import models.Item;
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
                System.out.println(rs.getInt(1));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return new User(0, "test", "test", "test", "Test", "test");
    }

    public void registerUser(User user) {
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO users(username, password, firstName, lastName, userType) VALUES('" + user.getUserUsername() + "', '" + user.getUserPassword() + "', '" + user.getUserFirstName() + "', '" + user.getUserLastName() + "', '" + user.getUserType() + "')";
            int result = stmt.executeUpdate(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> items =  new ArrayList<Item>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM items");
            while(rs.next()) {
                int itemId = rs.getInt(1);
                String itemName = rs.getString(2);
                double itemPrice = rs.getDouble(3);
                int itemQuantity = rs.getInt(4);
                Item item = new Item(itemId, itemName, itemPrice, itemQuantity);
                items.add(item);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

}
