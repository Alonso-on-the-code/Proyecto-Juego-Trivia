package trivia.models;
/*
* Clase abstracta Question.
 * - Define la estructura comun para diferentes tipos de preguntas.
* - Metodo abstracto isCorrect para verificar respuesta
*/

public abstract class Question {
    private String enunciado;
    private int dificultad; // 1,2,3

    public Question(String enunciado, int dificultad) {
        this.enunciado = enunciado;
        this.dificultad = dificultad;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public int getDificultad() {
        return dificultad;
    }

    /**
     * Verifica si la respuesta del jugador es correcta.
     * Implementado en las subclases (polimorfismo - sobreescritura).
     * @param respuesta entrada del usuario (puede interpretarse de distintas formas)
     * @return true si es correcta
     */
    public abstract boolean isCorrect(String respuesta);

    /**
     * Muestra la pregunta de forma legible.
     */
    public abstract String display();

    // sobrecarga de ejemplo: permitir verificar usando ints
    public boolean isCorrect(int respuestaIndex) {
        // por defecto intentar convertir el int a String
        return isCorrect(String.valueOf(respuestaIndex));
    }

    @Override
    public String toString() {
        return getEnunciado();
    }
}
