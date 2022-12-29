/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema_FerreteriaErick.pojos;

import java.io.File;
import java.sql.Date;

/**
 *
 * @author LAB07
 */
public class Personal {
    private File fotoPersonal;
    private String rolPersonal;
    private String nombrePersonal;
    private String dirPersonal;
    private String domicilioFiscalPersonal;
    private String lugarNacimientoPersonal;
    private String sexoPersonal;
    private Date fechaNacimientoPersonal;
    private int edadPersonal;
    private Date fechInicioContrato;
    private Date fechFincontrato;
    private double tiempoLaaboradoPersonal;
    private Integer dni;
    private Integer ruc;
    private Integer celularPersonal;
    private Integer telefonoPerrsonal;
    
    public Personal(File fotoPersonal, String rolPersonal, String nombrePersonal, String dirPersonal, String domicilioFiscalPersonal, String lugarNacimientoPersonal, String sexoPersonal, Date fechaNacimientoPersonal, int edadPersonal, Date fechInicioContrato, Date fechFincontrato, double tiempoLaaboradoPersonal, Integer dni, Integer ruc, Integer celularPersonal, Integer telefonoPerrsonal) {
        this.fotoPersonal = fotoPersonal;
        this.rolPersonal = rolPersonal;
        this.nombrePersonal = nombrePersonal;
        this.dirPersonal = dirPersonal;
        this.domicilioFiscalPersonal = domicilioFiscalPersonal;
        this.lugarNacimientoPersonal = lugarNacimientoPersonal;
        this.sexoPersonal = sexoPersonal;
        this.fechaNacimientoPersonal = fechaNacimientoPersonal;
        this.edadPersonal = edadPersonal;
        this.fechInicioContrato = fechInicioContrato;
        this.fechFincontrato = fechFincontrato;
        this.tiempoLaaboradoPersonal = tiempoLaaboradoPersonal;
        this.dni = dni;
        this.ruc = ruc;
        this.celularPersonal = celularPersonal;
        this.telefonoPerrsonal = telefonoPerrsonal;
    }

    public Integer getTelefonoPerrsonal() {
        return telefonoPerrsonal;
    }

    public void setTelefonoPerrsonal(Integer telefonoPerrsonal) {
        this.telefonoPerrsonal = telefonoPerrsonal;
    }

    public File getFotoPersonal() {
        return fotoPersonal;
    }

    public void setFotoPersonal(File fotoPersonal) {
        this.fotoPersonal = fotoPersonal;
    }

    public String getRolPersonal() {
        return rolPersonal;
    }

    public void setRolPersonal(String rolPersonal) {
        this.rolPersonal = rolPersonal;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getDirPersonal() {
        return dirPersonal;
    }

    public void setDirPersonal(String dirPersonal) {
        this.dirPersonal = dirPersonal;
    }

    public String getDomicilioFiscalPersonal() {
        return domicilioFiscalPersonal;
    }

    public void setDomicilioFiscalPersonal(String domicilioFiscalPersonal) {
        this.domicilioFiscalPersonal = domicilioFiscalPersonal;
    }

    public String getLugarNacimientoPersonal() {
        return lugarNacimientoPersonal;
    }

    public void setLugarNacimientoPersonal(String lugarNacimientoPersonal) {
        this.lugarNacimientoPersonal = lugarNacimientoPersonal;
    }

    public String getSexoPersonal() {
        return sexoPersonal;
    }

    public void setSexoPersonal(String sexoPersonal) {
        this.sexoPersonal = sexoPersonal;
    }

    public Date getFechaNacimientoPersonal() {
        return fechaNacimientoPersonal;
    }

    public void setFechaNacimientoPersonal(Date fechaNacimientoPersonal) {
        this.fechaNacimientoPersonal = fechaNacimientoPersonal;
    }

    public int getEdadPersonal() {
        return edadPersonal;
    }

    public void setEdadPersonal(int edadPersonal) {
        this.edadPersonal = edadPersonal;
    }

    public Date getFechInicioContrato() {
        return fechInicioContrato;
    }

    public void setFechInicioContrato(Date fechInicioContrato) {
        this.fechInicioContrato = fechInicioContrato;
    }

    public Date getFechFincontrato() {
        return fechFincontrato;
    }

    public void setFechFincontrato(Date fechFincontrato) {
        this.fechFincontrato = fechFincontrato;
    }

    public double getTiempoLaaboradoPersonal() {
        return tiempoLaaboradoPersonal;
    }

    public void setTiempoLaaboradoPersonal(double tiempoLaaboradoPersonal) {
        this.tiempoLaaboradoPersonal = tiempoLaaboradoPersonal;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getRuc() {
        return ruc;
    }

    public void setRuc(Integer ruc) {
        this.ruc = ruc;
    }

    public Integer getCelularPersonal() {
        return celularPersonal;
    }

    public void setCelularPersonal(Integer celularPersonal) {
        this.celularPersonal = celularPersonal;
    }

    
    
    
}
