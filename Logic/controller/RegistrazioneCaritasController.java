package controller;

import java.sql.SQLException;

import dao.CaritasRepository;
import entity.CaritasUser;

public class RegistrazioneCaritasController  {
	
	int tipo;



	public int completaButtonPressed( String nomeCaritas,String tipo, String passwordCaritas, String via, 
		
		String telefono, String email, String cittadiResidenza) throws SQLException {
	
		CaritasUser newUser = new CaritasUser(nomeCaritas,tipo, passwordCaritas, via, telefono, email, cittadiResidenza);
	
			CaritasRepository crep = new CaritasRepository();
			if (crep.insertCaritas(newUser)==0) {
				return 1;
			}
			
			return 0;
		
		

	}



}
