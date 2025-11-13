package igu;

import javax.swing.JOptionPane;
import trivia.models.MultipleChoiceQuestion;
import trivia.models.Question;
import trivia.models.Quiz;
import trivia.models.QuizSession;
import trivia.models.TrueFalseQuestion;
import trivia.models.Usuario;
import trivia.utils.ControladorTrivia;


public class VentanaJuegoReal extends javax.swing.JFrame {

    private QuizSession sesion;
    private boolean esMultiple; 
    private int dificultad;
    
    public VentanaJuegoReal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

//recibe el tipo de trivia y la dificultad desde VentanaJugar
public VentanaJuegoReal(boolean esMultiple, int dificultad) {
    // Primero validamos antes de inicializar componentes
    Usuario usuario = ControladorTrivia.getUsuarioActivo();
    if (usuario == null) {
        JOptionPane.showMessageDialog(null, "Primero selecciona un usuario.");
        // No creamos ni mostramos la ventana
        return;
    }

    // Si sí hay usuario, recién ahora inicializamos el formulario
    initComponents();
    this.setLocationRelativeTo(null);
    this.esMultiple = esMultiple;
    this.dificultad = dificultad;
    iniciarJuego();
}

private void iniciarJuego() {
    Usuario usuario = ControladorTrivia.getUsuarioActivo();
    if (usuario == null) {
        JOptionPane.showMessageDialog(this, "Primero selecciona un usuario.");
        new TriviaIGU().setVisible(true);
        dispose();
        return;
    }
    
     // Crear el quiz según tipo y dificultad
    Quiz quiz = new Quiz("Trivia nivel " + dificultad);
    for (Question q : ControladorTrivia.getPreguntas()) {
        boolean tipoCoincide = (esMultiple && q instanceof MultipleChoiceQuestion)
                            || (!esMultiple && q instanceof TrueFalseQuestion);
        if (tipoCoincide && q.getDificultad() == dificultad) {
            quiz.addQuestion(q);
        }
    }
    
    if (quiz.getSize() == 0) {
        JOptionPane.showMessageDialog(this, "No hay preguntas para ese tipo o dificultad.");
        new TriviaIGU().setVisible(true);
        dispose();
        return;
    }

    sesion = new QuizSession(usuario, quiz, null);
    sesion.iniciarSinConsola(); // método que agregaste en QuizSession
    mostrarPregunta();
}

 // Muestra la pregunta actual en la interfaz
private void mostrarPregunta() {
    Question q = sesion.getCurrentQuestion();
    if (q == null) {
        JOptionPane.showMessageDialog(this, "Juego terminado. Puntaje: " + sesion.getScore().getPoints());
        new TriviaIGU().setVisible(true);
        dispose();
        return;
    }
    
    AreaPregunta.setText(q.getEnunciado());

        if (q instanceof MultipleChoiceQuestion mcq) {
            OpcionA.setVisible(true);
            OpcionB.setVisible(true);
            OpcionC.setVisible(true);
            OpcionD.setVisible(true);

            OpcionA.setText("A. " + mcq.getOpciones().get(0));
            OpcionB.setText("B. " + mcq.getOpciones().get(1));
            OpcionC.setText("C. " + mcq.getOpciones().get(2));
            OpcionD.setText("D. " + mcq.getOpciones().get(3));
        } else if (q instanceof TrueFalseQuestion tfq) {
            OpcionA.setVisible(true);
            OpcionB.setVisible(true);
            OpcionC.setVisible(false);
            OpcionD.setVisible(false);

            OpcionA.setText("Verdadero");
            OpcionB.setText("Falso");
        }

        buttonGroup1.clearSelection();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaPregunta = new javax.swing.JTextArea();
        OpcionA = new javax.swing.JRadioButton();
        OpcionB = new javax.swing.JRadioButton();
        OpcionC = new javax.swing.JRadioButton();
        OpcionD = new javax.swing.JRadioButton();
        BotonSiguiente = new javax.swing.JButton();
        BotonMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(546, 452));

        Titulo.setFont(new java.awt.Font("Candara", 1, 32)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("TriviaMaster - En Juego");

        AreaPregunta.setEditable(false);
        AreaPregunta.setBackground(new java.awt.Color(255, 255, 255));
        AreaPregunta.setColumns(20);
        AreaPregunta.setLineWrap(true);
        AreaPregunta.setRows(5);
        AreaPregunta.setWrapStyleWord(true);
        jScrollPane1.setViewportView(AreaPregunta);

        buttonGroup1.add(OpcionA);
        OpcionA.setText("A");

        buttonGroup1.add(OpcionB);
        OpcionB.setText("B");

        buttonGroup1.add(OpcionC);
        OpcionC.setText("C");

        buttonGroup1.add(OpcionD);
        OpcionD.setText("D");

        BotonSiguiente.setBackground(new java.awt.Color(76, 175, 80));
        BotonSiguiente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonSiguiente.setText("Siguiente");
        BotonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSiguienteActionPerformed(evt);
            }
        });

        BotonMenu.setBackground(new java.awt.Color(255, 0, 0));
        BotonMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonMenu.setText("Volver al menu");
        BotonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonMenu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OpcionD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonSiguiente)
                        .addGap(133, 133, 133))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OpcionA)
                            .addComponent(OpcionB)
                            .addComponent(OpcionC)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(OpcionA)
                .addGap(18, 18, 18)
                .addComponent(OpcionB)
                .addGap(18, 18, 18)
                .addComponent(OpcionC)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonSiguiente)
                    .addComponent(OpcionD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(BotonMenu)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSiguienteActionPerformed
       int seleccion = -1;
    if (OpcionA.isSelected()) seleccion = 0; //OPCION A
    else if (OpcionB.isSelected()) seleccion = 1; //OPCION B
    else if (OpcionC.isSelected()) seleccion = 2; //OPCION C
    else if (OpcionD.isSelected()) seleccion = 3; //OPCION D

    if (seleccion == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona una respuesta antes de continuar.");
        return;
    }

    sesion.responder(seleccion);
    mostrarPregunta(); 
    }//GEN-LAST:event_BotonSiguienteActionPerformed

    private void BotonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMenuActionPerformed
        TriviaIGU menu = new TriviaIGU();
    menu.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_BotonMenuActionPerformed

    
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(VentanaJuegoReal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuegoReal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuegoReal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuegoReal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuegoReal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaPregunta;
    private javax.swing.JButton BotonMenu;
    private javax.swing.JButton BotonSiguiente;
    private javax.swing.JRadioButton OpcionA;
    private javax.swing.JRadioButton OpcionB;
    private javax.swing.JRadioButton OpcionC;
    private javax.swing.JRadioButton OpcionD;
    private javax.swing.JLabel Titulo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
