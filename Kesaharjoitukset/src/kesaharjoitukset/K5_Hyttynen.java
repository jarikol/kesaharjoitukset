package kesaharjoitukset;

public class K5_Hyttynen {
	public static void main(String[] args) {
		Hyttynen hyt = new Hyttynen();
		hyt.synny();
		hyt.lenna();
		hyt.ime("hirvi");
		hyt.lenna();
		hyt.ime("ihminen");
		hyt.kuole();
	}

}

class Hyttynen {
	public void synny() {
		System.out.println("Hyttynen syntyy");
	}
	
	public void lenna() {
		System.out.println("Hyttynen lentää");
	}
	
	public void ime(String syote) {
		System.out.println("Hyttynen imee "+syote);
		
	}
	public void kuole() {
		System.out.println("Hyttynen kuolee");
		
	}
}

