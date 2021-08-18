package controller;

import dao.CaritasRepository;
import dao.EventoDao;
import dao.ShopRepository;
import entity.CaritasUser;
import entity.EventTab;
import entity.ShopUser;

public class PromuoviEventoController {
	
	private EventoDao eventDao;
	
	
	
	public PromuoviEventoController() {
		eventDao = new EventoDao();
		
	}
	

	public void creaEventoController(String nomeEvento, String tipo, String noteEvento, float prezzoEvento, int idCar, int idUser) {
		
		
		CaritasRepository caritasdao = new CaritasRepository();
		ShopRepository shopDao = new ShopRepository();
		CaritasUser caritas = caritasdao.getCaritasByID(idCar);
		ShopUser shop = shopDao.getShopByID(idUser);
		EventTab evento = new EventTab(caritas.getId(),tipo,shop.getId(),nomeEvento, caritas.getNome(), noteEvento, prezzoEvento);
		this.eventDao.creaEvento(evento);
		
	}
	
}
