package kesaharjoitukset;

public class K4_Karpanen {
	public static void main(String[] args) {
		Karpanen k = new Karpanen();
		k.suhise();
		k.lenna();
		k.syo("keitto");
		k.syo("juusto");
	}

}

class Karpanen {
	public void suhise() {
		System.out.println("Kärpänen suhisee siivillään.");
	}
	
	public void lenna() {
		System.out.println("Kärpänen lentää");
	}
	
	public void syo(String syote) {
		System.out.println("Karpanen syo "+syote);
		
	}
}

