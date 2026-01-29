package BusinessLogic.Entities;

public class aaExoExplorador extends aaExobot {
    public aaExoExplorador() {
        super("ExoExplorador");
        this.aaArmaNombre = "GPS/Giroscopio";
    }

    @Override
    public String aaRealizarAccion() {
        return "Detectar (Energía)";
    }
}
