package trivia.models;

import java.util.ArrayList;
import java.util.Collections;

//Clase Quiz: agrupa preguntas (agregacion).
public class Quiz {
    private String nombre;
    private ArrayList<Question> preguntas;
    
    public Quiz(String nombre) {
        this.nombre = nombre;
        this.preguntas = new ArrayList<>();
    }
    public void addQuestion(Question q) {
        preguntas.add(q);
    }

    public int getSize() {
        return preguntas.size();
    }

    public ArrayList<Question> getPreguntas() {
        return preguntas;
    }

    // Devuelve preguntas mezcladas (no modifica la lista original)
    public ArrayList<Question> getPreguntasMezcladas() {
        ArrayList<Question> copia = new ArrayList<>(preguntas);
        Collections.shuffle(copia);
        return copia;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + preguntas.size() + " preguntas)";
    }
}
