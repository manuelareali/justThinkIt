package bean;




import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestisciEventiCaritasController;
import exception.MyException;
import exception.Trigger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;


public class PromuoviEventoGenerale {
	
	Logger logger = LoggerFactory.getLogger(PromuoviEventoGenerale.class.getName());


	private int idCar;
	private String tipo;
	private int idShop;
	

	
    @FXML
    private TextField nome;

    @FXML
    private TextField prezzo;

    @FXML
    private RadioButton idCibo;

    @FXML
    private RadioButton idVestiti;

    @FXML
    private RadioButton tutto;

    @FXML
    private TextArea note;

    @FXML
    private Button confermaEventoPressed;
   
    @FXML
    private Button indietro;
    

    
 
  
    public void loadId(int idCar) {
    	this.idCar = idCar;
    }
    
    @FXML
    void indietro(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_eventi_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) indietro.getScene().getWindow();
	
			GestisciEventiCaritasBoundary gestCar = loader.getController();
			
			gestCar.loadShop(idCar);
			home.setScene(new Scene(root, 800, 500));
			home.show();

		} catch (IOException e) {
			logger.error("errore IoException");
		}
    }

    @FXML
	void confermaEventoPressed(ActionEvent event) {
    	Trigger trigger = new Trigger();
		GestisciEventiCaritasController controller = new GestisciEventiCaritasController();
		float x = (float) 0.0;
			if (!checker() ) {
				controller.creaEventoGeneral(nome.getText(), tipo, x, note.getText(), this.idCar, this.idShop);
				this.switchPage(confermaEventoPressed.getScene().getWindow());
		}else {
			try {
				trigger.myTrigger();
			}catch(MyException e) {
				logger.error("Alcuni campi sono vuoti");
			}
		}
	}
    
    public void switchPage(Window stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_eventi_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) stage;
			home.setScene(new Scene(root, 800, 500));
			home.show();

			GestisciEventiCaritasBoundary gest = loader.getController();
			gest.loadShop(idCar);

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
    
	public boolean checker() {
		if (idCibo.isSelected()) {
			tipo = "Cibo";
		}
	
		else if (idVestiti.isSelected()) {
			tipo = "Vestiti";
			
		}else if(tutto.isSelected()) {
			tipo = "Tutto";
			
		}
		
		if(nome.getText().isEmpty() || tipo == null) {
			return true;
		}
		return false; 				
	}


}

