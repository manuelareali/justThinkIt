package bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.EmailController;
import exception.MyException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmailBoundary {
	
	private static Logger logger = LoggerFactory.getLogger(EmailBoundary.class.getName());
	private EmailController emailC;
	

	private TextArea[] textMex;
	
	
	@FXML
	private Stage stage;

	@FXML
	private TextArea messaggio;

	@FXML
	private TextField oggetto;

	@FXML
	private TextField destinatario;

	@FXML
	private TextField mittente;

	@FXML
	private Button invia;
	
	@FXML
	private Button indietro;


	public EmailBoundary() {
		
	}
	

	 
	
	@FXML
	public int sendMessage(ActionEvent event) {
		int i = 0;
		try {
			if (checker()) {

				i = emailC.sendMessageController(mittente.getText(), destinatario.getText(), messaggio.getText(),oggetto.getText());

				Stage st = (Stage) invia.getScene().getWindow();
				st.close();
				return i;
			}
		}catch(MyException e) {
			logger.error(e.getMessage());
		}
		
		return 0;
	}


	public boolean checker() throws MyException {
		
			if (this.mittente.getText().isEmpty() || this.destinatario.getText().isEmpty() || this.textMex[0].getText().isEmpty() ) {
				MyException e = new MyException("Alcuni campi sono vuoti.");
				e.setErrorNumber(MyException.EMAIL_ERROR);
				throw e;
				}	
		return true;
			
	}
	
	
	
	@FXML
	void initialize() {
		
		emailC = new EmailController();
		textMex = new TextArea[]{this.messaggio};
	}

	public void loadEmail(int idDestinatario, int idMittente) {
					
			String[] mitDest = emailC.loadMittenteDestinatario(idDestinatario, idMittente);			
			this.mittente.setText(mitDest[0]);
			this.destinatario.setText(mitDest[1]);
		
	}
	
	
	

}
