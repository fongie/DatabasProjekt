package integration;

/**
 * This code is used when generating our XML
 * Represents a row in table spelversion
 */
public class SpelVersion {
	
	String plattform;
	String spelserie;
	
	public SpelVersion(String plattform, String spelserie) {
		this.plattform = plattform;
		this.spelserie = spelserie;
	}
	
	public String getPlattform() { return plattform; }
	
	public String getSpelserie() { return spelserie; }

}
