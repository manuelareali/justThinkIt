package beanweb;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestisciDonazioniCaritas;
import entity.DonazioneTab;
import exception.MyException;
import exception.Trigger;




public class GestisciDonazioniBoundary {
	private int caritas;
	private Logger logger = LoggerFactory.getLogger(GestisciDonazioniBoundary.class.getName());
	private  Trigger trigger;
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
	

	public boolean cancellaDonazione(String i) {
		 
		gestDon = new GestisciDonazioniCaritas();
		    	if (i == null || i.equals("") ) {
		    		return false;
		    	}
		    	else {
		    		try {
						if(trigger.isNumerico(i)) {
							gestDon.cancellaDonazione(Integer.parseInt(i));
						}
					} catch (NumberFormatException e) {
						logger.error("Inserisci un id corretto" + e.getMessage());
					} catch (MyException e) {
						logger.error(e.getMessage());
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
			try {
				if(trigger.isNumerico(ritira)) {
					gestDon.ritiraDon(Integer.parseInt(ritira));
				}
			} catch (NumberFormatException e) {
				logger.error("Inserisci un id corretto" + e.getMessage());
			} catch (MyException e) {
				logger.error(e.getMessage());
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
		trigger = new Trigger();
		new ArrayList<>();
	}



}
