package trivia.persistence;

import trivia.models.*;
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

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
        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(usersFile), StandardCharsets.UTF_8))) {
            for (Usuario u : users) {
                pw.printf("%s;%d;%d%n", u.getNombre(), u.getPartidasJugadas(), u.getPuntajeTotal());
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

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    Usuario u = new Usuario(parts[0]);
                    try {
                        int partidas = Integer.parseInt(parts[1]);
                        int puntos = Integer.parseInt(parts[2]);
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
        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(questionsFile), StandardCharsets.UTF_8))) {
            for (Question q : questions) {
                if (q instanceof MultipleChoiceQuestion) {
                    MultipleChoiceQuestion m = (MultipleChoiceQuestion) q;
                    String opciones = String.join(":::", m.getOpciones());
                    pw.printf("MCQ|%d|%s|%s|%d%n", 
                            m.getDificultad(), escape(m.getEnunciado()), 
                            escape(opciones), m.getIndiceCorrecto());
                } else if (q instanceof TrueFalseQuestion) {
                    TrueFalseQuestion t = (TrueFalseQuestion) q;
                    pw.printf("TF|%d|%s|%b%n", 
                            t.getDificultad(), escape(t.getEnunciado()), 
                            t.isCorrect("true"));
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

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
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
                    questions.add(new MultipleChoiceQuestion(enunciado, opciones, indice, dificultad));
                } else if (tipo.equals("TF") && parts.length >= 4) {
                    boolean correct = Boolean.parseBoolean(parts[3]);
                    questions.add(new TrueFalseQuestion(enunciado, correct, dificultad));
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando preguntas: " + e.getMessage());
        }
        return questions;
    }

    private String escape(String s) {
        return s.replace("\n", "\\n").replace("|", "\\|");
    }

    private String unescape(String s) {
        return s.replace("\\n", "\n").replace("\\|", "|");
    }
// ----------- PAGOS Y SERVICIOS ------------
private static final String PLANES_FILE = "planes_premium.txt";
private static final String COMPRAS_FILE = "compras_extras.txt";

public static ArrayList<PlanPremium> cargarPlanes(){
    ArrayList<PlanPremium> lista = new ArrayList<>();
    try {
        java.io.File f = new java.io.File(PLANES_FILE);
        if(!f.exists()) return lista;

        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(f));
        String linea;
        while((linea = br.readLine()) != null){
            if(!linea.trim().isEmpty())
                lista.add(PlanPremium.fromCSV(linea));
        }
        br.close();
    } catch(Exception e){ e.printStackTrace(); }
    return lista;
}

public static void guardarPlanes(List<PlanPremium> lista){
    try {
        java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(PLANES_FILE));
        for(PlanPremium p : lista){
            bw.write(p.toString());
            bw.newLine();
        }
        bw.close();
    } catch(Exception e){ e.printStackTrace(); }
}

public static ArrayList<CompraExtra> cargarCompras(){
    ArrayList<CompraExtra> lista = new ArrayList<>();
    try {
        java.io.File f = new java.io.File(COMPRAS_FILE);
        if(!f.exists()) return lista;

        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(f));
        String linea;
        while((linea = br.readLine()) != null){
            if(!linea.trim().isEmpty())
                lista.add(CompraExtra.fromCSV(linea));
        }
        br.close();
    } catch(Exception e){ e.printStackTrace(); }
    return lista;
}

public static void guardarCompras(List<CompraExtra> lista){
    try {
        java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(COMPRAS_FILE));
        for(CompraExtra c : lista){
            bw.write(c.toString());
            bw.newLine();
        }
        bw.close();
    } catch(Exception e){ e.printStackTrace(); }
}
}