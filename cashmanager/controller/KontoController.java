package cashmanager.cashmanager.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import cashmanager.cashmanager.Benutzer;
import cashmanager.cashmanager.Budget;
import cashmanager.cashmanager.EinAus;
import cashmanager.cashmanager.Konto;
import cashmanager.cashmanager.Umbuchung;
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
	private BenutzerDao		benutzerjdbc	= new BenutzerJDBCDao();
	private BudgetDao			budgetjdbc		= new BudgetJDBCDao();
	private EintragDao		eintragjdbc		= new EintragJDBCDao();
	private KontoDao			kontojdbc			= new KontoJDBCDao();
	private UmbuchungDao	umbuchungjdbc	= new UmbuchungJDBCDao();
	
	private Konto					konto;
	private Benutzer			benutzer;
	private EinAus				einaus;
	private Budget				budget;
	private Umbuchung			umbuchung;
	
	private List<Konto>		kontoliste		= new ArrayList<Konto>();
	private List<Object>	allEntries		= new ArrayList<Object>();
	
	public Benutzer loadBenutzer(Benutzer b, int id) {
		b.setId(id);
		try {
			b = BenutzerDao.findBenutzerById(id);
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteBenutzer(Benutzer b) {
		b = this.getBenutzer();
		try {
			BenutzerDao.deleteBenutzer(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createKonto(double kontostand, String name, String typ) {
		Konto k = new Konto();
		k.setId(0);
		k.setKontostand(kontostand);
		k.setName(name);
		k.setTyp(typ);
		
		Benutzer b = this.getBenutzer();
		
		try {
			KontoDao.insertKonto(k, b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Konto> loadAllKonto(Benutzer b) {
		try {
			Collection<Integer> allekontos = KontoDao.getAllId(b);
			for (int id : allekontos) {
				Konto k = KontoDao.findKontobyId(id);
				kontoliste.add(k);
			}
			return kontoliste;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kontoliste;
	}
	
	public Konto loadKonto(int id) {
		try {
			Konto k = KontoDao.findKontobyId(id);
			return k;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteKonto() {
		Konto k = this.getKonto();
		try {
			KontoDao.deleteKonto(k);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createEintrag(String typ, double betrag, Date datum,
			String kategorie, String name, Konto welchesKonto) {
		EinAus ea = new EinAus(typ);
		ea.setBetrag(betrag);
		ea.setDatum(datum);
		ea.setId(0);
		ea.setKategorie(kategorie);
		ea.setName(name);
		
		Konto k = welchesKonto;
		
		try {
			EintragDao.insertEinAus(ea, k);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EinAus loadEintrag(int id) {
		try {
			EinAus ea = EintragDao.findEinAusById(id);
			return ea;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteEintrag() {
		EinAus ea = this.getEinaus();
		try {
			EintragDao.deleteEinAus(ea);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void createBudget(double betrag, Date vonBudget, Date bisBudget,
			Date datum, String kategorie, String name, Konto welchesKonto) {
		Budget bud = new Budget();
		bud.setBetrag(betrag);
		bud.setBisBudget(bisBudget);
		bud.setVonBudget(vonBudget);
		bud.setDatum(datum);
		bud.setId(0);
		bud.setKategorie(kategorie);
		bud.setName(name);
		
		Konto k = welchesKonto;
		
		try {
			BudgetDao.insertBudget(bud, k);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Budget loadBudget(int id) {
		try {
			Budget bud = BudgetDao.findBudgetById(id);
			return bud;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteBudget() {
		Budget bud = this.getBudget();
		try {
			BudgetDao.deleteBudget(bud);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createUmbuchung(double betrag, Date datum, String kategorie,
			String name, Konto startkonto, Konto zielkonto, Konto welchesKonto) {
		Umbuchung um = new Umbuchung();
		um.setBetrag(betrag);
		um.setDatum(datum);
		um.setId(0);
		um.setKategorie(kategorie);
		um.setName(name);
		um.setStartkonto(startkonto);
		um.setZielkonto(zielkonto);
		
		Konto k = welchesKonto;
		
		try {
			UmbuchungDao.insertUmbuchung(um, k);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Umbuchung loadUmbuchung(int id) {
		try {
			Umbuchung um = UmbuchungDao.findUmbuchungById(id);
			return um;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteUmbuchung() {
		Umbuchung um = this.getUmbuchung();
		try {
			UmbuchungDao.deleteUmbuchung(um);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void saveAllEntries() {
		
	}
	
	public List<Object> loadAllEntries(Konto k) {
		try {
			Collection<Integer> eintraege = EintragDao.getAllId(k);
			Collection<Integer> budgets = BudgetDao.getAllId(k);
			Collection<Integer> umbuchungen = UmbuchungDao.getAllId(k);
			
			for (int id : eintraege) {
				EinAus ea = EintragDao.findEinAusById(id);
				allEntries.add(ea);
			}
			
			for (int id : budgets) {
				Budget bud = BudgetDao.findBudgetById(id);
				allEntries.add(bud);
			}
			
			for (int id : umbuchungen) {
				Umbuchung um = UmbuchungDao.findUmbuchungById(id);
				allEntries.add(um);
			}
			return allEntries;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Konto getKonto() {
		if (this.konto == null) {
			this.setKonto(new Konto());
		}
		return konto;
	}
	
	public void setKonto(Konto konto) {
		this.konto = konto;
	}
	
	public Benutzer getBenutzer() {
		if (this.benutzer == null) {
			this.setBenutzer(new Benutzer());
		}
		return benutzer;
	}
	
	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
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
	
	public Umbuchung getUmbuchung() {
		return umbuchung;
	}
	
	public void setUmbuchung(Umbuchung umbuchung) {
		this.umbuchung = umbuchung;
	}
	
}
