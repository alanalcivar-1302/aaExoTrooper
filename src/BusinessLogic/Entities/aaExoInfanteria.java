package BusinessLogic.Entities;

public class aaExoInfanteria extends aaExobot {
    public aaExoInfanteria() {
        super("ExoInfanteria");
        this.aaArmaNombre = "Misil/Mortero";
    }

    @Override
    public String aaRealizarAccion() {
        return "Explotar (Munición)";
    }
}
