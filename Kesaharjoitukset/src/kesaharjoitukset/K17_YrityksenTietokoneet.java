package kesaharjoitukset;


public class K17_YrityksenTietokoneet {

	public static void main(String[] args) {
		Tietokone elite = new Tietokone("HP Elitebook", 5, 1650);
		Tietokone mac = new Tietokone("Apple MacBook", 2, 1990);
		Tietokone think = new Tietokone("Lenovo ThinkPad", 3, 1390);
		Tietokone fujitsu = new Tietokone("Fujitsu Siemens", 1, 950);
		Tietokone ideapad = new Tietokone("Lenovo IdeaPad", 2, 550);

		FirmanKoneet koneet = new FirmanKoneet(5);
		koneet.lisaaKone(elite);
		koneet.lisaaKone(mac);
		koneet.lisaaKone(think);
		koneet.lisaaKone(fujitsu);
		koneet.lisaaKone(ideapad);
		System.out.println(koneet);
		System.out.println("hankintahinta yhteensä: " + koneet.yhteisHinta() + " euroa");
	}
}

class Tietokone {
	private double hankintahinta;
	private int ika;
	private String nimi;
	
	public Tietokone(String nimi, int ika, double hinta) {
		this.nimi = nimi;
		this.ika = ika;
		this.hankintahinta = hinta;
	}
	
	public double getHinta() {
		return this.hankintahinta;
	}
	
	public int getIka() {
		return this.ika;
	}
	
	public String getNimi() {
		return this.nimi;
	}
	
	public String toString() {
		return this.nimi + " maksoi\t"+this.hankintahinta+" ja sen ikä on "+this.ika+" vuotta.";
	}
}

class FirmanKoneet {
	private Tietokone[] Tietokone; // Tämä olisi kätevämpi ArrayListillä, jolloin ei tarvitsisi
								   // antaa tietokonetaululle maksimikokoa.
	
	private int uusinLisays; // Tämän avulla pidetään kirjaa siitä, kuinka monta konetta on jo
							 // syötetty, jotta lisää-metodi osaa syöttää uuden koneen oikeaan indeksiin.
							 // Jos koneita pitäisi voida poistaa, ArrayList olisi kätevämpi.
	
	public FirmanKoneet(int maara) {
	this.Tietokone = new Tietokone[maara];
	uusinLisays = 0;
	}
	
	public void lisaaKone(Tietokone kone) {
		this.Tietokone[uusinLisays]=kone;
		uusinLisays++;
	}
	
	public double yhteisHinta() {
		double hinta = 0;
		// Seuraavassa luupissa hyödynnetään uusinLisäys -indeksinumeroa, sillä jos kaikkia listan paikkoja ei
		// olisi täytetty tietokoneilla, ohjelman suoritus päättyisi virheeseen.
		for (int i = 0; i<uusinLisays;i++) {
			hinta = hinta +Tietokone[i].getHinta();
		}
		return hinta;
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i<uusinLisays;i++) {
			output = output + Tietokone[i]+"\n";
		}
		return output;
	}
	
}
