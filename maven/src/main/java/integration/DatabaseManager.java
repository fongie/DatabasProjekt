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

        // query to get namn, plattform, pris
        query = "SELECT namn, plattform, pris FROM Spel INNER JOIN Spelversion ON Spel.spelID = Spelversion.spel";
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(query);


        List<Format> formatList = new ArrayList<Format>();
        formatList.add(new Format("Name", "Platform", "Price"));

        String template = "%-45s %-40s %10s%n";

        for (Format format : formatList) {
            System.out.printf(template, format.getSecond(), format.getSecond(), format.getThird());
            while (rs.next())
            {
                System.out.printf(template, rs.getString("namn"), rs.getString("plattform"), rs.getString("pris") + "kr");
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
        String game;
        String platform;
        ResultSet rs;
        Connection con = dbConnection.getCon();

        // get user input
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Name of the game: ");
        game = in.nextLine();
        System.out.println("To which platform: ");
        platform = in.nextLine();

        // query to get adress and butik
        query = "SELECT adress FROM  Butik INNER JOIN Lagersaldo ON Butik.butiksID=Lagersaldo.lagersaldoID INNER JOIN Spelversion ON Lagersaldo.spelversion=Spelversion.sträckkod INNER JOIN Spel ON SpelVersion.spel=Spel.spelID WHERE namn = ? AND plattform = ?";


        // use prepared statment to insert user input before execution of query
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, game);
        stmt.setString(2, platform);
        rs = stmt.executeQuery();


        List<Format> formatList = new ArrayList<Format>();
        formatList.add(new Format("Adress"));

        String template = "%-45s%n";

        for (Format format : formatList) {
            System.out.printf(template, format.getFirst());

            while (rs.next())
            {
                System.out.printf(template, rs.getString("adress"));
            }
        }
        stmt.close();
    }

    public void watchProduct () throws SQLException {
        String query;
        String mail;
        String lagersaldoID = "";
        String store;
        String game;
        String platform;
        ResultSet rs;
        Connection con = dbConnection.getCon();

        // get user input
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Enter your mail address: ");
        mail = in.nextLine();
        System.out.println("Enter the address of the store");
        store = in.nextLine();
        System.out.println("Enter name of the game");
        game = in.nextLine();
        System.out.println("Enter name of the plattform");
        platform = in.nextLine();

        // query to get lagersaldoID
        query = "SELECT lagersaldoID FROM ((Lagersaldo INNER JOIN Spelversion ON LagerSaldo.spelversion=SpelVersion.sträckkod) INNER JOIN Spel ON SpelVersion.spel=Spel.spelID) INNER JOIN Butik ON LagerSaldo.butiksID=Butik.butiksID WHERE namn = ? AND adress = ? AND plattform = ?";


        // use prepared statment to insert user input before execution of query
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, game);
        stmt.setString(2, store);
        stmt.setString(3, platform);
        rs = stmt.executeQuery();


        List<Format> formatList = new ArrayList<Format>();
        formatList.add(new Format("LagesaldoID"));

        String template = "%-45s%n";

        for (Format format : formatList) {
            System.out.printf(template, format.getFirst());

            while (rs.next())
            {
                System.out.printf(template, rs.getString("lagersaldoID"));
                lagersaldoID = rs.getString("lagersaldoID");
            }
        }

        // lägg till i produktbevakning
        addToWatchlist(lagersaldoID, mail);

        stmt.close();
    }

    // helper method add to watch list
    private void addToWatchlist(String lagersaldoID, String mail) throws SQLException {

        // declaration
        String query;
        ResultSet rs;
        Connection con = dbConnection.getCon();

        // query to insert
        query = "INSERT INTO Produktbevakning (Epost, lagersaldoID) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, mail);
        stmt.setString(2, lagersaldoID);
        stmt.executeUpdate();

        showWatchList();
        stmt.close();

    }

    private void showWatchList() throws SQLException{

        String query;
        ResultSet rs;
        Connection con = dbConnection.getCon();

        // query
        query = "SELECT * FROM Produktbevakning";
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(query);

        List<Format> formatList = new ArrayList<Format>();
        formatList.add(new Format("Produktbevakningar", "LagerSaldoID"));

        String template = "%-45s %-45s%n";

        for (Format format : formatList) {
            System.out.printf(template, format.getFirst(), format.getSecond());

            while (rs.next())
            {
                System.out.printf(template, rs.getString("Epost"),rs.getString("lagersaldoID"));
            }
        }
    }
}




