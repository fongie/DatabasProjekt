package view;

/**
 * Created by Anders on 2017-12-01.
 */
public class Command {

    /**
     * List available commands
     */
    void showCommandList() {
        System.out.println("\nCommand list\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "1 => Show all products\n" +
                "2 => Show all stores that doesn't have a specific product in stock\n" +
                "3 => Add a product to your watch list\n" +
                "4 => Bonus: Export part of our database as XML (shown in console)" +
                "\n(type quit to quit)\n");
    }
}
