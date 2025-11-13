package igu;

import trivia.models.*;
import javax.swing.*;
import java.awt.event.*;
import trivia.utils.ControladorTrivia;

public class VentanaJugar extends javax.swing.JFrame {

    private QuizSession sesion;

    
    public VentanaJugar() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        Usuario usuario = ControladorTrivia.getUsuarioActivo();
        if (usuario==null){
            JOptionPane.showMessageDialog(this, "Primero selecciona un usuario.");
            new TriviaIGU().setVisible(true);
            dispose();
            return;
        }
        
        int dificultad = Integer.parseInt(
            JOptionPane.showInputDialog(this, "Dificultad (1-facil, 2-medio, 3-dificil):"));
        
        Quiz quiz = new Quiz("Trivia Nivel " + dificultad);
        for (Question q : ControladorTrivia.getPreguntas()) {
            if (q.getDificultad() == dificultad) quiz.addQuestion(q);
        }
        
        if (quiz.getSize() == 0) {
            JOptionPane.showMessageDialog(this, "No hay preguntas de esa dificultad.");
            new TriviaIGU().setVisible(true);
            dispose();
            return;
        }
        
        sesion = new QuizSession(usuario, quiz, null); // sin Scanner
        mostrarPregunta();
    }

     private void mostrarPregunta() {
        Question q = sesion.getCurrentQuestion();
        if (q == null) {
            JOptionPane.showMessageDialog(this, "Juego terminado. Puntaje: " + sesion.getScore().getPoints());
            new TriviaIGU().setVisible(true);
            dispose();
            return;
        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        Titulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BotonOpcionMultiple = new javax.swing.JRadioButton();
        BotonFalsoVerdadero = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        ComboDificultad = new javax.swing.JComboBox<>();
        BotonIniciarJuego = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(546, 452));

        Titulo.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Elige el tipo de trivia");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Selecciona el tipo:");

        buttonGroup1.add(BotonOpcionMultiple);
        BotonOpcionMultiple.setText("Preguntas de opcion multiple");

        buttonGroup1.add(BotonFalsoVerdadero);
        BotonFalsoVerdadero.setText("Preguntas de falso y verdadero");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Selecciona la dificultad:");

        ComboDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Facil", "Medio", "Dificil", " " }));
        ComboDificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboDificultadActionPerformed(evt);
            }
        });

        BotonIniciarJuego.setBackground(new java.awt.Color(76, 175, 80));
        BotonIniciarJuego.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        BotonIniciarJuego.setText("Iniciar Juego");
        BotonIniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIniciarJuegoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Titulo)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(190, 190, 190))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotonOpcionMultiple)
                        .addGap(54, 54, 54)
                        .addComponent(BotonFalsoVerdadero)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ComboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotonIniciarJuego)
                        .addGap(208, 208, 208))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonOpcionMultiple)
                    .addComponent(BotonFalsoVerdadero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(BotonIniciarJuego)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TriviaIGU inicio = new TriviaIGU();
    inicio.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboDificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboDificultadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboDificultadActionPerformed

    private void BotonIniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIniciarJuegoActionPerformed
       if (!BotonOpcionMultiple.isSelected() && !BotonFalsoVerdadero.isSelected()) {
        JOptionPane.showMessageDialog(this, "Debes seleccionar un tipo de trivia.");
        return;
    }//GEN-LAST:event_BotonIniciarJuegoActionPerformed

       int dificultad = ComboDificultad.getSelectedIndex() + 1;
boolean esMultiple = BotonOpcionMultiple.isSelected();

Usuario usuario = ControladorTrivia.getUsuarioActivo();
if (usuario == null) {
    JOptionPane.showMessageDialog(this, "Primero selecciona un usuario.");
    return; // ← aquí se detiene si no hay usuario
}

// Si hay usuario, recién aquí se abre el juego
VentanaJuegoReal juego = new VentanaJuegoReal(esMultiple, dificultad);
juego.setVisible(true);
this.dispose();
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
            java.util.logging.Logger.getLogger(VentanaJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJugar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BotonFalsoVerdadero;
    private javax.swing.JButton BotonIniciarJuego;
    private javax.swing.JRadioButton BotonOpcionMultiple;
    private javax.swing.JComboBox<String> ComboDificultad;
    private javax.swing.JLabel Titulo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
