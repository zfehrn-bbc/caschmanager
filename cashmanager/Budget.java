package cashmanager.cashmanager;

import java.util.Calendar;
import java.util.Date;

public class Budget extends Eintrag {
	
	private java.util.Date utildatum = Calendar.getInstance().getTime();
	
	private java.sql.Date vonBudget = new java.sql.Date(utildatum.getTime());
	private java.sql.Date bisBudget = new java.sql.Date(utildatum.getTime());
	
	@Override
	public double betragAendern() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void eintragLoeschen() {
		// TODO Auto-generated method stub
		
	}

	
	
	public String toString() {
		String p;
		p = "Budget:\n" + this.getName();
		p = p + "\nIntervall: " + this.getVonBudget().toString() + " bis " + this.getBisBudget().toString() +"\n";
		p = p + "Budget: " + this.getBetrag();
		return p;
	}

	public Date getVonBudget() {
		return vonBudget;
	}

	public void setVonBudget(java.sql.Date vonBudget) {
		this.vonBudget = vonBudget;
	}

	public Date getBisBudget() {
		return bisBudget;
	}

	public void setBisBudget(java.sql.Date bisBudget) {
		this.bisBudget = bisBudget;
	}


}
