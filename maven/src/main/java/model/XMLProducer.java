package model;

import java.util.ArrayList;

import integration.DatabaseManager;
import integration.SpelEntry;
import integration.SpelVersion;

/**
 * This code is used when generating our XML
 * Produces XML
 */
public class XMLProducer {
	DatabaseManager db;

	public XMLProducer(DatabaseManager db) {
		this.db = db;
	}

	public void produceXML() {

		ArrayList<SpelEntry> list = db.getSpel();
		ArrayList<String> spelskapare = db.getSpelskapare(); //hack - wouldve been better to refractor Spelskapare to have its own object. Nested for loops below is slower than necessery

		/* Mall
		System.out.println("<spelRvi>\n" +
			<Spelskapare>
		       "\t<Spel>\n" +
		           "\t\t<Namn></Namn>\n" +
		           "\t\t<Genre></Genre>\n" +
		           "\t\t<SpelVersion>\n" +
		               "\t\t\t<Plattform></Plattform>\n" +
		               "\t\t\t<Spelserie></Spelserie>\n" +
		           "\t\t</SpelVersion>\n" +
		       "\t</Spel>\n" +
		   </Spelskapare>
		"</spelRvi>\n");
		 */
		System.out.println("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		System.out.println("<spelRvi>");

		for (String s : spelskapare) {
			System.out.println("\t<Spelskapare>");
			System.out.println("\t\t<Namn>" + s + "</Namn>");

			for (SpelEntry l : list) {
				if (l.getSkapare() == s) {
					System.out.println("\t\t<Spel>\n" +
							"\t\t\t<Namn>" + l.getNamn() + "</Namn>");
					for (String g : l.getGenre()) {
						System.out.println("\t\t\t<Genre>" + g + "</Genre>");
					}

					for (SpelVersion v : l.getProducts()) {
						System.out.println("\t\t\t<SpelVersion>");
						System.out.println("\t\t\t\t<Streckkod>" + v.getStreckkod() + "</Streckkod>");
						System.out.println("\t\t\t\t<Plattform>" + v.getPlattform() + "</Plattform>");
						if (!(v.getSpelserie() == null)) {
							System.out.println("\t\t\t\t<Spelserie>" + v.getSpelserie() + "</Spelserie>");
						}
						System.out.println("\t\t\t</SpelVersion>");
					}
					System.out.println("\t\t</Spel>");
				}
			}
			System.out.println("\t</Spelskapare>");
		}

		System.out.println("</spelRvi>");
	}
}
