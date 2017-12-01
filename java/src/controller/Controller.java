package controller;

/**
 * Created by Anders on 2017-12-01.
 */
public class Controller {

    /**
     * Show all products
     */
    public void showAllProducts() {
        System.out.println("Calls database and shows products");
    }

    /**
     * Show all stores that doesn't have a specific product in stock
     */
    public void notInStock(){
        System.out.println("Calls database and shows stores");
    }

    /**
     * Add a new product to your watchlist
     */
    public void watchProduct(){
        System.out.println("Calls database and adds a product to watchlist");
    }
}
