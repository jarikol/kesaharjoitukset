package kesaharjoitukset;

import java.util.HashMap;
import java.util.Set;

public class K16_Sanakirja {
	public static void main(String args[]) {

		WordBook words = new WordBook();
		words.put("object", "olio");
		words.put("computer", "tietokone");
		words.put("program", "ohjelma");
		words.put("programming", "ohjelmointi");
		words.put("system", "järjestelmä");
		words.put("compiler", "käntäjä");
		words.put("linker", "linkittäjä");
		words.put("interpreter", "tulkki");
		words.put("byte-code", "tavukoodi");
		words.put("execute", "suorittaa");
		words.put("execute", "ajaa");

		System.out.println("object: " + words.get("object"));
		System.out.println("execute: " + words.get("execute"));

		for (int i = 0; i < 80; i++) System.out.print("*");
		System.out.println();

		words.printAll();
	}
}

class WordBook extends HashMap<String, String> {
	private static final long serialVersionUID = 1L; //Tämä tuli eclipseltä automaattisesti kun se
													 //alkoi valittaa jostain kummasta.
	public void printAll() {
		
		//Katsottu suoraan https://www.codemiles.com/collections/print-the-content-of-hashmap-object-t10598.html
		//Vähän epäselvää, mitä tämä tekee.
        Set<Entry<String,String>> hashSet=this.entrySet();
        for(Entry<String,String> entry:hashSet ) {

            System.out.println(entry.getKey()+" ==> "+entry.getValue());
        }
	}
}
