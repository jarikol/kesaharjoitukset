package kesaharjoitukset;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class K11_TilastoBean {
	public static void main(String[] args) {
		TilastoBean sb = new TilastoBean();
		sb.setLukuMerkkijono("400,500,600,700,800,900,1000,1100,1200");
		System.out.println(sb.getLuku(0));
		System.out.println(sb.getLuku(1));
		System.out.println(sb.getLuku(2));
		System.out.println(sb.getKoko());

		System.out.println("keskiarvo=" + sb.getSumma());
		System.out.println("keskiarvo=" + sb.getKeskiarvo());
		
		System.out.println(sb);
		//Lisätehtävien tulostus
		System.out.println("Minimiarvo: "+sb.getMinimi());
		System.out.println("Maksimiarvo: "+sb.getMaksimi());
		System.out.println("Varianssi: "+sb.getVarianssi());
		System.out.println("Keskihajonta: "+sb.getKeskihajonta());
	}

}

class TilastoBean {
	private String[] jono;

	public void setLukuMerkkijono(String jono) {
		this.jono = jono.split(",");

	}

	public double getLuku(int indeksi) {
		return Double.parseDouble(jono[indeksi]);
	}

	public int getKoko() {
		return jono.length;
	}

	public double getSumma() {
		double summa = 0;
		int i = 0;
		while (i < jono.length) {
			summa = summa + Double.parseDouble(jono[i]);
			i++;
		}
		return summa;
	}

	public double getKeskiarvo() {
		double summa = 0;
		int i = 0;
		while (i < jono.length) {
			summa = summa + Double.parseDouble(jono[i]);
			i++;
		}
		return (summa / jono.length);
	}
	public String toString() {
		String tuloste = "";
		// Muutetaan String[] -muotoinen taulu Double[] -tauluksi
		Double [] doublejono = new Double[jono.length];
		for (int i = 0; i<jono.length;i++) {
			doublejono[i] = Double.parseDouble(jono[i]);
		}
		//Tehdään double-lukuja sisältävä lista-muuttuja, johon sijoitetaan
		//äskeisen Double[] -taulun arvot. Tämä lista saadaan järjestykseen
		//sort-komennolla.
		List<Double> lista = Arrays.asList(doublejono);
		Collections.sort(lista);
		//Lopuksi muodostetaan palautettava string, joko siis sisältää jokaisen
		//listalla olleen luvun ja niiden välissä pilkun.
		for(int i = 0; i<jono.length; i++) {
			if(tuloste != "") tuloste = tuloste + ",";
			tuloste = tuloste + lista.get(i);
		}
		return tuloste;
	}
	
	public double getMaksimi() {
		Double [] doublejono = new Double[jono.length];
		for (int i = 0; i<jono.length;i++) {
			doublejono[i] = Double.parseDouble(jono[i]);
		}
		List<Double> lista = Arrays.asList(doublejono);
		Collections.sort(lista);
		return lista.get(doublejono.length-1);
	}
	
	public double getMinimi() {
		Double [] doublejono = new Double[jono.length];
		for (int i = 0; i<jono.length;i++) {
			doublejono[i] = Double.parseDouble(jono[i]);
		}
		List<Double> lista = Arrays.asList(doublejono);
		Collections.sort(lista);
		return lista.get(0);
	}
	
	public double getVarianssi() {
		double summa=0;
		double varianssi=0;
		Double [] doublejono = new Double[jono.length];
		for (int i = 0; i<jono.length;i++) {
			doublejono[i] = Double.parseDouble(jono[i]);
		}
		//Tässä lasketaan hajontojen summa luupilla, joka lisää aina seuraavan alkion etäisyyden keskiarvosta korotettuna
		//toiseen potenssiin summa-nimiseen  		  ______________________________
		//muuttujaan.								 |       n						|
		// Siis 									 |	SUMMA[(x(i)-keskiarvo)^2]	|
		//											 |	  i=1						|
		//											 |______________________________|
		//                                           Tässä x(i) on siis: 1. arvo x(1), 2. arvo x(2) ... x(n).	
		for (int i = 0; i<doublejono.length;i++) {
			summa = summa + Math.pow((doublejono[i]-this.getKeskiarvo()), 2);
		}
		//Varianssi lasketaan jakamalla tämä summa alkioiden määrällä. Length:stä vähennetään 1, jos halutaan
		//"sample variance". Ilman vähennystä varianssi on tyyppiä "population variance"
		varianssi = summa/(doublejono.length/*-1*/);
		return varianssi;
	}
	
	public double getKeskihajonta() {
		return Math.sqrt(this.getVarianssi());
	}
	

}
