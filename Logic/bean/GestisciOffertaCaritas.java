package bean;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.ProponiOfferta;
import entity.Offerte;
import exception.MyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class GestisciOffertaCaritas {

	private Offerte offerta;
	private ProponiOfferta proponi;
	private int idCar;
	
	public GestisciOffertaCaritas() {
		proponi = new ProponiOfferta();
	}

	    @FXML
	    private TableView<Offerte> tab;

	    @FXML
	    private TableColumn<Offerte, String> nomeEvento;

	    @FXML
	    private TableColumn<Offerte, String> nomeNegozio;

	    @FXML
	    private TableColumn<Offerte, Float> prezzoEvento;

	    @FXML
	    private TableColumn<Offerte, String> noteEvento;

	    @FXML
	    private TableColumn<Offerte, String> dataEvento;

	    @FXML
	    private Button accetta;

	    @FXML
	    private Button back;

	 
    @FXML
    public void  accetta(ActionEvent event) {
    	Logger logger = LoggerFactory.getLogger(GestisciOffertaCaritas.class.getName());
		try {
			if (check()) {
				proponi.confermaEvento(this.offerta.getIdProp());
			}
		} catch (MyException e) {
			logger.error(e.getMessage());
		} 
		
    }

    @FXML
    void backPressed(ActionEvent event) {
    	TransizionePagine pageSwitch = new TransizionePagine();
		pageSwitch.backToMenuCaritas(idCar, back.getScene().getWindow());
    }
    

	@FXML
	void proposteSelected(MouseEvent event) {
		this.offerta = tab.getSelectionModel().getSelectedItem();

	}
    
	public boolean check() throws MyException{
		if(this.offerta == null) {
			MyException e = new MyException("Devi selezionare una riga della tabella");
			e.setErrorNumber(MyException.CARITAS_ERROR);
			throw e;	
		}
		return true;
	}

    public void loadFormBoundary(int idCar) {
    	this.idCar = idCar;
		List<Offerte> listEv = proponi.caricaOfferte(this.idCar);

		ObservableList<Offerte> data = FXCollections.observableArrayList(listEv);
		nomeNegozio.setCellValueFactory(new PropertyValueFactory<>("NomeNegozio"));
		nomeEvento.setCellValueFactory(new PropertyValueFactory<>("NomeEvento"));
		prezzoEvento.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
		noteEvento.setCellValueFactory(new PropertyValueFactory<>("note"));
		dataEvento.setCellValueFactory(new PropertyValueFactory<>("data"));
		

		tab.setItems(data);
    	
    }

}
