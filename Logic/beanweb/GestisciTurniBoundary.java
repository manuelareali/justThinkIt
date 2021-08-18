package beanweb;

import java.util.List;
import controller.GestioneTurniCaritas;
import entity.TurnoTab;



public class GestisciTurniBoundary {

		private GestioneTurniCaritas gestTurn;
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
	    
	   
	    public boolean cancellaTurno(String i) {
	    	if (i == null || i.equals("")) {
	    		return false;
	    	}
	    	else {
	    		int x = Integer.parseInt(i);
	    		gestTurn.cancellaTurno(x);
	    		return true;
	    	}
	    }

	   
	   public void creaTurno() {
		   gestTurn.setIdCaritas(id);
	 		    	
	    }

	   
	  public boolean modificaTurno(String note, String idTurno) {
			   if (note == null || note.equals("") || idTurno == null || idTurno.equals("")) {
				   return false;
			   }else {
				   gestTurn.modificaTurno(Integer.parseInt(idTurno),note,id);
		    	return true;
			   }
	  }

	

		public List<TurnoTab> loadFormTurni() {
			 return gestTurn.caricaTurni(id);
			
		}

		public void loadFormBoundary(int id) {
			this.id = id;
		}
	}


