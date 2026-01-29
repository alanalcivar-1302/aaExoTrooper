package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DataAccess.aaSQLiteDataHelper;
import DataAccess.DTO.aaExobotDTO;

public class aaExobotDAO extends aaSQLiteDataHelper {

    public boolean aaCreateExobot(aaExobotDTO aaDto) {
        String aaSql = "INSERT INTO aaExobot (aaIdTipoExobot, aaIdUsuario, aaEntrenado, aaNumeroAccion, aaIdArma) VALUES (?, ?, ?, ?, ?)";
        try (Connection aaConn = aaGetConnection();
             PreparedStatement aaPstmt = aaConn.prepareStatement(aaSql)) {
            
            aaPstmt.setInt(1, aaDto.aaGetIdTipoExobot());
            aaPstmt.setInt(2, aaDto.aaGetIdUsuario());
            aaPstmt.setInt(3, aaDto.aaIsEntrenado() ? 1 : 0);
            aaPstmt.setInt(4, aaDto.aaGetNumeroAccion());
            aaPstmt.setInt(5, aaDto.aaGetIdArma());
            
            return aaPstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error creating Exobot: " + e.getMessage());
            return false;
        }
    }
}
