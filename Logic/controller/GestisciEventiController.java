package controller;

import java.util.List;

import dao.EventoDao;
import entity.EventTab;

public class GestisciEventiController {
	
	

	private EventoDao eventDao;

	
	
	public GestisciEventiController() {
	
		eventDao = new EventoDao();
	}
	
	public List<EventTab> caricaEventiPropCaritas(int idShop) {
		return this.eventDao.cercaEventiPropCaritas();

	}
	
	
	public List<EventTab> caricaEventi(int idShop){
		return eventDao.cercaEventi(idShop);	
	}
	
	public boolean confermaEvento(int idEvento) {
		return eventDao.confermaEvento(idEvento);
	}
	
	public boolean cancellaEvento(int evento){
		return eventDao.cancellaEvento(evento);
	}
	
		
	
}
