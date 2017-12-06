package integration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private DBConnection dbConnection = new DBConnection();

    /**
     * Show all products
     * @throws SQLException
     */
    public void showAll () throws SQLException {
        String query;
        ResultSet rs;
        Connection con = dbConnection.getCon();

        query = "SELECT namn, pris FROM Spel INNER JOIN Spelversion ON Spel.spelID = Spelversion.spel";
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(query);


        List<Format> formatList = new ArrayList<Format>();
        formatList.add(new Format("Namn", "Pris"));

        String template = "%-45s %10s%n";

        for (Format format : formatList) {
            System.out.printf(template, format.getName(), format.getDescription());
            while (rs.next())
            {
                System.out.printf(template, rs.getString("namn"), rs.getString("pris"));
            }
        }

        stmt.close();
    }

    /**
     * Show all stores that doesn't have a specific product in stock
     * @throws SQLException
     */
    public void notInStock() throws SQLException {
        String query;
        String choise;
        ResultSet rs;
        Connection con = dbConnection.getCon();

        // get user input
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Name of the game: ");
        choise = in.nextLine();

        // get the adress of a store that doesn't have any copies of a specific game in stock
        query = "SELECT adress FROM  Butik INNER JOIN Lagersaldo ON Butik.butiksID=Lagersaldo.lagersaldoID INNER JOIN Spelversion ON Lagersaldo.spelversion=Spelversion.sträckkod INNER JOIN Spel ON SpelVersion.spel=Spel.spelID WHERE namn = ?";

        // use prepared statment to insert user input before execution of query
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, choise);
        rs = stmt.executeQuery();


        List<Format> formatList = new ArrayList<Format>();
        formatList.add(new Format("Adress"));

        String template = "%-45s%n";

        for (Format format : formatList) {
            System.out.printf(template, format.getButik());
            while (rs.next())
            {
                System.out.printf(template, rs.getString("adress"));
            }
        }
        stmt.close();
    }

    public void watchProduct () throws SQLException {
        String query;
        ResultSet rs;
        Connection con = dbConnection.getCon();

        query = "SELECT * FROM spelversion";
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(query);

        while (rs.next())
        {
            System.out.print("Pris: " + rs.getString("pris"));
            //System.out.println(" Antal personer: " + rs.getInt("antal"));
        }
        stmt.close();
    }

}
