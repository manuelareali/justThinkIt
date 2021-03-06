package entity;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EventTab {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty nomeEvento;
	private SimpleStringProperty noteEvento;
	private SimpleStringProperty tipoEvento;
	private SimpleStringProperty latitudine;
	private SimpleStringProperty longitudine;
	



	private SimpleFloatProperty prezzoEvento;
	private SimpleIntegerProperty numPartecipanti;
	private SimpleFloatProperty importoRaggiunto;
	private SimpleStringProperty nomeCaritas;
	private SimpleStringProperty rapportoDenaro;
	private SimpleIntegerProperty codiceCaritas;
	private SimpleStringProperty statoEvento;
	private SimpleIntegerProperty codiceNegozio;
	private SimpleStringProperty nomeNegozio;
	private SimpleStringProperty emailCaritas;
	private SimpleStringProperty emailNegozio;

    
	
	
	




	public EventTab(int id, String nomeEvento,String nomeNegozio, String emailNegozio,float prezzoEvento, String noteEvento, 
			 int codiceNeg) {
		this.id = new SimpleIntegerProperty(id);	
		this.nomeEvento = new SimpleStringProperty(nomeEvento);	
		this.emailNegozio= new SimpleStringProperty(emailNegozio);	
		this.prezzoEvento = new SimpleFloatProperty(prezzoEvento);
		this.noteEvento = new SimpleStringProperty(noteEvento);
		this.nomeNegozio = new SimpleStringProperty(nomeNegozio);
		this.codiceNegozio = new SimpleIntegerProperty(codiceNeg);
		this.statoEvento = new SimpleStringProperty("");
		this.importoRaggiunto = new SimpleFloatProperty(0); 
		this.rapportoDenaro = new SimpleStringProperty("");
	}

	public EventTab(int idCaritas, String tipo ,int codiceNeg, String nomeEvento, String nomeCaritas, String noteEvento, float prezzoEvento) {
		
		this.noteEvento = new SimpleStringProperty(noteEvento);
		this.codiceNegozio = new SimpleIntegerProperty(codiceNeg);
		this.tipoEvento = new SimpleStringProperty(tipo);
		this.nomeEvento = new SimpleStringProperty(nomeEvento);
		this.nomeCaritas = new SimpleStringProperty(nomeCaritas);
		this.statoEvento = new SimpleStringProperty("");
		new SimpleIntegerProperty(0);
		this.prezzoEvento = new SimpleFloatProperty(prezzoEvento);
		this.importoRaggiunto = new SimpleFloatProperty(0);
		this.rapportoDenaro = new SimpleStringProperty("");
		this.codiceCaritas = new SimpleIntegerProperty(idCaritas);
	}

	public EventTab(String nomeEvento,String nomeCaritas, String emailCaritas, String noteEvento, float prezzoEvento, int codiceCaritas) {
		this.nomeEvento = new SimpleStringProperty(nomeEvento);
		this.emailCaritas = new SimpleStringProperty(emailCaritas);
		this.nomeNegozio = new SimpleStringProperty(nomeCaritas);
		this.codiceCaritas = new SimpleIntegerProperty(codiceCaritas);
		this.prezzoEvento = new SimpleFloatProperty(prezzoEvento);
		this.noteEvento = new SimpleStringProperty(noteEvento);
		this.statoEvento = new SimpleStringProperty("");
		this.importoRaggiunto = new SimpleFloatProperty(0);
		this.rapportoDenaro = new SimpleStringProperty("");
		this.id  = new SimpleIntegerProperty(0);
		this.nomeCaritas = new SimpleStringProperty(nomeCaritas);
	}
	
	public EventTab(int id, String nomeEvento, String nomeCaritas, String noteEvento, String tipoEvento, String statoEvento) {
		this.id = new SimpleIntegerProperty(id);
		this.nomeEvento = new SimpleStringProperty(nomeEvento);
		this.nomeCaritas = new SimpleStringProperty(nomeCaritas);
		this.noteEvento = new SimpleStringProperty(noteEvento);
		this.tipoEvento = new SimpleStringProperty(tipoEvento);
		this.statoEvento = new SimpleStringProperty(statoEvento);

	}

	public String getLatitudine() {
		return latitudine.get();
	}

	public void setLatitudine(String coordinate) {
		this.latitudine.set(coordinate);
	}

	
	public String getNomeEvento() {
		return this.nomeEvento.get();
	}
	
	public String getEmailNegozio() {
		return emailNegozio.get();
	}

	public void setEmailNegozio(String emailNegozio) {
		this.emailNegozio.set(emailNegozio);
	}
	
	public String getEmailCaritas() {
		return emailCaritas.get();
	}

	
	public void setEmailCaritas(String emailCaritas) {
		this.emailCaritas.set(emailCaritas);
	}

	public Integer getNumPartecipanti() {
		return numPartecipanti.get();
	}

	public void setNumPartecipanti(Integer numPartecipanti) {
		this.numPartecipanti.set(numPartecipanti);
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento.set(nomeEvento);
	}


	public String getNoteEvento() {
		return this.noteEvento.get();
	}

	public void setNoteEvento(String noteEvento) {
		this.noteEvento.set(noteEvento);
	}

	public float getPrezzoEvento() {
		return this.prezzoEvento.get();
	}

	public void setPrezzoEvento(float prezzoEvento) {
		this.prezzoEvento.set(prezzoEvento);
	}



	public float getImportoRaggiunto() {
		return this.importoRaggiunto.get();
	}

	public void setImportoRaggiunto(float importoRaggiunto) {
		this.importoRaggiunto.set(importoRaggiunto);
	}

	public String getNomeCaritas() {
		return this.nomeCaritas.get();
	}

	public void setNomeCaritas(String nomeCaritas) {
		this.nomeCaritas.set(nomeCaritas);
	}

	public String getRapportoDenaro() {
		return this.rapportoDenaro.get();
	}

	public void setRapportoDenaro() {
		this.rapportoDenaro.set(this.importoRaggiunto.get() + "/" + this.prezzoEvento.get());
	}

	public int getIdCaritas() {
		return this.codiceCaritas.get();
	}

	public void setIdCaritas(int idCaritas) {
		this.codiceCaritas.set(idCaritas);
	
	}

	public int getCodiceNegozio() {
		return this.codiceNegozio.get();
	}

	public void setCodiceNegozio(int codiceNegozio) {
		this.codiceNegozio.set(codiceNegozio);
	}

	public String getNomeNegozio() {
		return this.nomeNegozio.get();
	}

	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio.set(nomeNegozio);
	}

	public String getStatoEvento() {
		return this.statoEvento.get();
	}

	public void setStatoEvento(String statoEvento) {
		this.statoEvento.set(statoEvento);
	}
	
	public int getId() {
		return this.id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}
	
	public String getTipoEvento() {
		return tipoEvento.get();
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento.set(tipoEvento);
	}

	public String getLongitudine() {
		return longitudine.get();
	}

	public void setLongitudine(String longitudine) {
		this.longitudine.set(longitudine);
	}
}
