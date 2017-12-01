package controller;

import integration.DatabaseManager;

/**
 * Created by Anders on 2017-12-01.
 */
public class Controller {
    DatabaseManager databaseManager = new DatabaseManager();

    /**
     * Show all products
     */
    public void showAllProducts() {
        databaseManager.showAll();
    }

    /**
     * Show all stores that doesn't have a specific product in stock
     */
    public void notInStock(){
    }

    /**
     * Add a new product to your watchlist
     */
    public void watchProduct(){
    }
}
