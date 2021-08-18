package controller;

import dao.BachecaDao;
import entity.Necessita;

public class CreaNecessitaController {
	private BachecaDao creaBachecaDao;
	
	private int idCaritas;
	
	public CreaNecessitaController() {
		creaBachecaDao = new BachecaDao();
		
	}
	
	
	public int creaNecessita(String tipo, String urg, String desc) {
		
		Necessita necessita = new Necessita(tipo, desc, urg);
		return creaBachecaDao.creaNecessita(necessita, idCaritas);
		
	}
	
	
	
	public void inizializza(int codCar) {
		this.idCaritas = codCar;
	}
	
}
