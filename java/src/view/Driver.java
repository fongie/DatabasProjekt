package view;

import controller.Controller;

import java.util.Scanner;

/**
 * A system that works with our SpelRvi database
 */
public class Driver {
    /**
     * System menu
     *
     * @param args
     */
    public static void main(String[] args) {
        Command commandlist = new Command();
        Controller controller = new Controller();

        Scanner in = new Scanner(System.in);
        System.out.println("\n= = = = = = = = = =\nWelcome to SpelRvi!\n= = = = = = = = = =");
        commandlist.showCommandList();
        String command = "";

        // loops until user inputs quit
        while (!command.equalsIgnoreCase("quit")) {
            command = in.nextLine();
            switch (command.toLowerCase()) {

                case "product":
                    controller.showAllProducts();
                    break;
                case "stock":
                    controller.notInStock();
                    break;
                case "watch":
                    controller.watchProduct();
                    break;
            }
        }
    }
}