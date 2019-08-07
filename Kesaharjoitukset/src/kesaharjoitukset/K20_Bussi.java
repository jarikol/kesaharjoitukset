package kesaharjoitukset;

public class K20_Bussi {
	public static void main(String args[]) {
		Matkustaja pekka = new Matkustaja("Pekka", "Tampere", 35.50);
		Matkustaja aino = new Matkustaja("Aino", "Kerava", 14.30);
		Matkustaja eki = new Matkustaja("Erkki", "Kuopio", 79.40);
		Matkustaja virpi = new Matkustaja("Virpi", "Järvenpää", 18.70);
		Matkustaja aimo = new Matkustaja("Aimo", "Jyväskylä", 52.80);
		Matkustaja emmi = new Matkustaja("Emmi", "Orivesi", 38.20);
		Matkustaja onni = new Matkustaja("Onni", "Tampere", 35.50);

		Bussi pikabussi = new Bussi(11); // 20-paikkainen bussi // Lisätään
											// bussiin kuusi matkustajaa
		pikabussi.lisaaMatkustaja(pekka);
		pikabussi.lisaaMatkustaja(aino);
		pikabussi.lisaaMatkustaja(eki);
		pikabussi.lisaaMatkustaja(virpi);
		pikabussi.lisaaMatkustaja(aimo);
		pikabussi.lisaaMatkustaja(emmi);

		// ja poistetaan viimeksi lisätty
		pikabussi.poistaViimeinen();
		// ja lisätään vielä yksi
		pikabussi.lisaaMatkustaja(onni);

		System.out.println(pikabussi.palautaKaikki());
		System.out.println(pikabussi);
//
//		// Jatkotehtävänä kaksi metodia
//		// Tee metodi, joka laskee, montako paikkaa bussissa on vapaana
//		// Tee metodi, joka laskee bussin matkustajien maksaman yhteishinnan
		System.out.println("vapaat paikat: " + pikabussi.vapaatPaikat());
		System.out.printf("Matkustajien liput maksavat yhteensä %.2f euroa", pikabussi.yhteishinta());

	}
}
