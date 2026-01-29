package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataAccess.aaSQLiteDataHelper;
import DataAccess.DTO.aaUsuarioDTO;

public class aaUsuarioDAO extends aaSQLiteDataHelper {

    public aaUsuarioDTO aaLogin(String aaUsername, String aaPassword) {
        String aaQuery = "SELECT aaIdUsuario, aaNombre, aaUsername, aaPassword FROM aaUsuario " +
                         "WHERE aaUsername = ? AND aaPassword = ?";
        try (Connection aaConn = aaGetConnection();
             PreparedStatement aaPstmt = aaConn.prepareStatement(aaQuery)) {
            
            aaPstmt.setString(1, aaUsername);
            aaPstmt.setString(2, aaPassword);
            
            ResultSet aaRs = aaPstmt.executeQuery();
            
            if (aaRs.next()) {
                return new aaUsuarioDTO(
                    aaRs.getInt("aaIdUsuario"),
                    aaRs.getString("aaNombre"),
                    aaRs.getString("aaUsername"),
                    aaRs.getString("aaPassword")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error en aaLogin: " + e.getMessage());
        }
        return null;
    }
}
