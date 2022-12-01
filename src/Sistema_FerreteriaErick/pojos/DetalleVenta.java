/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema_FerreteriaErick.pojos;

/**
 *
 * @author LAB07
 */
public class DetalleVenta {
    int idDetalleVenta;
    Long idVenta;
    String idprod;
    double CantidadVendida;

    public DetalleVenta(int idDetalleVenta, Long idVenta, String idprod, double CantidadVendida) {
        this.idDetalleVenta = idDetalleVenta;
        this.idVenta = idVenta;
        this.idprod = idprod;
        this.CantidadVendida = CantidadVendida;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdprod() {
        return idprod;
    }

    public void setIdprod(String idprod) {
        this.idprod = idprod;
    }

    public double getCantidadVendida() {
        return CantidadVendida;
    }

    public void setCantidadVendida(double CantidadVendida) {
        this.CantidadVendida = CantidadVendida;
    }
    
}
