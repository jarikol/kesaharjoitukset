package kesaharjoitukset;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class K18_SaanMittaustulokset {
    public static void main(String args[]) {
        Mittaussarja sarja = new Mittaussarja();
		sarja.setMittaustulos("8.4.2019", "00:00", 0.9, 0.0);
		sarja.setMittaustulos("8.4.2019", "02:00", 0.8, 0.2);
		sarja.setMittaustulos("8.4.2019", "04:00", 0.7, 0.0);
		sarja.setMittaustulos("8.4.2019", "06:00", 0.6, 0.0);
		sarja.setMittaustulos("8.4.2019", "08:00", 0.7, 0.0);
		sarja.setMittaustulos("8.4.2019", "10:00", 1.1, 0.0);
		sarja.setMittaustulos("8.4.2019", "12:00", 1.9, 0.0);
		sarja.setMittaustulos("8.4.2019", "14:00", 2.5, 0.0);
		sarja.setMittaustulos("8.4.2019", "16:00", 2.8, 0.0);
		sarja.setMittaustulos("8.4.2019", "18:00", 2.4, 0.2);
		sarja.setMittaustulos("8.4.2019", "20:00", 2.5, 1.0);
		sarja.setMittaustulos("8.4.2019", "22:00", 2.7, 0.2);
		sarja.setMittaustulos("9.4.2019", "00:00", 2.7, 0.0);
		sarja.setMittaustulos("9.4.2019", "02:00", 2.4, 0.0);
		sarja.setMittaustulos("9.4.2019", "04:00", 2.2, 0.0);
		sarja.setMittaustulos("9.4.2019", "06:00", 1.9, 0.0);
		sarja.setMittaustulos("9.4.2019", "08:00", 1.7, 0.2);
		sarja.setMittaustulos("9.4.2019", "10:00", 1.8, 0.0);
		sarja.setMittaustulos("9.4.2019", "12:00", 2.2, 0.4);

      
		System.out.println("***Ei sorttausta, tulostus tallennusajan mukaan ***");
		System.out.println(sarja);
		System.out.println("   ***Sorttaus lämpötilan mukaan***");    
		sarja.sortLampotila();
		System.out.println(sarja);
		System.out.println("   ***Sorttaus sademäärän mukaan***");
		sarja.sortSademaara();
		System.out.println(sarja);
		System.out.println("   ***Sorttaus aikaleiman mukaan***");
		sarja.sortAikaleima();
		System.out.println(sarja);

    }
}

class Mittaus { // Tämä luokka tallentaa yksittäisen mittaustuloksen
	private String[] pvm;
	private int paiva;
	private int kk;
	private int vuosi;
	private String[] klo;
	private int tunnit;
	private int minuutit;
	private double temp;
	private double sade;
	private GregorianCalendar kalenteri;
	private SimpleDateFormat ajankohta = new SimpleDateFormat("d.M.yyyy HH:mm");

	public Mittaus(String pvm, String klo, double temp, double sade) {
		// Ensiksi perusjutut eli mittauksen lämpö- ja sadetiedot talteen:
		this.temp = temp;
		this.sade = sade;
		
		// Sitten aloitetaan kalenterileikki.
		// Hajotetaan ensin syötetty päivämäärä String[] -muuttujaksi:
		this.pvm = pvm.split("\\.");
		
		// Tämän jälkeen parsitaan String[] -muuttujasta int-arvot paiva, kk, ja vuosi-muuttujiin.
		this.paiva= Integer.parseInt(this.pvm[0]);
		this.kk= Integer.parseInt(this.pvm[1]) - 1; // Jostain syystä GregorianCalendar aloittaa kk:n laskemisen 0:sta
		this.vuosi= Integer.parseInt(this.pvm[2]);
		
		// Sitten sama kellonajalle:
		this.klo = klo.split(":");
		this.tunnit = Integer.parseInt(this.klo[0]);
		this.minuutit = Integer.parseInt(this.klo[1]);

		// Lopuksi syötetään arvot GregorianCalendar -muuttujaan:
		kalenteri = new GregorianCalendar();
		kalenteri.set(this.vuosi, this.kk, this.paiva, this.tunnit, this.minuutit, 0);

	}
	public GregorianCalendar getMittausaika() {
		return kalenteri;
	}
	
	public long getMittausaikaAbs() { 		// Tämä palauttaa absoluuttisen mittausajan, sitä
		return kalenteri.getTimeInMillis(); // tarvitaan sortatessa mittauksia ajan mukaan.
	}
	
	public double getLampotila() {
		return temp;
	}
	public double getSademaara() {
		return sade;
	}
	public String toString() {
		return this.temp+",\t"+this.sade+",\t"+ajankohta.format(kalenteri.getTime());
	}
}

class Mittaussarja { // Tämä luokka hallitsee koko mittaussarjaa, ja koostuu yksittäisistä Mittaus-olioista
	private ArrayList<Mittaus> tulokset;
	
