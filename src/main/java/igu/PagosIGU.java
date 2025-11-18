
package igu;

import javax.swing.*;
import trivia.models.PlanPremium;
import trivia.models.CompraExtra;
import trivia.utils.ControladorPagos;
import trivia.persistence.GeneradorPDF;

public class PagosIGU extends javax.swing.JFrame {

    
    
    public PagosIGU() {
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        btnComprarPremium = new javax.swing.JButton();
        btnServiciosExtra = new javax.swing.JButton();
        btnServiciosExtra1 = new javax.swing.JButton();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(534, 452));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setForeground(new java.awt.Color(60, 63, 65));

        titulo.setFont(new java.awt.Font("Candara", 1, 33)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Gestion de Pagos y Servicios");

        btnComprarPremium.setBackground(new java.awt.Color(255, 255, 255));
        btnComprarPremium.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnComprarPremium.setForeground(new java.awt.Color(0, 0, 0));
        btnComprarPremium.setText("Comprar Premium");
        btnComprarPremium.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnComprarPremium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarPremiumActionPerformed(evt);
            }
        });

        btnServiciosExtra.setBackground(new java.awt.Color(255, 255, 255));
        btnServiciosExtra.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnServiciosExtra.setForeground(new java.awt.Color(0, 0, 0));
        btnServiciosExtra.setText("Comprar Servicio Extra");
        btnServiciosExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosExtraActionPerformed(evt);
            }
        });

        btnServiciosExtra1.setBackground(new java.awt.Color(255, 255, 255));
        btnServiciosExtra1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnServiciosExtra1.setForeground(new java.awt.Color(0, 0, 0));
        btnServiciosExtra1.setText("Generar Reportes PDF");
        btnServiciosExtra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosExtra1ActionPerformed(evt);
            }
        });

        Salir.setBackground(new java.awt.Color(255, 0, 0));
        Salir.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("Regresar");
        Salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnServiciosExtra1)
                            .addComponent(btnServiciosExtra))
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnComprarPremium, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(titulo)
                .addGap(55, 55, 55)
                .addComponent(btnComprarPremium, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnServiciosExtra)
                .addGap(33, 33, 33)
                .addComponent(btnServiciosExtra1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

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

    private void btnComprarPremiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarPremiumActionPerformed
        try {
            String usuario = JOptionPane.showInputDialog(this, "Nombre del usuario:");
            if (usuario == null || usuario.trim().isEmpty()) return;

            String[] opciones = {"Mensual - $5.99", "Anual - $49.99"};
            int sel = JOptionPane.showOptionDialog(this, "Elige el plan premium", 
                    "Planes Premium", 0, JOptionPane.INFORMATION_MESSAGE,
                    null, opciones, opciones[0]);

            if (sel == -1) return;

            double precio = sel == 0 ? 5.99 : 49.99;
            int dias = sel == 0 ? 30 : 365;

            PlanPremium plan = new PlanPremium(usuario, precio, ControladorPagos.hoy(), dias);

            ControladorPagos.addPlan(plan);

            JOptionPane.showMessageDialog(this, "Plan premium comprado correctamente.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnComprarPremiumActionPerformed

    private void btnServiciosExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosExtraActionPerformed
        try {
            String usuario = JOptionPane.showInputDialog(this, "Nombre del usuario:");
            if (usuario == null || usuario.trim().isEmpty()) return;

            String[] opciones = {
                "Pista - $0.99",
                "Quitar anuncios - $2.99",
                "Modo experto - $3.99"
            };

            String servicioSel = (String) JOptionPane.showInputDialog(
                    this, "Elige un servicio:", "Servicios",
                    JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            if (servicioSel == null) return;

            double precio = servicioSel.contains("0.99") ? 0.99
                            : servicioSel.contains("2.99") ? 2.99 : 3.99;

            String nombreServicio = servicioSel.split(" - ")[0];

            CompraExtra compra = new CompraExtra(usuario, nombreServicio, precio, ControladorPagos.hoy());

            ControladorPagos.addCompra(compra);

            JOptionPane.showMessageDialog(this, "Servicio adicional comprado correctamente.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnServiciosExtraActionPerformed

    private void btnServiciosExtra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosExtra1ActionPerformed
         try {
            GeneradorPDF.generarPDFPremium("reporte_premium.pdf");
            GeneradorPDF.generarPDFExtras("reporte_extras.pdf");

            JOptionPane.showMessageDialog(this, "PDFs generados correctamente.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al generar PDFs: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnServiciosExtra1ActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        TriviaIGU inicio = new TriviaIGU();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    
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
            java.util.logging.Logger.getLogger(PagosIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagosIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagosIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagosIGU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagosIGU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton btnComprarPremium;
    private javax.swing.JButton btnServiciosExtra;
    private javax.swing.JButton btnServiciosExtra1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
