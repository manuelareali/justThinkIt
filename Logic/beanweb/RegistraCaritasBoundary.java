package beanweb;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.RegistrazioneCaritasController;



public class RegistraCaritasBoundary  {

	private RegistrazioneCaritasController regController;

	

	public RegistraCaritasBoundary() {
		regController = new RegistrazioneCaritasController();
	}

	public boolean isNumeric(String str) { 
		 Logger logger = LoggerFactory.getLogger(RegistraCaritasBoundary.class.getName());
		  try {  
		    Integer.parseInt(str); 
		    return true;
		  } catch(NumberFormatException e){  
			  logger.error("Inserisci correttamente il numero di telefono");
		    return false;  
		  } 
		}
	

	public boolean completaButtonPressed(String nomeCaritas,String tipologia, String password, String indirizzoCaritas,  String recapitoTel, String email, String citta ) throws SQLException{
		 if (nomeCaritas == null || nomeCaritas.equals("") || password == null || password.equals("") || indirizzoCaritas == null || indirizzoCaritas.equals("")|| recapitoTel == null || recapitoTel.equals("") || email == null || email.equals("") || citta == null || citta.equals("")) {
			 return false;
		}
		 else{
				 regController.completaButtonPressed(nomeCaritas,tipologia,password,indirizzoCaritas,recapitoTel,email,citta);	
			 }
	     return true;
	}

}