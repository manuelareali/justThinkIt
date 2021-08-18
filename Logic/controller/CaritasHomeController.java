package controller;



import dao.CaritasRepository;
import dao.UserDao;
import entity.CaritasUser;

/**
 * Sample Skeleton for "CaritasHomePage.fxml" Controller Class You can copy and
 * paste this code into your favorite IDE
 **/

public class CaritasHomeController {

	private CaritasUser currentUser;
	
	public void deleteAccount(int id) {
		UserDao userd = new UserDao();
		userd.deleteVolunteer(id);
	}

	public CaritasUser getCurrentUser() {
		return this.currentUser;
	}

	public void setCurrentUser(CaritasUser currentUser) {
		this.currentUser = currentUser;
	}

	public void initDataCaritas(int idUser, Object caritasHomeBoundary) {
		CaritasRepository c = new CaritasRepository();
		currentUser = c.getCaritasByID(idUser);
		if(caritasHomeBoundary.getClass() == bean.CaritasHomeBoundary.class) {
			((bean.CaritasHomeBoundary) caritasHomeBoundary).initDataC(currentUser.getId(), currentUser.getNome());
		}
		else if (caritasHomeBoundary.getClass() == beanweb.CaritasHomeBoundary.class) {
			((beanweb.CaritasHomeBoundary) caritasHomeBoundary).initDataC(currentUser.getId(), currentUser.getNome());
		}
	}

}
