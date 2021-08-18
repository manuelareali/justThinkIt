package beanweb;



import controller.RegistrationShopManagerController;


public class RegistrationShopBoundary{
	private RegistrationShopManagerController regNeg;

	
	public RegistrationShopBoundary() {
		regNeg = new RegistrationShopManagerController();
	}



	public boolean registraNegozioPressed(String tipologia, String nomeNegozio,String password, String indirizzoNeg, String recapitoTel, String email, String citta){
    	if (nomeNegozio == null || nomeNegozio.equals("") || password == null || password.equals("") ||indirizzoNeg == null || indirizzoNeg.equals("") || recapitoTel == null || recapitoTel.equals("")|| email == null  ||  email.equals("")|| citta == null || citta.equals("")) {
    		return false;    		
    	}
    	else {
    		regNeg.registraNegozioPressed(tipologia ,nomeNegozio,password, indirizzoNeg, recapitoTel, email, citta);
    		return true;
    	} 	
    }
    	

    
    
 
   
    
}
