package kesaharjoitukset;

import java.util.ArrayList;
import java.util.Scanner;


public class K7_Tietovisailu {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int vastaus;
		int oikein = 0;
		// Tehtävänannon 1. kohta on tulostaa kysymykset vastausvaihtoehtoineen. Tätä varten on luotu
		// abstrakti TietovisaTaulu -luokka, jonka ainoa metodi tulostaa kysymykset, vastausvaihtoehdot
		// sekä erilliseen muuttujaan tallennetun oikean vastauksen.
		TietovisaTaulu.tulostaKysymykset();
		
		//Tehtävänannon lisäharjoituksessa kysytään kysymyksiä hallinnoivaa Visa-luokkaa, joka on toteutettu kysymyksiä
		//sisältävänä ArrayListinä. Kysymys on oma olio, joka annetaan Visa-luokan parametriksi.
		Visa tietovisa = new Visa();	
		Kysymys uusi;
		
		
		//Kysymyksiä voi syöttää näin. Tässä toteutuksessa ei tällaisenaan ole paljoa mieltä, mutta
		//se olisi helppo muuttaa luupiksi, joka keräisi käyttäjältä halutut kysymykset.
		uusi = new Kysymys("Mikä on Nöpö?", "Kissa", "Koira", "Hiiri",1);
		tietovisa.lisaa(uusi);
		uusi = new Kysymys("Mikä on Pipsa?", "Kissa", "Koira", "Hiiri",2);
		tietovisa.lisaa(uusi);
		uusi = new Kysymys("Paistaako päivisin aurinko vai kuu?", "Aurinko", "Kuu", "Ei kumpikaan",1);
		tietovisa.lisaa(uusi);

		
		//Vaihtoehtoisesti voidaan syöttää valmiiksi tallennetut kysymykset, jotka tässä tapauksessa ovat
		//String -taulukossa. Käytännössä ne varmaan haettaisiin tietokannasta.
		String lisakysymykset[][] = {
				{"Javan yritysversio?","Java EE","Java SE","Java CE","1"},
				{"Uusin Java versio?","Java SE 8","Java SE 12","Java SE 18","2"},
				{"Kuuluisa IDE?","Eclipse","Sun","Fun","1"},
				{"Javan kehitti alunperin yritys?","Moon","Sun","Star","2"},
				{"Javasta vastaa nykyisin?","IBM","Oracle","Nöpön keksi","3"}
				};
		for(int i = 0; i<lisakysymykset.length;i++) {
			uusi = new Kysymys(lisakysymykset[i][0],lisakysymykset[i][1],lisakysymykset[i][2],lisakysymykset[i][3],Integer.parseInt(lisakysymykset[i][4]));
			tietovisa.lisaa(uusi);
		}
		
		// tietovisa.tulosta(); //Tämä metodi tulostaa kysymykset vastausvaihtoehtoineen, sekä oikeat vastaukset.
		//						  Se lienee järkevintä kommentoida piiloon, sillä kysymisessä ei ole paljoa mieltä,
		//						  jos vastaukset ovat jo tiedossa.
		
		
		//Tässä osiossa kysytään kaikki Visa-olioon tallennetut kysymykset yksi kerrallaan,
		//kysytään vastausvaihtoehtoa ja ilmoitetaan, onko vastaus oikein. Lopullisessa ohjelmassa
		//käyttäjän syöte tarkistettaisiin kiellettyjen merkkien varalta.
		for(int i = 0; i<(tietovisa.getKysymystenMaara());i++) {
			System.out.println("");
			tietovisa.tulosta(i);
			System.out.print("Anna vastausnumero: ");
			vastaus = sc.nextInt();
			tietovisa.tulostaOnkoOikein(i,vastaus);
			if (tietovisa.onkoOikein(i,vastaus)==true) oikein++;
		}
		System.out.println("\nVastasit oikein "+oikein+" kysymykseen.");
		sc.close();
		}
	}

