package trivia.models;

/**
 * Score: objeto que representa el resultado de una sesión.
 * - Ejemplo de composicion: Score se crea dentro de QuizSession y no tiene sentido fuera de ella.
 - Mantiene el registro de respuestas correctas/incorrectas y el puntaje total.
 * - Permite calcular estadísticas del desempeño del jugador.
 */
public class Score {
    private int total;
    private int correct;
    private int points;

    public Score() {
        this.total = 0;
        this.correct = 0;
        this.points = 0;
    }

    // actualizar al responder una pregunta
    public void registrarRespuesta(boolean correcta, int puntosPorPregunta) {
        total++;
        if (correcta) {
            correct++;
            points += puntosPorPregunta;
        }
    }

    //total preguntas
    public int getTotal() {
        return total;
    }

    public int getCorrect() {
        return correct;
    }

    //Da los puntos
    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return String.format("Correctas: %d/%d, Puntos: %d", correct, total, points);
    }
}
