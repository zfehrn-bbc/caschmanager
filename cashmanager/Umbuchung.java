package cashmanager.cashmanager;

public class Umbuchung extends Eintrag {
	
	private Konto startkonto;
	private Konto zielkonto;
	
	@Override
	public double betragAendern() {
		return 0;
	}
	
	@Override
	public void eintragLoeschen() {
		// TODO Auto-generated method stub
	}

	public Konto getStartkonto() {
		return startkonto;
	}

	public void setStartkonto(Konto startkonto) {
		this.startkonto = startkonto;
	}

	public Konto getZielkonto() {
		return zielkonto;
	}

	public void setZielkonto(Konto zielkonto) {
		this.zielkonto = zielkonto;
	}
	public String toString(){
		String p;
		p = "Betrag: " + this.getBetrag();
		p += "Name: " + this.getName();
		p += "StartKonto : "+this.getStartkonto()+ "\n";
		p += "ZielKonto: " + this.getZielkonto();
		return p;
}
} 