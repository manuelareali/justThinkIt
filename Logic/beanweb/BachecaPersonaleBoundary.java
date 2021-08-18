package beanweb;

import java.util.List;
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

	
	public boolean eliminaNecessita(String i){
		if (i == null || i.equals("")) {
			return false;
		}
		else {
			int x = Integer.parseInt(i);
			bachecaController.eliminaAnnuncio(x);
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
