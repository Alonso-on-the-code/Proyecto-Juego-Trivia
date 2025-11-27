package trivia.models;

import java.util.ArrayList;
import java.util.Collections; //coleccion de preguntas que se presentarán al jugador.

/**
  Representa un conjunto de preguntas que conforman un juego de trivia.
  - Implementa agregacion: contiene referencias a objetos Question, pero no los posee exclusivamente.
  - Permite mezclar las preguntas para presentarlas en orden aleatorio.
 */

public class Quiz {
    private String nombre;
    private ArrayList<Question> preguntas;
    
    public Quiz(String nombre) {
        this.nombre = nombre;
        this.preguntas = new ArrayList<>();
    }
    
    //aqui se agregan las preguntas
    public void addQuestion(Question q) {
        preguntas.add(q);
    }

    //se obtiene el numero de preguntas
    //y retorna el tamaño del quiz (preguntas)
    public int getSize() {
        return preguntas.size();
    }

    public ArrayList<Question> getPreguntas() {
        return preguntas;
    }

    // Devuelve preguntas mezcladas (no modifica la lista original)
    //retorna una copia de la lista de preguntas en aleatorio
    public ArrayList<Question> getPreguntasMezcladas() {
        ArrayList<Question> copia = new ArrayList<>(preguntas);
        Collections.shuffle(copia);
        return copia;
    }

    //obtiene el nombre del quiz
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + preguntas.size() + " preguntas)";
    }
}
