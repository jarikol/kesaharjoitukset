package yleiset;

public abstract class LuvunMuunnin {
	
	public static String muunnaHeksaluvuksi(int syote) {
		return Integer.toHexString(syote);
	}
	
	public static String muunnaBinaariluvuksi(int syote) {
		return Integer.toBinaryString(syote);
	}
	
	public static String muunnaOktaaliluvuksi(int syote) {
		return Integer.toOctalString(syote);
	}

}
