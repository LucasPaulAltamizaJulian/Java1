
package Sistema_FerreteriaErick.pojos;


public class Pariente {
    private Integer dniPersonal;
    private String parentesco;
    private String apellPariente;
    private String nombrePariente;
    private String direccionPariente;
    private Integer celularPariente;

    public Pariente(Integer dniPersonal, String parentesco, String apellPariente, String nombrePariente, String direccionPariente, Integer celularPariente) {
        this.dniPersonal = dniPersonal;
        this.parentesco = parentesco;
        this.apellPariente = apellPariente;
        this.nombrePariente = nombrePariente;
        this.direccionPariente = direccionPariente;
        this.celularPariente = celularPariente;
    }

    public Integer getCelularPariente() {
        return celularPariente;
    }

    public void setCelularPariente(Integer celularPariente) {
        this.celularPariente = celularPariente;
    }

    public Integer getDniPersonal() {
        return dniPersonal;
    }

    public void setDniPersonal(Integer dniPersonal) {
        this.dniPersonal = dniPersonal;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getApellPariente() {
        return apellPariente;
    }

    public void setApellPariente(String apellPariente) {
        this.apellPariente = apellPariente;
    }

    public String getNombrePariente() {
        return nombrePariente;
    }

    public void setNombrePariente(String nombrePariente) {
        this.nombrePariente = nombrePariente;
    }

    public String getDireccionPariente() {
        return direccionPariente;
    }

    public void setDireccionPariente(String direccionPariente) {
        this.direccionPariente = direccionPariente;
    }

  
    
}
