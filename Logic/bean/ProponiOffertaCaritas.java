package bean;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.ProponiOfferta;
import exception.MyException;
import exception.MyIOException;
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
    

   

  @FXML
  void conferma(ActionEvent event) {
  	ProponiOfferta proponiOfferta = new ProponiOfferta();
  	Trigger trigger = new Trigger();
  	try {
  		if(trigger.isNumeric(prezzo.getText()) && check()) {
	  		proponiOfferta.proponi(idShop, idEv, Float.parseFloat(prezzo.getText()),dataEvento.getValue().toString(), note.getText());	
			this.switchPage(conferma.getScene().getWindow());}
  		}catch(MyException e) {
  			logger.error(e.getMessage());
  		}catch (NumberFormatException n) {
  			logger.error("Non sono presenti solo numeri in Prezzo Evento." + n.getMessage());
  		}
  	}
  
    public boolean check() throws MyException {
    	if(dataEvento.getValue() == null) {
    		MyException e = new MyException("Alcuni campi sono vuoti");
			e.setErrorNumber(MyException.CAMPI_VUOTI);
			throw e;
    	}
		return true;
    }


    @FXML
    public void indietro(ActionEvent event) {
    	 this.switchPage(conferma.getScene().getWindow());
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

		}catch (Exception e) {
			logger.error(e.getMessage());
			MyIOException.openPageFault("Shop Event propose");
		}
	}
    

    
    public void load(int idShop, int idEvento) {
    	this.idShop = idShop;
    	this.idEv = idEvento;
    }
}
