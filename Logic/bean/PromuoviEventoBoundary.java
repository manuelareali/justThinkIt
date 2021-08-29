package bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.PromuoviEventoController;
import exception.MyException;
import exception.Trigger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class PromuoviEventoBoundary {

 	Logger logger = LoggerFactory.getLogger(PromuoviEventoBoundary.class.getName());

		private int idCar;
		private int idShop;
		private String tipo;
		
	

		
	    @FXML
	    private TextField nome;

	    @FXML
	    private TextField prezzo;

	    @FXML
	    private RadioButton idCibo;

	    @FXML
	    private RadioButton idVestiti;

	    @FXML
	    private TextArea note;

	    @FXML
	    private Button conferma;

	    @FXML
		void confermaPressed(ActionEvent event) {
	    	Trigger trigger = new Trigger();
	    	PromuoviEventoController promuoviEvento = new PromuoviEventoController();
			try {
				if (checker() ) {
					promuoviEvento.creaEventoController(nome.getText(), tipo, note.getText(), Float.parseFloat(prezzo.getText()), idCar, idShop);
				}
			} catch (NumberFormatException n) {
				logger.error("In Prezzo non sono presenti solo numeri" + n.getMessage());
			} catch (MyException e) {
				logger.error(e.getMessage());
			}
		
		}

		public void loadFormBoundary(int idCar, int idShop) {
			this.idCar = idCar;
			this.idShop = idShop;
			
		}

		
		
		public boolean checker() throws MyException {
			if(idCibo.isSelected() && idVestiti.isSelected()) {
				tipo = "Tutto";
			}else if (idVestiti.isSelected()) {
				tipo = "Vestiti";
				
			}else if (idCibo.isSelected()) {
				tipo = "Cibo";
			}
			if(nome.getText().isEmpty() && prezzo.getText().isEmpty()) {
				MyException e = new MyException("Alcuni campi sono vuoti");
				e.setErrorNumber(MyException.CAMPI_VUOTI);
				throw e;
			}
		
			return false;
			
		}	
	
		

}
