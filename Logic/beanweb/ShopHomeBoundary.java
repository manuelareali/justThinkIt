package beanweb;

import controller.UserHomeController;

public class ShopHomeBoundary {
	

	private int idShop;
	private String nome;
	
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



	public void initData(int id, String nome) {
		this.idShop = id;	
		this.nome = nome;
	}


	public String getNomeShop() {
		return this.nome;
	}



}

