package BusinessLogic;

import BusinessLogic.Entities.aaExobot;
import BusinessLogic.Entities.aaSoldadoExperto;

public class aaIABOT {
    
    // //Refactorización: Changed signature to include SoldadoExperto as per diagram implication
    public void aaEntrenar(aaExobot aaExobot, aaSoldadoExperto aaSoldado) {
        if (aaExobot != null) {
            aaExobot.aaSetEntrenado(true);
        }
    }
}
