package bean;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.PrenotaTurnoController;
import entity.Orario;
import exception.MyException;
import exception.Trigger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrenotaTurnoBoundary {

	private PrenotaTurnoController prenotaC;
	private Trigger trigger;
	private static Logger logger = LoggerFactory.getLogger(PrenotaTurnoBoundary.class.getName());

	public PrenotaTurnoBoundary() {
		trigger = new Trigger();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ChoiceBox<String> turni;

	@FXML
	private ChoiceBox<String> cbOraInizio;

	@FXML
	private ChoiceBox<String> cbOraFine;

	@FXML
	private TextField cv;

	@FXML
	private Button indietro;

	@FXML
	private Button prenota;

	@FXML
	void prenotaTurno(ActionEvent event) {
		if(!checker()) {
			prenotaC.prenotaTurno(turni.getValue().toString(), cbOraInizio.getValue().toString(),
					cbOraFine.getValue().toString(), cv.getText());
			Stage st = (Stage) prenota.getScene().getWindow();
			st.close();
		}else {
			try {
				trigger.myTrigger();
			} catch (MyException e) {
				logger.error("Alcuni campi sono vuoti");
			}
		}
	}

	public boolean checker() {
		
		if(turni.getValue() == null || cbOraInizio.getValue() == null || cbOraFine.getValue() == null|| cv.getText().isEmpty() || cbOraInizio.getValue().toString().contentEquals(cbOraFine.getValue().toString())) {
			return true;
		}
	return false;
}

	@FXML
	void initialize() {
		prenotaC = new PrenotaTurnoController();

		String[] giorni;

		giorni = prenotaC.inizializzaGiorni();

		for (int i = 0; i < 8; i++) {
			turni.getItems().add(giorni[i]);
		}

		List<Orario> oraArrayList = prenotaC.initializzaOrari();

		int i = 0;
		
		while (i < oraArrayList.size()) {
			
			cbOraInizio.getItems().add(oraArrayList.get(i).getOraFine());

			cbOraFine.getItems().add(oraArrayList.get(i).getOraInizio());

			i++;
		}
		

	}

	public void setData(int idCar, int idUte) {
		prenotaC.setDataController(idCar, idUte);
	}
}
