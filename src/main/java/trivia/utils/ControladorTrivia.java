

package trivia.utils;

import trivia.models.*;
import trivia.persistence.FileManager;
import java.util.ArrayList;

//Esta clase mantiene todos los datos cargados disponibles para todas tus ventanas GUI.
public class ControladorTrivia {
    private static final String USERS_FILE = "usuarios.txt";
    private static final String QUESTIONS_FILE = "preguntas.txt";

    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Question> preguntas;
    private static FileManager fileManager;
    private static Usuario usuarioActivo;

    static {
        fileManager = new FileManager(USERS_FILE, QUESTIONS_FILE);
        usuarios = fileManager.loadUsers();
        preguntas = fileManager.loadQuestions();
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static ArrayList<Question> getPreguntas() {
        return preguntas;
    }

    public static Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public static void setUsuarioActivo(Usuario u) {
        usuarioActivo = u;
    }

    public static void guardarDatos() {
        fileManager.saveUsers(usuarios);
        fileManager.saveQuestions(preguntas);
    }

    public static void cargarDatos() {
        usuarios = fileManager.loadUsers();
        preguntas = fileManager.loadQuestions();
    }
}
