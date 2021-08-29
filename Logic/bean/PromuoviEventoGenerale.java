package bean;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.GestisciEventiCaritasController;
import exception.MyException;
import exception.MyIOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;


public class PromuoviEventoGenerale {
	
	Logger logger = LoggerFactory.getLogger(PromuoviEventoGenerale.class.getName());


	private int idCar;
	private String tipo;
	private int idShop;
	

	
    @FXML
    private TextField nome;

    @FXML
    private TextField prezzo;

    @FXML
    private RadioButton idCibo;

    @FXML
    private RadioButton idVestiti;

    @FXML
    private RadioButton tutto;

    @FXML
    private TextArea note;

    @FXML
    private Button confermaEventoPressed;
   
    @FXML
    private Button indietro;
    

    
 
  
    public void loadId(int idCar) {
    	this.idCar = idCar;
    }
    
    @FXML
    void indietro(ActionEvent event) {
        this.switchPage(confermaEventoPressed.getScene().getWindow());
       }

    @FXML
	void confermaEventoPressed(ActionEvent event) {
		GestisciEventiCaritasController controller = new GestisciEventiCaritasController();
		float x = (float) 0.0;
			try {
				if (checker() == true ) {
					controller.creaEventoGeneral(nome.getText(), tipo, x, note.getText(), this.idCar, this.idShop);
					this.switchPage(confermaEventoPressed.getScene().getWindow());
}
			} catch (MyException e) {
				logger.error(e.getMessage());
			}
	}
    
    public void switchPage(Window stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_eventi_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) stage;
			home.setScene(new Scene(root, 800, 500));
			home.show();

			GestisciEventiCaritasBoundary gest = loader.getController();
			gest.loadShop(idCar);

		} catch (Exception e) {
			logger.error(e.getMessage());
			MyIOException.openPageFault("Gestisci Eventi Caritas");
		}
	}
    
	public boolean checker() throws MyException {
		if (idCibo.isSelected()) {
			tipo = "Cibo";
		}
	
		else if (idVestiti.isSelected()) {
			tipo = "Vestiti";
			
		}else if(tutto.isSelected()) {
			tipo = "Tutto";
			
		}
		
		if(nome.getText().isEmpty() || !idCibo.isSelected() && !idVestiti.isSelected() && !tutto.isSelected()) {
			MyException e = new MyException("Alcuni campi sono vuoti.");
			e.setErrorNumber(MyException.CAMPI_VUOTI);
			throw e;
		}
		return true; 				
	}


}

