//jarikol
package kesaharjoitukset;

import java.util.Scanner;

import yleiset.Tarkista;

public class K1_Bensankulutus {
	
	public static void main (String[] args) {
		Scanner skanneri = new Scanner(System.in);
		String str;
		double kulutus, matka, hinta; 
		
		while (true) {
			System.out.print("Anna kulutus per 100 km tai lopeta kirjoittamalla 'lopeta': ");
			str = skanneri.nextLine();
			if(Tarkista.onkoPositiivinenDouble(str)==true) {
				kulutus = Double.parseDouble(str);
			}
			else if( str.equals("lopeta")) break;
			else continue;
			
			System.out.print("Annna bensan hinta e/litra: ");
			str = skanneri.nextLine();
			if (Tarkista.onkoPositiivinenDouble(str)==true) {
				hinta = Double.parseDouble(str);
			} else continue;
			
			System.out.print("Anna matkan pituus km: ");
			str = skanneri.nextLine();
			if (Tarkista.onkoPositiivinenDouble(str)==true) {
				matka = Double.parseDouble(str);
			} else continue;
		System.out.printf("\nBensan kulutus on %.2f litraa.\nMatkalle tulee hintaa %.2f euroa.\n\n",(kulutus*matka/100),(hinta*kulutus*matka/100));
		
		}
		
		skanneri.close();
				
	}

}
