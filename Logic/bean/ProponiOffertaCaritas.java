package bean;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import beanweb.CreaTurnoBoundary;
import controller.ProponiOfferta;
import exception.MyException;
import exception.Trigger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ProponiOffertaCaritas {

 	Logger logger = LoggerFactory.getLogger(ProponiOffertaCaritas.class.getName());
	private int idShop;
	private int idEv;
	
    @FXML
    private TextField prezzo;
    @FXML
    private DatePicker dataEvento;

    @FXML
    private TextArea note;

    @FXML
    private Button conferma;
    
    @FXML
    private Button indietro;
    
    
	public boolean isNumeric(String str) { 
		Logger logger = LoggerFactory.getLogger(ProponiOffertaCaritas.class.getName());
		  try {  
			  Float.parseFloat(str); 
		    return true;
		  } catch(NumberFormatException e){  
			  logger.error("Inserisci correttamente il prezzo dell'evento");
		    return false;  
		  } 
		}

    @FXML
    void conferma(ActionEvent event) {
    	ProponiOfferta proponiOfferta = new ProponiOfferta();
    	if(isNumeric(prezzo.getText()) && dataEvento.getValue() != null) {
  	  		proponiOfferta.proponi(idShop, idEv, Float.parseFloat(prezzo.getText()),dataEvento.getValue().toString(), note.getText());	
			this.switchPage(conferma.getScene().getWindow());
    	}else {
    		Trigger trigger = new Trigger();
    		try {
    			trigger.myTrigger();
    		}catch(MyException e) {
    			logger.error("Alcuni campi sono vuoti");
    		}
    	}
    }


    @FXML
    void indietro(ActionEvent event) {
   
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/EventiPropNeg.fxml"));
			Parent root = loader.load();
			GestisciEventiPropCaritas  prop= loader.getController();
		
			prop.loadShop(idShop);
			Stage home = (Stage) indietro.getScene().getWindow();
			home.setScene(new Scene(root, 800, 500));

			home.show();
		} catch (IOException e) {
			logger.error("IOException");
		}

    }
    
    
    public void switchPage(Window stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/EventiPropNeg.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) stage;
			home.setScene(new Scene(root, 800, 500));
			home.show();

			GestisciEventiPropCaritas gest = loader.getController();
			gest.loadShop(idShop);

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
    

    
    public void load(int idShop, int idEvento) {
    	this.idShop = idShop;
    	this.idEv = idEvento;
    }
}
