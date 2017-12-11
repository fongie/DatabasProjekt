package controller;

import integration.DatabaseManager;
import model.XMLProducer;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Anders on 2017-12-01.
 */
public class Controller {
    private DatabaseManager databaseManager = new DatabaseManager();

    public Controller() throws IOException {
    }

    /**
     * Show all products
     */
    public void showAllProducts() throws SQLException {
        databaseManager.showAll();
    }

    /**
     * Show all stores that doesn't have a specific product in stock
     */
    public void notInStock() throws SQLException {
        databaseManager.notInStock();
    }

    /**
     * Add a new product to your watchlist
     */
    public void watchProduct() throws SQLException {
        databaseManager.watchProduct();
    }

    /** Produce XML our way
     
     */
	public void produceXML() {
		// TODO Auto-generated method stub
		XMLProducer xml = new XMLProducer(databaseManager);
		xml.produceXML();
		
	}
}
