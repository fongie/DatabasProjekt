package integration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    DBConnection dbConnection = new DBConnection();

    private void showAll () throws SQLException {
        String query;
        ResultSet rs;
        Connection con = dbConnection.getCon();
        Statement stmt = null;

        stmt = con.createStatement();
        query = "SELECT *, FROM spelversion";
        rs = stmt.executeQuery(query);
        while (rs.next())
        {
            System.out.print("Pris: " + rs.getString("pris"));
            //System.out.println(" Antal personer: " + rs.getInt("antal"));
        }
        stmt.close();

    }
}
