package kesaharjoitukset;

public class K10_Omenat_ja_Kori {

	public static void main(String[] args) {
		Omena omppu1 = new Omena("Aino", 120);
		Omena omppu2 = new Omena("Amorosa", 80);
		Omena omppu3 = new Omena("Ola", 420);
		Kori omenakori = new Kori("Pärekori");
		omenakori.lisaaOmena(omppu1);
		omenakori.lisaaOmena(omppu2);
		omenakori.lisaaOmena(omppu3);
		omenakori.lisaaOmena(new Omena("Raike", 210));
		
		omenakori.lisaaOmena(new Omena("Valkea kuulas", 120.05));
		omenakori.lisaaOmena(new Omena("Åkero", 120));

		System.out.println(omenakori);
	}


}


class Omena {
	private String nimi;
	private double paino;
	
	public Omena(String nimi, double paino) {
		this.nimi = nimi;
		this.paino = paino;
	}
	
	public String toString() {
		return nimi +", "+ paino;
	}
	
	public double getPaino() {
		return paino;
	}
}

class Kori {
	private String malli;
	private Omena[] omenat;
	private String omenalista = "";
	private double korinPaino = 0;
	private int indeksi = 0;
	private static int KOKO = 6; // korin maksimi koko
	
	public Kori(String malli) {
		this.malli = malli;
		omenat = new Omena[KOKO];
	}
	public void lisaaOmena(Omena omena) {
		this.omenat[indeksi] = omena;
		indeksi++;
		korinPaino = korinPaino + omena.getPaino();
		if(omenalista.equals("")) omenalista = "["+omena.toString()+"]";
		else omenalista = omenalista+ ", ["+omena.toString()+"]";
	}
	
	public String toString() {
		return "Kori ["+malli+"], omenien yhteispaino "+korinPaino+"g.\nKorissa omenat = ["+omenalista+"]";
	}
}

