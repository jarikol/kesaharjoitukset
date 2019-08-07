package kesaharjoitukset;

public class Bussi {
	private Matkustaja [] kyydissa;
	private int paikkojenMaara;
	private int varatutPaikat;
	
	public Bussi(int paikat) {
		this.paikkojenMaara = paikat;
		this.varatutPaikat = 0;
		this.kyydissa = new Matkustaja[paikat];
	}
	
	public Bussi() {
		this.varatutPaikat = 0;
		this.paikkojenMaara = 10;
		this.kyydissa = new Matkustaja[10];
	}

	public void lisaaMatkustaja(Matkustaja matkustaja) {
		if(varatutPaikat <paikkojenMaara) {
			kyydissa[varatutPaikat] = matkustaja;
			varatutPaikat++;
		}
	}
	
	public void poistaViimeinen() {
		this.varatutPaikat--;
	}
	
	public int vapaatPaikat() {
		return paikkojenMaara - varatutPaikat;
	}
	
	public String palautaKaikki() {
		String output = "";
		output = "Bussissa on matkustajia "+varatutPaikat+"\n";
		for(int i = 0; i<varatutPaikat; i++) {
			output = output + kyydissa[i].toString()+"\n";
		}
		return output;
	}
	
	public String toString() {
		return "Bussissa on matkustajia "+varatutPaikat + "\n"+ kyydissa;
	}
	public double yhteishinta() {
		double output = 0;
		for(int i = 0; i<varatutPaikat; i++) {
			output = output + kyydissa[i].getHinta();
		}
		return output;
	}
}
