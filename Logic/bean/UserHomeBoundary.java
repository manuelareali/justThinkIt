package bean;

import java.sql.SQLException;
import java.util.Optional;

import controller.UserHomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;



public class UserHomeBoundary{



private int userId;


	
	@FXML
    private Text nomeCognome;
	
	@FXML
    private Button profileButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button deleteAccountButton;

    @FXML
    private Button searchCaritasButton;

    @FXML
    private Button logoutButton;
    
  

    
    @FXML
    void deleteAccountButtonPressed(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Logout");
    	alert.setHeaderText("Se cancelli il tuo account verrano cancellati anche le tue attività in corso e potresti ricevere delle sanzioni");
    	alert.setContentText("Sei sicuro di voler cancellare il tuo account?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		UserHomeController controller = new UserHomeController();
    		controller.deleteAccount(userId);
    		TransizionePagine pageSwitch = new TransizionePagine();
    		pageSwitch.backToLogin(deleteAccountButton.getScene().getWindow());
    	
    	} 	
    }


 

    @FXML
    void logoutButtonPressed(ActionEvent event) {
    	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());

	}

  

    @FXML
    void searchCaritasButtonPressed(ActionEvent event) throws NumberFormatException, SQLException {
    	
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.userId, searchCaritasButton.getScene().getWindow());

   
    }
 

	public void initData(String nome, String cognome, int id) {
     	this.nomeCognome.setText(nome + " "+ cognome);
        this.userId = id;
  
    }
      

}


