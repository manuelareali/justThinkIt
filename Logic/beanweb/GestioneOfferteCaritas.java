package beanweb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.ProponiOfferta;
import entity.Offerte;
import exception.MyException;
import exception.Trigger;

public class GestioneOfferteCaritas {


	private ProponiOfferta proponi;
	private int idCar;
	
	public GestioneOfferteCaritas() {
		proponi = new ProponiOfferta();
	}
	
	private static GestioneOfferteCaritas instance = null;

	public static  GestioneOfferteCaritas getInstance(){
		if ( instance == null) {
			instance = new  GestioneOfferteCaritas();
		}
		return instance;
	}
		


	
	 

	  public boolean accetta(String idEv) {
		  Logger logger = LoggerFactory.getLogger(GestioneOfferteCaritas.class.getName());
		  Trigger trigger = new Trigger();
		  if(idEv == null || idEv.equals("")) {
	    		return false;
		  }else {
			  try {
				if(trigger.isNumerico(idEv)) {
					  proponi.confermaEvento(Integer.parseInt(idEv));
				  }
			} catch (NumberFormatException e) {
				logger.error("Inserisci un id corretto" + e.getMessage());
			} catch (MyException e) {
				logger.error(e.getMessage());
			}
	    	return true;
		  }
	    }

    public List<Offerte> loadOfferte(){
    	return proponi.caricaOfferte(idCar);
    }

    public void loadFormBoundary(int idCar) {
    	this.idCar = idCar;
    }

}
