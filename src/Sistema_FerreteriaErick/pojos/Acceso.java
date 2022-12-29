/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema_FerreteriaErick.pojos;

/**
 *
 * @author LAB07
 */
public class Acceso {
    String usuario;
    String password;
    String dni_personal;

    public Acceso(String usuario, String password, String dni_personal) {
        this.usuario = usuario;
        this.password = password;
        this.dni_personal = dni_personal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni_personal() {
        return dni_personal;
    }

    public void setDni_personal(String dni_personal) {
        this.dni_personal = dni_personal;
    }

    
}
