package beanweb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestioneTurniCaritas;
import entity.TurnoTab;
import exception.MyException;
import exception.Trigger;



public class GestisciTurniBoundary {
		private Logger logger = LoggerFactory.getLogger(GestisciTurniBoundary.class.getName());
		private GestioneTurniCaritas gestTurn;
		private CreaTurnoBoundary creaTurn;
	    private int id;
	    private  Trigger trigger;
	    
	    private static GestisciTurniBoundary instance  = null;
	    
		public static GestisciTurniBoundary getInstance() {
			if(instance == null) {
				instance = new GestisciTurniBoundary();
			}
			return instance;
			}
	    
	    private GestisciTurniBoundary() {
	    	this.gestTurn = new GestioneTurniCaritas();
	    	this.trigger = new Trigger();
	    }
	    
		
	   
	    public boolean cancellaTurno(String i) {

	    	if (i == null || i.equals("")) {
	    		return false;
	    	}
	    	else {
	    		try {
					if(trigger.isNumeric(i)) {
						int x = Integer.parseInt(i);
						gestTurn.cancellaTurno(x);
					}
				} catch (NumberFormatException e) {
					logger.error("Inserisci un id corretto" + e.getMessage());
				} catch (MyException e) {
					logger.error(e.getMessage());
				}
	    		return true;
	    	}
	    }

	  
	   
	  public boolean modificaTurno(String note, String idTurno) {
			   if ( idTurno == null || idTurno.equals("")) {
				   return false;
			   }else {
				   try {
					if(trigger.isNumeric(idTurno)) {
						   gestTurn.modificaTurno(Integer.parseInt(idTurno),note,id);
					   }
				} catch (NumberFormatException e) {
					logger.error("Inserisci un id corretto" + e.getMessage());
				} catch (MyException e) {
					logger.error(e.getMessage());
				}
		    	return true;
			   }
	  }

	  public void creaTurni() {
		  creaTurn.getInstance().setCaritas(id);
	  }

		public List<TurnoTab> loadFormTurni() {
			 return gestTurn.caricaTurni(id);
			
		}

		public void loadFormBoundary(int id) {
			this.id = id;
		}
	}


