package beanweb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		return  gestisciEventiC.caricaEventiPropCaritas();
			
	}
	
	public GestisciEventiPropCaritas() {
    	gestisciEventiC = new GestisciEventiController();
   
    }
	
	public boolean isNumeric(String str) { 
		Logger logger = LoggerFactory.getLogger(GestisciEventiPropCaritas.class.getName());
		  try {  
		    Integer.parseInt(str); 
		    return true;
		  } catch(NumberFormatException e){  
			  logger.error("Inserisci correttamente l'id evento");
		    return false;  
		  } 
		}

	public boolean proponi (String i) {
		if (i == null || i.equals("")) {
    		return false;
    	}
		int x = Integer.parseInt(i);
		prop.getInstance().load(idShop, x);
		return true;
	}
}

