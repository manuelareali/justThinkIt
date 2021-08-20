package beanweb;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.RegistrazioneVolontarioController;


public class RegistrazioneVolontarioBoundary{
	private RegistrazioneVolontarioController regC;

	
	
	
	
	public RegistrazioneVolontarioBoundary() {
		regC = new RegistrazioneVolontarioController();
	}
	
	public boolean isNumeric(String str) { 
		 Logger logger = LoggerFactory.getLogger(RegistrazioneVolontarioBoundary.class.getName());
		  try {  
		    Integer.parseInt(str); 
		    return true;
		  } catch(NumberFormatException e){  
			  logger.error("Inserisci correttamente il numero di telefono");
		    return false;  
		  } 
		}
	
	public boolean registraVolontarioPressed(String nome, String cognome, String password, String via, String recapitoTel, String email, String dataNascita, String citta) {	
		 if (nome == null || nome.equals("") || cognome == null || cognome.equals("")){
			 return false;
		 }
		 else if(password == null || password.equals("")) {
			 return false;
		 }
		 else if (via == null || via.equals("") ||  citta == null || citta.equals("")){
			 return false;
		 }
		 
		 else if (email == null || email.equals("")) {
			 return false;
		 }
		 else if (dataNascita == null || dataNascita.equals("")) {
			 return false;
		 }
		 else {
				regC.completaButtonPressed( nome, cognome,password, via, recapitoTel, email, dataNascita,citta);
			 return true;
		 }
	}

}