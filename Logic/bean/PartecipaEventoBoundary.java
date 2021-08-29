package bean;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.PartecipaEventoController;
import exception.MyException;
import exception.Trigger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PartecipaEventoBoundary {

	private int idUtente;
	private int idEvento;



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
	


	@FXML
	void partecipaEvento(ActionEvent event) {
		 Logger logger = LoggerFactory.getLogger(PartecipaEventoBoundary.class.getName());
		Trigger trigger = new Trigger();
		try {
			if(trigger.isNumeric(importo.getText())) {
				PartecipaEventoController parteCon = new PartecipaEventoController();
				parteCon.setDataController(idEvento, idUtente);
				parteCon.partecipaEvento(Float.parseFloat(importo.getText()));
				Stage st = (Stage) partecipa.getScene().getWindow();
				st.close();
			}
		} catch (NumberFormatException n) {
			logger.error("In prezzo Evento non sono presenti solo numeri"+ n.getMessage());
			
		} catch (MyException e) {
			logger.error(e.getMessage());			
		}
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
