package cashmanager.cashmanager;

public class Benutzer {
	
	private int id = 0;
	private Konto konto = new Konto();	
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Konto getKonto() {
		return konto;
	}
	
	public String toString(){
		String p;
		p = "Name: "+this.getName()+ "\n";
		p += this.getKonto()+ "\n";
		
		return p;
	}

	public void setKonto(Konto konto) {
		this.konto = konto;
	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
}
