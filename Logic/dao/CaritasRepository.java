package dao;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connector.Connector;
import entity.CaritasUser;
import java.sql.*;

public class CaritasRepository {

    private final Connector connector;
    private static final Logger logger = LoggerFactory.getLogger(CaritasRepository.class);

    public CaritasRepository() {
        this.connector =  new Connector("jdbc:mysql://127.0.0.1:3307/Justthinkit", "rootUser", "password");
    }

    public int insertCaritas(CaritasUser caritasUser) {

        	//Registra Caritas
    	    String sql = "call registrazione_caritas(?,?,?,?,?,?,?,?)";

            try (Connection conn = connector.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            	pstmt.setString(1,caritasUser.getEmail());
            	pstmt.setString(2, caritasUser.getPassword());
                pstmt.setString(3, caritasUser.getNome());
                pstmt.setString(4, caritasUser.getIndirizzo());
                pstmt.setString(5,caritasUser.getRecapitoTel());
                pstmt.setString(6, caritasUser.getTipologia());
                pstmt.setString(7, caritasUser.getCitta());
                pstmt.setString(8, "Caritas");
                
                pstmt.executeUpdate();
                
          
        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        }
        

        return 0;
    }


 

  public CaritasUser getCaritasByID(int id) {

        String sql = "SELECT  NomeCaritas, IndirizzoCaritas,  utenti.Email, Tipologia, RecapitoTel FROM caritas JOIN utenti ON caritas.CodiceCaritas = utenti.Id_utente WHERE CodiceCaritas=?";
        ResultSet rs = null;
        CaritasUser carUsr = new CaritasUser();

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	
                carUsr.setNome(rs.getString("NomeCaritas"));
                carUsr.setId(id);
                carUsr.setIndirizzo(rs.getString("IndirizzoCaritas"));
                carUsr.setEmail(rs.getString("Email"));
                carUsr.setTipologia(rs.getString("Tipologia"));
                carUsr.setRecapitoTel(rs.getString("RecapitoTel"));
               
            }

        } catch (SQLException ex) {
           logger.debug(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
               logger.debug(e.getMessage());
            }
        } return carUsr;
    }

   


   

}
