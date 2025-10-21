package trivia.utils;

import java.util.Scanner;
import trivia.exceptions.InvalidOptionException;

/**
 * Utilidades para manejar entradas por consola con validación y manejo de excepciones.
 */
public class InputUtils {
    /**
     * Lee un entero de forma segura, lanzando InvalidOptionException si no es válido.
     */
    public static int leerEntero(Scanner sc, String prompt) throws InvalidOptionException {
        System.out.print(prompt);
        String line = sc.nextLine();
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException ex) {
            throw new InvalidOptionException("Se esperaba un número entero.");
        }
    }

    /**
     * Lee una cadena (no vacía).
     */
    public static String leerString(Scanner sc, String prompt) throws InvalidOptionException {
        System.out.print(prompt);
        String line = sc.nextLine();
        if (line == null || line.trim().isEmpty()) {
            throw new InvalidOptionException("La entrada no puede estar vacía.");
        }
        return line.trim();
    }

    /**
     * Lee un booleano simple: interpreta true/false/t/f/verdadero/falso.
     */
    public static boolean leerBoolean(Scanner sc, String prompt) throws InvalidOptionException {
        System.out.print(prompt);
        String line = sc.nextLine().trim().toLowerCase();
        if (line.equals("true") || line.equals("t") || line.equals("verdadero") || line.equals("v")) return true;
        if (line.equals("false") || line.equals("f") || line.equals("falso")) return false;
        throw new InvalidOptionException("Se esperaba true/false (o t/f, verdadero/falso).");
    }
}
