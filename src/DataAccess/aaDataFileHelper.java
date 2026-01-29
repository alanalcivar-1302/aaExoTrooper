//Refactorización
package DataAccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Infrastructure.aaAppConfig;

public class aaDataFileHelper {
    public static String aaBuscarMunicion(String aaArmaNombre) {
        // //Refactorización: Added helper for file reading
        try (BufferedReader aaBr = new BufferedReader(new FileReader(aaAppConfig.aaFILE_MUNISION))) {
            String aaLine;
            while ((aaLine = aaBr.readLine()) != null) {
                String[] aaParts = aaArmaNombre.split("/");
                for (String aaPart : aaParts) {
                    if (aaLine.contains(aaPart.trim())) {
                        return aaLine.trim();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
