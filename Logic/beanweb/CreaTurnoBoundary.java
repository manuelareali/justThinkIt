package beanweb;

import controller.CreaTurnoController;



public class CreaTurnoBoundary {

	private int  caritas;

	private static CreaTurnoBoundary instance = null;
	
	private CreaTurnoBoundary() {
		
	}
	
	public static CreaTurnoBoundary getInstance() {
		if (instance == null) {
			instance = new CreaTurnoBoundary();
		}
		return instance;
	}
	
	public boolean creaTurnoPressed(String nomeGiorno, String oraInizio, String oraFine, String  numMaxParte, String note) {
		if (nomeGiorno == null || nomeGiorno.equals("")) {
			return false;
		} 
		else if ( oraInizio == null || oraInizio.equals("")) {
			return false;
		}
		else if (oraFine == null || oraFine.equals("")) {
			return false;
		} 
		else if ( numMaxParte == null || numMaxParte.equals("")) {
			return false;
		}
		else if (note == null || note.equals("")) {
			return false;
		}
		else {
				CreaTurnoController creaTurno = new CreaTurnoController();
				creaTurno.creaTurno(caritas, nomeGiorno,oraInizio, oraFine,Integer.parseInt(numMaxParte), note);
				return true;
			}
		}


	public void setCaritas(int caritas) {
		this.caritas = caritas;
	}

}
