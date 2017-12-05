package integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    String URL = "jdbc:ucanaccess:////Users/Anders/KTH Datateknik/Datalagring IV1351/project/DatabasProjekt/java/databas/spelRvi.accdb";
    String userID = "";
    String password = "password";
    Connection con;



    public DBConnection() {
        startConnection();
    }

    public Connection getCon() {
        return con;
    }

    public void connect () {
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(URL, userID, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        }
    }
    private void startConnection()
    {
        try {
            Class.forName(driver).newInstance();
            this.con = DriverManager.getConnection(URL, userID, password);
            System.out.println("Connected to the database");
            con.close();
            System.out.println("Disconnected from database");
        } catch (Exception e) {
            System.out.println("NO CONNECTION =(");
            e.printStackTrace();
        }
    }

}

