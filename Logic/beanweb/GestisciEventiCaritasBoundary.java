package beanweb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestisciEventiCaritasController;
import entity.EventTab;
import exception.MyException;
import exception.Trigger;


public class GestisciEventiCaritasBoundary {


		private GestisciEventiCaritasController gestEventC;
		private PromuoviEventoGenerale prom;
		private int idCar;
		private Logger logger = LoggerFactory.getLogger(GestisciEventiBoundary.class.getName());
		private Trigger trigger;
		
		private EventTab event;
		
		private static GestisciEventiCaritasBoundary instance  = null;
		
		public static GestisciEventiCaritasBoundary getInstance() {
			if(instance == null) {
				instance = new GestisciEventiCaritasBoundary();
			}
			return instance;
			}
		

	
	
		public boolean confermaEvento(String id) {
			
			if (id == null || id.equals("")) {
	    		return false;
	    	}
	    	else {
	    		try {
					if(trigger.isNumerico(id)) {
						gestEventC.confermaEvento(Integer.parseInt(id));
					}
				} catch (NumberFormatException e) {
					logger.error("Inserisci un id corretto" + e.getMessage());
				} catch (MyException e) {
					logger.error(e.getMessage());
				}
	    		return true;
	    	}
		}
		
		
		public boolean cancellaEvento(String id) {
	    	if (id == null || id.equals("")) {
	    		return false;
	    	}
	    	else {
	    		try {
					if(trigger.isNumerico(id)) {
						gestEventC.cancellaEvento(Integer.parseInt(id));
					}
				} catch (NumberFormatException e) {
					logger.error("Inserisci un id corretto" + e.getMessage());
				} catch (MyException e) {
					logger.error(e.getMessage());
				}
	    		return true;
	    	}
		 }
		  
		   
		EmailBoundary email = null;
		 public void contattaShop() {	  
	          email = email.getInstance();
	          email.loadEmail(this.event.getCodiceNegozio(), idCar);
	    	        	    	
		    }
		
		
		public List<EventTab> loadFormEvento() {
			return  gestEventC.caricaEventi(idCar);
				
		}

		public void loadShop(int idCar) {
			this.idCar = idCar;
		}
		
	private GestisciEventiCaritasBoundary(){
			gestEventC = new GestisciEventiCaritasController();
		}
		
	
	public void creaEvento() {
		prom.getInstance().loadId(idCar);
	}
		
		
	}


