package trivia.persistence;

import java.util.ArrayList;
import trivia.models.Usuario;
import trivia.models.Question;

/**
 * Interfaz Persistable: define contrato de persistencia.
 */
public interface Persistable {
    void saveUsers(ArrayList<Usuario> users);
    ArrayList<Usuario> loadUsers();

    void saveQuestions(ArrayList<Question> questions);
    ArrayList<Question> loadQuestions();
}
