package controller;

import java.util.List;


import dao.OfferteNegoziCaritas;
import entity.Offerte;

public class ProponiOfferta {

	private OfferteNegoziCaritas offerte;

	
	public ProponiOfferta() {
		offerte = new OfferteNegoziCaritas();
	}
	
	
	public int proponi(int idNeg, int evento, float prezzo, String data, String note) {
		Offerte offerteEntity = new Offerte(idNeg, evento, prezzo, data, note);
		offerte.creaOfferta(offerteEntity);
		return 0;	
	}
	
	public boolean confermaEvento(int idOfferta) {
		return offerte.confermaOfferta(idOfferta);
	}
	
	public List<Offerte> caricaOfferte(int idCar){
		return this.offerte.cercaOfferteCaritas(idCar);
	}
}
