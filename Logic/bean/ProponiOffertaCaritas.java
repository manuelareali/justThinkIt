package bean;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestisciEventiController;
import controller.ProponiOfferta;
import controller.ShopHomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TextField dataEvento;

    @FXML
    private TextArea note;

    @FXML
    private Button conferma;
    
    @FXML
    private Button indietro;
    

    @FXML
    void conferma(ActionEvent event) {
    	ProponiOfferta proponiOfferta = new ProponiOfferta();
    	if(note.getText() != null && prezzo.getText() != null && dataEvento.getText() != null) {
  	  		proponiOfferta.proponi(idShop, idEv, Float.parseFloat(prezzo.getText()),dataEvento.getText(), note.getText());	
			this.switchPage(conferma.getScene().getWindow());
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
