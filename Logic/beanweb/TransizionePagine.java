package beanweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.CaritasHomeController;
import controller.CercaCaritasController;



public class TransizionePagine {
	private beanweb.CercaCaritas cercaCaritasBean;
	private beanweb.CaritasHomeBoundary caritasHomeBoundary;


	
	public void apriMappa(int idUser){
				cercaCaritasBean = cercaCaritasBean.getInstance();
	        CercaCaritasController controller = new CercaCaritasController(); 
	        controller.initUser(idUser, cercaCaritasBean);
	}
	

	
	public void backToMenuCaritas(int idUser) {
			CaritasHomeController caritasHomeC = new CaritasHomeController();
			caritasHomeC.initDataCaritas(idUser, caritasHomeBoundary);
	}
	

	
	
}
