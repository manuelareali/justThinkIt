package beanweb;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.RegistrationShopManagerController;


public class RegistrationShopBoundary{
	private RegistrationShopManagerController regNeg;

	
	public RegistrationShopBoundary() {
		regNeg = new RegistrationShopManagerController();
	}

	public boolean isNumeric(String str) { 
		 Logger logger = LoggerFactory.getLogger(RegistrationShopBoundary.class.getName());
		  try {  
		    Integer.parseInt(str); 
		    return true;
		  } catch(NumberFormatException e){  
			  logger.error("Inserisci correttamente il numero di telefono");
		    return false;  
		  } 
		}
	

	public boolean registraNegozioPressed(String tipologia, String nomeNegozio,String password, String indirizzoNeg, String recapitoTel, String email, String citta){
    	if (nomeNegozio == null || nomeNegozio.equals("") || password == null || password.equals("") ||indirizzoNeg == null || indirizzoNeg.equals("") || email == null  ||  email.equals("")|| citta == null || citta.equals("")) {
    		return false;    		
    	}
    	else {
    		regNeg.registraNegozioPressed(tipologia ,nomeNegozio,password, indirizzoNeg, recapitoTel, email, citta);
    		return true;
    	} 	
    }
    	

    
    
 
   
    
}
