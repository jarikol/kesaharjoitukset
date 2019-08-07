package kesaharjoitukset;

public class Matkustaja {
	private String nimi;
	private String kohde;
	private double hinta;
	
	public Matkustaja(String nimi, String kohde, double hinta) {
		this.nimi = nimi;
		this.kohde = kohde;
		this.hinta = hinta;
	}
	
	public Matkustaja() {}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public void setKohde(String kohde) {
		this.kohde = kohde;
	}
	
	public void setPaikanHinta(double hinta) {
		this.hinta = hinta;
	}
	
	public String toString() {
		return nimi+" matkustaa paikkaan "+kohde+" hintaan "+hinta+ " euroa.";
	}
	
	public double getHinta() {
		return hinta;
	}
	
}
