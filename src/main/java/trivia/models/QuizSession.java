package trivia.models;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * QuizSession: gestiona la ejecucion de un quiz para un usuario.
 * - Asociacion: referencia a Usuario (no lo crea).
 * - Composicion: crea internamente Score.
 */
public class QuizSession {
    private Usuario usuario; // asociacion -> la sesion esta ligada a un usuario
    private Quiz quiz;       // asociacion
    private Score score;     // composicion -> creado dentro de la sesion
    private Scanner sc;

    public QuizSession(Usuario usuario, Quiz quiz, Scanner sc) {
        this.usuario = usuario;
        this.quiz = quiz;
        this.sc = sc;
        this.score = new Score(); // composicion: Score existe solo dentro de la sesion
    }

    public void start() {
        // Obtener preguntas mezcladas
        ArrayList<Question> preguntas = quiz.getPreguntasMezcladas();
        System.out.println("Iniciando quiz: " + quiz.getNombre() + " | Usuario: " + usuario.getNombre());
        for (Question q : preguntas) {
            System.out.println("\n" + q.display());
            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine();
            boolean correcta = q.isCorrect(respuesta);
            // puntos por dificultad: fácil=10 medio=20 difícil=30
            int puntos = 10 * q.getDificultad();
            score.registrarRespuesta(correcta, puntos);
            System.out.println(correcta ? "¡Correcto!" : "Incorrecto.");
        }
        // Actualizar estadisticas del usuario (asociacion)
        usuario.incrementarPartida();
        usuario.agregarPuntaje(score.getPoints());
    }

    public Score getScore() {
        return score;
    }
}
