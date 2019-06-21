/**
 * 
 */
package kesaharjoitukset;

/**
 * @author jarik
 *
 */
public class K2_Bensatankki {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bensatankki tankki = new Bensatankki(60, 30);
		Bensatankki tankki2 = new Bensatankki (50, 27.5);
		
		System.out.println(tankki);
		System.out.println(tankki2);

	}

}

class Bensatankki {
	private double tilavuus;
	private double bensanMaara;
	
	public Bensatankki(double tilavuus, double maara) {
		this.tilavuus = tilavuus;
		this.bensanMaara = maara;
	}
	
	public double getTilavuus() {
		return tilavuus;
	}
	
	public void setTilavuus(double syote) {
		this.tilavuus = syote;
	}
	
	public double getMaara() {
		return this.bensanMaara;
	}
	
	public void setMaara(double syote) {
		this.bensanMaara = syote;
	}
	
	public String toString() {
		return "Bensatankin tilavuus on "+ this.tilavuus +" litraa, ja siellä on "+this.bensanMaara+" litraa bensaa.";
	}
}
