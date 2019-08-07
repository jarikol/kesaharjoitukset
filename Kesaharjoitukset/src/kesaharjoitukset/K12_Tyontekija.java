package kesaharjoitukset;

import java.util.ArrayList;

public class K12_Tyontekija {
	public static void main(String args[]) {
		Tyontekija aku = new Tyontekija("Aku Ankka");
		Osoite kotiOsoite = new Osoite("Ankkalinna","43210", "Ankkakuja 46 B", "KOTI");
		Osoite tyoOsoite  = new Osoite("Ankkalinna","43210", "Rahasäiliönkatu 1 B", "Työ");
		Puhelinnumero kotiPuhelin = new Puhelinnumero(0453245, "Koti");
		Puhelinnumero matkaPuhelin = new Puhelinnumero(0403245, "KOTI");
		
		aku.lisaaOsoite(kotiOsoite);
		aku.lisaaOsoite(tyoOsoite);
		aku.lisaaPuhelinnumero(kotiPuhelin);
		aku.lisaaPuhelinnumero(matkaPuhelin);
		System.out.println(aku);
		
	}
}
class Tyontekija {
	private String nimi;
	private ArrayList<Osoite> osoitteet;
	private ArrayList<Puhelinnumero> puhelimet;
	
	public Tyontekija (String nimi) {
		this.nimi = nimi;
		this.osoitteet = new ArrayList<Osoite>();
		this.puhelimet = new ArrayList<Puhelinnumero>();
	}
	
	public void lisaaOsoite(Osoite osoite) {
		this.osoitteet.add(osoite);
	}
	
	public void lisaaPuhelinnumero(Puhelinnumero numero) {
		this.puhelimet.add(numero);
	}
	
	public String toString() {
		return "Työntekijä:\n[Nimi="+this.nimi+",\nosoitteet="+osoitteet.toString()+"\npuhelinnumerot="+puhelimet.toString();
	}

}

class Osoite {
	private String postitoimipaikka;
	private String postinumero;
	private String katuosoite;
	private String tyyppi;
	
	public Osoite(String kaupunki, String postinro, String katuosoite, String tyyppi) {
		this.postitoimipaikka = kaupunki;
		this.postinumero = postinro;
		this.katuosoite = katuosoite;
		this.tyyppi = tyyppi;
	}
	
	public String toString() {
		return "Osoite: [postitoimipaikka="+this.postitoimipaikka+", postinumero= "+this.postinumero
				+", katuosoite="+this.katuosoite+", tyyppi="+this.tyyppi+"]";
	}
}

class Puhelinnumero {
	private int numero;
	private String tyyppi;
	
	public Puhelinnumero(int numero, String tyyppi) {
		this.numero = numero;
		if (tyyppi.equalsIgnoreCase("MATKA")) this.tyyppi = "Matka";
		else if (tyyppi.equalsIgnoreCase("KOTI")) this.tyyppi = "Koti";
		else if (tyyppi.equalsIgnoreCase("TYÖ")) this.tyyppi = "Työ";
		else this.tyyppi = null;
		}

	
	public String toString() {
		return "Puhelin: ["+this.numero+", "+this.tyyppi+"]";
	}
}