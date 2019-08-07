/**
 * 
 */
package kesaharjoitukset;

/**
 * @author jarik
 *
 */
public class K8_Kissa_ja_Koira {
	public static void main(String[] args) {
		Kissa katti = new Kissa("Katti");
		Koira musti = new Koira("Musti");
		System.out.println(katti + "\n" + musti);
		musti.jahtaa(katti);
		katti.karkuun(musti);
	}

}

class Kissa {
	private String nimi;

	public Kissa(String nimi) {
		this.nimi = nimi;
	}

	public String toString() {
		return "Kissa: "+nimi;
	}

	public void karkuun(Koira koira) {
		System.out.println(this.nimi + " juoksee karkuun oliota " + koira);
	}
}

class Koira {
	private String nimi;

	public Koira(String nimi) {
		this.nimi = nimi;
	}
	
	public String toString() {
		return "Koira: "+ nimi;
	}

	public void jahtaa(Kissa kissa) {
		System.out.println(nimi + " jahtaa oliota " + kissa);
	}
}