package bean;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.RegistrationShopManagerController;
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

public class RegistrationShopBoundary implements Initializable {
	private RegistrationShopManagerController regNeg;


	private TextField[] textField;
	private String tipo;
	Logger logger = LoggerFactory.getLogger(RegistrationShopBoundary.class.getName());



	@FXML
	private TextField cittaResNeg;

	@FXML
	private TextField viaNeg;

	@FXML
	private TextField civicoNeg;

	@FXML
	private TextField telNeg;

	@FXML
	private TextField nomeNegozio;

	@FXML
	private TextField mailNeg;

	@FXML
	private CheckBox typeCiboNeg;

	@FXML
	private CheckBox typeVestNeg;

	@FXML
	private Button registraNegozio;

	@FXML
	private Button backButtonNeg;

	@FXML
	private PasswordField passwordNeg;

	@FXML
	private PasswordField confermaPassNeg;

	@FXML
	private Text passwordMatch;

	public RegistrationShopBoundary() {
		this.regNeg = new RegistrationShopManagerController();
	}

	@FXML
	void backButtonNegPressed(ActionEvent event) {
		TransizionePagine pageSwitch;
		pageSwitch = new TransizionePagine();
		pageSwitch.visualizzaPagina("/boundary/RegistrazioneMenu.fxml", backButtonNeg.getScene().getWindow());

	}

	@FXML
	void registraNegozioPressed(ActionEvent event) {
		TransizionePagine check = new TransizionePagine();
	if(checker() == 0) {
		if(check.isNumeric(telNeg.getText())){
		try {
			 regNeg.registraNegozioPressed(tipo, nomeNegozio.getText(), passwordNeg.getText(),
					viaNeg.getText() + " " + civicoNeg.getText(), telNeg.getText(), mailNeg.getText(),
					cittaResNeg.getText());
			

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Login_boundary.fxml"));
				Parent root = loader.load();
				Stage home = (Stage) registraNegozio.getScene().getWindow();
				home.setScene(new Scene(root));
				home.show();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
	}
	}else {
			
			check.check();
			
		}
		

	}


	public int checker() {

		// Controlla che non ci siano campi lasciati vuoti
		for (int i = 0; i < textField.length; i++) {
			if (textField[i].getText().isEmpty()) {
				passwordMatch.setText("Alcuni campi sono vuoti");
				passwordMatch.setVisible(true);
				return 1;
			}
		}
		if(typeCiboNeg.isSelected()) {
			tipo = "Cibo";
		}
		else if(typeVestNeg.isSelected()) {
			tipo = "Vestiti";
		}
		
		// Valida che i campi password e conferma password siano uguali

		if (passwordNeg.getText().equals(confermaPassNeg.getText())) {
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
		textField = new TextField[] { cittaResNeg, viaNeg, civicoNeg, telNeg, nomeNegozio, mailNeg };

	}

}
