package DataAccess.DTO;

public class aaUsuarioDTO {
    private int aaIdUsuario;
    private String aaNombre;
    private String aaUsername;
    private String aaPassword;

    public aaUsuarioDTO() {}

    public aaUsuarioDTO(int aaIdUsuario, String aaNombre, String aaUsername, String aaPassword) {
        this.aaIdUsuario = aaIdUsuario;
        this.aaNombre = aaNombre;
        this.aaUsername = aaUsername;
        this.aaPassword = aaPassword;
    }

    public int aaGetIdUsuario() {
        return aaIdUsuario;
    }

    public void aaSetIdUsuario(int aaIdUsuario) {
        this.aaIdUsuario = aaIdUsuario;
    }

    public String aaGetNombre() {
        return aaNombre;
    }

    public void aaSetNombre(String aaNombre) {
        this.aaNombre = aaNombre;
    }

    public String aaGetUsername() {
        return aaUsername;
    }

    public void aaSetUsername(String aaUsername) {
        this.aaUsername = aaUsername;
    }

    public String aaGetPassword() {
        return aaPassword;
    }

    public void aaSetPassword(String aaPassword) {
        this.aaPassword = aaPassword;
    }
}
