package model;

import java.util.ArrayList;
import java.util.HashMap;

import integration.DatabaseManager;
import integration.SpelEntry;
import integration.SpelVersion;

public class XMLProducer {
	DatabaseManager db;
	
	public XMLProducer(DatabaseManager db) {
		this.db = db;
	}

	public void produceXML() {
		
		ArrayList<SpelEntry> list = db.getSpel();

		/* Mall
		System.out.println("<spelRvi>\n" +
		       "\t<Spel>\n" +
		           "\t\t<Namn></Namn>\n" +
		           "\t\t<Genre></Genre>\n" +
		           "\t\t<Spelskapare></Spelskapare>\n" +
		           "\t\t<SpelVersion>\n" +
		               "\t\t\t<Plattform></Plattform>\n" +
		               "\t\t\t<Spelserie></Spelserie>\n" +
		           "\t\t</SpelVersion>\n" +
		       "\t</Spel>\n" +
		"</spelRvi>\n");
		*/
		System.out.println("<?xml version=\"1.0\" standalone=\"yes\" encoding=\"ISO-8859-1\"?>");
		System.out.println("<!doctype spelRvi>");
		System.out.println("<spelRvi>");
		for (SpelEntry l : list) {
			System.out.println("\t<Spel>\n" +
				           "\t\t<Namn>" + l.getNamn() + "</Namn>");
			for (String g : l.getGenre()) {
				System.out.println("\t\t<Genre>" + g + "</Genre>");
			}
			System.out.println("\t\t<Spelskapare>" + l.getSkapare() + "</Spelskapare>");
			
			for (SpelVersion v : l.getProducts()) {
				System.out.println("\t\t<SpelVersion>");
				System.out.println("\t\t\t<Plattform>" + v.getPlattform() + "</Plattform>");
				if (!(v.getSpelserie() == null)) {
					System.out.println("\t\t\t<Spelserie>" + v.getSpelserie() + "</Spelserie>");
				}
				System.out.println("\t\t</SpelVersion>");
			}
			System.out.println("\t</Spel>");
		}
		System.out.println("</spelRvi>");

	}

}
