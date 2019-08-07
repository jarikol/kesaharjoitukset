package kesaharjoitukset;

public class K19_Matkustaja {
	public static void main(String[] args) {
		Matkustaja pekka = new Matkustaja();
		pekka.setNimi("Pekka");
		pekka.setKohde("Tampere");
		pekka.setPaikanHinta(35.50);
		
		Matkustaja aino = new Matkustaja();
		aino.setNimi("Aino");
		aino.setKohde("Kerava");
		aino.setPaikanHinta(14.30);

		Matkustaja eki = new Matkustaja();
		eki.setNimi("Erkki");
		eki.setKohde("Kuopio");
		eki.setPaikanHinta(79.40);
		
		Matkustaja virpi = new Matkustaja();
		virpi.setNimi("Virpi");
		virpi.setKohde("Järvenpää");
		virpi.setPaikanHinta(18.70);
		
		Matkustaja aimo = new Matkustaja();
		aimo.setNimi("Aimo");
		aimo.setKohde("Jyväskylä");
		aimo.setPaikanHinta(52.80);
		
		System.out.println(pekka);
		System.out.println(aino);
		System.out.println(eki);
		System.out.println(virpi);
		System.out.println(aimo);
	}

}
