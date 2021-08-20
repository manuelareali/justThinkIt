package bean;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.RegistrazioneCaritasController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistraCaritasBoundary implements Initializable {

	
	private RegistrazioneCaritasController regController;
	Logger logger = LoggerFactory.getLogger(RegistraCaritasBoundary.class.getName());
	private TextField[] textFields;
	TransizionePagine pageSwitch;
	private String tipo;


	@FXML
	private TextField cittadiResidenza;

	@FXML
	private TextField via;

	@FXML
	private TextField civico;

	@FXML
	private TextField telefono;

	@FXML
	private Button backButton;

	@FXML
	private TextField nomeCaritas;

	@FXML
	private TextField email;

	@FXML
	private CheckBox type;

	@FXML
	private CheckBox type2;

	@FXML
	private Button completaButton;

	@FXML
	private PasswordField passwordCaritas;

	@FXML
	private Text passwordMatch;

	@FXML
	private PasswordField confermaPassCaritas;

	public RegistraCaritasBoundary() {
		regController = new RegistrazioneCaritasController();
	}

	@FXML
	void backButtonPressed(ActionEvent event) {

		pageSwitch = new TransizionePagine();
		pageSwitch.visualizzaPagina("/boundary/RegistrazioneMenu.fxml", backButton.getScene().getWindow());

	}

	@FXML
	public void completaButtonPressed(ActionEvent event) throws SQLException {
		TransizionePagine check = new TransizionePagine();
		int resCheck = checker();
		if (resCheck != 1) {
			if(check.isNumeric(telefono.getText()) == true) {
			try {

			 regController.completaButtonPressed(nomeCaritas.getText(),tipo, passwordCaritas.getText(),
						via.getText(), telefono.getText() , email.getText(), cittadiResidenza.getText());

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Login_boundary.fxml"));
				Parent root = loader.load();
				Stage home = (Stage) completaButton.getScene().getWindow();
				home.setScene(new Scene(root));
				home.show();

			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		
			} else {
			check.check();
		}
	}
	}

	public int checker() {
		pageSwitch = new TransizionePagine();
		// Controlla che non ci siano campi lasciati vuoti
		if (pageSwitch.checkerText(textFields)) {
			passwordMatch.setText("Alcuni campi sono vuoti");
			passwordMatch.setVisible(true);
		}
		if (type.isSelected() && type2.isSelected()) {
			tipo = "Tutto";
		} else if (type2.isSelected()) {
			tipo = "Cibo";
		}else if (type.isSelected()) {
			tipo = "Vestiti";
		} 	
		else {
			passwordMatch.setText("Alcuni campi sono vuoti 2");
			passwordMatch.setVisible(true);
			return 1; // Almeno uno dei tipi deve essere selezionato
		}

		// Valida che i campi password e conferma password siano uguali

		if (passwordCaritas.getText().equalsIgnoreCase(confermaPassCaritas.getText())) {
			passwordMatch.setVisible(false);
			return 0;
		} else {
			passwordMatch.setText("Le password non corrispondono");
			passwordMatch.setVisible(true);
			return 1;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		passwordMatch.setVisible(false);
		textFields = new TextField[] { cittadiResidenza, via, civico, telefono, nomeCaritas, email };

	}

}