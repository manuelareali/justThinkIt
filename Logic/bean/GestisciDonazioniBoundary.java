package bean;



import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.GestisciDonazioniCaritas;
import entity.DonazioneTab;
import exception.MyException;
import exception.Trigger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class GestisciDonazioniBoundary {
	Logger logger = LoggerFactory.getLogger(GestisciDonazioniBoundary.class.getName());
	private Trigger trigger;
	String s = "Devi selezionare una riga della tabella";
	
		
	@FXML
	private TableView<DonazioneTab> table;

	@FXML
	private TableColumn<DonazioneTab, String> nomeVolontario;
	
	@FXML
	private TableColumn<DonazioneTab, String> tipologia;

	@FXML
	private TableColumn<DonazioneTab, String> descrizione;

	@FXML
	private TableColumn<DonazioneTab, String> indirizzo;

	@FXML
	private TableColumn<DonazioneTab, String> stato;
	
  

	@FXML
	private Button ritira;

	@FXML
	private Button contatta;

	@FXML
	private Button back;

	@FXML
	private Button cancella;
	

	private List<DonazioneTab> listDon;

	private int caritas;

	private int idVolontario = 0;
	private int idDono;

	private GestisciDonazioniCaritas gestDon;
	
	@FXML
	void cancellaDonazione(ActionEvent event) {
		if(this.idVolontario != 0) {
			gestDon.cancellaDonazione(this.idDono);
		}else {
			try {
				trigger.myTrigger();
			}catch(MyException e) {
				logger.error(s);
			}
		}

	}

	@FXML
	void backPressed(ActionEvent event) {
		
		TransizionePagine pageSwitch = new TransizionePagine();
		pageSwitch.backToMenuCaritas(caritas, back.getScene().getWindow());
		

	}

	@FXML
	void contattaVolontario(ActionEvent event) {
		
		if(this.idVolontario != 0) {
			TransizionePagine pageSwitch = new TransizionePagine();
			pageSwitch.goToEmail(idVolontario, caritas, contatta.getScene().getWindow());
		}else {
			try {
				trigger.myTrigger();
			}catch(MyException e) {
				logger.error(s);
			}
		}

	}
	
	




	@FXML
	void ritiraDonazione(ActionEvent event) {
		if(this.idVolontario != 0) {
			gestDon.ritiraDon(this.idDono);
		}else {
			try {
				trigger.myTrigger();
			} catch (MyException e) {
				logger.error(s);
			}
		}

	}

	@FXML
	void donationSelect(MouseEvent event) {
		this.idVolontario = table.getSelectionModel().getSelectedItem().getCodVol();
		this.idDono = table.getSelectionModel().getSelectedItem().getIdDon();
	}

	public void loadFormBoundary(int idCar) {
		this.caritas = idCar;
		this.listDon = gestDon.visualizzaDonazioni(caritas);
		ObservableList<DonazioneTab> data = FXCollections.observableArrayList(this.listDon);
		this.nomeVolontario.setCellValueFactory(new PropertyValueFactory<>("nomeVolontario"));
		this.tipologia.setCellValueFactory(new PropertyValueFactory<>("tipologia"));
		this.descrizione.setCellValueFactory(new PropertyValueFactory<>("descrizione"));
		this.indirizzo.setCellValueFactory(new PropertyValueFactory<>("indirizzo"));
		this.stato.setCellValueFactory(new PropertyValueFactory<>("stato"));
		table.setItems(data);

	}

	public GestisciDonazioniBoundary() {
		this.gestDon = new GestisciDonazioniCaritas();
		listDon = new ArrayList<>();
		trigger = new Trigger();
	}


}
