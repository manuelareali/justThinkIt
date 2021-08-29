package bean;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.ShopHomeController;
import exception.MyIOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShopHomeBoundary {
	

	

	private int idShop;
	

	
    @FXML
    private Button gestEvent;

    @FXML
    private Button deleteAccountButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Text nomeCognome;


    @FXML
    private Button searchCaritasButton;

    @FXML
    private Button gestisciProposteCaritas;

  


    @FXML
    public void cercaCaritas(ActionEvent event) {
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.idShop, searchCaritasButton.getScene().getWindow());

    }

    

    @FXML
    public void deleteAccountButtonPressed(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Logout");
    	alert.setHeaderText("Se cancelli il tuo account verrano cancellati anche le tue attività in corso e potresti ricevere delle sanzioni");
    	alert.setContentText("Sei sicuro di voler cancellare il tuo account?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		ShopHomeController controller = new ShopHomeController();
    		controller.deleteAccount(idShop);
    		TransizionePagine pageSwitch = new TransizionePagine();
    		pageSwitch.backToLogin(deleteAccountButton.getScene().getWindow());
    	
    	} 	
    }
    

    @FXML
    public void gestisciProposteCaritas(ActionEvent event) {
    	Logger logger = LoggerFactory.getLogger(ShopHomeBoundary.class.getName());
    	try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/EventiPropNeg.fxml"));

			GestisciEventiPropCaritas gestisciProp = fxmlLoader.getController();
			Stage stage = (Stage) gestEvent.getScene().getWindow();
			stage.setTitle("Gestisci Eventi Proposti dalle Caritas");
			gestisciProp.loadShop(idShop);
			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);
			stage.show();

		}catch (Exception e) {
			logger.error(e.getMessage());
			MyIOException.openPageFault("Shope event propose");
		}
    }

    
	@FXML
	public void gestisciEventi(ActionEvent event) {
		Logger logger = LoggerFactory.getLogger(ShopHomeBoundary.class.getName());
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Eventi2.fxml"));

			GestisciEventiBoundary gestisciBoundary = fxmlLoader.getController();
			Stage stage = (Stage) gestEvent.getScene().getWindow();
			stage.setTitle("Gestisci Eventi");
			gestisciBoundary.loadShop(idShop);
			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);
			stage.show();

		} catch (Exception e) {
			logger.error(e.getMessage());
			MyIOException.openPageFault("shop Event");
		}

	}
 
  

    @FXML
    public void logoutButtonPressed(ActionEvent event) {
    	
     	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());
    	
    	
	}

	public void initData(int id, String nome) {
		this.idShop = id;
    	nomeCognome.setText(nome);
    	final Circle clip = new Circle();
    	clip.setCenterX(25);
    	clip.setCenterY(58);
    	clip.setRadius(200);
	}





}
