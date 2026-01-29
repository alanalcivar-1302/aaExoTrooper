package BusinessLogic.Entities;

public class aaExoComando extends aaExobot {
    public aaExoComando() {
        super("ExoComando");
        this.aaArmaNombre = "Laser/Bayoneta";
    }

    @Override
    public String aaRealizarAccion() {
        return "Combatir (Energía)";
    }
}
