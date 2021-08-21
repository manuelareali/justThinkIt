package bean;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.PartecipaEventoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PartecipaEventoBoundary {

	private int idUtente;
	private int idEvento;

	private TextField[] textFields;

	@FXML
	private ResourceBundle resources;

	@FXML
	private TextField importo;

	@FXML
	private TextField cdc;

	@FXML
	private ImageView imgEvento;

	@FXML
	private Button partecipa;

	@FXML
	private Button indietro;
	
	public boolean isNumeric(String str) { 
		Logger logger = LoggerFactory.getLogger(PartecipaEventoBoundary.class.getName());
		try {  
		  Float.parseFloat(str); 
		  return true;
		} catch(NumberFormatException e){  
			logger.error("Inserisci correttamente l'importo da donare");
		  return false;  
		} 
	}


	@FXML
	void partecipaEvento(ActionEvent event) {
		if(isNumeric(importo.getText()) == true) {
			PartecipaEventoController parteCon = new PartecipaEventoController();
			parteCon.setDataController(idEvento, idUtente);
			parteCon.partecipaEvento(Float.parseFloat(importo.getText()));
			Stage st = (Stage) partecipa.getScene().getWindow();
			st.close();
		}
	}

	public int checker() {

		// Controlla che non ci siano campi lasciati vuoti
		for (int i = 0; i < textFields.length; i++) {
			if (textFields[i].getText().isEmpty()) {

				return -1;
			}

		}
		return 0;

	}

	public void initialize() {

		textFields = new TextField[] { importo, cdc };

	}

	public void setData(int idEvento, int idVolontario) {
		this.idEvento = idEvento;
		this.idUtente = idVolontario;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public int getIdEvento() {
		return idEvento;
	}

}
