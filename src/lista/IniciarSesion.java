/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lista;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.CifrarContraseña1;
import modelo.SQLUsuario;
import modelo.Usuario;

/**
 *
 * @author CAJICA
 */
public class IniciarSesion extends javax.swing.JFrame {

    /**
     * Creates new form IniciarSesion
     */
    public IniciarSesion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaTitulo = new javax.swing.JLabel();
        cajaUsuario = new javax.swing.JTextField();
        etiquetaUsuario = new javax.swing.JLabel();
        etiquetaContraseña = new javax.swing.JLabel();
        botonIniciarSesion = new javax.swing.JButton();
        cajaContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        etiquetaTitulo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        etiquetaTitulo.setText("Inicia sesion en el programa");

        etiquetaUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        etiquetaUsuario.setText("Usuario: ");

        etiquetaContraseña.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        etiquetaContraseña.setText("Contraseña: ");

        botonIniciarSesion.setText("Iniciar sesion");
        botonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(etiquetaTitulo)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(etiquetaContraseña)
                    .addComponent(etiquetaUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonIniciarSesion)
                    .addComponent(cajaUsuario)
                    .addComponent(cajaContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(etiquetaTitulo)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaUsuario))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaContraseña)
                    .addComponent(cajaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(botonIniciarSesion)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarSesionActionPerformed

        Usuario usuario = new Usuario();
        
        SQLUsuario sqlUsuario = new SQLUsuario();
        //Capturando la hora en que el usuario inicia sesion:
        
        Date date = new Date();
        
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH::mm:ss");//se le pasa el diseño que tendra la hora de la BD
        
        
        
        
        //Transformamos la contraseña a String
        
        String contraseña = new String(cajaContraseña.getPassword());
        
        if(cajaUsuario.getText().equals("")||contraseña.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos antes de continuar");
        }else{
            try {
                String nuevaContraseña = CifrarContraseña1.cifrarMD5(contraseña);
                usuario.setNombreUsuario(cajaUsuario.getText());
                usuario.setContraseña(nuevaContraseña);
                usuario.setUltima_sesion(fechaHora.format(date));// de esta forma se pasa la hora que capturamos hacia la BD.
                
                if(sqlUsuario.iniciarSesion(usuario)){//retorna booleano
                    //JOptionPane.showMessageDialog(null, "Bienvenido, Ingresaste al sistema");
                    
                    Inicio.iniciarSesion=null;
                    this.dispose();
                    
                    Programa programa = new Programa(usuario);
                    programa.setVisible(true);
                    
                }else{
                   JOptionPane.showMessageDialog(null, "Datos Invalidos"); 
                }
                
                
                
            } catch (NoSuchAlgorithmException ex) {
                System.err.println("Error"+ex);
            }
            
        }
    }//GEN-LAST:event_botonIniciarSesionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Inicio.iniciarSesion=null;
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciarSesion;
    private javax.swing.JPasswordField cajaContraseña;
    private javax.swing.JTextField cajaUsuario;
    private javax.swing.JLabel etiquetaContraseña;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JLabel etiquetaUsuario;
    // End of variables declaration//GEN-END:variables
}
