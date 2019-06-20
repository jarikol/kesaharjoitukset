package yleiset;
//TESTI
public abstract class Tarkista {
	private static char DECIM = '.'; // Please set your preferred decimal separator here. Use '.' if using Java native notation
	
	public static void setDecim(char syote) { //Use this only when working with user inputs
		DECIM = syote;
	}

	public static boolean onkoPositiivinenLuku(String merkkijono) { // Palauttaa true, jos positiivinen kokonaisluku
		boolean kirjain = true;
		if (merkkijono.length() == 0)
			return false;
		if (merkkijono.contains(" "))
			return false;
		if (merkkijono.charAt(0) == '-')
			return false;
		if (merkkijono.contentEquals(Character.toString(DECIM)))
			return false;
		if (merkkijono.contentEquals("-"))
			return false;
		if (merkkijono.length() > 10)
			return false; // int -tietotyyppi ei tue 10 numeroa suurempia lukuja
		for (int i = 0; i < merkkijono.length(); i++) {
			if (!(merkkijono.charAt(i) == '0' || merkkijono.charAt(i) == '1' || merkkijono.charAt(i) == '2'
					|| merkkijono.charAt(i) == '3' || merkkijono.charAt(i) == '4' || merkkijono.charAt(i) == '5'
					|| merkkijono.charAt(i) == '6' || merkkijono.charAt(i) == '7' || merkkijono.charAt(i) == '8'
					|| merkkijono.charAt(i) == '9')) {
				kirjain = true;
				break;
			} else
				kirjain = false;
		}
		if (kirjain == true)
			return false;
		else
			return true;

	}

	public static boolean onkoLuku(String merkkijono) { //Palauttaa true, jos kokonaisluku
		boolean kirjain = false;
		if (merkkijono.length() == 0)
			return false;
		if (merkkijono.contains(" "))
			return false;
		if (merkkijono.contentEquals(Character.toString(DECIM)))
			return false;
		if (merkkijono.contentEquals("-"))
			return false;
		if (merkkijono.charAt(0) == '-') {
			if (merkkijono.length() > 11) // tässä 11, koska miinus-merkki on merkki, joka ei sisälly intin pituuteen.
				return false;
			for (int i = 1; i < merkkijono.length(); i++) {
				if (!(merkkijono.charAt(i) == '0' || merkkijono.charAt(i) == '1' || merkkijono.charAt(i) == '2'
						|| merkkijono.charAt(i) == '3' || merkkijono.charAt(i) == '4' || merkkijono.charAt(i) == '5'
						|| merkkijono.charAt(i) == '6' || merkkijono.charAt(i) == '7' || merkkijono.charAt(i) == '8'
						|| merkkijono.charAt(i) == '9')) {
					kirjain = true;
					break;
				} else
					kirjain = false;
			}
		} else {
			if (merkkijono.length() > 10)
				return false;
			for (int i = 0; i < merkkijono.length(); i++) {
				if (!(merkkijono.charAt(i) == '0' || merkkijono.charAt(i) == '1' || merkkijono.charAt(i) == '2'
						|| merkkijono.charAt(i) == '3' || merkkijono.charAt(i) == '4' || merkkijono.charAt(i) == '5'
						|| merkkijono.charAt(i) == '6' || merkkijono.charAt(i) == '7' || merkkijono.charAt(i) == '8'
						|| merkkijono.charAt(i) == '9')) {
					kirjain = true;
					break;
				} else
					kirjain = false;
			}
		}
		if (kirjain == true)
			return false;
		else
			return true;

	}

	public static int parsi(String merkkijono) // Palauttaa syötteen kokonaislukuna, jos se on sellainen. Jos syöte ei
												// ole kokonaisluku, metodi palauttaa -1.
	{
		if (Tarkista.onkoLuku(merkkijono) == true) {
			return Integer.parseInt(merkkijono);
		} else
			return -1;
	}

