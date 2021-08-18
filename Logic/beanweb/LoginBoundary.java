package beanweb;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.BachecaBoundary;
import controller.CaritasHomeController;
import controller.LoginController;
import controller.ShopHomeController;
import controller.UserHomeController;



public class LoginBoundary {

	private static Logger logger = LoggerFactory.getLogger(BachecaBoundary.class.getName());


	private LoginController loginC = new LoginController();

	private beanweb.UserHomeBoundary userHomeBoundary;

	private beanweb.ShopHomeBoundary shopHomeBoundary;
	private beanweb.CaritasHomeBoundary caritasHomeBoundary;

	
	
		
	public String loginPressed(String username, String password) {
		UserHomeController userHomeController;
			if (loginC.trovaID(username)!= 0) {
			String loggedUser = loginC.loginAccess(username, password);
			if (loggedUser.equalsIgnoreCase("Volontario")) {
				userHomeBoundary = userHomeBoundary.getInstance();				
				userHomeController = new UserHomeController();
				userHomeController.initDataCont(loginC.trovaID(username), userHomeBoundary);
				return loggedUser;
			} else if (loggedUser.equalsIgnoreCase("Caritas")) {
				caritasHomeBoundary = caritasHomeBoundary.getInstance();
				CaritasHomeController caritasHomeController = new CaritasHomeController();
				caritasHomeController.initDataCaritas(loginC.trovaID(username), caritasHomeBoundary);
				return loggedUser;
			} else if (loggedUser.equalsIgnoreCase("Negozio")) {
				shopHomeBoundary = shopHomeBoundary.getInstance();
				ShopHomeController shopHomeC = new ShopHomeController();
				shopHomeC.initDataShop(loginC.trovaID(username), shopHomeBoundary);
				return loggedUser;
				}
			return loggedUser;
			}else {
				logger.error("Utente non esiste");
				return "Niente";
			}
		
		}
	
}


