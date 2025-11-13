package igu;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Comparator;
import trivia.models.Usuario;
import trivia.utils.ControladorTrivia;

public class VentanaPuntaje extends javax.swing.JFrame {

    
    
    public VentanaPuntaje() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        actualizarUsuarioActivo();
        cargarTablaPuntajes();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UsuarioActivo = new javax.swing.JLabel();
        BotonRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Puntaje = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaPuntajes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(546, 452));

        UsuarioActivo.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        UsuarioActivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UsuarioActivo.setText("Usuario activo:");

        BotonRegresar.setBackground(new java.awt.Color(255, 0, 0));
        BotonRegresar.setText("Regresar");
        BotonRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jLabel2.setText("Seccion de Puntajes");

        Puntaje.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        Puntaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Puntaje.setText("puntaje:");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(60, 63, 65), null, null));

        TablaPuntajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Posicion", "Usuario", "Partidas", "Puntaje Total"
            }
        ));
        jScrollPane2.setViewportView(TablaPuntajes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Puntaje)
                            .addComponent(UsuarioActivo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(BotonRegresar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsuarioActivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Puntaje)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(BotonRegresar)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
       TriviaIGU inicio = new TriviaIGU();
       inicio.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_BotonRegresarActionPerformed

    private void actualizarUsuarioActivo() {
        Usuario activo = ControladorTrivia.getUsuarioActivo();
        if (activo != null) {
            UsuarioActivo.setText("Usuario activo: " + activo.getNombre());
            Puntaje.setText("Puntaje: " + activo.getPuntajeTotal());
        } else {
            UsuarioActivo.setText("Usuario activo: (ninguno)");
            Puntaje.setText("Puntaje: 0");
        }
    }
    
    // 👉 Carga y ordena los puntajes en la tabla
    private void cargarTablaPuntajes() {
        String[] columnas = {"Posición", "Usuario", "Partidas", "Puntaje Total"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        ArrayList<Usuario> listaUsuarios = new ArrayList<>(ControladorTrivia.getUsuarios());
        listaUsuarios.sort(Comparator.comparingInt(Usuario::getPuntajeTotal).reversed());

        int posicion = 1;
        for (Usuario u : listaUsuarios) {
            Object[] fila = {posicion++, u.getNombre(), u.getPartidasJugadas(), u.getPuntajeTotal()};
            modelo.addRow(fila);
        }

        TablaPuntajes.setModel(modelo);
    }
    
    
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
            java.util.logging.Logger.getLogger(VentanaPuntaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPuntaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPuntaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPuntaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPuntaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JLabel Puntaje;
    private javax.swing.JTable TablaPuntajes;
    private javax.swing.JLabel UsuarioActivo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
