/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lista;

import modelo.Usuario;

/**
 *
 * @author CAJICA
 */
public class Programa extends javax.swing.JFrame {

    Usuario usuario;

    public Programa() {
        initComponents();
        
    }

    public Programa(Usuario usuario) {

        initComponents();
        setLocationRelativeTo(null);

        this.usuario = usuario;
        
        etiquetaNombre.setText(usuario.getNombre());
        etiquetaRol.setText(usuario.getNombreRol());

       

        if (usuario.getIdTipo_Usuario()== 1) {

        } else if (usuario.getIdTipo_Usuario() == 2) {
            menuProveedores.setVisible(false);
            subMenuAgregarProducto.setVisible(false);

        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaBienvenido = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaRol = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuProductos = new javax.swing.JMenu();
        subMenuAgregarProducto = new javax.swing.JMenuItem();
        subMenuModificarProducto = new javax.swing.JMenuItem();
        subMenuCatalogoProductos = new javax.swing.JMenuItem();
        menuProveedores = new javax.swing.JMenu();
        subMenuAgregarProveedor = new javax.swing.JMenuItem();
        subMenuCatalogoProveedores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaBienvenido.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        etiquetaBienvenido.setText("Bienvenido al programa");

        etiquetaNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        etiquetaRol.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        menuProductos.setText("Productos");

        subMenuAgregarProducto.setText("Agregar Producto");
        menuProductos.add(subMenuAgregarProducto);

        subMenuModificarProducto.setText("Modificar Producto");
        menuProductos.add(subMenuModificarProducto);

        subMenuCatalogoProductos.setText("Catalogo de Productos");
        menuProductos.add(subMenuCatalogoProductos);

        jMenuBar1.add(menuProductos);

        menuProveedores.setText("Proveedores");

        subMenuAgregarProveedor.setText("Agregar Proveedor");
        subMenuAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuAgregarProveedorActionPerformed(evt);
            }
        });
        menuProveedores.add(subMenuAgregarProveedor);

        subMenuCatalogoProveedores.setText("Catalogo de Proveedores");
        menuProveedores.add(subMenuCatalogoProveedores);

        jMenuBar1.add(menuProveedores);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(etiquetaBienvenido)
                .addGap(168, 168, 168))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiquetaNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(etiquetaRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(etiquetaBienvenido)
                .addGap(48, 48, 48)
                .addComponent(etiquetaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiquetaRol, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subMenuAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAgregarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subMenuAgregarProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Programa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaBienvenido;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaRol;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuProductos;
    private javax.swing.JMenu menuProveedores;
    private javax.swing.JMenuItem subMenuAgregarProducto;
    private javax.swing.JMenuItem subMenuAgregarProveedor;
    private javax.swing.JMenuItem subMenuCatalogoProductos;
    private javax.swing.JMenuItem subMenuCatalogoProveedores;
    private javax.swing.JMenuItem subMenuModificarProducto;
    // End of variables declaration//GEN-END:variables
}
