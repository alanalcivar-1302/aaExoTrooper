package BusinessLogic.Entities;

public abstract class aaExobot {
    protected int aaIdExobot;
    protected String aaTipoExobot;
    protected boolean aaEntrenado;
    protected int aaNumeroAccion;
    protected String aaArmaNombre;
    
    // Composition: Parts of the Exobot
    protected aaBrazo aaBrazoIzquierdo;
    protected aaBrazo aaBrazoDerecho;
    protected aaPierna aaPiernaIzquierda;
    protected aaPierna aaPiernaDerecha;
    
    public aaExobot(String aaTipoExobot) {
        this.aaTipoExobot = aaTipoExobot;
        this.aaNumeroAccion = 0;
        this.aaEntrenado = false;
        
        // Initialize Core Components (Composition)
        this.aaBrazoIzquierdo = new aaBrazo();
        this.aaBrazoDerecho = new aaBrazo();
        this.aaPiernaIzquierda = new aaPierna();
        this.aaPiernaDerecha = new aaPierna();
    }

    public abstract String aaRealizarAccion();

    public int aaGetIdExobot() { return aaIdExobot; }
    public void aaSetIdExobot(int id) { this.aaIdExobot = id; }
    
    public String aaGetTipoExobot() { return aaTipoExobot; }
    
    public boolean aaIsEntrenado() { return aaEntrenado; }
    public void aaSetEntrenado(boolean entrenado) { this.aaEntrenado = entrenado; }
    
    public int aaGetNumeroAccion() { return aaNumeroAccion; }
    public void aaIncrementarAccion() { this.aaNumeroAccion++; }
    
    public String aaGetArmaNombre() { return aaArmaNombre; }
    public void aaSetArmaNombre(String arma) { this.aaArmaNombre = arma; }
}
