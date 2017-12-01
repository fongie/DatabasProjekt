package view;

/**
 * Created by Anders on 2017-12-01.
 */
public class Command {

    // lists available commands
    public void showCommandList() {
        System.out.println("\nCommand list\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "product    => Show all products\n" +
                "stock      => Show all stores that doesn't have a specific product in stock\n" +
                "watch      => Add a product to your watch list\n");
    }
}
