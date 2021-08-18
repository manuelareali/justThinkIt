package controller;

import dao.CreaTurnoDao;

public class CreaTurnoController {


	private CreaTurnoDao turnodao;
	
	public CreaTurnoController() {
		turnodao = new CreaTurnoDao();
	}
	
	
	public boolean creaTurno(int codCar, String giorno, String oraIni, String oraFin, int numPart, String newNote) {
		return turnodao.creaTurno(codCar, giorno, newNote, oraIni, oraFin, numPart);
	}
}
