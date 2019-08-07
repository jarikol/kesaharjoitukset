package kesaharjoitukset;

public class K13_OmaPaivamaara {
	public static void main(String[] args) {
		Paivamaara pvm = new Paivamaara(17, 6, 2019);
		System.out.println(pvm);
		pvm.setPaiva(pvm.getPaiva() +  1);
		System.out.println(pvm.usaFormaatti());
		pvm.setKuukausi(pvm.getKuukausi() +  2);
		System.out.println(pvm.isoFormaatti());

	}

}

class Paivamaara {
	private int kuukausi;
	private int vuosi;
	private int paiva;
	private String paivaNollalla;
	private String kuukausiNollalla;
	
	public Paivamaara(int paiva, int kuukausi, int vuosi) {
		if (paiva < 10) this.paivaNollalla = "0"+paiva;
		else this.paivaNollalla = ""+paiva;
		
		if (kuukausi < 10) this.kuukausiNollalla = "0"+kuukausi;
		else this.paivaNollalla = ""+kuukausi;
		
		this.kuukausi = kuukausi;
		this.paiva = paiva;
		this.vuosi = vuosi;
	}
	
	public int getPaiva() {
		return this.paiva;
	}
	public int getKuukausi() {
		return this.kuukausi;
	}
	public int getVuosi() {
		return this.vuosi;
	}
	
	public void setPaiva(int paiva) {
		this.paiva = paiva;
		if (paiva < 10) this.paivaNollalla = "0"+paiva;
		else this.paivaNollalla = ""+paiva;
	}
	
	public void setKuukausi(int kuukausi) {
		this.kuukausi = kuukausi;
		if (kuukausi < 10) this.kuukausiNollalla = "0"+kuukausi;
		else this.kuukausiNollalla = ""+kuukausi;
	}
	
	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}
	
	public String usaFormaatti() {
		return this.kuukausiNollalla+"/"+this.paivaNollalla+"/"+this.vuosi;
	}
	
	public String isoFormaatti() {
		return this.vuosi+"-"+this.kuukausiNollalla+"-"+this.paivaNollalla;
	}
	
	public String toString() {
		return this.paiva+"."+this.kuukausi+"."+this.vuosi+"   /   "+this.paivaNollalla+"."+this.kuukausiNollalla+"."+this.vuosi;
	}
}