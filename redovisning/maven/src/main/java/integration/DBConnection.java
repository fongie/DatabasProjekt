package integration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*  TO GET PATH
**  String path = new java.io.File(".").getCanonicalPath();
**  System.out.println(path);
*/

public class DBConnection {
    String driver = "net.ucanaccess.jdbc.UcanaccessDriver";

    // gets the relative path of the project and gets the database
    String path = new java.io.File(".").getCanonicalPath();
    String URL = "jdbc:ucanaccess:///" + path + "/src/main/java/database/spelRvi.accdb";
    String userID = "";
    String password = "password";
    Connection con;


    public DBConnection() throws IOException {
        startConnection();
    }

    public Connection getCon() {
        return con;
    }

    // initiate database connection
    private void startConnection() {
        try {
            Class.forName(driver).newInstance();
            this.con = DriverManager.getConnection(URL, userID, password);
            System.out.println("Connected to the database");
            // con.close();
            // System.out.println("Disconnected from database");
        } catch (Exception e) {
            System.out.println("COULD NOT CONNECT TO DATABASE");
            e.printStackTrace();
        }
    }
}


