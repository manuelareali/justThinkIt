package bean;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.GestisciEventiController;
import controller.ShopHomeController;
import entity.EventTab;
import exception.MyException;
import exception.MyIOException;
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

public class GestisciEventiBoundary {
	private static Logger logger = LoggerFactory.getLogger(GestisciEventiBoundary.class.getName());

	private GestisciEventiController gestEventC;
	private int idShop;
	private int idCaritas;
	private String s = "error IoException";
	private EventTab event;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button caritas;

	@FXML
	private TableView<EventTab> table;

	@FXML
	private TableColumn<EventTab, String> nomeEvento;

	@FXML
	private TableColumn<EventTab, String> nomeCaritas;
	@FXML
	private TableColumn<EventTab, Integer> noteEvento;

	@FXML
	private TableColumn<EventTab, Integer> numPartecipanti;
	@FXML
	private TableColumn<EventTab, Float> importo;

	@FXML
	private Button eliminaE;

	@FXML
	private Button back;

	
	@FXML
	void backButtonPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
			Parent root = loader.load();
			ShopHomeBoundary  shopC= loader.getController();
			ShopHomeController shopHomeC = new ShopHomeController();
			shopHomeC.initDataShop(idShop, shopC);
			Stage home = (Stage) back.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));

			home.show();
		} catch (IOException e) {
			logger.error(s);
		}

	}

	@FXML
	void contattaCaritas(ActionEvent event) {
		try {
			if (check()) {
				try {
					
					FXMLLoader fxmlLoader = new FXMLLoader();
					Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Email.fxml"));

					EmailBoundary email = fxmlLoader.getController();
					email.loadEmail(this.idCaritas, this.idShop);
					Stage stage = new Stage();
					stage.setTitle("Email");

					stage.setScene(new Scene(rootNode, 800, 500));
					stage.setResizable(false);
					stage.show();

				} catch (Exception e) {
					logger.error(e.getMessage());
					MyIOException.openPageFault("Email");
				}
			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
			
		

	

	@FXML
	public void eliminaEvento(ActionEvent event) {
		try {
			if(check()) {
				gestEventC.cancellaEvento(this.event.getId());
			}
		}catch(MyException ex) {
			logger.error(ex.getMessage());
		}
	}


	@FXML
	void prendiEvento(MouseEvent e) {
		this.event = table.getSelectionModel().getSelectedItem();
		this.idCaritas = event.getIdCaritas();
	}
	
	
	public boolean check() throws MyException {
		if(this.event == null && this.idCaritas == 0) {
			MyException e = new MyException("Devi selezionare una riga della tabella.");
			e.setErrorNumber(MyException.NEGOZIO_ERROR);
			throw e;
		}
		return true;
	}
	

	public GestisciEventiBoundary() {
		gestEventC = new GestisciEventiController();

	}

	public GestisciEventiBoundary(int i) {

		gestEventC = new GestisciEventiController();
		this.idShop = i;

	}

	public void loadShop(int idShop) {
		this.idShop = idShop;
		List<EventTab> listEv = gestEventC.caricaEventi(this.idShop);

		ObservableList<EventTab> data = FXCollections.observableArrayList(listEv);
		nomeEvento.setCellValueFactory(new PropertyValueFactory<>("NomeEvento"));
		importo.setCellValueFactory(new PropertyValueFactory<>("rapportoDenaro"));
		nomeCaritas.setCellValueFactory(new PropertyValueFactory<>("NomeCaritas"));
		noteEvento.setCellValueFactory(new PropertyValueFactory<>("NoteEvento"));


		table.setItems(data);

	}


}