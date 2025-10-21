package trivia.models;

/**
 * Pregunta verdadero/falso.
 * - Hereda de Question
 */
public class TrueFalseQuestion extends Question {
    private boolean respuestaCorrecta;

    public TrueFalseQuestion(String enunciado, boolean respuestaCorrecta, int dificultad) {
        super(enunciado, dificultad);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean isCorrect(String respuesta) {
        respuesta = respuesta.trim().toLowerCase();
        if (respuesta.equals("true") || respuesta.equals("t") || respuesta.equals("verdadero") || respuesta.equals("v")) {
            return respuestaCorrecta == true;
        } else if (respuesta.equals("false") || respuesta.equals("f") || respuesta.equals("falso")) {
            return respuestaCorrecta == false;
        }
        // si no se entiende, devolver false
        return false;
    }

    @Override
    public String display() {
        return getEnunciado() + " (true/false)";
    }

    @Override
    public String toString() {
        return "TF: " + getEnunciado();
    }
}
