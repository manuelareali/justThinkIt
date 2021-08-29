package bean;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.GestisciEventiCaritasController;
import entity.EventTab;
import exception.MyException;
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
	public void cancellaEvent(ActionEvent event) {
		try {
			if(check()) {
				gestEventC.cancellaEvento(this.event.getId());
			}
		} catch (MyException e) {
			logger.error(e.getMessage());
		}

	}

	@FXML
	void backtomenu(ActionEvent event) {
		TransizionePagine pageSwitch = new TransizionePagine();
		pageSwitch.backToMenuCaritas(idCar, back.getScene().getWindow());

	}

	@FXML
	public void confermaEvento(ActionEvent event) {
		try {
			if(check()) {
				 gestEventC.confermaEvento(this.event.getId());
			}
		} catch (MyException e) {
			logger.error(e.getMessage());
		}

	}
	
	
	@FXML
	void contattaShop(ActionEvent event) {
		try {
			if (check()) {
				TransizionePagine pageSwitch = new TransizionePagine();
				pageSwitch.goToEmail(this.event.getCodiceNegozio(), idCar);
			}
		} catch (MyException e) {
			logger.error(e.getMessage());
		}

	}
	
	public boolean check() throws MyException{
		if(this.event == null) {
			MyException e = new MyException("Devi selezionare una riga della tabella");
			e.setErrorNumber(MyException.CARITAS_ERROR);
			throw e;	
		}
		return true;
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
		promEv = new PromuoviEventoGenerale();
	}

}
