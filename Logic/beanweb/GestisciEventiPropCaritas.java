package beanweb;

import java.util.List;


import controller.GestisciEventiController;
import controller.ProponiOfferta;
import entity.EventTab;

public class GestisciEventiPropCaritas {

	private int idShop;
	private ProponiOffertaCaritas prop;
	private GestisciEventiController gestisciEventiC;
	private static GestisciEventiPropCaritas instance = null;
	
	public static GestisciEventiPropCaritas getInstance(){
		if ( instance == null) {
			instance = new GestisciEventiPropCaritas();
		}
		return instance;
	}
	
	public void loadShop(int idShop) {
		this.idShop = idShop;
	}
	
	public boolean proponiOfferta(String proponi){
		if(proponi == null || proponi.equals("")) {
			return false;
		}else {
			gestisciEventiC.confermaEvento(Integer.parseInt(proponi));
			return true;
		}
		
		
	}
	
	public List<EventTab> loadFormEvento() {
		return  gestisciEventiC.caricaEventiPropCaritas(idShop);
			
	}
	
	public GestisciEventiPropCaritas() {
    	gestisciEventiC = new GestisciEventiController();
   
    }

	public void proponi (int idEv) {
		prop.getInstance().load(idShop, idEv);
	}
}

