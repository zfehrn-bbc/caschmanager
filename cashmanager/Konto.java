package cashmanager.cashmanager;

public class Konto {

	private int id = 0;
	private String name;
	private double kontostand;
	private String typ;

	private Benutzer benutzer;
	private Eintrag eintrag;

	public void kontostandAendern() {
		this.getKontostand();
	}

	public void neuerEintrag() {
		
	}

	public void kontoBearbeiten() {
		
	}
	
	public Konto(int id, String name, double kontostand, String typ, Benutzer benutzer) {
		this.setId(id);
		this.setName(name);
		this.setKontostand(kontostand);
		this.setTyp(typ);
		this.setBenutzer(benutzer);		
	}
	
	public Konto() {
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

	public String getTyp() {
		return typ;
	}

	public void setTyp(String string) {
		this.typ = string;
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

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
}
