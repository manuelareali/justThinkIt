package beanweb;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.CreaTurnoBoundary;
import controller.PromuoviEventoController;


public class PromuoviEventoBoundary {


		private int idCar;
		private int idShop;
		private static PromuoviEventoBoundary   instance  = null;
		
	
		
public static PromuoviEventoBoundary getInstance() {
		if(instance == null) {
			instance = new PromuoviEventoBoundary();
		}
		return instance;
		}
	   
	    
public boolean isNumeric(String str) { 
	 Logger logger = LoggerFactory.getLogger(PromuoviEventoBoundary.class.getName());
	  try {  
		  Float.parseFloat(str); 
	    return true;
	  } catch(NumberFormatException e){  
		  logger.error("Inserisci correttamente il prezzo");
	    return false;  
	  } 
	}
	    
	   public boolean confermaPressed(String nome, String tipo, String note, Float costoEvento){
		   if (nome == null || nome.equals("")|| tipo == null || tipo.equals("") ||  costoEvento == null || costoEvento.equals("")) {
			   return false;
		   }
		   else {
			
				   PromuoviEventoController promuoviEvento = new PromuoviEventoController();
				   promuoviEvento.creaEventoController(nome,tipo, note, costoEvento , idCar,idShop);	
			
			   return true;
		   }
	    }

	   
		public void loadFormBoundary(int idCar, int idShop) {
			this.idCar = idCar;
			this.idShop = idShop;
			
		}

	

}
