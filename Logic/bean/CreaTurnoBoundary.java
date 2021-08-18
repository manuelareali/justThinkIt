package bean;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.CreaTurnoController;
import exception.MyException;
import exception.Trigger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CreaTurnoBoundary {
	private static Logger logger = LoggerFactory.getLogger(CreaTurnoBoundary.class.getName());
	
	private TextField[] text ;
	private TextArea[] textArea;
	
	private Trigger trigger;
	
	public CreaTurnoBoundary() {
		trigger = new Trigger();
	}

	@FXML
	private Button back;

	@FXML
	private Button creaTurno;

	@FXML
	private TextArea note;

	@FXML
	private TextField orain;

	@FXML
	private TextField oraFin;

	@FXML
	private ChoiceBox<String> giorni;

	@FXML
	private TextField numParte;

	private int caritas;

	@FXML
	void backPressed(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_turni_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) back.getScene().getWindow();
			GestisciTurniBoundary gestTurn;
			gestTurn = loader.getController();
			
			gestTurn.loadFormBoundary(caritas);
			home.setScene(new Scene(root, 883, 550));
			home.show();

		} catch (IOException e) {
			logger.error("errore IoException");
		}

	}


	public boolean checker() {
		// Controlla che non ci siano campi lasciati vuoti
		for (int i = 0; i < text.length; i++) {
			if (text[i].getText().isEmpty()){
				return false;
			}
		}	
		return true;
	}
	
	@FXML
	void creaTurnoPressed(ActionEvent event) {
		CreaTurnoController creaTurn = new CreaTurnoController();
		if (checker() && giorni.getValue() != null && !textArea[0].getText().isEmpty()) {
				creaTurn.creaTurno(caritas, giorni.getValue().toString(), orain.getText(), oraFin.getText(),
						Integer.parseInt(numParte.getText()), note.getText());
					this.switchPage(creaTurno.getScene().getWindow());
		} else {
				try {
					trigger.myTrigger();
				} catch (MyException e) {
					logger.error("Alcuni campi sono vuoti");
				}
			}
		} 
	

	public void setCaritas(int caritas) {
		this.caritas = caritas;
	}
	
	public void switchPage(Window stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_turni_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) stage;
			home.setScene(new Scene(root, 885, 550));
			home.show();

			GestisciTurniBoundary gest = loader.getController();
			gest.loadFormBoundary(caritas); 

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	@FXML
	void initialize() {

		String[] days = { "Lunedi", "Martedì", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica" };

		for (int i = 0; i < 7; i++) {

			giorni.getItems().add(days[i]);

		}
		
		text = new TextField[] {
				this.oraFin, 
				this.orain,
				this.numParte
		};
		
		textArea = new TextArea[] {
				this.note
		};

	}

}
