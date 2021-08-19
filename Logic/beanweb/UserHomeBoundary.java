package beanweb;


import controller.UserHomeController;



public class UserHomeBoundary{

	private int userId;
	private String nome;
	private String cognome;
	private String email;
	
	private static UserHomeBoundary instance = null;
	
	public static UserHomeBoundary getInstance() {
		if (instance == null) {
			instance = new UserHomeBoundary();
			}
		return instance;
	}
	

    public void deleteAccountButtonPressed() {
    	UserHomeController controller = new UserHomeController();
		controller.deleteAccount(this.userId);  
}



    public int  searchCaritasButtonPressed(){
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.userId);
    	return 0;
    }
 

	public void initData(int id, String nome, String cognome, String email) {
        this.userId = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }
	
	public String getNomeVolunteer() {
		return this.nome + " "+ this.cognome;
	}
	
	public String getEmail() {
		return this.email;
	}
}





