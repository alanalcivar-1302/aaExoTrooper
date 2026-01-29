package BusinessLogic.Entities;

public class aaExoAsalto extends aaExobot {
    public aaExoAsalto() {
        super("ExoAsalto");
        this.aaArmaNombre = "Fusil/Revolver";
    }

    @Override
    public String aaRealizarAccion() {
        return "Disparar (Munición)";
    }
}
