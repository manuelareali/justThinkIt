package bean;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.RegistrazioneVolontarioController;
import exception.MyException;
import exception.MyIOException;
import exception.Trigger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegistrazioneVolontarioBoundary  {
	private RegistrazioneVolontarioController regC;
	


	

	

	@FXML
	private TextField cittaRes;

	@FXML
	private TextField via;

	@FXML
	private TextField civico;

	@FXML
	private TextField tel;

	@FXML
	private TextField mail;

	@FXML
	private TextField nome;

	@FXML
	private TextField cognome;

	@FXML
	private Button completaReg;

	@FXML
	private TextField codiceFisc;

	@FXML
	private Button backButton;

	@FXML
	private PasswordField password;

	@FXML
	private PasswordField confermaPass;

	@FXML
	private Text passwordMatch;

	@FXML
	private DatePicker date;



	public RegistrazioneVolontarioBoundary() {
		regC = new RegistrazioneVolontarioController();	
	}
	

	@FXML
	void backButtonPres(ActionEvent event) {
		TransizionePagine pageswitch = new TransizionePagine();
		String pagina = "/boundary/RegistrazioneMenu.fxml";
		Window stage = backButton.getScene().getWindow();
		pageswitch.visualizzaPagina(pagina, stage);

	}
	
	@FXML
	void registraVolontarioPressed(ActionEvent event) {
		Logger logger = LoggerFactory.getLogger(RegistrazioneVolontarioBoundary.class.getName());
		Trigger trigger = new Trigger();
		
		
			try {
				if(checker() && trigger.isNumeric(tel.getText()) && trigger.isNumeric(civico.getText())) {
				try {
					
				 regC.completaButtonPressed(nome.getText(), cognome.getText(), password.getText(),
							via.getText(),tel.getText(), mail.getText(), date.getValue().toString(), cittaRes.getText());

					FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Login_boundary.fxml"));
					Parent root = loader.load();
					Stage home = (Stage) completaReg.getScene().getWindow();
					home.setScene(new Scene(root));

					home.show();
				} catch (Exception e) {
					logger.error(e.getMessage());
					MyIOException.openPageFault("login");
					
				}
				}
			} catch (NumberFormatException e) {
				logger.error("Non sono presenti solo numeri in Telefono o N civico" + e.getMessage());
			} catch (MyException e) {
				logger.error(e.getMessage());
			}
		
	}


	public boolean checker() throws MyException{

		// Controlla che non ci siano campi lasciati vuoti
			if (nome.getText().isEmpty() || mail.getText().isEmpty() || cittaRes.getText().isEmpty() || cognome.getText().isEmpty() ||
					civico.getText().isEmpty() || via.getText().isEmpty() || tel.getText().isEmpty()) {
				MyException e = new MyException("Alcuni campi sono vuoti.");
				e.setErrorNumber(MyException.CAMPI_VUOTI);
				throw e;		
			}
		
		// Valida che i campi password e conferma password siano uguali
		if (password.getText().equals(confermaPass.getText())) {
			passwordMatch.setVisible(false);
			
		} else {
			passwordMatch.setText("Le password non corrispondono");
			passwordMatch.setVisible(true);
		}
		return true;
	}


}
