package trivia.persistence;

import trivia.models.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

/**
 * FileManager: implementacion simple de persistencia en texto.
 * - Guarda usuarios en usersFile (cada linea: nombre;partidas;puntaje)
 * - Guarda preguntas en questionsFile tipo CSV:
 *   tipo|dificultad|enunciado|otros campos...
 */
public class FileManager implements Persistable {
    private String usersFile;
    private String questionsFile;

    public FileManager(String usersFile, String questionsFile) {
        this.usersFile = usersFile;
        this.questionsFile = questionsFile;
    }

    @Override
    public void saveUsers(ArrayList<Usuario> users) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(usersFile))) {
            for (Usuario u : users) {
                pw.printf("%s;%d;%d\n", u.getNombre(), u.getPartidasJugadas(), u.getPuntajeTotal());
            }
        } catch (IOException e) {
            System.out.println("Error guardando usuarios: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Usuario> loadUsers() {
        ArrayList<Usuario> users = new ArrayList<>();
        File f = new File(usersFile);
        if (!f.exists()) return users;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    Usuario u = new Usuario(parts[0]);
                    // intentar parsear partidas y puntaje (si hay datos)
                    try {
                        // reflectamos los valores mediante métodos públicos
                        int partidas = Integer.parseInt(parts[1]);
                        int puntos = Integer.parseInt(parts[2]);
                        // aplicar
                        for (int i = 0; i < partidas; i++) u.incrementarPartida();
                        u.agregarPuntaje(puntos);
                    } catch (NumberFormatException ignore) {}
                    users.add(u);
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando usuarios: " + e.getMessage());
        }
        return users;
    }

    @Override
    public void saveQuestions(ArrayList<Question> questions) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(questionsFile))) {
            for (Question q : questions) {
                if (q instanceof MultipleChoiceQuestion) {
                    MultipleChoiceQuestion m = (MultipleChoiceQuestion) q;
                    // formato: MCQ|dificultad|enunciado|opc1:::opc2:::opc3:::opc4|indiceCorrecto
                    String opciones = String.join(":::", m.getOpciones());
                    pw.printf("MCQ|%d|%s|%s|%d\n", m.getDificultad(), escape(m.getEnunciado()), escape(opciones), m.getIndiceCorrecto());
                } else if (q instanceof TrueFalseQuestion) {
                    TrueFalseQuestion t = (TrueFalseQuestion) q;
                    pw.printf("TF|%d|%s|%b\n", t.getDificultad(), escape(t.getEnunciado()), t.isCorrect("true")); // guardamos la verdad
                }
            }
        } catch (IOException e) {
            System.out.println("Error guardando preguntas: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Question> loadQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        File f = new File(questionsFile);
        if (!f.exists()) return questions;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length < 3) continue;
                String tipo = parts[0];
                int dificultad = Integer.parseInt(parts[1]);
                String enunciado = unescape(parts[2]);
                if (tipo.equals("MCQ") && parts.length >= 5) {
                    String opcionesRaw = unescape(parts[3]);
                    ArrayList<String> opciones = new ArrayList<>(Arrays.asList(opcionesRaw.split(":::")));
                    int indice = Integer.parseInt(parts[4]);
                    MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(enunciado, opciones, indice, dificultad);
                    questions.add(mcq);
                } else if (tipo.equals("TF") && parts.length >= 4) {
                    boolean correct = Boolean.parseBoolean(parts[3]);
                    TrueFalseQuestion tfq = new TrueFalseQuestion(enunciado, correct, dificultad);
                    questions.add(tfq);
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando preguntas: " + e.getMessage());
        }
        return questions;
    }

    // escapado simple para '|' y saltos de linea
    private String escape(String s) {
        return s.replace("\n", "\\n").replace("|", "\\|");
    }

    private String unescape(String s) {
        return s.replace("\\n", "\n").replace("\\|", "|");
    }
}
