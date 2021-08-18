package bean;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.DonationController;
import exception.MyException;
import exception.Trigger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DonationBoundary {
	private static Logger logger = LoggerFactory.getLogger(DonationBoundary.class.getName());
	private Trigger trigger;
	
	@FXML
	private RadioButton vestiti;

	@FXML
	private RadioButton cibo;

	@FXML
	private Button donazione;

	@FXML
	private Button indietro;

	@FXML
	private TextField indirizzo;

	@FXML
	private TextArea descrizione;

	private TextField[] textFields;

	private DonationController controller;

	public DonationBoundary() {
		controller = DonationController.getInstance();
		trigger = new Trigger();
	}

	@FXML
	public void creaDonazione(ActionEvent event) {
		int i = checker();
		if (i != -1) {
			controller.setIndirizzo(this.indirizzo.getText());
			controller.setDescrizione(this.descrizione.getText());
			controller.creaDonazione();
			Stage st = (Stage) donazione.getScene().getWindow();
			st.close();
		}
		else {
			try {
			  	trigger.myTrigger();
			}catch(MyException e) {
				logger.error("Alcuni campi sono vuoti");
			}
			
		}
	}

	public void initialize() {
		textFields = new TextField[] { indirizzo };

	}

	public int checker() {
		// Controlla che non ci siano campi lasciati vuoti
		for (int i = 0; i < textFields.length; i++) {
			if (textFields[i].getText().isEmpty()) {
				return -1;
			}
		}
		if (cibo.isSelected()) {
			controller.setTipologia(2);
			return 0;
		}
		// Almeno uno dei tipi deve essere selezionato
		else if (vestiti.isSelected()) {
			controller.setTipologia(1);
			return 0;
			// Almeno uno dei tipi deve essere selezionato
		} else {
			return -1;
		}
	}

	

	public void initBoundary(int idCar, int idUte) {
		controller.initController(idCar, idUte);
	}

}
