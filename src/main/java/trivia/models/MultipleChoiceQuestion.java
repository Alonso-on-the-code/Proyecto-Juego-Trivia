package trivia.models;

import java.util.ArrayList;

 //Pregunta de opcion multiple.
//Hereda de Question
//Ejemplo sobrecarga: constructor adicional

public class MultipleChoiceQuestion extends Question{
    private ArrayList<String> opciones;
    private int indiceCorrecto; 
    
    // Constructor principal
    public MultipleChoiceQuestion(String enunciado, ArrayList<String> opciones, int indiceCorrecto, int dificultad) {
        super(enunciado, dificultad);
        this.opciones = new ArrayList<>(opciones); // copia para encapsular
        this.indiceCorrecto = indiceCorrecto;
    }
    
    // Constructor sobrecargado: permite crear con 4 opciones separadas (ejemplo de sobrecarga)
    public MultipleChoiceQuestion(String enunciado, String a, String b, String c, String d, int indiceCorrecto, int dificultad) {
        this(enunciado, new ArrayList<String>() {{
            add(a); add(b); add(c); add(d);
        }}, indiceCorrecto, dificultad);
    }

    public ArrayList<String> getOpciones() {
        return opciones;
    }

    public int getIndiceCorrecto() {
        return indiceCorrecto;
    }

    @Override
    public boolean isCorrect(String respuesta) {
        try {
            // esperar que el usuario envíe "1","2","3" o "A","B","C"
            respuesta = respuesta.trim().toUpperCase();
            if (respuesta.length() == 1 && respuesta.charAt(0) >= 'A' && respuesta.charAt(0) <= 'Z') {
                int index = respuesta.charAt(0) - 'A';
                return index == indiceCorrecto;
            } else {
                int idx = Integer.parseInt(respuesta) - 1;
                return idx == indiceCorrecto;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append(getEnunciado()).append("\n");
        char label = 'A';
        for (String opt : opciones) {
            sb.append(label).append(") ").append(opt).append("\n");
            label++;
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "MCQ: " + getEnunciado();
    }

}
