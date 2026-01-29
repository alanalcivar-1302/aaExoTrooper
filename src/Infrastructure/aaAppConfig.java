//Refactorización
package Infrastructure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class aaAppConfig {
    public static String aaDB_URL;
    public static String aaDRIVER;
    public static String aaFILE_MUNISION;
    public static String aaFILE_TRACER;

    static {
        Properties aaProps = new Properties();
        try (FileInputStream aaFis = new FileInputStream("src/app.properties")) {
            aaProps.load(aaFis);
            aaDB_URL = aaProps.getProperty("db.url");
            aaDRIVER = aaProps.getProperty("db.driver");
            aaFILE_MUNISION = aaProps.getProperty("file.munision");
            aaFILE_TRACER = aaProps.getProperty("file.tracer");
        } catch (IOException e) {
            System.err.println("ERROR: No se pudo cargar app.properties");
            e.printStackTrace();
        }
    }
}
