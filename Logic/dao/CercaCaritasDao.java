package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.sothawo.mapjfx.Coordinate;
import com.sothawo.mapjfx.Marker;
import entity.CoordinateMap;

import entity.MarkerID;
import connector.Connector;


public class CercaCaritasDao {
	
	private final Connector connector;
	private String latit = "latitudine";
	private String longit = "longitudine";
    private static final Logger logger = LoggerFactory.getLogger(CercaCaritasDao.class);
    String codiceEvent = "codiceEv";

	 public CercaCaritasDao() {
		    this.connector =  new Connector("jdbc:mysql://127.0.0.1:3307/Justthinkit", "rootUser", "password");
		}

	 
	public List<MarkerID> getCaritasMarkers() {
		List<MarkerID> lista = new ArrayList<>();
		String sql = "Call assegna_marker()";
		ResultSet rs = null;
		
		try (Connection conn = connector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			rs = pstmt.executeQuery();

			while (rs.next()) {
				double lati = Double.parseDouble(rs.getString(this.latit));
				double longi = Double.parseDouble(rs.getString(this.longit));
				int codiceCaritas = rs.getInt("CodiceCaritas");
				
				Coordinate caritasCoordinate = new Coordinate(lati,longi);
				Marker m = Marker.createProvided(Marker.Provided.RED).setPosition(caritasCoordinate);
				MarkerID mc = new MarkerID(m, codiceCaritas);
		
				lista.add(mc);
				
	         } 
	
	     } catch (SQLException ex) {
	         logger.debug(ex.getMessage());
	     } finally {
	         try {
	             if (rs != null) rs.close();
	         } catch (SQLException e) {
	        	 logger.debug(e.getMessage());
	         }
	     }
		return lista;
		}
		

	public List<MarkerID> assegnaMarkerEvento() {
		List<MarkerID> markerEvento =new ArrayList<>();
		
		 String sql = "Call assegna_marker_evento_volontario()";
	     ResultSet resultSet = null;
	 
	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    	
	        
	    	 resultSet = pstmt.executeQuery();

	         while (resultSet.next()) {
	        	 int codiceEvento = resultSet.getInt(codiceEvent);
	        	 
	        	 Coordinate eventoCoordinate = new Coordinate(Double.parseDouble(resultSet.getString(this.latit)),Double.parseDouble(resultSet.getString(this.longit)));
	        	 Marker m = Marker.createProvided(Marker.Provided.BLUE).setPosition(eventoCoordinate);
	        	 MarkerID mc = new MarkerID(m, codiceEvento);
	        		
	        	 markerEvento.add(mc); 
	         } 
	     } catch (SQLException ex) {
	    	 logger.debug(ex.getMessage());
	     } finally {
	         try {
	             if (resultSet != null) resultSet.close();
	         } catch (SQLException e) {
	        	 logger.debug(e.getMessage());
	         }
	     } return markerEvento;
		}
	
	
	
	
	public List<MarkerID> assegnaMarkerEvento(int idCar) {
		
		List<MarkerID> markerEvento =new ArrayList<>();
		
		 String sql = "Call assegna_marker_evento_caritas(?)";
	     ResultSet rs = null;
	 
	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    		pstmt.setInt(1, idCar );
	        
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	 int codiceEvento = rs.getInt(codiceEvent);
	        	 
	        	 Coordinate eventoCoordinate = new Coordinate(Double.parseDouble(rs.getString(this.latit)),Double.parseDouble(rs.getString(this.longit)));
	        	 Marker m = Marker.createProvided(Marker.Provided.BLUE).setPosition(eventoCoordinate);
	        	 MarkerID mc = new MarkerID(m, codiceEvento);
	        		
	        	 markerEvento.add(mc);
	         } 

	     } catch (SQLException ex) {
	    	 logger.debug(ex.getMessage());
	     } finally {
	         try {
	             if (rs != null) rs.close();
	         } catch (SQLException e) {
	        	 logger.debug(e.getMessage());
	         }
	     } return markerEvento;
		}
	
	
