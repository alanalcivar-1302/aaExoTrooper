package ConsoleApp;

import java.util.Scanner;
import DataAccess.DAO.aaUsuarioDAO;
import DataAccess.DTO.aaUsuarioDTO;
import Infrastructure.aaAppMSG;
import Infrastructure.aaCMD;

public class aaLogin {
    
    public boolean aaAutenticar() {
        Scanner aaScanner = new Scanner(System.in);
        int aaIntentos = 0;
        final int aaMAX_INTENTOS = 3;

        while (aaIntentos < aaMAX_INTENTOS) {
            System.out.print("Ingrese Cédula (o Username): ");
            String aaUser = aaScanner.nextLine();
            
            System.out.print("Ingrese Clave: ");
            String aaPass = aaScanner.nextLine();
            
            aaUsuarioDAO aaDao = new aaUsuarioDAO();
            aaUsuarioDTO aaDto = aaDao.aaLogin(aaUser, aaPass);
            
            if (aaDto != null) {
                aaCMD.aaImprimir(aaAppMSG.aaMSG_LOGIN_EXITO);
                return true;
            } else {
                aaCMD.aaImprimir(aaAppMSG.aaMSG_LOGIN_FALLO);
                aaIntentos++;
                System.out.println("Intentos restantes: " + (aaMAX_INTENTOS - aaIntentos));
            }
        }
        return false;
    }
}
