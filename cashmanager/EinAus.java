package ch.berufsbildungscenter.cashmanager;

public class EinAus extends Eintrag {
	
	private char typ;
	
	@Override
	public double betragAendern() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void eintragLoeschen() {
		// TODO Auto-generated method stub
		
	}

	public char getTyp() {
		return typ;
	}

	public void setTyp(char typ) {
		this.typ = typ;
	}
	
}
