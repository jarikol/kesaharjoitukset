package kesaharjoitukset;

public class K14_PistePikseli {
		public static void main(String[] a) {
			tulostaPisteet();
			tulostaPisteetPoikkeukset();
		//Tehdään kulmio:
			Piste p1 = new Piste(1,1);
			Piste p2 = new Piste(5,1);
			Piste p3 = new Piste(5,5);
			Kulmio kolmio = new Kulmio(p1, p2, p3);
			System.out.println(kolmio);
		// tehdään kolmiosta nelikulmio:
			kolmio.setKulma(3, new Piste(10,10));
		// tulostuu vain, kun kulmien määrä on kulmio-luokassa
		// vähintään 4.
			System.out.println(kolmio);
		// Tehdään neliö käyttäen tyhjän kulmion konstruktoria ja
		// setKulma -metodia kulmien asettamiseen:
			Kulmio nelio = new Kulmio();
			System.out.println(nelio); //Tämä ei tulosta yhtään kulmaa, sillä null-arvoja ei palauteta.
			nelio.setKulma(0, new Piste(0,0));
			nelio.setKulma(1, new Piste(10,0));
			nelio.setKulma(2, new Piste(10,10));
			nelio.setKulma(3, new Piste(0,10));
			System.out.println(nelio);
		
		}

		static void tulostaPisteet() {
			Piste piste = new Piste();
			System.out.println(piste);
			piste.setPoint(21, 7);
			System.out.println(piste);

			Pikseli pikseli = new Pikseli(12, 5, 9);
			System.out.println(pikseli);

		}

		static void tulostaPisteetPoikkeukset() {
			Piste p1 = new Piste(4, 2);
			Piste p2 = null;

			try {
				p2 = (Piste) p1.clone();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("** P1: **");
			System.out.println(p1);
			System.out.println("** P2: **");
			System.out.println(p2);
			System.out.println("\np1==p2: " + p1.equals(p2));
		}
	}

class Piste {
	private int xPos, yPos;
	
	public Piste() {
		this.xPos = 0;
		this.yPos = 0;
	}
	
	public Piste(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setPoint(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	public String toString() {
		return "X: "+xPos+",\tY:"+yPos;
	}
	
	public Piste clone() {
		return this;
	}

}


class Pikseli extends Piste {
	private int vari;
	public Pikseli() {
		super(0, 0);
		this.vari = 0;
	}
	public Pikseli(int xPos, int yPos, int vari) {
		super(xPos, yPos);
		this.vari = vari;
	}
	public int getVari() {
		return this.vari;
	}
	
	public void setVari(int vari) {
		this.vari = vari;
	}
	
}

class Kulmio {
	private static final int kulmia = 4; // Tähän arvo, joka on vähintään 2
	private Piste[] kulmat;
	
	public Kulmio(Piste p1, Piste p2, Piste p3) {
		// Tämän voi tehdä myös näin, mutta silloin ohjelma palauttaa virheen, jos
		// kulmia - muuttujan arvoksi on annettu muu kuin 3:
		// 		this.kulmat = new Piste[]{p1, p2, p3};
		this.kulmat = new Piste[kulmia];
		this.kulmat[0] = p1;
		this.kulmat[1] = p2;
		// Yksi piste ei epäilemättä voi olla kulmio, mutta 
		// jos kahdenkaan pisteen muodostamaa kuviota (=viivaa) ei voi sanoa kulmioksi,
		// if-lausetta ei tarvita. Tällöin kulmia-muuttujan on oltava vähintään 3.
		if(kulmia>2) this.kulmat[2] = p3;
	}
	
	public Kulmio() {
		this.kulmat = new Piste[kulmia];
//		for(int i = 0; i<kulmia;i++) {
//		this.kulmat = 
//		}
	}
	
	public void setKulma(int indeksi, Piste kulma) {
		// Mahdollistaa kulman asettamisen. Ensimmäisenä parametrinä välitetään kulman
		// indeksinumero ja jälkimmäisenä uusi piste, jonka kulmio tulee saamaan.
		if(indeksi < kulmia) this.kulmat[indeksi] = kulma;
	}
	
	public String toString() {
		String output = "Kulmiosi koordinaatit:\n";
		//Tämän voisi toteuttaa ihan tulostamalla rivit erikseen. Jos kulmio-luokkaa joskus käytetään kolmiota
		//monimutkaisempiin objekteihin, koodia ei tarvitse kirjoittaa uusiksi.
		for(int i=0;i<kulmia;i++) {
			if(kulmat[i]!=null) output = output + kulmat[i]+"\n";
		}
		return output;
	}
}

