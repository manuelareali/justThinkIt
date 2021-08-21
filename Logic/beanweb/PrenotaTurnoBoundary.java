package beanweb;


import controller.PrenotaTurnoController;




public class PrenotaTurnoBoundary {

	private PrenotaTurnoController prenotaC;

	private static PrenotaTurnoBoundary instance = null;
	
	private PrenotaTurnoBoundary() {
		prenotaC = PrenotaTurnoController.getInstance();
	}

	public static  PrenotaTurnoBoundary getInstance() {
		if(instance == null) {
			instance = new  PrenotaTurnoBoundary();
		}
		return instance;
		}
	
    public boolean  prenotaTurno(String turni, String cbOraInizio, String oraFine, String cv) {
    	if(cbOraInizio.contentEquals(oraFine)) {
    		return false;
    	}else {	
    		prenotaC.prenotaTurno(turni, cbOraInizio, oraFine, cv);
    		return true;
    	}
	}



	public void setData(int idCar, int idUte) {
	
		prenotaC.setDataController(idCar, idUte);
	}
}

