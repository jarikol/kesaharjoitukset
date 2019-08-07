package kesaharjoitukset;

public class K9_LuokanOppilas {
	public static void main(String[] args) {
		LuokanOppilas matti = new LuokanOppilas("Matti", true);
		LuokanOppilas pekka = new LuokanOppilas("Pekka", false);
		LuokanOppilas kaarina = new LuokanOppilas("Kaarina", false);
		LuokanOppilas aino = new LuokanOppilas("Aino", false);
		LuokanOppilas annikki = new LuokanOppilas("Annikki", true);
		matti.tulosta();
		pekka.setIstuu(true);
		pekka.tulosta();
		annikki.setIstuu(false);
		aino.tulosta();
		annikki.tulosta();
		System.out.println(matti);
		System.out.println(pekka);
		System.out.println(kaarina);
		// Lisätehtävä
		System.out.println("Luokassa on oppilaita on yhteensä " + LuokanOppilas.oppilaitaYhteensa() + " kappaletta");

	}
		
}

class LuokanOppilas {
	String nimi;
	boolean istuu;
	static int maara = 0;
	
	public LuokanOppilas(String nimi, boolean istuu) {
		this.nimi = nimi;
		this.istuu = istuu;
		LuokanOppilas.maara++;
	}
	
	public void setIstuu(boolean istuuko) {
		this.istuu = istuuko;
	}
	public String toString() {
		if(this.istuu == false) return nimi + " ei istu.";
		else return nimi + " istuu.";
	}
	
	public void tulosta() {
		if(this.istuu == false) System.out.println(nimi + " ei istu.");
		else System.out.println(nimi + " istuu.");
	}
	
	public static int oppilaitaYhteensa() { //Staattinen metodi palauttaa oppilaiden
		return maara;						//määrän, vaikka pääohjelma ei kerro,
	}										//mitä oliota (oppilasta) kysymys koskee.
}
