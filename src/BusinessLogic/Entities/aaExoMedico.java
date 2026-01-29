package BusinessLogic.Entities;

public class aaExoMedico extends aaExobot {
    public aaExoMedico() {
        super("ExoMedico");
        this.aaArmaNombre = "BioSensor/BioEscaner";
    }

    @Override
    public String aaRealizarAccion() {
        return "Asistir (Energía)";
    }
}
