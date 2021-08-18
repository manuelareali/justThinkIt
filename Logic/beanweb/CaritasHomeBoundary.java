package beanweb;

import controller.UserHomeController;

public class CaritasHomeBoundary {

	
	private int idCar;
	private String nome;
	
	private static CaritasHomeBoundary instance = null;

	private GestisciTurniBoundary gestTurn;
	private GestisciDonazioniBoundary gestDon;
	private GestisciEventiCaritasBoundary gestisciB;
	private BachecaPersonaleBoundary bacheca;
	private GestioneOfferteCaritas offerte;



	public static CaritasHomeBoundary getInstance() {
		if (instance == null) {
			instance = new CaritasHomeBoundary();
		}
		return instance;
	}
	
    public void deleteAccountButtonPressed() {
    	UserHomeController controller = new UserHomeController();
		controller.deleteAccount(this.idCar);  
}


	private CaritasHomeBoundary() {
		bacheca = bacheca.getInstance();
		gestTurn = gestTurn.getInstance();
		gestDon = gestDon.getInstance();
		gestisciB = gestisciB.getInstance();
		offerte = offerte.getInstance();
	}
	
	   public void cercaCaritas(){
	    	TransizionePagine switchPage = new TransizionePagine();
	    	switchPage.apriMappa(this.idCar);
	    }
	   
	  public void gestisciOfferte() {
		  offerte.getInstance().loadFormBoundary(idCar);
	  } 

	public void gestisciDonazioni() {		
		gestDon.getInstance().loadFormBoundary(idCar);
	}

	
	public void gestisciEventi() {			
			gestisciB.getInstance().loadShop(idCar);
	}

	
	public void gestisciTurni() {
			gestTurn.getInstance().loadFormBoundary(idCar);
	}

	public void visualizzaBacheca() {		
			bacheca.getInstance().loadFormBoundary(idCar);
	}

	public void initDataC(int id, String nome) {
		this.idCar = id;
		this.nome = nome;
	}
	
	public String getNomeCaritas() {
		return this.nome;
	}

}