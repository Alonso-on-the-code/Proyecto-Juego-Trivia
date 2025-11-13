
package igu;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import trivia.models.Usuario;
import trivia.persistence.GeneradorPDF;
import trivia.utils.ControladorTrivia;


public class TriviaIGU extends javax.swing.JFrame {

   
    public TriviaIGU() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TriviaMaster = new javax.swing.JLabel();
        BotonJugar = new javax.swing.JButton();
        BotonPuntaje = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BotonUsuario = new javax.swing.JButton();
        BotonCargarDatos = new javax.swing.JButton();
        BotonGuardarDatos = new javax.swing.JButton();
        GenerarReporte = new javax.swing.JButton();
        btnCertificado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(97, 176, 74));

        TriviaMaster.setFont(new java.awt.Font("Candara", 0, 48)); // NOI18N
        TriviaMaster.setForeground(new java.awt.Color(255, 255, 255));
        TriviaMaster.setText("TriviaMaster");
        TriviaMaster.setName("Nombre del juego"); // NOI18N

        BotonJugar.setBackground(new java.awt.Color(76, 175, 80));
        BotonJugar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BotonJugar.setForeground(new java.awt.Color(255, 255, 255));
        BotonJugar.setText("Jugar");
        BotonJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonJugarMouseClicked(evt);
            }
        });
        BotonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonJugarActionPerformed(evt);
            }
        });

        BotonPuntaje.setBackground(new java.awt.Color(255, 255, 255));
        BotonPuntaje.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BotonPuntaje.setForeground(new java.awt.Color(0, 0, 0));
        BotonPuntaje.setText("Puntaje");
        BotonPuntaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPuntajeActionPerformed(evt);
            }
        });

        BotonSalir.setBackground(new java.awt.Color(255, 0, 0));
        BotonSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BotonSalir.setForeground(new java.awt.Color(255, 255, 255));
        BotonSalir.setText("Salir");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        jLabel3.setText("version 1.0");

        BotonUsuario.setBackground(new java.awt.Color(255, 255, 255));
        BotonUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BotonUsuario.setForeground(new java.awt.Color(0, 0, 0));
        BotonUsuario.setText("Seleccionar/Registrar usuario");
        BotonUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonUsuarioActionPerformed(evt);
            }
        });

        BotonCargarDatos.setBackground(new java.awt.Color(255, 255, 255));
        BotonCargarDatos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BotonCargarDatos.setForeground(new java.awt.Color(0, 0, 0));
        BotonCargarDatos.setText("Cargar Datos");
        BotonCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCargarDatosActionPerformed(evt);
            }
        });

        BotonGuardarDatos.setBackground(new java.awt.Color(255, 255, 255));
        BotonGuardarDatos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BotonGuardarDatos.setForeground(new java.awt.Color(0, 0, 0));
        BotonGuardarDatos.setText("Guardar Datos");
        BotonGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarDatosActionPerformed(evt);
            }
        });

        GenerarReporte.setBackground(new java.awt.Color(255, 255, 255));
        GenerarReporte.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GenerarReporte.setForeground(new java.awt.Color(0, 0, 0));
        GenerarReporte.setText("Generar Reporte PDF");
        GenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarReporteActionPerformed(evt);
            }
        });

        btnCertificado.setBackground(new java.awt.Color(255, 255, 255));
        btnCertificado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCertificado.setForeground(new java.awt.Color(0, 0, 0));
        btnCertificado.setText("Generar Certificado PDF");
        btnCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TriviaMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonGuardarDatos)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(BotonCargarDatos))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(BotonUsuario))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(BotonJugar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(BotonPuntaje))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(BotonSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(GenerarReporte)))
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCertificado)
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TriviaMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonJugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonPuntaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GenerarReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCertificado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonGuardarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonCargarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TriviaMaster.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonJugarActionPerformed
      // Validar si hay un usuario activo antes de crear la ventana
    if (ControladorTrivia.getUsuarioActivo() == null) {
        JOptionPane.showMessageDialog(this, "Primero selecciona un usuario.");
        return; // No se crea la ventana
    }

    // Si sí hay usuario, abrir la ventana de jugar
    VentanaJugar jugar = new VentanaJugar();
    jugar.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_BotonJugarActionPerformed

    private void BotonPuntajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPuntajeActionPerformed
      VentanaPuntaje puntaje = new VentanaPuntaje();
    puntaje.setVisible(true);
    this.dispose();  
    }//GEN-LAST:event_BotonPuntajeActionPerformed

    //Aqui se confirma la salida del juego
    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "¿Deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        System.exit(0);
    }//GEN-LAST:event_BotonSalirActionPerformed
    }
    private void BotonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonUsuarioActionPerformed
        VentanaUsuario usuario = new VentanaUsuario();
    usuario.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_BotonUsuarioActionPerformed

    private void BotonCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCargarDatosActionPerformed
        VentanaCargar cargar = new VentanaCargar();
        cargar.setVisible(true);
        ControladorTrivia.cargarDatos();
    JOptionPane.showMessageDialog(this, "Datos cargados correctamente.");
        this.dispose();
        
    }//GEN-LAST:event_BotonCargarDatosActionPerformed

    private void BotonGuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarDatosActionPerformed
        VentanaGuardar guardar = new VentanaGuardar();
        guardar.setVisible(true);
        ControladorTrivia.guardarDatos();
    JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
        this.dispose();
    }//GEN-LAST:event_BotonGuardarDatosActionPerformed

    private void BotonJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonJugarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonJugarMouseClicked

    private void GenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarReporteActionPerformed
        List<Usuario> usuarios = ControladorTrivia.getUsuarios();
    GeneradorPDF.generarReportePuntajes(usuarios);
    JOptionPane.showMessageDialog(this, "Reporte generado correctamente (reporte_puntajes.pdf)");
    }//GEN-LAST:event_GenerarReporteActionPerformed

    private void btnCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoActionPerformed
       Usuario usuario = ControladorTrivia.getUsuarioActivo();
    if (usuario != null) {
        GeneradorPDF.generarCertificado(usuario);
        JOptionPane.showMessageDialog(this, "Certificado generado para " + usuario.getNombre());
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona primero un usuario.");
    }
    }//GEN-LAST:event_btnCertificadoActionPerformed

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
            java.util.logging.Logger.getLogger(TriviaIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TriviaIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TriviaIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TriviaIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TriviaIGU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCargarDatos;
    private javax.swing.JButton BotonGuardarDatos;
    private javax.swing.JButton BotonJugar;
    private javax.swing.JButton BotonPuntaje;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JButton BotonUsuario;
    private javax.swing.JButton GenerarReporte;
    private javax.swing.JLabel TriviaMaster;
    private javax.swing.JButton btnCertificado;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
