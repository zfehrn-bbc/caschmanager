package cashmanager.cashmanager;

public class BenutzerTester {

	public static void main(String[] args) {
		
		Benutzer b = new Benutzer();
		b.setName("Oli"); 
		
		b.getKonto().setKontostand(355.00);
		b.getKonto().setName("Sparkonto");
		b.getKonto().setTyp('s');
		
		Budget budget = new Budget();
		budget.setBetrag(300.00);
		budget.setName("Essen: ");
		b.getKonto().setEintrag(budget);
		
		
		System.out.println(b.toString() + budget.toString());

	}

}
