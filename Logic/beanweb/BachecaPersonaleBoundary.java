package beanweb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.BachecaPersonaleController;
import entity.Necessita;
import exception.MyException;
import exception.Trigger;

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


	
	public boolean eliminaNecessita(String i){
		 Logger logger = LoggerFactory.getLogger(BachecaPersonaleBoundary.class.getName());
		  Trigger trigger = new Trigger();
		if (i == null || i.equals("") ) {
			return false;
		}
		else {
			try {
				if(trigger.isNumerico(i)) {
					int x = Integer.parseInt(i);
					bachecaController.eliminaAnnuncio(x);
				}
			} catch (NumberFormatException e) {
				logger.error("Inserisci un id corretto" + e.getMessage());
			} catch (MyException e) {
				logger.error(e.getMessage());
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
