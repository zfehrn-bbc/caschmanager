package cashmanager.cashmanager;

public class Benutzer {
	
	private int id = 0;	
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		String p;
		p = "Name: "+this.getName()+ "\n";
		
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
	
}