abstract class TietovisaTaulu {
	private static final String kysymykset[][] = {
		{"Javan yritysversio?","1. Java SE","2. Java EE"},
		{"Uusin Java versio?","1. Java SE 8","2. Java SE 12"},
		{"Kuuluisa IDE?","1. Eclipse","2. Sun"},
		{"Javan kehitti alunperin yritys?","1. Moon","2. Star","3. Sun"},
		{"Javasta vastaa nykyisin?","1. IBM","2. Oracle"}
		};
	private static final int vastaukset[] = {
			1,
			2,
			1,
			3,
			2,
	};
	public static void tulostaKysymykset() {
		for(int i = 0; i<kysymykset.length;i++) {
			for(int v = 0;v<kysymykset[i].length;v++) {
				System.out.println(kysymykset[i][v]);
			}
			System.out.println("Oikea vastaus: "+kysymykset[i][vastaukset[i]]);
			
		}
	}
	
	
}


class Visa{
	private ArrayList<Kysymys> kysymykset;
	
	public Visa() {
		kysymykset = new ArrayList<>();
	}
	public void lisaa(Kysymys kysymys) {
		kysymykset.add(kysymys);
	}
	public void tulosta() { //Ilman kysymyksen numeroa tulostuskäsky tulostaa kaikki kysymykset
		int k = 1;
		System.out.println("Lista kysymyksistä:");
		for (Kysymys indeksi : kysymykset) {
				System.out.print("Kysymys "+k+": ");
				indeksi.tulostaKysymys();
				indeksi.tulostaVaihtoehdot();
				System.out.println("Oikea vastaus: "+indeksi.getVastaus(indeksi.getOikeaVastaus())+"\n");
				k++;
				}
		}
	
	public void tulosta(int kysnro) { //Tulostaa yhden kysymyksen, eikä myöskään kerro oikeaa vastausta.
		System.out.println(kysymykset.get(kysnro));
		System.out.println(kysymykset.get(kysnro).getVastaus(1));
		System.out.println(kysymykset.get(kysnro).getVastaus(2));
		System.out.println(kysymykset.get(kysnro).getVastaus(3));
		}
	
	public int getKysymystenMaara() {
		return kysymykset.size();
	}
	
	
	public void tulostaOnkoOikein(int kysnro, int vaihtoehto) {
		if(kysymykset.get(kysnro).getOikeaVastaus()==vaihtoehto) {
			System.out.println("*** "+kysymykset.get(kysnro).getVastaus(vaihtoehto)+" oli oikea vastaus! ***");
		}
		else {
			System.out.println("*** "+kysymykset.get(kysnro).getVastaus(vaihtoehto)+" oli väärä vastaus! ***");
		}
	}
	public boolean onkoOikein(int kysnro, int vaihtoehto) {
		if(kysymykset.get(kysnro).getOikeaVastaus()==vaihtoehto) {
			return true;
		}
		else {
			return false;
		}
	}
	
	}


class Kysymys { //Kysymys-luokkaan tallennetaan kysymyksiä kolmen vastausvaihtoehdon kera. Vaihtoehtojen määrää
				//ei voi muuttaa, mutta useimmiten tietovisoissa lienee vakiomäärä vastausvaihtoehtoja.
	private String kysymys;
	private String vastaus1;
	private String vastaus2;
	private String vastaus3;
	private int oikea;
	
	public Kysymys(String kysymys, String vastaus1, String vastaus2, String vastaus3, int oikea) {
		this.kysymys = kysymys;
		this.vastaus1 = vastaus1;
		this.vastaus2 = vastaus2;
		this.vastaus3 = vastaus3;
		this.oikea = oikea;
	}
	
	public String toString() {
	return kysymys;
	}
	
	public void tulostaKysymys() {
		System.out.println(kysymys);
	}
	
	public void tulostaVaihtoehdot() {
		System.out.println("Vastausvaihtoehto 1: "+vastaus1);
		System.out.println("Vastausvaihtoehto 2: "+vastaus2);
		System.out.println("Vastausvaihtoehto 3: "+vastaus3);
	}
	
	public int getOikeaVastaus() {
		return oikea;
	}
	public String getVastaus(int numero) {
		switch(numero) {
		case 1: return "1. " +vastaus1;
		case 2: return "2. " +vastaus2;
		case 3: return "3. " +vastaus3;
		default : return null;
		}
}
}

