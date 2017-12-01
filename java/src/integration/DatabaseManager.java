package integration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    DBConnection dbConnection = new DBConnection();

    private void showAll () {
        String query;
        ResultSet rs;
        Connection con = dbConnection.getCon();
        Statement stmt;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
