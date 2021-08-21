package beanweb;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.ProponiOfferta;


public class ProponiOffertaCaritas {

 	Logger logger = LoggerFactory.getLogger(ProponiOffertaCaritas.class.getName());
	private int idShop;
	private int idEv;
	private static ProponiOffertaCaritas  instance  = null;
   
	public static ProponiOffertaCaritas getInstance() {
		if(instance == null) {
			instance = new ProponiOffertaCaritas();
		}
		return instance;
		}
	   
	public boolean isNumeric(String str) { 
		 Logger logger = LoggerFactory.getLogger(ProponiOffertaCaritas.class.getName());
		  try {  
			  Float.parseFloat(str); 
		    return true;
		  } catch(NumberFormatException e){  
			  logger.error("Inserisci correttamente il prezzo");
		    return false;  
		  } 
		}
	
    public boolean conferma(Float prezzo, String note, String data) {
    	ProponiOfferta proponiOfferta = new ProponiOfferta();
    	if(note == null || note.equals("") ||  data == null || data.equals("")){
    		return false;
    	}else {	
  	  		proponiOfferta.proponi(idShop, idEv, prezzo ,data, note);	
  	  		return true;
    	}
    }

   

    
    public void load(int idShop, int idEvento) {
    	this.idShop = idShop;
    	this.idEv = idEvento;
    }
}
