package trivia.exceptions;

/**
 * Excepcion personalizada para opciones inválidas o entradas incorrectas.
 */
public class InvalidOptionException extends Exception {
    public InvalidOptionException(String message) {
        super(message);
    }
}
