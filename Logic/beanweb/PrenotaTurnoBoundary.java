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
	
    public int  prenotaTurno(String turni, String cbOraInizio, String oraFine, String cv) {
    	prenotaC.prenotaTurno(turni, cbOraInizio, oraFine, cv);
    	return 0;
	}



	public void setData(int idCar, int idUte) {
	
		prenotaC.setDataController(idCar, idUte);
	}
}

