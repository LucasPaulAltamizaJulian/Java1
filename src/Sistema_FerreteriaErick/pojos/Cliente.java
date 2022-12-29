
package Sistema_FerreteriaErick.pojos;

import java.sql.Date;

public class Cliente {
    String nomCliente;
    int rucDniCliente;
    String direccionCliente;
    String correoCliente;
    String sexoCliente;
    Date fechaNacimientoCliente;
    Integer celCliente;

    public Cliente(String nomCliente, int rucDniCliente, String direccionCliente, String correoCliente, String sexoCliente, Date fechaNacimientoCliente, Integer celCliente) {
        this.nomCliente = nomCliente;
        this.rucDniCliente = rucDniCliente;
        this.direccionCliente = direccionCliente;
        this.correoCliente = correoCliente;
        this.sexoCliente = sexoCliente;
        this.fechaNacimientoCliente = fechaNacimientoCliente;
        this.celCliente = celCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public int getRucDniCliente() {
        return rucDniCliente;
    }

    public void setRucDniCliente(int rucDniCliente) {
        this.rucDniCliente = rucDniCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    public Date getFechaNacimientoCliente() {
        return fechaNacimientoCliente;
    }

    public void setFechaNacimientoCliente(Date fechaNacimientoCliente) {
        this.fechaNacimientoCliente = fechaNacimientoCliente;
    }

    public Integer getCelCliente() {
        return celCliente;
    }

    public void setCelCliente(Integer celCliente) {
        this.celCliente = celCliente;
    }
    
    
}
