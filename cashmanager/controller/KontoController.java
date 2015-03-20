package cashmanager.cashmanager.controller;

import cashmanager.cashmanager.Benutzer;
import cashmanager.cashmanager.dao.BenutzerDao;
import cashmanager.cashmanager.dao.BenutzerJDBCDao;
import cashmanager.cashmanager.dao.BudgetDao;
import cashmanager.cashmanager.dao.BudgetJDBCDao;
import cashmanager.cashmanager.dao.EintragDao;
import cashmanager.cashmanager.dao.EintragJDBCDao;
import cashmanager.cashmanager.dao.KontoDao;
import cashmanager.cashmanager.dao.KontoJDBCDao;
import cashmanager.cashmanager.dao.UmbuchungDao;
import cashmanager.cashmanager.dao.UmbuchungJDBCDao;

public class KontoController {
	private final BenutzerDao benutzerjdbc = new BenutzerJDBCDao();
	private final BudgetDao budgetjdbc = new BudgetJDBCDao();
	private final EintragDao eintragjdbc = new EintragJDBCDao();
	private final KontoDao kontojdbc =  new KontoJDBCDao();
	private final UmbuchungDao umbuchungjdbc =  new UmbuchungJDBCDao();
	
	public void createBenutzer(Benutzer b) {
		
	}
	
	public void loadBenutzer(Benutzer b) {
		
	}
	
	public void deleteBenutzer(Benutzer b) {
		
	}
	
	public void createKonto() {
		
	}
	
	public void loadKonto() {
		
	}
	
	public void deleteKonto() {
		
	}
	
	public void createEintrag() {
		
	}
	
	public void loadAll() {
		
	}
	
}
