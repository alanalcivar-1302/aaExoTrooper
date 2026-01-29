//Refactorización
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Infrastructure.aaAppConfig;

public abstract class aaSQLiteDataHelper {
    
    protected static Connection aaGetConnection() throws SQLException {
        try {
            Class.forName(aaAppConfig.aaDRIVER);
            return DriverManager.getConnection(aaAppConfig.aaDB_URL);
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite Driver not found", e);
        }
    }
}
