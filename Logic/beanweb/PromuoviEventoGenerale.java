package beanweb;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.GestisciEventiCaritasController;

public class PromuoviEventoGenerale {
	
	Logger logger = LoggerFactory.getLogger(PromuoviEventoGenerale.class.getName());


	private int idCar;
	private int idShop;

	private static PromuoviEventoGenerale instance = null;
	
	public static PromuoviEventoGenerale getInstance() {
		if(instance == null) {
			instance = new PromuoviEventoGenerale();
		}
		return instance;
		}
	

	
    public void loadId(int idCar) {
    	this.idCar = idCar;
    }


    public boolean confermaEventoPressed(String nome, String tipo, Float x, String note) {
    	if(nome == null || nome.equals("") || tipo == null || tipo.equals("") ||note == null || note.equals("") ) {
    		return false;
    	}else {
    		GestisciEventiCaritasController controller = new GestisciEventiCaritasController();
    		controller.creaEventoGeneral(nome, tipo, (float) 0.0, note, this.idCar, this.idShop);
			return true;
    	}
	   	}
		
	
    

    


}

