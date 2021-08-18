package bean;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sothawo.mapjfx.Projection;

import controller.CercaCaritasController;
import controller.PromuoviEventoController;
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
			if (checker() != -1) {
				float costoEvento = Float.parseFloat(prezzo.getText());

				PromuoviEventoController promuoviEvento = new PromuoviEventoController();
				promuoviEvento.creaEventoController(nome.getText(), tipo, note.getText(), costoEvento, idCar, idShop);
			}
		
		}

		public void loadFormBoundary(int idCar, int idShop) {
			this.idCar = idCar;
			this.idShop = idShop;
			
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
