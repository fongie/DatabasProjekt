package view;

import controller.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * A system that works with our SpelRvi database
 */
public class Driver {

    /**
     * System menu
     */
    public static void main(String[] args) throws SQLException, IOException {

        /*  TO GET PATH

            String path = new java.io.File(".").getCanonicalPath();
            System.out.println(path);
         */

        Command commandlist = new Command();
        Controller controller = new Controller();

        Scanner in = new Scanner(System.in);
        System.out.println("\n= = = = = = = = = =\nWelcome to SpelRvi!\n= = = = = = = = = =");
        commandlist.showCommandList();
        String command = "";

        // loops until user inputs quit
        while (!command.equalsIgnoreCase("quit")) {
            command = in.nextLine();
            String s = command.toLowerCase();
            if (s.equals("product")) {
                System.out.println("Calls database and shows products\n");
                controller.showAllProducts();

            } else if (s.equals("stock")) {
                System.out.println("Calls database and shows stores\n");
                controller.notInStock();

            } else if (s.equals("watch")) {
                System.out.println("Calls database and adds a product to watchlist\n");
                controller.watchProduct();

            }
        }
    }
}