package controller;

import java.util.List;
import dao.CercaCaritasDao;
import dao.CoordinateDao;
import dao.UserDao;
import entity.CoordinateMap;
import entity.MarkerID;


public class CercaCaritasController {
	
	private CercaCaritasDao cercaCaritasD;
	private CoordinateDao coord;
	private UserDao v;

	
	
	public CercaCaritasController() {
		coord = new CoordinateDao();
		cercaCaritasD = new CercaCaritasDao();
		v = new UserDao();
	}

	
	public void initMap2(int id, String lati, String longi) {
		coord.setCoordinate(id,lati,longi);
	}
	

	public List<MarkerID> initMarkersCaritas(){
		return cercaCaritasD.getCaritasMarkers();
	}
	
	public List<MarkerID> initMarkersNegozio(){
		return cercaCaritasD.assegnaMarkerNegozio();
	}
	
	public List<MarkerID> initMarkersDonazione(int idCaritas){
		return cercaCaritasD.assegnaMarkerDonazione(idCaritas);

	}
	public List<MarkerID> initMarkersEvento(int idCar){
		return cercaCaritasD.assegnaMarkerEvento(idCar);

	}

	public List<MarkerID> initMarkersEvento() {
	
		return cercaCaritasD.assegnaMarkerEvento();
	}


	
	public List<CoordinateMap> initMarkerCar(){
		return cercaCaritasD.getCoordinateCaritas();
	}
	
	public List<CoordinateMap> initMarkerEvent(){
		
		return cercaCaritasD.getCoordinateEvento();
	}
	
	public List<CoordinateMap> initMarkerEvent(int idUser){
		
		return cercaCaritasD.getCoordinateEvento(idUser);
	}
	
	public List<CoordinateMap> initMarkerDonation(int idUser){
		return cercaCaritasD.getCoordinateDonazione(idUser);
	}
	
	public String trovaRuolo(int idUser) {
		return v.trovaTipoUtente(idUser);
	}
	
	public void initUser(int idUser, Object cercaBean){
	
		String ruoloUser = v.trovaTipoUtente(idUser);
		if(cercaBean.getClass() == bean.CercaCaritas.class) {
			((bean.CercaCaritas) cercaBean).initMarkers(idUser, ruoloUser);
		}
		else if (cercaBean.getClass() == beanweb.CercaCaritas.class) {
				((beanweb.CercaCaritas) cercaBean).getInstance().setUser(idUser, ruoloUser);
		}
	}


}
