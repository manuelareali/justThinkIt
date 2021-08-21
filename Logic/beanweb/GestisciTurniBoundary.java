package beanweb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestioneTurniCaritas;
import entity.TurnoTab;



public class GestisciTurniBoundary {

		private GestioneTurniCaritas gestTurn;
		private CreaTurnoBoundary creaTurn;
	    private int id;
	
	    
	    private static GestisciTurniBoundary instance  = null;
	    
		public static GestisciTurniBoundary getInstance() {
			if(instance == null) {
				instance = new GestisciTurniBoundary();
			}
			return instance;
			}
	    
	    private GestisciTurniBoundary() {
	    	this.gestTurn = new GestioneTurniCaritas();
	    }
	    
		public boolean isNumeric(String str) { 
			Logger logger = LoggerFactory.getLogger(GestisciTurniBoundary.class.getName());
			  try {  
			    Integer.parseInt(str); 
			    return true;
			  } catch(NumberFormatException e){  
				  logger.error("Inserisci correttamente l'id");
			    return false;  
			  } 
			}
	   
	    public boolean cancellaTurno(String i) {
	    	if (i == null || i.equals("")) {
	    		return false;
	    	}
	    	else {
	    		if(isNumeric(i)) {
	    			int x = Integer.parseInt(i);
	    			gestTurn.cancellaTurno(x);
	    		}
	    		return true;
	    	}
	    }

	  
	   
	  public boolean modificaTurno(String note, String idTurno) {
			   if ( idTurno == null || idTurno.equals("")) {
				   return false;
			   }else {
				   if(isNumeric(idTurno)) {
					   gestTurn.modificaTurno(Integer.parseInt(idTurno),note,id);
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


