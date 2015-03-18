package cashmanager.cashmanager;

public class Umbuchung extends Eintrag {
	
	private String startkonto;
	private String zielkonto;
	
	@Override
	public double betragAendern() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void eintragLoeschen() {
		// TODO Auto-generated method stub
		
	}

	public String getStartkonto() {
		return startkonto;
	}

	public void setStartkonto(String startkonto) {
		this.startkonto = startkonto;
	}

	public String getZielkonto() {
		return zielkonto;
	}

	public void setZielkonto(String zielkonto) {
		this.zielkonto = zielkonto;
	}
	public String toString(){
		String p;
		p = "StartKonto : "+this.getStartkonto()+ "\n";
		p += this.getZielkonto();
		
		return p;
}
} 