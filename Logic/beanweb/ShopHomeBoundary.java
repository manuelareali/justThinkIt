package beanweb;

import controller.UserHomeController;

public class ShopHomeBoundary {
	

	private int idShop;
	private String nome;
	private String email;
	
	private GestisciEventiBoundary gestisciBoundary;
	private GestisciEventiPropCaritas gestisciPropCar;
	private static ShopHomeBoundary instance = null;
	

		public static ShopHomeBoundary getInstance() {
			if (instance == null) {
				instance = new ShopHomeBoundary();
				}
			return instance;
		}

		private ShopHomeBoundary() {
			 gestisciBoundary = gestisciBoundary.getInstance();
			 gestisciPropCar = gestisciPropCar.getInstance();
		}
		
    public void cercaCaritas(){
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.idShop);
    }


    public void deleteAccountButtonPressed() {
    	UserHomeController controller = new UserHomeController();
		controller.deleteAccount(this.idShop);  
}

   
    public void gestisciEventi() {
    	gestisciBoundary.getInstance().loadShopBean(idShop);
    }

  
    public void gestisciEventiPropCaritas() {
    	gestisciPropCar.getInstance().loadShop(idShop);
    }



	public void initData(int id, String nome,String email) {
		this.idShop = id;	
		this.nome = nome;
		this.email = email;
	}


	public String getNomeShop() {
		return this.nome;
	}
	
	public String getEmailShop() {
		return this.email;
	}


}

