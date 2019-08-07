/**
 * 
 */
package kesaharjoitukset;

/**
 * @author jarik
 *
 */
public class K6_Kruunu_vai_klaava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Kolikko k = new Kolikko();
		int kruunu = 0;
		int klaava = 0;
		int arvo;
		int heittoja = 1000000;

		for (int i = 1; i <= heittoja; i++) {
			k.heita();
			arvo = k.palautaArvo();
			if (arvo == 0)
				kruunu++;
			else
				klaava++;
		}
		System.out.println("Heittoja : " + heittoja);
		System.out.println("Kruunuja: " + kruunu);
		System.out.println("Klaavoja : " + klaava);
	}

}

class Kolikko {
	private int arvo;
	
	public void heita() {
		arvo = (int) Math.round(Math.random());
	}
	
	public int palautaArvo(){
		return arvo;
	}

}