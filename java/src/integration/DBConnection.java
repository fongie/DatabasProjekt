package integration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    String URL = "jdbc:ucanaccess://../access/spelRvi.accdb";
    String userID = "root";
    String password = "secretpassword";
    Connection con;

    public DBConnection() {
        connect();
    }

    public Connection getCon() {
        return con;
    }

    public void connect () {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userID, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}


