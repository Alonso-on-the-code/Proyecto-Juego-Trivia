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

    // --- NUEVO CÓDIGO PARA LA INTERFAZ GRÁFICA ---
private ArrayList<Question> preguntas; 
private int indiceActual = 0;

/**
 * Inicia la sesión sin usar consola (para GUI).
 * Carga las preguntas mezcladas desde el quiz.
 */
public void iniciarSinConsola() {
    preguntas = quiz.getPreguntasMezcladas();
    indiceActual = 0;
    score = new Score(); // reiniciar puntaje
}

/**
 * Devuelve la pregunta actual (null si ya no hay más).
 */
public Question getCurrentQuestion() {
    if (preguntas != null && indiceActual < preguntas.size()) {
        return preguntas.get(indiceActual);
    }
    return null;
}

/**
 * Registra una respuesta (según índice) y avanza a la siguiente pregunta.
 */
public void responder(int opcionSeleccionada) {
    if (preguntas == null || indiceActual >= preguntas.size()) return;

    Question actual = preguntas.get(indiceActual);
    boolean correcta = actual.isCorrect(String.valueOf(opcionSeleccionada + 1)); 
    int puntos = 10 * actual.getDificultad();
    score.registrarRespuesta(correcta, puntos);

    indiceActual++;

    // si ya terminó, actualiza las estadísticas del usuario
    if (indiceActual >= preguntas.size()) {
        usuario.incrementarPartida();
        usuario.agregarPuntaje(score.getPoints());
    }
}

/**
 * Indica si quedan preguntas por responder.
 */
public boolean hayMasPreguntas() {
    return preguntas != null && indiceActual < preguntas.size();
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
