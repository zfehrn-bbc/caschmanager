package cashmanager.cashmanager;

public class Konto {

	private String name;
	private double kontostand;
	private char typ;

	private Eintrag eintrag;

	public void kontostandAendern() {

	}

	public void neuerEintrag() {

	}

	public void kontoBearbeiten() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getKontostand() {
		return kontostand;
	}

	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}

	public char getTyp() {
		return typ;
	}

	public void setTyp(char typ) {
		this.typ = typ;
	}
	
	public Eintrag getEintrag() {
		return eintrag;
	}

	public void setEintrag(Eintrag eintrag) {
		this.eintrag = eintrag;
	}
	

	public String toString() {
		String p;
		p = "Kotnoname: "+this.getName()+"\n";
		p += "Kontostand: " + this.getKontostand()+"\n";
		p += "Typ: " + this.getTyp()+"\n";

		return p;
	}
}
