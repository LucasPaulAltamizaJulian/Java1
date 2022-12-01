
package Sistema_FerreteriaErick.pojos;

import java.io.File;

public class Producto {
   String idProducto;
   String nomProducto;
   String descProducto;
   double stockProducto;
   File fotoProducto;
   String unidadProducto;
   double precioCompraproducto;
   double precioVentaproducto;
   double existenciasProducto;
   int idCategoria;
   int idProveedor;

    public Producto(String idProducto, String nomProducto, String descProducto, double stockProducto, File fotoProducto, String unidadProducto, double precioCompraproducto, double precioVentaproducto, double existenciasProducto, int idCategoria, int idProveedor) {
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.descProducto = descProducto;
        this.stockProducto = stockProducto;
        this.fotoProducto = fotoProducto;
        this.unidadProducto = unidadProducto;
        this.precioCompraproducto = precioCompraproducto;
        this.precioVentaproducto = precioVentaproducto;
        this.existenciasProducto = existenciasProducto;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public double getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(double stockProducto) {
        this.stockProducto = stockProducto;
    }

    public File getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(File fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    public String getUnidadProducto() {
        return unidadProducto;
    }

    public void setUnidadProducto(String unidadProducto) {
        this.unidadProducto = unidadProducto;
    }

    public double getPrecioCompraproducto() {
        return precioCompraproducto;
    }

    public void setPrecioCompraproducto(double precioCompraproducto) {
        this.precioCompraproducto = precioCompraproducto;
    }

    public double getPrecioVentaproducto() {
        return precioVentaproducto;
    }

    public void setPrecioVentaproducto(double precioVentaproducto) {
        this.precioVentaproducto = precioVentaproducto;
    }

    public double getExistenciasProducto() {
        return existenciasProducto;
    }

    public void setExistenciasProducto(double existenciasProducto) {
        this.existenciasProducto = existenciasProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
   
}
