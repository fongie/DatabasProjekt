package view;

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
        Scanner in = new Scanner(System.in);
        System.out.println("\n= = = = = = = = = =\nWelcome to SpelRvi!\n= = = = = = = = = =");
        commandlist.showCommandList();
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