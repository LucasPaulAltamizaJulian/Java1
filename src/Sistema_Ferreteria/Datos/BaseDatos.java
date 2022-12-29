
package Sistema_Ferreteria.Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import Sistema_FerreteriaErick.pojos.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
    public InputStream buscarFotoPersonal(String personal){
         InputStream streamFoto=null;
    try{
    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
    String sql = "SELECT foto_personal from personal where dni_personal=?";
     prepSt = conn.prepareStatement(sql);
    prepSt.setString(1, personal);
    rs = prepSt.executeQuery();
    while(rs.next()){
        streamFoto = rs.getBinaryStream("foto_personal");
    }
    }catch(SQLException ex){
        ex.printStackTrace(System.err);
    }finally{
        try{
            prepSt.close();
            conn.close();
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace(System.err);
        }
    }
        return streamFoto; 
    }
    public void insertarProducto(Producto producto) throws FileNotFoundException{
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            File fileFoto = producto.getFotoProducto();
            FileInputStream fis = new FileInputStream(fileFoto);
            
            String sql= "INSERT INTO cat_productos (id_prod, nombre_prod, desc_prod, stock_prod, foto_prod, unidad_prod, "
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
              Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                prepSt.close();
                conn.close();
            }catch(SQLException ex){
                ex.printStackTrace(System.err);
            }
        }
    }
    public void insertarPersonal(Personal personal, Acceso acceso){
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            File fileFoto = personal.getFotoPersonal();
            FileInputStream fis = new FileInputStream(fileFoto);
            String sql="INSERT INTO personal (foto_personal, usuario_personal, contrasenia_personal, rol_personal,"
                    + "nombre_personal, direccion_personal, domicilio_fiscal_personal, lugar_nacimiento, sexo_personal"
                    + ", fecha_nacimiento, edad_personal, fecha_inicio_contrato, fecha_fin_contrato, tiempo_laborado, "
                    + "dni_personal, ruc_personal, celular_personal, telefono_personal) values(?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            prepSt = conn.prepareStatement(sql);

            //Agregar la entrada de foto
            long tamanoFoto= fileFoto.length();
            prepSt.setBinaryStream(1, fis,tamanoFoto);
            prepSt.setString(2, acceso.getUsuario());
            prepSt.setString(3, acceso.getPassword());
            prepSt.setString(4, personal.getRolPersonal());
            prepSt.setString(5, personal.getNombrePersonal());
            prepSt.setString(6, personal.getDirPersonal());
            prepSt.setString(7, personal.getDomicilioFiscalPersonal());
            prepSt.setString(8,personal.getLugarNacimientoPersonal());
            prepSt.setString(9, personal.getSexoPersonal());
            prepSt.setDate(10, personal.getFechaNacimientoPersonal());
            prepSt.setInt(11, personal.getEdadPersonal());
            prepSt.setDate(12, personal.getFechInicioContrato());
            prepSt.setDate(13,personal.getFechFincontrato());
            prepSt.setDouble(14, personal.getTiempoLaaboradoPersonal());
            prepSt.setInt(15, personal.getDni());
            prepSt.setInt(16, personal.getRuc());
            prepSt.setInt(17, personal.getCelularPersonal());
            prepSt.setInt(18, personal.getTelefonoPerrsonal());
            
            prepSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
                prepSt.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }
    public void insertarCliente(Cliente cliente){
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            String sql="INSERT INTO cliente(nombre_cliente, ruc_dni_cliente, dir_cliente, correo_cliente,"
                    + " sexo_cliente, fecha_nacimiento_cliente, cel_cliente) values(?, ?, ?, ?, ?, ?, ?)";
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setString(1, cliente.getNomCliente());
            prepSt.setInt(2, cliente.getRucDniCliente());
            prepSt.setString(3, cliente.getDireccionCliente());
            prepSt.setString(4, cliente.getCorreoCliente());
            prepSt.setString(5, cliente.getSexoCliente());
            prepSt.setDate(6, cliente.getFechaNacimientoCliente());
            prepSt.setInt(7, cliente.getCelCliente());
            
            prepSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                conn.close();
                prepSt.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }
    public void insertarParientePersonal(Pariente pariente){
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            String sql = "INSERT INTO pariente_personal(dni_personal, parentesco_pariente, apellidos_pariente"
                    + ", nombre_pariente, dir_pariente, cel_pariente) values(?, ?, ?, ?, ?, ?)";
            
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setInt(1,pariente.getDniPersonal());
            prepSt.setString(2, pariente.getParentesco());
            prepSt.setString(3, pariente.getApellPariente());
            prepSt.setString(4, pariente.getNombrePariente());
            prepSt.setString(5, pariente.getDireccionPariente());
            prepSt.setInt(6, pariente.getCelularPariente());
            
            prepSt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                conn.close();
                prepSt.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }
    public void insertarAcceso(Acceso login){
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            String sql="INSERT INTO acceso(usuario_login, password_login, dni_personal) values(?, ?, ?)";
            
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setString(1, login.getUsuario());
            prepSt.setString(2, login.getPassword());
            prepSt.setString(3, login.getDni_personal());
            prepSt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                prepSt.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
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
    public void borraCliente(Integer cliente){
        try
        {
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql ="DELETE FROM cliente WHERE ruc_dni_cliente=?";
            prepSt=conn.prepareStatement(sql);
            
            prepSt.setInt(1, cliente);
            prepSt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                prepSt.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
    }
    public void borrarPersonal(String personalq){
        try
        {
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql ="DELETE FROM personal WHERE dni_personal=?";
            prepSt=conn.prepareStatement(sql);
            
            prepSt.setString(1, personalq);
            prepSt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                prepSt.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
    }
    public String obtenerAcceso(String usuario){
        String contrasenia="";
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql="SELECT password_login FROM acceso WHERE usuario_login LIKE'%"+usuario+"%'";
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                String password=rs.getString("password_login");
                contrasenia=password;
            }
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                st.close();
                rs.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
        return contrasenia;
    }
    public ArrayList<Cliente> obtenerClientePorCriterio(String criterio){
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql="SELECT * FROM cliente WHERE  nombre_cliente LIKE '%"+criterio+"%' order by nombre_cliente";
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                String nombre = rs.getString("nombre_cliente");
                int rucDni = rs.getInt("ruc_dni_cliente");
                String direccion = rs.getString("dir_cliente");
                String correo = rs.getString("correo_cliente");
                String sexo = rs.getString("sexo_cliente");
                Date fecNaci = rs.getDate("fecha_nacimiento_cliente");
                Integer celular = rs.getInt("cel_cliente");
                
                Cliente cliente = new Cliente(nombre, rucDni, direccion, correo, sexo, fecNaci, celular);
                listaClientes.add(cliente);
            }
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                rs.close();
                prepSt.close();
                st.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
        return listaClientes;
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
    public ArrayList<Personal> obtenerPersonalPorCriterio(String criterio){
        ArrayList<Personal> listaPersonal = new ArrayList<>();
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql="SELECT * FROM personal WHERE  nombre_personal LIKE '%"+criterio+"%' OR dni_personal LIKE'%"+criterio+"' order by nombre_personal";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Integer dni = rs.getInt("dni_personal");
                String rol= rs.getString("rol_personal");
                String nombre = rs.getString("nombre_personal");
                String direccion = rs.getString("direccion_personal");
                int edad = rs.getInt("edad_personal");
                String sexo = rs.getString("sexo_personal");
                String lugarNacimiento=rs.getString("lugar_nacimiento");
                Date fecNacimiento = rs.getDate("fecha_nacimiento");
                Date fecInicio = rs.getDate("fecha_inicio_contrato");
                Date fecFin = rs.getDate("fecha_fin_contrato");
                String domFiscal = rs.getString("domicilio_fiscal_personal");
                Integer celular = rs.getInt("celular_personal");
                Integer telefono = rs.getInt("telefono_personal");
                Integer tiempoLaborado = rs.getInt("tiempo_laborado");
                Integer ruc = rs.getInt("ruc_personal");
                
                Personal personal = new Personal (null,rol,nombre,direccion,domFiscal,lugarNacimiento,sexo,fecNacimiento,edad,fecInicio,fecFin,tiempoLaborado,dni,ruc,celular,telefono);
                listaPersonal.add(personal);
            }
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                prepSt.close();
                rs.close();
            } catch (Exception e)
            {
            }
        }
        return listaPersonal;
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
                int numero =(int) rs.getDouble("dir_numero");
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
    public ArrayList<Cliente> obtenerCliente(){
        ArrayList<Cliente>listaClientes=new ArrayList<Cliente>();
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql ="SELECT * FROM cliente";
            prepSt = conn.prepareStatement(sql);
            rs = prepSt.executeQuery();
            
            while(rs.next()){
                String nombre = rs.getString("nombre_cliente");
                int rucDniCliente= rs.getInt("ruc_dni_cliente");
                String direccion = rs.getString("dir_cliente");
                String correo = rs.getString("correo_cliente");
                String sexo = rs.getString("sexo_cliente");
                Date fecha= rs.getDate("fecha_nacimiento_cliente");
                Integer celular = rs.getInt("cel_cliente");
                
                Cliente cliente= new Cliente(nombre, rucDniCliente,direccion,correo,sexo,fecha,celular);
                listaClientes.add(cliente);
            }
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                prepSt.close();
                rs.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
        return listaClientes;
    }
    public ArrayList<Personal> obtenerPersonal(){
        ArrayList<Personal> listaPersonal=new ArrayList<Personal>();
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql ="SELECT * FROM personal order by nombre_personal";
            prepSt = conn.prepareStatement(sql);
            rs = prepSt.executeQuery();
            
            while(rs.next()){
                Integer dni = rs.getInt("dni_personal");
                Integer ruc = rs.getInt("ruc_personal");
                String rol= rs.getString("rol_personal");
                String nombre = rs.getString("nombre_personal");
                String direccion = rs.getString("direccion_personal");
                int edad = rs.getInt("edad_personal");
                String sexo = rs.getString("sexo_personal");
                String lugarNacimiento=rs.getString("lugar_nacimiento");
                Date fecNacimiento = rs.getDate("fecha_nacimiento");
                Date fecInicio = rs.getDate("fecha_inicio_contrato");
                Date fecFin = rs.getDate("fecha_fin_contrato");
                String domFiscal = rs.getString("domicilio_fiscal_personal");
                Integer celular = rs.getInt("celular_personal");
                Integer telefono = rs.getInt("telefono_personal");
                Integer tiempoLaborado = rs.getInt("tiempo_laborado");
                
                Personal personal = new Personal (null,rol,nombre,direccion,domFiscal,lugarNacimiento,sexo,fecNacimiento,edad,fecInicio,fecFin,tiempoLaborado,dni,ruc,celular,telefono);
                listaPersonal.add(personal);
            }
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                prepSt.close();
                rs.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
        return listaPersonal;
    }
    public void actualizaCliente(Integer cliente, String direccion, Integer celular, String correo){
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            String sql ="UPDATE cliente SET cel_cliente=?, dir_cliente=?, correo_cliente=? WHERE ruc_dni_cliente=?";
            prepSt=conn.prepareStatement(sql);
            
            prepSt.setInt(1, celular);
            prepSt.setString(2, direccion);
            prepSt.setString(3, correo);
            prepSt.setInt(4, cliente);
            
            prepSt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                prepSt.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
    }
    public void actualizarAcceso(String dni, String pass){
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            
            String sql ="UPDATE acceso SET password_login=? WHERE dni_personal=?";
            prepSt=conn.prepareStatement(sql);
            
            prepSt.setString(1, pass);
            prepSt.setString(2, dni);
            
            prepSt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                prepSt.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
    }
    public void actualizarPersonal(Personal personal, String contra, String direccion, String fiscal, Integer celular, Integer telefono,String dni,boolean cambiarFoto) throws FileNotFoundException{
        try
        {
            if(cambiarFoto==true){
                File fileFoto = personal.getFotoPersonal();
                FileInputStream fis = new FileInputStream(fileFoto);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            String sql="UPDATE personal SET foto_personal=?, contrasenia_personal=?, direccion_personal=?, domicilio_fiscal_personal=?, celular_personal=?, telefono_personal=? where dni_personal=?";
            prepSt=conn.prepareStatement(sql);
            long tamanoFoto= fileFoto.length();
                prepSt.setBinaryStream(1, fis, tamanoFoto);
                prepSt.setString(2, contra);
                prepSt.setString(3, direccion);
                prepSt.setString(4, fiscal);
                prepSt.setInt(5, celular);
                prepSt.setInt(6, telefono);
                prepSt.setString(7,dni);
            prepSt.executeUpdate();
            }else{
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-ferreteriaerick","postgres","123");
            String sql="UPDATE personal SET contrasenia_personal=?, direccion_personal=?, domicilio_fiscal_personal=?, celular_personal=?, telefono_personal=? where dni_personal=?";
            prepSt=conn.prepareStatement(sql);
                prepSt.setString(1, contra);
                prepSt.setString(2, direccion);
                prepSt.setString(3, fiscal);
                prepSt.setInt(4, celular);
                prepSt.setInt(5, telefono);
                prepSt.setString(6,dni);
            prepSt.executeUpdate();
            }
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.err);
        } finally
        {
            try
            {
                conn.close();
                prepSt.close();
            } catch (SQLException e)
            {
                e.printStackTrace(System.err);
            }
        }
    }
}
