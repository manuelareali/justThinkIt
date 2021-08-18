package beanweb;

import java.sql.SQLException;

import controller.RegistrazioneCaritasController;



public class RegistraCaritasBoundary  {

	private RegistrazioneCaritasController regController;

	

	public RegistraCaritasBoundary() {
		regController = new RegistrazioneCaritasController();
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