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
            if (s.equals("1")) {
                System.out.println("All products:\n");
                controller.showAllProducts();
                commandlist.showCommandList();

            } else if (s.equals("2")) {
                System.out.println("Calls database and shows stores\n");
                controller.notInStock();
                commandlist.showCommandList();

            } else if (s.equals("3")) {
                System.out.println("Calls database and adds a product to watchlist\n");
                controller.watchProduct();
                commandlist.showCommandList();

            } else if (s.equals("4")) {
            	System.out.println("XML producer shows:");
            	controller.produceXML();
                commandlist.showCommandList();
            }
        }
    }
}