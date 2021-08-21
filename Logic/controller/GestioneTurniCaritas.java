package controller;

import java.util.List;

import beanweb.CreaTurnoBoundary;
import dao.CreaTurnoDao;
import entity.TurnoTab;

public class GestioneTurniCaritas {
	
	private CreaTurnoDao turniDao;
	
	public GestioneTurniCaritas() {
		this.turniDao = new CreaTurnoDao();
	}

	
	
	
	public boolean modificaTurno(int idTurn, String newNote, int codCar) {
		return this.turniDao.modificaTurno(idTurn, newNote, codCar);
		
	}
	
	
	public boolean cancellaTurno(int idTurn) {
		return this.turniDao.cancellaTurno(idTurn);
	
	}

	public List<TurnoTab> caricaTurni(int idCaritas) {
		return this.turniDao.visualizzaTurni(idCaritas);
	}

}
