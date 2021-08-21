package bean;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.PromuoviEventoController;
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
		
		private TextField[] text;

		
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
			if (checker() != -1 && isNumeric(prezzo.getText()) == true) {
				float costoEvento = Float.parseFloat(prezzo.getText());

				PromuoviEventoController promuoviEvento = new PromuoviEventoController();
				promuoviEvento.creaEventoController(nome.getText(), tipo, note.getText(), costoEvento, idCar, idShop);
			}
		
		}

		public void loadFormBoundary(int idCar, int idShop) {
			this.idCar = idCar;
			this.idShop = idShop;
			
		}

		public boolean isNumeric(String str) { 
			  try {  
			    Integer.parseInt(str); 
			    return true;
			  } catch(NumberFormatException e){  
				  logger.error("Inserisci correttamente il prezzo dell'evento");
			    return false;  
			  } 
			}
		
		public int checker() {
			if(idCibo.isSelected() && idVestiti.isSelected()) {
				tipo = "Tutto";
				return 0;
			}else if (idVestiti.isSelected()) {
				tipo = "Vestiti";
				return 0;
			}else if (idCibo.isSelected()) {
				tipo = "Cibo";
				return 0;
			}else {
				return -1;
			}
		} 		
	
		

}
