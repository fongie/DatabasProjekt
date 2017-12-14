package integration;

/**
 * This code is used when generating our XML
 * Represents a row in table spelversion
 */
public class SpelVersion {
	
	private String plattform;
	private String spelserie;
	private int streckkod;
	
	public SpelVersion(int streckkod, String plattform, String spelserie) {
		this.plattform = plattform;
		this.spelserie = spelserie;
		this.streckkod = streckkod;
	}
	
	public String getPlattform() { return plattform; }
	
	public String getSpelserie() { return spelserie; }
	
	public int getStreckkod() { return streckkod; }

}
