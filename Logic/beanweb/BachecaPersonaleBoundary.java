package beanweb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.BachecaPersonaleController;
import entity.Necessita;

public class BachecaPersonaleBoundary {
	
	private int idCar;
	private BachecaPersonaleController bachecaController;
	private CreaNecessitaBoundary creaNec;
	
	private static BachecaPersonaleBoundary instance  = null;
	
	public static BachecaPersonaleBoundary getInstance() {
		if(instance == null) {
			instance = new BachecaPersonaleBoundary();
		}
		return instance;
		} 
	
	private BachecaPersonaleBoundary() {
		bachecaController = new BachecaPersonaleController();
	}
	
	
	public void creaNecessita() {
			 creaNec.getInstance().setCaritas(idCar);
	}

	public boolean isNumeric(String str) { 
		Logger logger = LoggerFactory.getLogger(BachecaPersonaleBoundary.class.getName());
		  try {  
		    Integer.parseInt(str); 
		    return true;
		  } catch(NumberFormatException e){  
			  logger.error("Inserisci correttamente l'id");
		    return false;  
		  } 
		}
	
	public boolean eliminaNecessita(String i){
		if (i == null || i.equals("") ) {
			return false;
		}
		else {
			if(isNumeric(i)) {
				int x = Integer.parseInt(i);
				bachecaController.eliminaAnnuncio(x);
			}
			return true;
		}
	}

	public List<Necessita> loadFormBacheca(){
		return bachecaController.loadForm(idCar);
		}

	
	public void loadFormBoundary(int idCar) {
		this.idCar = idCar;
	}
	


}