	public Mittaussarja() {
		this.tulokset = new ArrayList<Mittaus>();
	}
	
	public void setMittaustulos (String pvm, String klo, double temp, double sade) {
		tulokset.add(new Mittaus(pvm, klo, temp, sade));
	}
	
	public String toString() {
		String output ="";
		int hashtag = 1; // Lisätty lukemisen helpottamiseksi juokseva numerointi kullekin mittaukselle
		for (Mittaus indeksi : tulokset) {
				output= output+"# "+hashtag+":\t"+indeksi+"\n";
				hashtag++;
	}
		return output;
	}
		public List<Mittaus> getMittaukset() {
		List<Mittaus> output = new ArrayList<Mittaus>();
		for (int i = 0; i<tulokset.size(); i++) {
			output.add(tulokset.get(i));
			}
		return output;
		}
		
		private List<Double> getLampotilat() { // Privaatti metodi, vältetään turhia rajapintoja ulospäin luokasta.
		List<Double> output = new ArrayList<Double>();
		for (int i = 0; i<tulokset.size(); i++) {
			output.add(tulokset.get(i).getLampotila());
			}
		return output;
		}
		
		private List<Double> getSademaarat() { // Privaatti metodi, vältetään turhia rajapintoja ulospäin luokasta.
		List<Double> output = new ArrayList<Double>();
		for (int i = 0; i<tulokset.size(); i++) {
			output.add(tulokset.get(i).getSademaara());
			}
		return output;
		}
		
		private List<Long> getAjat() { // Privaatti metodi, vältetään turhia rajapintoja ulospäin luokasta.
		List<Long> output = new ArrayList<Long>();
		for (int i = 0; i<tulokset.size(); i++) {
			output.add(tulokset.get(i).getMittausaikaAbs());
			}
		return output;
		}

		public void sortLampotila() { // Sorttaus lämpötilan mukaan suurimmasta pienimpään - muuttaa sisäisen järjestyksen, eikä palauta mitään.
			// Tehdään yksi indeksimuuttuja a, sekä temppitaulu, johon kopioidaan yksitellen
			// mittausarvoja pienimmästä suurimpaan.
			int a = 0;
			ArrayList<Mittaus> temppitaulu = new ArrayList<Mittaus>();
			
			// Tehdään vielä lämpötilataulu, johon kopioidaan kaikki lämpötilat mittaukset sisältävästä
			// Tulos -taulusta. Idea on se, että lämpötilat kopioituvat samassa järjestyksessä, jolloin
			// lämpötilojen vertailulla saadulla indeksillä voidaan hakea koko mittausta
			// Tulos-taulusta.
			List<Double> lampotilataulu = this.getLampotilat();
			
			// Tehdään luuppi, jossa indeksimuuttuja a saa sen indeksin arvon, joka lämpötilataulua
			// vertailtaessa paljastuu kaikista suurimmaksi. Tämän jälkeen lämpötilatauluun tallennetaan
			// kyseiseen kohtaan mielivaltaisen pieni luku, jolloin se ei tule uudestaan valituksi.
			for (int i = 0; i<lampotilataulu.size();i++) {
			a = lampotilataulu.indexOf(Collections.max(lampotilataulu));
			temppitaulu.add(tulokset.get(a));
			lampotilataulu.set(a, (double) -999999999);
			a = 0;
			}
			
			// Edellisessä luupissa tyhjään temppitauluun tallennetaan yksi kerrallaan indeksimuuttujan
			// avulla löydetty suurin lämpötila. Lopussa tämä temppitaulu kopioidaan varsinaiseksi
			// Tulos-tauluksi.
			this.tulokset = temppitaulu;
		}
		
		public void sortSademaara() { // Tämä samalla tavalla kuin lämpötilan sorttaus
			int a = 0;
			ArrayList<Mittaus> temppitaulu = new ArrayList<Mittaus>();
			List<Double> sademaarataulu = this.getSademaarat();
			for (int i = 0; i<sademaarataulu.size();i++) {
			a = sademaarataulu.indexOf(Collections.max(sademaarataulu));
			temppitaulu.add(tulokset.get(a));
			sademaarataulu.set(a, (double) -999999999);
			a = 0;
			}
			this.tulokset = temppitaulu;
		}
		
		public void sortAikaleima() { // Tämä samalla tavalla kuin lämpötilan sorttaus
			int a = 0;
			ArrayList<Mittaus> temppitaulu = new ArrayList<Mittaus>();
			List<Long> aikataulu = this.getAjat();
			for (int i = 0; i<aikataulu.size();i++) {
			a = aikataulu.indexOf(Collections.max(aikataulu));
			temppitaulu.add(tulokset.get(a));
			aikataulu.set(a, (long) 1);
			a = 0;
			}
			this.tulokset = temppitaulu;
		}
		

}
