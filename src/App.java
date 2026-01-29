import ConsoleApp.aaLogin;
import UserInterface.aaExoTrooperForm;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        // Init Login
        aaLogin aaLoginService = new aaLogin();
        
        if (aaLoginService.aaAutenticar()) {
            // Launch GUI if auth is successful
            SwingUtilities.invokeLater(() -> {
                aaExoTrooperForm aaForm = new aaExoTrooperForm();
                aaForm.setVisible(true);
            });
        } else {
            System.exit(0);
        }
    }
}
