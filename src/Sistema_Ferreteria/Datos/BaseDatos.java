
package Sistema_Ferreteria.Datos;

import java.io.*;
import java.sql.*;
import java.util.*;
import Sistema_FerreteriaErick.pojos.*;
public class BaseDatos {
    String contrasenia = "123";
    Connection conn = null;
    PreparedStatement prepSt = null;
    Statement st=null;
    ResultSet rs = null;
    public BaseDatos(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace(System.err);
        }
    }
    public void insertarProducto(Producto producto){
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            File fileFoto = producto.getFotoProducto();
            FileInputStream fis = new FileInputStream(fileFoto);
            
            String sql= "INSERT INTO ca_productos (id_prod, nombre_prod, desc_prod, stock_prod, foto_prod, unidad_prod, "
                    +"precio_compra_prod, precio_venta_prod, existencias_prod, id_categoria_prod, id_proveedor) "
                    +"values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setString(1, producto.getIdProducto());
            prepSt.setString(2, producto.getNomProducto());
            prepSt.setString(3, producto.getDescProducto());
            prepSt.setDouble(4, producto.getStockProducto());
            long tamanoFoto= fileFoto.length();
            prepSt.setBinaryStream(5, fis, tamanoFoto);
            prepSt.setString(6, producto.getUnidadProducto());
            prepSt.setDouble(7, producto.getPrecioCompraproducto());
            prepSt.setDouble(8, producto.getPrecioVentaproducto());
            prepSt.setDouble(9, producto.getExistenciasProducto());
            prepSt.setInt(10, producto.getIdCategoria());
            prepSt.setInt(11, producto.getIdProveedor());
            
            prepSt.executeUpdate();
        } catch (SQLException ex) {
          ex.printStackTrace(System.err);
        } catch(FileNotFoundException ex){
            System.out.println("aaaaaaaaa");
        }finally{
            try{
                prepSt.close();
                conn.close();
            }catch(SQLException ex){
                ex.printStackTrace(System.err);
            }
        }
    }
    public void borrrarProducto(Producto producto){
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql = "DELETE FROM cat_productos Where id_prod=?";
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, producto.getIdProducto());
            prepSt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.err);
        }finally{
            try{
                prepSt.close();
                conn.close();
                
            }catch(SQLException ex){
                ex.printStackTrace(System.err);
            }
        }
        
    }
    public void actualizarProducto(Producto producto, boolean cambiarFoto){
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            if(cambiarFoto == true){
                File fileFoto = producto.getFotoProducto();
                FileInputStream fis = new FileInputStream(fileFoto);
                String sql ="UPDATE  cat_productos SET desc_prod=?, stock_prod=?, foto_prod=?, unidad_prod=?, precio_compra_prod=?, precio_venta_prod=?, id_categoria_prod=?, id_proveedor=? WHERE id_prod=?";
                prepSt = conn.prepareStatement(sql);
                
                prepSt.setString(1, producto.getDescProducto());
                prepSt.setDouble(2, producto.getStockProducto());
                long tamanoFoto= fileFoto.length();
                prepSt.setBinaryStream(3, fis, tamanoFoto);
                prepSt.setString(4, producto.getUnidadProducto());
                prepSt.setDouble(5, producto.getPrecioCompraproducto());
                prepSt.setDouble(6, producto.getPrecioVentaproducto());
                prepSt.setInt(7, producto.getIdCategoria());
                prepSt.setInt(8, producto.getIdProveedor());
                prepSt.setString(9, producto.getIdProducto());
                        
            }else{
                String sql ="UPDATE  cat_productos SET desc_prod=?, stock_prod=?, unidad_prod=?, precio_compra_prod=?, precio_venta_prod=?, id_categoria_prod=?, id_proveedor=? WHERE id_prod=?";
                prepSt=conn.prepareStatement(sql);
                prepSt.setString(1, producto.getDescProducto());
                prepSt.setDouble(2, producto.getStockProducto());
                prepSt.setString(3, producto.getUnidadProducto());
                prepSt.setDouble(4, producto.getPrecioCompraproducto());
                prepSt.setDouble(5, producto.getPrecioVentaproducto());
                prepSt.setInt(6, producto.getIdCategoria());
                prepSt.setInt(7, producto.getIdProveedor());
                prepSt.setString(8, producto.getIdProducto());
            }
            prepSt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }catch(FileNotFoundException ex){
            System.out.println("aaaaaaaa");
        }finally{
            try{
                prepSt.close();
                conn.close();
            }catch(SQLException ex){
                ex.printStackTrace(System.err);
            }
        }
    }
    public InputStream buscarFoto(Producto producto){  
        InputStream streamFoto=null;
    try{
    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
    String sql = "SELECT foto_prod from cat_productos where id_prod=?";
    prepSt = conn.prepareStatement(sql);
    prepSt.setString(1, producto.getIdProducto());
    rs = prepSt.executeQuery();
    while(rs.next()){
        streamFoto = rs.getBinaryStream("foto_prod");
    }
    }catch(SQLException ex){
        ex.printStackTrace(System.err);
    }finally{
        try{
            prepSt.close();
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace(System.err);
        }
    }
        return streamFoto;
}
    public void actualizarInventario(Producto producto, double cantidad){
        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            String sql ="UPDATE cat_productos SET existencias_prod = ? WHERE id_prod=?";
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setDouble(1, cantidad);
            prepSt.setString(2, producto.getIdProducto());
            
            prepSt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.err);
        }finally{
            try{
                prepSt.close();
                conn.close();
            }catch(SQLException ex){
                ex.printStackTrace(System.err);
            }
        }
    }
    public void insertarCategoriaProducto(CategoriaProd categoria){
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres",contrasenia);
            String sql= "INSERT INTO cat_categorias (nom_categoria_prod, desc_categoria_prod) values(?, ?)";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, categoria.getNomCategoriaProd());
            prepSt.setString(2, categoria.getDescCategoriaProd());
            prepSt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        }finally{
            try{
                prepSt.close();
                conn.close();
            }catch(SQLException e){
                e.printStackTrace(System.err);
            }
            
        }
    }
    public void insertarProveedor(Proveedor prov){
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            String sql ="INSERT INTO cat_proveedores (nom_proveedor, dir_proveedor, dir_numero, dir_region, dir_provincia, "
                    +"dir_distrito, telefono_proveedor, email_proveedor, contacto_proveedor) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, prov.getNomProveedor());
            prepSt.setString(2, prov.getDirProveedor());
            prepSt.setInt(3, prov.getDirNumero());
            prepSt.setString(4,prov.getDirRegion());
            prepSt.setString(5, prov.getDirProvincia());
            prepSt.setString(6, prov.getDirDistrito());
            prepSt.setString(7, prov.getTelProveedor());
            prepSt.setString(8, prov.getEmailProveedor());
            prepSt.setString(9, prov.getContactoProveedor());
            
            prepSt.executeUpdate();
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        }finally{
            try
            {
                prepSt.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
    }
    
    public Long insertarVenta(Venta venta){
        long lastVal = 01;
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql ="INSERT INTO ventas (monto_venta, fecha_venta) values(?, ?)";
            
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setDouble(1,venta.getMontoVenta());
            prepSt.setDate(2, venta.getFechaVenta());
            
            prepSt.executeUpdate();
            prepSt.close();
            prepSt = this.conn.prepareStatement("select lastval () ");
            
            rs = prepSt.executeQuery();
            
            while(rs.next()){
                lastVal = rs.getLong("lastval");
            }
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                rs.close();
                prepSt.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
        return lastVal;
    }
    public void insertarDetalleVenta(DetalleVenta detalle){
        try
        {
             conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteria","postgres","123");
             
             String sql = "INSERT INTO detalle_venta (id_venta, id_prod, cantidad_vendida) values(?, ?, ?)";
             
             prepSt  = conn.prepareStatement(sql);
             
             prepSt.setLong(1, detalle.getIdVenta());
             prepSt.setString(2, detalle.getIdprod());
             prepSt.setDouble(3, detalle.getCantidadVendida());
             
             prepSt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                prepSt.close();
                conn.close();
            } catch (Exception e)
            {
                e.printStackTrace(System.err);
            }
        }
    }
    public void obtenerProducto(Producto prod){
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql ="SELECT * from cat_productos where id_prod = ?";
            
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setString(1, prod.getIdProducto());
            
            rs = prepSt.executeQuery();
            
            while(rs.next()){
                
            }
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                prepSt.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
    }
    public ArrayList<Producto> obtenerProductosporCriterio (String criterio){
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql= "SELECT * FROM cat_productos  WHERE id_prod LIKE '"+criterio+"%' OR nombre_prod LIKE '%"+criterio+"%' order by nombre_prod";
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                String id =rs.getString("id_prod");
                String nombre =rs.getString("nombre_prod");
                String descripcion =rs.getString("desc_prod");
                double stock = rs.getDouble("stock_prod");
                String unidad =rs.getString("unidad_prod");
                double precioCompra = rs.getDouble("precio_compra_prod");
                double precioVenta = rs.getDouble("precio_venta_prod");
                double existencias = rs.getDouble("existencias_prod");
                int idCategoria = rs.getInt("id_categoria_prod");
                int idProveedor = rs.getInt("id_proveedor");
                
                Producto producto= new Producto(id, nombre, descripcion, stock, null, unidad, precioCompra, precioVenta, existencias, idCategoria, idProveedor);
                listaProductos.add(producto);
            }
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                st.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
        return listaProductos;
    }
    public ArrayList<Producto> obtenerProductos(){
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql ="SELECT * FROM cat_productos order by nombre_prod";
            
            prepSt = conn.prepareStatement(sql);
            rs = prepSt.executeQuery();
            while(rs.next()){
                String id =rs.getString("id_prod");
                String nombre =rs.getString("nombre_prod");
                String descripcion =rs.getString("desc_prod");
                double stock = rs.getDouble("stock_prod");
                String unidad =rs.getString("unidad_prod");
                double precioCompra = rs.getDouble("precio_compra_prod");
                double precioVenta = rs.getDouble("precio_venta_prod");
                double existencias = rs.getDouble("existencias_prod");
                int idCategoria = rs.getInt("id_categoria_prod");
                int idProveedor = rs.getInt("id_proveedor");
                
                Producto producto= new Producto(id, nombre, descripcion, stock, null, unidad, precioCompra, precioVenta, existencias, idCategoria, idProveedor);
                listaProductos.add(producto);
            }
        } catch (Exception e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                prepSt.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
        return listaProductos;
    }
    
    public ArrayList<CategoriaProd> obtenerCategorias(){
        ArrayList <CategoriaProd> listaCategorias = new ArrayList<CategoriaProd>();
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql = "SELECT * FROM cat_categorias";
            prepSt = conn.prepareStatement(sql);
            rs = prepSt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id_categoria_prod");
                String nombre = rs.getString("nom_categoria_prod");
                String descripcion = rs.getString("desc_categoria_prod");
                
                CategoriaProd categoria = new CategoriaProd(id, descripcion, descripcion);
                listaCategorias.add(categoria);
            }
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                prepSt.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
        return listaCategorias;
    }
    public ArrayList<Proveedor> obtenerProveedor(){
        ArrayList<Proveedor> listaProveedores= new ArrayList<Proveedor>();
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql ="SELECT * FROM cat_proveedores";
            prepSt = conn.prepareStatement(sql);
            rs = prepSt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nom_proveedor");
                String direccion = rs.getString("dir_proveedor");
                int numero =rs.getShort("dir_numero");
                String region = rs.getString("dir_region");
                String provincia = rs.getString("dir_provincia");
                String distrito = rs.getString("dir_distrito");
                String telefono = rs.getString("telefono_proveedor");
                String email = rs.getString("email_proveedor");
                String contacto = rs.getString("contacto_proveedor");
                
               Proveedor proveedor = new Proveedor(numero, nombre, distrito, numero, region, provincia, distrito, telefono, email, contacto);
               listaProveedores.add(proveedor);
            }
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                prepSt.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
        return listaProveedores;
    }
    public static void main(String[] args) {
        CategoriaProd categoria = new CategoriaProd(1,"Categoria de prueba", "Descripcion de la categoria");
        BaseDatos base = new BaseDatos();
        base.insertarCategoriaProducto(categoria);
    }
}