	public static double parsiDouble(String merkkijono) // Palauttaa syötteen double-lukuna, jos se on sellainen. Jos
														// syöte ei ole double, metodi palauttaa -1.
	{
		if (Tarkista.onkoDouble(merkkijono) == true) {
			if(merkkijono.contains(".")) return Double.parseDouble(merkkijono);
			String[] split = merkkijono.split(Character.toString(DECIM));
			String merkkijonoUusi="-1";
			if(split.length==1) return Double.parseDouble(split[0]);
			else if(split.length==2) {
				merkkijonoUusi=split[0]+"."+split[1];
				return Double.parseDouble(merkkijonoUusi);
			}
			else return -1;
		} else
			return -1;
	}

	public static boolean onkoDouble(String merkkijono) { //Palauttaa true, jos on desimaaliluku
		boolean kirjain = false;
		int pilkku = 0;
		if (merkkijono.length() == 0)
			return false;
		if (merkkijono.contains(" "))
			return false;
		if (merkkijono.contentEquals(Character.toString(DECIM)))
			return false;
		if (merkkijono.contentEquals("-"))
			return false;
		if (merkkijono.charAt(0) == '-') {

			for (int i = 1; i < merkkijono.length(); i++) {
				if (!(merkkijono.charAt(i) == '0' || merkkijono.charAt(i) == DECIM || merkkijono.charAt(i) == '1'
						|| merkkijono.charAt(i) == '2' || merkkijono.charAt(i) == '3' || merkkijono.charAt(i) == '4'
						|| merkkijono.charAt(i) == '5' || merkkijono.charAt(i) == '6' || merkkijono.charAt(i) == '7'
						|| merkkijono.charAt(i) == '8' || merkkijono.charAt(i) == '9')) {
					kirjain = true;
					break;
				} else
					kirjain = false;
				if (merkkijono.charAt(i) == DECIM) {
					pilkku++;
				}
			}
		} else {
			for (int i = 0; i < merkkijono.length(); i++) {
				if (!(merkkijono.charAt(i) == '0' || merkkijono.charAt(i) == DECIM || merkkijono.charAt(i) == '1'
						|| merkkijono.charAt(i) == '2' || merkkijono.charAt(i) == '3' || merkkijono.charAt(i) == '4'
						|| merkkijono.charAt(i) == '5' || merkkijono.charAt(i) == '6' || merkkijono.charAt(i) == '7'
						|| merkkijono.charAt(i) == '8' || merkkijono.charAt(i) == '9')) {
					kirjain = true;
					break;
				} else
					kirjain = false;
				if (merkkijono.charAt(i) == DECIM) {
					pilkku++;
				}
			}
		}
		if (kirjain == true || pilkku > 1)
			return false;
		else
			return true;

	}

	public static boolean onkoPositiivinenDouble(String merkkijono) { //Palauttaa true, jos on positiivinen desimaaliluku
		boolean kirjain = false;
		int pilkku = 0;
		if (merkkijono.length() == 0)
			return false;
		if (merkkijono.contains(" "))
			return false;
		if (merkkijono.contentEquals(Character.toString(DECIM)))
			return false;
		if (merkkijono.contentEquals("-"))
			return false;
		if (merkkijono.charAt(0) == '-')
			return false;
		else {
			for (int i = 0; i < merkkijono.length(); i++) {
				if (!(merkkijono.charAt(i) == '0' || merkkijono.charAt(i) == DECIM || merkkijono.charAt(i) == '1'
						|| merkkijono.charAt(i) == '2' || merkkijono.charAt(i) == '3' || merkkijono.charAt(i) == '4'
						|| merkkijono.charAt(i) == '5' || merkkijono.charAt(i) == '6' || merkkijono.charAt(i) == '7'
						|| merkkijono.charAt(i) == '8' || merkkijono.charAt(i) == '9')) {
					kirjain = true;
					break;
				} else
					kirjain = false;
				if (merkkijono.charAt(i) == DECIM) {
					pilkku++;
				}
			}
		}
		if (kirjain == true || pilkku > 1)
			return false;
		else
			return true;

	}
}
