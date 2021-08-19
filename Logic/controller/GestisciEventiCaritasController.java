package controller;

import java.util.List;

import dao.CaritasRepository;
import dao.EventoDao;
import dao.ShopRepository;
import entity.CaritasUser;
import entity.EventTab;
import entity.ShopUser;

public class GestisciEventiCaritasController {

	private EventoDao eventDao;

	public List<EventTab> caricaEventi(int idCaritas) {

		return eventDao.cercaEventiCaritas(idCaritas);

	}
	
	
	public boolean confermaEvento(int idEvento) {
		return eventDao.confermaEvento(idEvento);
	}

	public GestisciEventiCaritasController() {
		eventDao = new EventoDao();
	}

	public boolean cancellaEvento(int idEvento) {
		return eventDao.cancellaEvento(idEvento);
	}

	public void creaEventoGeneral(String nomeEvento, String tipo,Float prezzo, String noteEvento , int idCar, int idNeg ) {
		CaritasRepository caritasdao = new CaritasRepository();
		ShopRepository shopDao = new ShopRepository();
		CaritasUser caritas = caritasdao.getCaritasByID(idCar);
		ShopUser shop = shopDao.getShopByID(idNeg);
		EventTab evento = new EventTab(caritas.getId(),tipo,shop.getId(),nomeEvento, caritas.getNome(), noteEvento, prezzo);
		this.eventDao.creaEvento(evento);
	}
}
