package entity;

public class Offerte {


	private float prezzo;
	private String data;
	private String note;
	private int evento;
	private int idNeg;
	private String nomeEvento;
	private String nomeNegozio;
	private int idProp;
	


	public int getIdProp() {
		return idProp;
	}


	public void setIdProp(int idProp) {
		this.idProp = idProp;
	}


	public Offerte(int idNeg, int evento,float prezzo, String data, String note) {
		this.evento = evento;
		this.prezzo = prezzo;
		this.data  = data;
		this.note = note;
		this.idNeg = idNeg;
	}
	
	
	public Offerte(int idProp, int idEvento, String nomeNegozio,String nomeEvento, float prezzo, String note, String data, int idNegozio) {
		this.idProp = idProp;
		this.nomeEvento = nomeEvento;
		this.prezzo = prezzo;
		this.note = note;
		this.data  = data;
		this.nomeNegozio = nomeNegozio;
		this.idNeg = idNegozio;
		this.evento = idEvento;
	
	}

	public String getNomeEvento() {
		return nomeEvento;
	}


	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}


	public int getIdNeg() {
		return idNeg;
	}

	public void setIdNeg(int idNeg) {
		this.idNeg = idNeg;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNote() {
		return note;
	}
	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public String getNomeNegozio() {
		return nomeNegozio;
	}


	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio = nomeNegozio;
	}


}
