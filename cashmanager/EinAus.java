package cashmanager.cashmanager;

public class EinAus extends Eintrag {
	
	private String typ;
	
	@Override
	public double betragAendern() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void eintragLoeschen() {
		// TODO Auto-generated method stub
		
	}
	
	public EinAus(String typ) {
		this.setTyp(typ);
	}
	
	public EinAus() {
		
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String string) {
		this.typ = string;
	}
	
}
