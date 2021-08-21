package beanweb;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestisciDonazioniCaritas;
import entity.DonazioneTab;




public class GestisciDonazioniBoundary {
	private int caritas;

	private int idVolontario;
	private GestisciDonazioniCaritas gestDon;
	private EmailBoundary email;
	
	
	 private static  GestisciDonazioniBoundary instance  = null;
	
	 public static  GestisciDonazioniBoundary getInstance() {
			if(instance == null) {
				instance = new  GestisciDonazioniBoundary();
			}
			return instance;
			}
	

		public boolean isNumeric(String str) { 
			Logger logger = LoggerFactory.getLogger(GestisciDonazioniBoundary.class.getName());
			  try {  
			    Integer.parseInt(str); 
			    return true;
			  } catch(NumberFormatException e){  
				  logger.error("Inserisci correttamente l' id donazione");
			    return false;  
			  } 
			}
	 
	public boolean cancellaDonazione(String i) {
		gestDon = new GestisciDonazioniCaritas();
		    	if (i == null || i.equals("") ) {
		    		return false;
		    	}
		    	else {
		    		if(isNumeric(i) == true) {
		    			gestDon.cancellaDonazione(Integer.parseInt(i));
		    		}
		    		return true;
		    	}
		    }
		    

	public void contattaVolontario() {
		email = email.getInstance();
		email.loadEmail(this.idVolontario, caritas);
	}

	
	public boolean ritiraDonazione(String ritira) {
		if (ritira == null || ritira.equals("")) {
			return false;
		}
		else {
			if(isNumeric(ritira) == true) {
				gestDon.ritiraDon(Integer.parseInt(ritira));
			}
			return true;
		}
	}


	public List<DonazioneTab> loadFormDonazione() {
			return gestDon.visualizzaDonazioni(caritas);	
	}

	public void loadFormBoundary(int caritas ) {
		this.caritas = caritas;
	}
	
	private GestisciDonazioniBoundary() {
		this.gestDon = new GestisciDonazioniCaritas();
		new ArrayList<>();
	}



}
