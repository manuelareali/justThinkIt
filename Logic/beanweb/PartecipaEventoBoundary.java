package beanweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import controller.PartecipaEventoController;

public class PartecipaEventoBoundary {

	private int idUtente;
	private int idEvento;

	private PartecipaEventoController partecipaC;
	private static PartecipaEventoBoundary instance = null;
	 
	public static PartecipaEventoBoundary getInstance() {
		if(instance == null) {
			instance = new PartecipaEventoBoundary();
		}
		return instance;
		}
	
	private PartecipaEventoBoundary() {
		partecipaC = PartecipaEventoController.getInstance();
	}

	
	 public boolean isNumeric(String str) { 
		Logger logger = LoggerFactory.getLogger(PartecipaEventoBoundary.class.getName());
		try {  
		  Float.parseFloat(str); 
		  return true;
		} catch(NumberFormatException e){  
		  logger.error("Inserisci correttamente l'importo da donare");
		  return false;  
		} 
	}

	
	public boolean partecipaEvento(String importo) {
		if (importo == null || importo.equals("")) {
			return false;
		}
		else {
			partecipaC.getInstance().setDataController(idEvento, idUtente);
			partecipaC.getInstance().partecipaEvento(Float.parseFloat(importo));
			return true;
		}
	}

	
	public void setData(int idEvento, int idVolontario) {
		this.idEvento = idEvento;
		this.idUtente = idVolontario;
	}

	public int getIdUtente() {
		return idUtente;
	}




}
