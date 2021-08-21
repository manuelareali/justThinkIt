package bean;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestisciEventiCaritasController;
import entity.EventTab;
import exception.MyException;
import exception.Trigger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GestisciEventiCaritasBoundary {
	private static Logger logger = LoggerFactory.getLogger(GestisciEventiCaritasBoundary.class.getName());
	private GestisciEventiCaritasController gestEventC;
	private int idCar;
	private PromuoviEventoGenerale promEv;
	private EventTab event;
	String s = "Devi selezionare una riga della tabella";
	private Trigger trigger;

	@FXML
	private TableView<EventTab> tab;

	@FXML
	private TableColumn<EventTab, String> nomeEvento;

	@FXML
	private TableColumn<EventTab, String> nomeNegozio;

	@FXML
	private TableColumn<EventTab, String> noteEvento;

	@FXML
	private TableColumn<EventTab, Float> importo;

	@FXML
	private TableColumn<EventTab, Integer> numPartecipanti;

	@FXML
	private TableColumn<EventTab, String> stato;

	@FXML
	private Button cancellaEvento;

	@FXML
	private Button contattaNegozio;

	@FXML
	private Button back;
	
	@FXML
	private Button confEvent;

    @FXML
    private Button creaEventoGenerale;

	@FXML
	boolean cancellaEvent(ActionEvent event) {
		if(this.event != null) {
			return gestEventC.cancellaEvento(this.event.getId());
		}else {
			try {
				trigger.myTrigger();
				
			} catch (MyException e) {
				logger.error(s);
			}
			return false;
		}

	}

	@FXML
	void backtomenu(ActionEvent event) {
		TransizionePagine pageSwitch = new TransizionePagine();
		pageSwitch.backToMenuCaritas(idCar, back.getScene().getWindow());

	}

	@FXML
	boolean confermaEvento(ActionEvent event) {
		if(this.event != null && this.event.getCodiceNegozio() != 0) {
			return gestEventC.confermaEvento(this.event.getId());
		} else {
			if(this.event == null) {
				try {
					trigger.myTrigger();
				} catch (MyException e) {
					logger.error(s);
				} 
			}else {
				try {
					trigger.myTrigger();
				} catch (MyException e) {
					logger.error("Non puoi selezionare questo evento, verifica se ci sono offerte da parte dei negozi.");
				} 
			}
				
			return false;
		}

	}
	
	
	@FXML
	void contattaShop(ActionEvent event) {
		if (this.event != null) {
			TransizionePagine pageSwitch = new TransizionePagine();
			pageSwitch.goToEmail(this.event.getCodiceNegozio(), idCar);
		} else {
			try {
				trigger.myTrigger();
			} catch (MyException e) {
				logger.error(s);
			}
		}

	}

	@FXML
	void eventClicked(MouseEvent event) {
		this.event = tab.getSelectionModel().getSelectedItem();

	}

	public void loadShop(int idCar) {
		this.idCar = idCar;
		List<EventTab> listEv = gestEventC.caricaEventi(this.idCar);
		
		ObservableList<EventTab> data = FXCollections.observableArrayList(listEv);
		nomeEvento.setCellValueFactory(new PropertyValueFactory<>("NomeEvento"));
		importo.setCellValueFactory(new PropertyValueFactory<>("rapportoDenaro"));
		nomeNegozio.setCellValueFactory(new PropertyValueFactory<>("NomeNegozio"));
		noteEvento.setCellValueFactory(new PropertyValueFactory<>("NoteEvento"));
		stato.setCellValueFactory(new PropertyValueFactory<>("StatoEvento"));

		tab.setItems(data);
		
	}
	
	
    @FXML
    void creaEventoGenerale(ActionEvent event) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ProponiEventoGenerale.fxml"));
				Parent root = loader.load();
				this.promEv = loader.getController();
				this.promEv.loadId(idCar);
				Stage home = (Stage) creaEventoGenerale.getScene().getWindow();
				home.setScene(new Scene(root, 750, 500));

				home.show();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
    

	public GestisciEventiCaritasBoundary() {
		gestEventC = new GestisciEventiCaritasController();
		trigger = new Trigger();
		promEv = new PromuoviEventoGenerale();
	}

}
