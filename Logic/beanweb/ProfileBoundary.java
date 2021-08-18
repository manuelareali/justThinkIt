package beanweb;



import controller.UserHomeController;


public class ProfileBoundary{

	
	private int idUser;
	private UserHomeBoundary userHomeBoundary;

    

 
void backHomeButtonPressed() {
			UserHomeController userHomeC = new UserHomeController();
			
			userHomeC.initDataCont(idUser, userHomeBoundary);
    }
 
}
