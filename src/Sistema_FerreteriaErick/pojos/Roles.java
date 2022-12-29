
package Sistema_FerreteriaErick.pojos;

public class Roles {
  Integer idRol;
  String nombreRol;
  String descRol;

    public Roles(Integer idRol, String nombreRol, String descRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.descRol = descRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }



    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescRol() {
        return descRol;
    }

    public void setDescRol(String descRol) {
        this.descRol = descRol;
    }
  
}
