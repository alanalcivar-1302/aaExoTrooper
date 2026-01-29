package DataAccess.DTO;

public class aaExobotDTO {
    private int aaIdExobot;
    private int aaIdTipoExobot;
    private int aaIdUsuario;
    private boolean aaEntrenado;
    private int aaNumeroAccion;
    private int aaIdArma;

    public aaExobotDTO() {}

    public aaExobotDTO(int aaIdExobot, int aaIdTipoExobot, int aaIdUsuario, boolean aaEntrenado, int aaNumeroAccion, int aaIdArma) {
        this.aaIdExobot = aaIdExobot;
        this.aaIdTipoExobot = aaIdTipoExobot;
        this.aaIdUsuario = aaIdUsuario;
        this.aaEntrenado = aaEntrenado;
        this.aaNumeroAccion = aaNumeroAccion;
        this.aaIdArma = aaIdArma;
    }

    public int aaGetIdExobot() { return aaIdExobot; }
    public void aaSetIdExobot(int aaIdExobot) { this.aaIdExobot = aaIdExobot; }

    public int aaGetIdTipoExobot() { return aaIdTipoExobot; }
    public void aaSetIdTipoExobot(int aaIdTipoExobot) { this.aaIdTipoExobot = aaIdTipoExobot; }

    public int aaGetIdUsuario() { return aaIdUsuario; }
    public void aaSetIdUsuario(int aaIdUsuario) { this.aaIdUsuario = aaIdUsuario; }

    public boolean aaIsEntrenado() { return aaEntrenado; }
    public void aaSetEntrenado(boolean aaEntrenado) { this.aaEntrenado = aaEntrenado; }

    public int aaGetNumeroAccion() { return aaNumeroAccion; }
    public void aaSetNumeroAccion(int aaNumeroAccion) { this.aaNumeroAccion = aaNumeroAccion; }

    public int aaGetIdArma() { return aaIdArma; }
    public void aaSetIdArma(int aaIdArma) { this.aaIdArma = aaIdArma; }
}
