package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connector.Connector;
import entity.Offerte;

public class OfferteNegoziCaritas {
	private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";
    private List<Offerte> listEv;
    private static final Logger logger = LoggerFactory.getLogger(OfferteNegoziCaritas.class);
    
 private final Connector connector;
	
	
    public OfferteNegoziCaritas() {
    	this.connector =  new Connector("jdbc:mysql://127.0.0.1:3307/Justthinkit", "rootUser", "password");
    	listEv = new ArrayList<>();
    }
	
    
    public List<Offerte> cercaOfferteCaritas(int idCar){

	   	String sql = "call visualizza_proposte_negozi(?) ";
	   	int i = 0;
		ResultSet resultSet = null;
		listEv.clear();
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, idCar );
				 resultSet = stmt.executeQuery();
	
	           while ( resultSet.next()) {
	        	   this.listEv.add(new Offerte( resultSet.getInt("id_proposta"),  resultSet.getInt("id_evento") , resultSet.getString("NomeNegozio"), resultSet.getString("NomeEvento"),  resultSet.getFloat("prezzo"),  resultSet.getString("noteEvento"),  resultSet.getString("dataEvento"),  resultSet.getInt("id_negozio")));
	        	   Offerte temp = this.listEv.get(i);
	        	 
	        	  i++;
	           }
	       } catch (SQLException ex) {
	           logger.debug(ex.getMessage());
	       } finally {
	           try {
	               if ( resultSet != null)
	            	   resultSet.close();
	           } catch (SQLException e) {
	               logger.debug(e.getMessage());
	           }
	       }
    	
    	return listEv;
    	
    }
    
    public Offerte creaOfferta(Offerte offerte) {
	   	
      	 String sql = "call proponi_prezzo_caritas(?,?,?,?,?)";

            try (Connection conn = connector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
          	
          	  pstmt.setInt(1, offerte.getIdNeg());
          	  pstmt.setInt(2, offerte.getEvento());
          	  pstmt.setFloat(3, offerte.getPrezzo());
          	  pstmt.setString(4, offerte.getData());
          	  pstmt.setString(5, offerte.getNote());

             pstmt.executeUpdate();

              } catch (SQLException ex) {
                logger.debug((ex.getMessage()));
            }
   		    	
      	
      	return offerte;
      	
      }
      
    
    public boolean confermaOfferta(int idEvento) {
    	
  	   int rowAffected;
  	 	
  	    String sql = "call conferma_proposta_negozio(?)";

         try (Connection conn = connector.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
         	pstmt.setInt(1, idEvento);
         	
             rowAffected = pstmt.executeUpdate();

             if (rowAffected == 1) {
                 logger.debug(SUCCESS);
             } 
             else { logger.debug(FAILED);
             	return false;
             }


         } catch (SQLException ex) {
             logger.debug((ex.getMessage()));
         }
  		    	

  	return true;
  }

}
