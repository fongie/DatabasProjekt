package integration;

import java.util.ArrayList;

/**
 * This code is used when generating our XML
 * Represents a row in table spel
 */
public class SpelEntry {

	String namn;
	ArrayList<String> genre;
	String spelskapare;
	ArrayList<SpelVersion> produkter;
	DatabaseManager db;
	
	public SpelEntry(String namn, String spelskapare, ArrayList<String> genre, DatabaseManager db) {
		this.namn = namn;
		this.genre = genre;
		this.spelskapare = spelskapare;
		this.db = db;
		
		fetchProducts();
	}
	public String getNamn() { return this.namn; }
	public String getSkapare() { return this.spelskapare; }
	public ArrayList<String> getGenre() { return this.genre; }
	
	public ArrayList<SpelVersion> getProducts() {
		return this.produkter;
	}
	
	private void fetchProducts() {
		this.produkter = db.fetchProducts(this.namn);
	}
	
}
