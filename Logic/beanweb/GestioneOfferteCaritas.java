package beanweb;

import java.util.List;
import controller.ProponiOfferta;
import entity.Offerte;

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
		  if(idEv == null || idEv.equals("")) {
	    		return false;
		  }else {
	    	proponi.confermaEvento(Integer.parseInt(idEv));
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
