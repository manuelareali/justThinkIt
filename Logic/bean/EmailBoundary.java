package bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.EmailController;
import exception.MyException;
import exception.Trigger;
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
	
	private Trigger trigger;
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
		trigger = new Trigger();
	}
	

	 
	
	@FXML
	public int sendMessage(ActionEvent event) {
		int i = 0;
		if (!mittente.getText().isEmpty() && !destinatario.getText().isEmpty() && !textMex[0].getText().isEmpty()) {
		i = emailC.sendMessageController(mittente.getText(), destinatario.getText(), messaggio.getText(),
				oggetto.getText());

		Stage st = (Stage) invia.getScene().getWindow();
		st.close();
		return i;
		}else {
			try {
				trigger.myTrigger();
			}catch(MyException e) {
				logger.error("Alcuni campi sono vuoti");
			}
		}
		return 0;
	}



	
	@FXML
	void initialize() {
		
		emailC = new EmailController();
		textMex = new TextArea[]{this.messaggio};
	}

	public void loadEmail(int idDestinatario, int idMittente) {
		try {
			
			String[] mitDest = emailC.loadMittenteDestinatario(idDestinatario, idMittente);
			this.mittente.setText(mitDest[0]);
			this.destinatario.setText(mitDest[1]);
			trigger.myTrigger();
		}catch(MyException e){
			logger.error("Bisogna selezionare una riga della tabella");	
			
		}
	}
	
	
	

}
