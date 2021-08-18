package bean;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.UserHomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CaritasHomeBoundary {

	private int idCar;
	
	private static CaritasHomeBoundary instance = null;
	private static Logger logger = LoggerFactory.getLogger(CaritasHomeBoundary.class.getName());
	private String s = "errore IoException";

	private GestisciTurniBoundary gestTurn;
	private GestisciDonazioniBoundary gestDon;
	private GestisciOffertaCaritas gestOff;
	private BachecaPersonaleBoundary bacheca;




	@FXML
	private Button deleteAccountButton;

	@FXML
	private Button vBacheca;

	@FXML
	private Font x1;

	@FXML
	private Button eventiC;

	@FXML
	private Button turni;

	
	@FXML
	private Button logoutButton;

	@FXML
	private ImageView arrowRight;

	@FXML
	private ImageView arrowLeft;

	@FXML
	private Text nomeCognome;
	
    @FXML
    private Button openMappa;

	@FXML
	private ImageView profileImage;

	@FXML
	private Button gestisciDona;
	
    @FXML
    private Button offerteProposte;

	public static CaritasHomeBoundary getInstance() {
		if (instance == null) {
			instance = new CaritasHomeBoundary();
		}
		return instance;
	}

	public CaritasHomeBoundary() {
		bacheca = new BachecaPersonaleBoundary();
		gestTurn = new GestisciTurniBoundary();
		gestDon = new GestisciDonazioniBoundary();
		gestOff = new GestisciOffertaCaritas();
	}
	

    @FXML
    void openMappa(ActionEvent event) {
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.idCar, openMappa.getScene().getWindow());

    }

	@FXML
	void gestisciDonazioni(ActionEvent event) {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("../boundary/Gestisci_Donazioni.fxml"));
			gestDon = fxmlLoader.getController();
			Stage stage = (Stage) eventiC.getScene().getWindow();
			stage.setTitle("Gestisci Eventi");
		
			gestDon.loadFormBoundary(idCar);
			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			logger.error(s);
		}
	}

	@FXML
	void gestisciEventi(ActionEvent event) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader
					.load(getClass().getResourceAsStream("../boundary/Gestisci_eventi_caritas.fxml"));
			GestisciEventiCaritasBoundary gestisciB = fxmlLoader.getController();
			Stage stage = (Stage) eventiC.getScene().getWindow();
			stage.setTitle("Gestisci Eventi");
			
			gestisciB.loadShop(idCar);
			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			logger.error(s);
		}
	}

	@FXML
	void gestisciTurni(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_turni_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) turni.getScene().getWindow();

			gestTurn = loader.getController();

			gestTurn.loadFormBoundary(idCar);

			home.setScene(new Scene(root, 883, 550));
			home.show();

		} catch (IOException e) {
			logger.error(s);
		}

	}

	@FXML 
	void visualizzaBacheca(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Bacheca_Personale.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) vBacheca.getScene().getWindow();
			home.setScene(new Scene(root, 775, 500));
			home.show();

			bacheca = loader.getController();
		
			bacheca.loadFormBoundary(idCar);

		} catch (IOException e) {
			logger.error(s);
		}
	}

	 @FXML
	    void deleteAccountButtonPressed(ActionEvent event) {
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Logout");
	    	alert.setHeaderText("Se cancelli il tuo account verrano cancellati anche le tue attività in corso e potresti ricevere delle sanzioni");
	    	alert.setContentText("Sei sicuro di voler cancellare il tuo account?");
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    		UserHomeController controller = new UserHomeController();
	    		controller.deleteAccount(idCar);
	    		TransizionePagine pageSwitch = new TransizionePagine();
	    		pageSwitch.backToLogin(deleteAccountButton.getScene().getWindow());
	    	
	    	} 	
	    }


	    @FXML
	    void offerteProposte(ActionEvent event) {
	    	Logger logger = LoggerFactory.getLogger(GestisciOffertaCaritas.class.getName());
	    	try {

				FXMLLoader fxmlLoader = new FXMLLoader();
				Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/GestisciOfferte.fxml"));

				gestOff = fxmlLoader.getController();
				Stage stage = (Stage) offerteProposte.getScene().getWindow();
				stage.setTitle("Gestisci Offerte agli Eventi Proposti dalle Caritas");
				gestOff.loadFormBoundary(idCar);
				stage.setScene(new Scene(rootNode, 830, 530));
				stage.setResizable(false);
				stage.show();

			} catch (IOException e) {
				logger.error(e.getMessage());
			}
	    	
	    }


	@FXML
	void logoutButtonPressedCaritas(ActionEvent event) {
	 	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());
    	

	}

	public void initDataC(int id, String nome) {
		this.idCar = id;
		nomeCognome.setText(nome);
		final Circle clip = new Circle();
		clip.setCenterX(25);
		clip.setCenterY(58);
		clip.setRadius(200);
		profileImage.setClip(clip);
		

	}

}
