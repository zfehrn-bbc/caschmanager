package cashmanager.cashmanager;

public class Budget extends Eintrag {
	
	private int intervall = 0;
	
	@Override
	public double betragAendern() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void eintragLoeschen() {
		// TODO Auto-generated method stub
		
	}

	public int getIntervall() {
		return intervall;
	}

	public void setIntervall(int intervall) {
		this.intervall = intervall;
	}
	
	public String toString() {
		String p;
		p = "Budget:\n" + this.getName();
		p = p + "\nIntervall: " + this.getIntervall()+"\n";
		p = p + "Budget: " + this.getBetrag();
		return p;
	}


}
