package beanweb;

import java.util.List;
import controller.GestisciEventiCaritasController;
import entity.EventTab;


public class GestisciEventiCaritasBoundary {


		private GestisciEventiCaritasController gestEventC;
		private PromuoviEventoGenerale prom;
		private int idCar;
		
		
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
	    		gestEventC.confermaEvento(Integer.parseInt(id));
	    		return true;
	    	}
		}
		
		
		public boolean cancellaEvento(String id) {
	    	if (id == null || id.equals("")) {
	    		return false;
	    	}
	    	else {
	    		gestEventC.cancellaEvento(Integer.parseInt(id));
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


