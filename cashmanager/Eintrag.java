package cashmanager.cashmanager;

import java.util.Date;

public abstract class Eintrag {
	
	private double betrag;
	private String kategorie;
	private String name;
	private Date datum = new Date();
	
	public abstract double betragAendern();
	
	public abstract void eintragLoeschen();

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public String toString() {
		String p;
		p = this.getKategorie()+"\n";
		p += this.getDatum();
		p += this.getBetrag();
		p += this.getName();
		return p;
	}
	
}
