package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DonazioneTab {
	private SimpleIntegerProperty idDon;
	private SimpleIntegerProperty codVol;
	private SimpleStringProperty tipologia;
	private SimpleStringProperty descrizione;
	private SimpleStringProperty indirizzo;
	private SimpleStringProperty stato;
	private SimpleStringProperty emailVolontario;
	private SimpleStringProperty nomeVolontario;
	
	
	
	public String getNomeVolontario() {
		return nomeVolontario.get();
	}




	public void setNomeVolontario(String nomeVolontario) {
		this.nomeVolontario.set(nomeVolontario); 
	}




	public DonazioneTab(String nomeVolontario,int id, String emailVolontario, int codVol, String tipologia, String desc, String ind, String stato) {
		this.nomeVolontario = new SimpleStringProperty(nomeVolontario);
		this.idDon = new SimpleIntegerProperty(id);
		this.emailVolontario = new SimpleStringProperty(emailVolontario);
		this.tipologia = new SimpleStringProperty(tipologia);
		this.descrizione = new SimpleStringProperty(desc);
		this.indirizzo = new SimpleStringProperty(ind);
		this.codVol = new SimpleIntegerProperty(codVol);
		this.stato = new SimpleStringProperty(stato);
	}
	
	
	
	
	public String getEmailVolontario() {
		return emailVolontario.get();
	}

	public void setEmailVolontario(String emailVolontario) {
		this.emailVolontario.set(emailVolontario);
	}

	public String getTipologia() {
		return this.tipologia.get();
	}
	public void setTipologia(String tipologia) {
		this.tipologia.set(tipologia);
	}
	public String getDescrizione() {
		return this.descrizione.get();
	}
	public void setDescrizione(String descrizione) {
		this.descrizione.set(descrizione);
	}
	public String getIndirizzo() {
		return this.indirizzo.get();
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo.set(indirizzo);
	}

	public int getCodVol() {
		return this.codVol.get();
	}

	public void setCodVol(int codVol) {
		this.codVol.set(codVol);
	}

	public int getIdDon() {
		return this.idDon.get();
	}

	public void setIdDon(int idDon) {
		this.idDon.set(idDon);
	}
	
	public String getStato() {
		return this.stato.get();
	}

	public void setStato(String stato) {
		this.stato.set(stato);
	}
	
	
	
	
	
	

}
