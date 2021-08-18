package beanweb;

import controller.CreaNecessitaController;


public class CreaNecessitaBoundary {
	
		private int idCaritas;
		
		
		
		private static CreaNecessitaBoundary instance = null;
		
		private CreaNecessitaBoundary() {
			
		}
		  
		public static CreaNecessitaBoundary getInstance() {
		  if (instance == null) {
			  instance = new CreaNecessitaBoundary();
			 }
			 return instance;
		 }
	    
	 
	    public boolean creaAnnuncioPressed(String tipologia,String urgenza,String richiesta) {
	    	if (tipologia == null || tipologia.equals("") || urgenza == null || urgenza.equals("") || richiesta == null || richiesta.equals("")) {
	    		return false;
	    	}else {
	    		CreaNecessitaController creaNec = new CreaNecessitaController();
	    		creaNec.inizializza(idCaritas);
	    		creaNec.creaNecessita(tipologia, urgenza, richiesta);
	    		return true;
	    	}
	    }

	    
	    
	    public void setCaritas(int idCar) {
	    	this.idCaritas = idCar;
	    }
	    
	    
	

}
