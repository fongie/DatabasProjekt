package view;

import java.util.Scanner;

/**
 * A system that works with our SpelRvi database
 */
public class Driver {

    // lists available commands
    private static void showCommandList() {
        System.out.println("\nCommand list\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "product    = Show all products\n" +
                "stock      = Show all stores that do NOT have a product in stock.\n" +
                "watch      = Add a product to your watch list\n");
    }

    /**
     * System menu
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n= = = = = = = = = =\nWelcome to SpelRvi!\n= = = = = = = = = =");
        showCommandList();
        String command = "";

        while (!command.equalsIgnoreCase("quit")) {
            command = in.nextLine();
            switch (command.toLowerCase()) {

                case "product":
                    System.out.println("Shows product");
                    break;
                case "stock":
                    System.out.println("Shows stock");
                    break;
                case "watch":
                    System.out.println("Shows watch");
                    break;
            }
        }
    }
}