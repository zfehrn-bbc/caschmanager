package ch.berufsbildungscenter.cashmanager;

public class Benutzer {
	
	private Konto konto = new Konto();	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Konto getKonto() {
		return konto;
	}
	
}
