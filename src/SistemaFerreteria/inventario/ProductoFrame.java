/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package SistemaFerreteria.inventario;

import Sistema_Ferreteria.Datos.BaseDatos;
import Sistema_FerreteriaErick.pojos.CategoriaProd;
import Sistema_FerreteriaErick.pojos.Producto;
import Sistema_FerreteriaErick.pojos.Proveedor;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author lucas
 */
public class ProductoFrame extends javax.swing.JDialog {

    /**
     * Creates new form Producto
     */
    DefaultComboBoxModel<CategoriaProd> modeloCategorias;
    DefaultComboBoxModel<Proveedor> modeloProveedor;
    BaseDatos base;
    public ProductoFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        modeloCategorias = new DefaultComboBoxModel<CategoriaProd>();
        modeloProveedor = new DefaultComboBoxModel<Proveedor>();
        base = new BaseDatos();
        cargarModeloCat();
        cargarModelProv();
         initComponents();
    }
    private void cargarModeloCat(){
        ArrayList<CategoriaProd> listaCategorias;
        listaCategorias = base.obtenerCategorias();
        for(CategoriaProd categoria : listaCategorias)
            modeloCategorias.addElement(categoria);
    }
    private void cargarModelProv(){
        ArrayList<Proveedor> listaProveedores;
        listaProveedores = base.obtenerProveedor();
        for(Proveedor proveedor : listaProveedores)
            modeloProveedor.addElement(proveedor);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        boxDesc = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxClave = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        boxCompra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        boxUnidades = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        boxVenta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        boxStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        boxName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        boxImagenProd = new javax.swing.JLabel();
        comboProveedores = new javax.swing.JComboBox<>();
        comboCategorias = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(boxDesc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 330, 110));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Descripcion:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Clave:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));
        jPanel1.add(boxClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 260, 36));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Precio de Compra:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 232, -1, -1));

        boxCompra.setText("0");
        jPanel1.add(boxCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 257, 130, 33));

        jLabel4.setText("Unidad de Medida:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 235, -1, -1));

        boxUnidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogramo", "Miligramo", "Metro", "Galon", "Libra", "Unidad" }));
        jPanel1.add(boxUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 257, 88, 33));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Proveedor:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 347, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Precio Venta:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 308, -1, -1));

        boxVenta.setText("0");
        jPanel1.add(boxVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 333, 130, 33));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Stock Requerido:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 100, -1));

        boxStock.setText("0");
        boxStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxStockActionPerformed(evt);
            }
        });
        jPanel1.add(boxStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 100, 33));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Categoria:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 440, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 103, 53));

        jButton2.setText("Cancelar");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 121, 53));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Nombre:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        boxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNameActionPerformed(evt);
            }
        });
        jPanel1.add(boxName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 260, 36));

        boxImagenProd.setBackground(new java.awt.Color(153, 255, 102));
        boxImagenProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boxImagenProdMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boxImagenProd, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boxImagenProd, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 242, -1));

        comboProveedores.setModel(modeloProveedor);
        jPanel1.add(comboProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 320, 40));

        comboCategorias.setModel(modeloCategorias);
        jPanel1.add(comboCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 250, 40));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxNameActionPerformed
    File imgArticleFile;
    private void boxImagenProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxImagenProdMousePressed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen Jpg, Jpge, gif o png","Jpge","png","gif");
        chooser.setFileFilter(filter);
        
        int returnval = chooser.showOpenDialog(this);
        if(returnval == JFileChooser.APPROVE_OPTION){
            int anchoImagen = boxImagenProd.getWidth();
            int altoImagen = boxImagenProd.getHeight();
            
            imgArticleFile = chooser.getSelectedFile();
            ImageIcon icono = new ImageIcon(imgArticleFile.getAbsolutePath());
            Image imagen = icono.getImage();
            Image imagenRedimensionada = imagen.getScaledInstance(anchoImagen,altoImagen, Image.SCALE_DEFAULT);
            
            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
            boxImagenProd.setIcon(iconoRedimensionado);
        }
    }//GEN-LAST:event_boxImagenProdMousePressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String codigo = boxClave.getText();
        String nombre = boxName.getText();
        String descripcion = boxDesc.getText();
        double stock = Double.parseDouble(boxStock.getText());
        double precioCompra = Double.parseDouble(boxCompra.getText());
        double precioVenta = Double.parseDouble(boxVenta.getText());
        String unidad = boxUnidades.getSelectedItem().toString();
        CategoriaProd categoria = (CategoriaProd)comboCategorias.getSelectedItem();
        Proveedor proveedor = (Proveedor)comboProveedores.getSelectedItem();
        if(imgArticleFile == null){
            JOptionPane.showMessageDialog(this,"No ha elegidouna fotografia para el producto");
        }else{
            Producto producto = new Producto(codigo, nombre, descripcion, stock, imgArticleFile, unidad, precioCompra, precioVenta, 0.0, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
            try
            {
                base.insertarProducto(producto);
            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(ProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this,"Se realizo correctamente la insercion del Producto");
            this.dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void boxStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxStockActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BaseDatos base = new BaseDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductoFrame dialog = new ProductoFrame(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField boxClave;
    private javax.swing.JTextField boxCompra;
    private javax.swing.JTextPane boxDesc;
    private javax.swing.JLabel boxImagenProd;
    private javax.swing.JTextField boxName;
    private javax.swing.JTextField boxStock;
    private javax.swing.JComboBox<String> boxUnidades;
    private javax.swing.JTextField boxVenta;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<CategoriaProd> comboCategorias;
    private javax.swing.JComboBox<Proveedor> comboProveedores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
