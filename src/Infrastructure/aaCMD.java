//Refactorización
package Infrastructure;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class aaCMD {
    
    // ANSI Colors
    public static final String aaANSI_RESET = "\u001B[0m";
    public static final String aaANSI_BLUE = "\u001B[34m";
    public static final String aaANSI_RED = "\u001B[31m";

    public static void aaImprimir(String aaMensaje) {
        if (aaMensaje.startsWith("GOOD")) {
            System.out.println(aaANSI_BLUE + aaMensaje + aaANSI_RESET);
        } else if (aaMensaje.startsWith("ERROR")) {
            System.out.println(aaANSI_RED + aaMensaje + aaANSI_RESET);
        } else {
            System.out.println(aaMensaje);
        }
        
        aaGuardarEnArchivo(aaMensaje);
    }

    private static void aaGuardarEnArchivo(String aaMensaje) {
        try (FileWriter aaFw = new FileWriter(aaAppConfig.aaFILE_TRACER, true);
             PrintWriter aaPw = new PrintWriter(aaFw)) {
            aaPw.println(aaMensaje);
        } catch (IOException e) {
            System.err.println("Error writing to ExoTracer.txt: " + e.getMessage());
        }
    }
}
