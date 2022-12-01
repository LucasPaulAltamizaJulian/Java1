/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema_FerreteriaErick.pojos;

/**
 *
 * @author LAB07
 */
public class Proveedor {
    int idProveedor;
    String nomProveedor;
    String dirProveedor;
    int dirNumero;
    String dirRegion;
    String dirProvincia;
    String dirDistrito;
    String telProveedor;
    String emailProveedor;
    String contactoProveedor;

    public Proveedor(int idProveedor, String nomProveedor, String dirProveedor, int dirNumero, String dirRegion, String dirProvincia, String dirDistrito, String telProveedor, String emailProveedor, String contactoProveedor) {
        this.idProveedor = idProveedor;
        this.nomProveedor = nomProveedor;
        this.dirProveedor = dirProveedor;
        this.dirNumero = dirNumero;
        this.dirRegion = dirRegion;
        this.dirProvincia = dirProvincia;
        this.dirDistrito = dirDistrito;
        this.telProveedor = telProveedor;
        this.emailProveedor = emailProveedor;
        this.contactoProveedor = contactoProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNomProveedor() {
        return nomProveedor;
    }

    public void setNomProveedor(String nomProveedor) {
        this.nomProveedor = nomProveedor;
    }

    public String getDirProveedor() {
        return dirProveedor;
    }

    public void setDirProveedor(String dirProveedor) {
        this.dirProveedor = dirProveedor;
    }

    public int getDirNumero() {
        return dirNumero;
    }

    public void setDirNumero(int dirNumero) {
        this.dirNumero = dirNumero;
    }

    public String getDirRegion() {
        return dirRegion;
    }

    public void setDirRegion(String dirRegion) {
        this.dirRegion = dirRegion;
    }

    public String getDirProvincia() {
        return dirProvincia;
    }

    public void setDirProvincia(String dirProvincia) {
        this.dirProvincia = dirProvincia;
    }

    public String getDirDistrito() {
        return dirDistrito;
    }

    public void setDirDistrito(String dirDistrito) {
        this.dirDistrito = dirDistrito;
    }

    public String getTelProveedor() {
        return telProveedor;
    }

    public void setTelProveedor(String telProveedor) {
        this.telProveedor = telProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public String getContactoProveedor() {
        return contactoProveedor;
    }

    public void setContactoProveedor(String contactoProveedor) {
        this.contactoProveedor = contactoProveedor;
    }
    
    @Override
    public String toString(){
        return this.nomProveedor;
    }
}
