package cashmanager.cashmanager;

public class Konto {
	
	private String name;
	private double kontostand;
	private char typ;
	
	private Umbuchung umbuchung = new Umbuchung();
	private EinAus einaus = new EinAus();
	private Budget budget = new Budget();
	
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

	public Umbuchung getUmbuchung() {
		return umbuchung;
	}

	public void setUmbuchung(Umbuchung umbuchung) {
		this.umbuchung = umbuchung;
	}

	public EinAus getEinaus() {
		return einaus;
	}

	public void setEinaus(EinAus einaus) {
		this.einaus = einaus;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}
}