public List<MarkerID> assegnaMarkerNegozio() {

		List<MarkerID> markerNegozio =new ArrayList<>();
		
		 String sql = "Call assegna_marker_negozio()";
	     ResultSet rs = null;
	 
	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	 int codiceNegozio = rs.getInt("codiceNegozio");
	        	 
	        	 Coordinate negozioCoordinate = new Coordinate(Double.parseDouble(rs.getString(this.latit)),Double.parseDouble(rs.getString(this.longit)));
	        	 Marker m = Marker.createProvided(Marker.Provided.BLUE).setPosition(negozioCoordinate);
	        	 MarkerID mc = new MarkerID(m, codiceNegozio);
	        		
	        	 markerNegozio.add(mc);
					
	        	
	        	 
	         } 

	     } catch (SQLException ex) {
	    	 logger.debug(ex.getMessage());
	     } finally {
	         try {
	             if (rs != null) rs.close();
	         } catch (SQLException e) {
	        	 logger.debug(e.getMessage());
	         }
	     } return markerNegozio;
		}
	
	
	public List<MarkerID> assegnaMarkerDonazione(int idCaritas) {
		
		List<MarkerID> markerDonazione =new ArrayList<>();
		
		 String sql = "Call assegna_marker_donazione(?)";
	     ResultSet rs = null;
	   

	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    	 pstmt.setInt(1, idCaritas);
	        
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	 int codiceDono = rs.getInt("codiceDono");
	        	 Coordinate donazioneCoordinate = new Coordinate(Double.parseDouble(rs.getString(this.latit)),Double.parseDouble(rs.getString(this.longit)));
	        	 Marker m = Marker.createProvided(Marker.Provided.GREEN).setPosition(donazioneCoordinate);
	        	 MarkerID mc = new MarkerID(m, codiceDono);	        	 
	        	 markerDonazione.add(mc);
	        	 
	         } 

	     } catch (SQLException ex) {
	    	 logger.debug(ex.getMessage());
	     } finally {
	         try {
	             if (rs != null) rs.close();
	         } catch (SQLException e) {
	        	 logger.debug(e.getMessage());
	         }
	     } return markerDonazione;
		}
	
	
	
	public List<CoordinateMap> getCoordinateCaritas() {
		List<CoordinateMap> lista = new ArrayList<>();
		String sql = "Call assegna_marker()";
		ResultSet rs = null;
		
		try (Connection conn = connector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			rs = pstmt.executeQuery();

			while (rs.next()) {
				double lati = Double.parseDouble(rs.getString(this.latit));
				double longi = Double.parseDouble(rs.getString(this.longit));
				int codiceCaritas = rs.getInt("CodiceCaritas");
				
				CoordinateMap caritasCoordinate = new CoordinateMap(lati,longi, codiceCaritas);
				lista.add(caritasCoordinate);
	         } 
	
	     } catch (SQLException ex) {
	         logger.debug(ex.getMessage());
	     } finally {
	         try {
	             if (rs != null) rs.close();
	         } catch (SQLException e) {
	        	 logger.debug(e.getMessage());
	         }
	     }
		return lista;
		}
	
	
public List<CoordinateMap> getCoordinateEvento() {
		
		List<CoordinateMap> markerEvento =new ArrayList<>();
		
		 String sql = "Call assegna_marker_evento_volontario()";
	     ResultSet rs = null;
	 
	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	 int codiceEvento = rs.getInt(codiceEvent);
	        	 double lati = Double.parseDouble(rs.getString(this.latit));
	        	 double longi = Double.parseDouble(rs.getString(this.longit));
					
	        	 CoordinateMap eventoCoordinate = new CoordinateMap(lati,longi,codiceEvento);
	        	 markerEvento.add(eventoCoordinate);	 
	         } 

	     } catch (SQLException ex) {
	    	 logger.debug(ex.getMessage());
	     } finally {
	         try {
	             if (rs != null) rs.close();
	         } catch (SQLException e) {
	        	 logger.debug(e.getMessage());
	         }
	     } return markerEvento;
		}
	

public List<CoordinateMap> getCoordinateEvento(int idUser) {
	
	List<CoordinateMap> markerEvento =new ArrayList<>();
	
	 String sql = "Call assegna_marker_evento_caritas(?)";
     ResultSet rs = null;
 
     try (Connection conn = connector.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(sql)) {
    	 pstmt.setInt(1, idUser);
        
         rs = pstmt.executeQuery();

         while (rs.next()) {
        	 int codiceEvento = rs.getInt(codiceEvent);
        	 double lati = Double.parseDouble(rs.getString(this.latit));
        	 double longi = Double.parseDouble(rs.getString(this.longit));
				
        	 CoordinateMap eventoCoordinate = new CoordinateMap(lati,longi,codiceEvento);
        	 markerEvento.add(eventoCoordinate);	 
         } 

     } catch (SQLException ex) {
    	 logger.debug(ex.getMessage());
     } finally {
         try {
             if (rs != null) rs.close();
         } catch (SQLException e) {
        	 logger.debug(e.getMessage());
         }
     } return markerEvento;
	}



	public List<CoordinateMap> getCoordinateDonazione(int idUser) {
	
	List<CoordinateMap> markerDonazione =new ArrayList<>();
	
	 String sql = "Call assegna_marker_donazione(?)";
     ResultSet rs = null;
   

     try (Connection conn = connector.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(sql)) {
    	 pstmt.setInt(1, idUser);
        
         rs = pstmt.executeQuery();

         while (rs.next()) {
        	 int codiceDono = rs.getInt("codiceDono");
        	 double lati = Double.parseDouble(rs.getString(this.latit));
        	 double longi = Double.parseDouble(rs.getString(this.longit));
        	 CoordinateMap donazioneCoordinate = new CoordinateMap(lati,longi,codiceDono);     	 
        	 markerDonazione.add(donazioneCoordinate);
        	 
         } 

     } catch (SQLException ex) {
    	 logger.debug(ex.getMessage());
     } finally {
         try {
             if (rs != null) rs.close();
         } catch (SQLException e) {
        	 logger.debug(e.getMessage());
         }
     } return markerDonazione;
	}


}
	


