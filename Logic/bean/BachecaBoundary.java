package bean;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.BachecaController;
import entity.Necessita;
import exception.MyIOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BachecaBoundary {
	private static Logger logger = LoggerFactory.getLogger(BachecaBoundary.class.getName());
	private int idCar;
	private int idUte;

	@FXML
	private Text nomeCaritas;

	@FXML
	private TextArea cibo;

	@FXML
	private TextArea varie;

	@FXML
	private TextArea vestiti;
	
    @FXML
    private TableView<Necessita> tab;
	
    @FXML
    private TableColumn<Necessita, String> tipologia;

    @FXML
    private TableColumn<Necessita, String> descrizione;

    @FXML
    private TableColumn<Necessita, String> urgenza;

	@FXML
	void creaDonazione(ActionEvent event) {
		try {

			DonationBoundary donationBoundary;

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Donation.fxml"));

			donationBoundary = fxmlLoader.getController();

			Stage stage = new Stage();
			stage.setTitle("Donazione");
			donationBoundary.initBoundary(idCar, idUte);
			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);
			stage.show();

		} catch (Exception e) {
			logger.error(e.getMessage());
			MyIOException.openPageFault("Email");
		}

	}

	@FXML
	void creaEmail(ActionEvent event) {

		EmailBoundary emailBoundary;

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();

			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Email.fxml"));

			emailBoundary = fxmlLoader.getController();

			Stage stage = new Stage();
			stage.setTitle("Email");

			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);

			emailBoundary.loadEmail(idCar, idUte);

			stage.show();

		} catch (IOException e) {
			logger.error(e.getMessage());
		}

	}

	public void loadFormBoundary(int idCar, int idUte) {
		this.idCar = idCar;
		this.idUte = idUte;
		BachecaController bachecaController = new BachecaController();
		List<Necessita> necessita = bachecaController.loadForm(idCar);

		ObservableList<Necessita> data = FXCollections.observableArrayList(necessita);
		descrizione.setCellValueFactory(new PropertyValueFactory<>("Descrizione"));
		tipologia.setCellValueFactory(new PropertyValueFactory<>("Tipologia"));
		urgenza.setCellValueFactory(new PropertyValueFactory<>("Urgenza"));

		tab.setItems(data);

		}

	

}
