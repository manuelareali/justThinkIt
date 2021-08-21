package beanweb;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestisciEventiController;
import entity.EventTab;


public class GestisciEventiBoundary {

	private GestisciEventiController gestEventC;
	private int idShop;

	
	private EventTab event;
	
	EmailBoundary email = null;
	
	private static GestisciEventiBoundary instance = null;

	public static GestisciEventiBoundary getInstance(){
		if ( instance == null) {
			instance = new GestisciEventiBoundary();
		}
		return instance;
	}
		
	   
	   public void contattaCaritas() {
		   email = email.getInstance();
	       email.loadEmail(this.event.getIdCaritas(),this.idShop);  	
	   }  	
	    
		public boolean isNumeric(String str) { 
			Logger logger = LoggerFactory.getLogger(GestisciEventiBoundary.class.getName());
			  try {  
			    Integer.parseInt(str); 
			    return true;
			  } catch(NumberFormatException e){  
				  logger.error("Inserisci correttamente l'id");
			    return false;  
			  } 
			}
	    
	   public boolean eliminaEvento(String i) {
		   if (i == null || i.equals("")) {
			   return false;
		   }
		   else {
			   if(isNumeric(i)) {
				   gestEventC.cancellaEvento(Integer.parseInt(i)); 
				   
			   }
			   return true;
		   }
	    }


	private GestisciEventiBoundary() {
		gestEventC = new GestisciEventiController();

	}

	public GestisciEventiBoundary(int i) {
		gestEventC = new GestisciEventiController();
		this.idShop = i;

	}
	
	public List<EventTab> loadShopBoundary(){
		return gestEventC.caricaEventi(idShop);
	}
	
	


	public void loadShopBean(int idShop) {
		this.idShop = idShop;
	}
	



	

}