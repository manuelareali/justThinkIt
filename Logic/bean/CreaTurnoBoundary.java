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
	


	@FXML
	private Button back;

	@FXML
	private Button creaTurno;

	@FXML
	private TextArea note;

    @FXML
    private ChoiceBox<String> orain;

    @FXML
    private ChoiceBox<String> oraFin;

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


	public boolean checker() throws MyException {
		// Controlla che non ci siano campi lasciati vuoti	
		if(giorni.getValue() == null || orain.getValue() == null  || oraFin.getValue() == null || numParte.getText() == null) {
			MyException e = new MyException("Alcuni campi sono vuoti.");
			e.setErrorNumber(MyException.CAMPI_VUOTI);
			throw e;
		}
		if(orain.getValue() == oraFin.getValue()) {
			MyException ex = new MyException("Devi inserire orari diversi");
			 ex.setErrorNumber(MyException.ORARIO);
			throw ex;
		}
		return true;
	}


	
	@FXML
	void creaTurnoPressed(ActionEvent event) {
		Trigger trigger = new Trigger(); 
		CreaTurnoController creaTurn = new CreaTurnoController();
		try {
			if (checker() && trigger.isNumeric(numParte.getText())) {
				creaTurn.creaTurno(caritas, giorni.getValue().toString(), orain.getValue().toString(), oraFin.getValue().toString(),
						Integer.parseInt(numParte.getText()), note.getText());
					this.switchPage(creaTurno.getScene().getWindow());
			}}catch(MyException e) {
				logger.error(e.getMessage());
	  		}catch (NumberFormatException n) {
	  			logger.error("Non sono presenti solo numeri \n" + n.getMessage());
	  		}catch (Exception e) {
				logger.error(e.getMessage());
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
		String[] days = { "Lunedi", "Marted�", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica" };

		for (int i = 0; i < 7; i++) {

			giorni.getItems().add(days[i]);

		}
		String[] oraIn = { "7:00", "7:30", "8:00", "8:30", "9:00", "9:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00",
				"13:30", "14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30"};
		
		for(int i= 0; i<30; i++) {
			orain.getItems().add(oraIn[i]);
		}
		
		String[] oraFine = {"7:30", "8:00", "8:30", "9:00", "9:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00",
				"13:30", "14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00"};
		
		for(int i= 0; i<30; i++) {
			oraFin.getItems().add(oraFine[i]);
		}
		

	}

}
