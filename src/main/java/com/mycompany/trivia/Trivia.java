package com.mycompany.trivia;

import trivia.models.*;
import trivia.persistence.*;
import trivia.exceptions.*;
import trivia.utils.*;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main: menú principal y punto de entrada.
 */
public class Trivia {
   
    

// Rutas de archivos para persistencia (puedes cambiar si quieres)
    private static final String USERS_FILE = "usuarios.txt";
    private static final String QUESTIONS_FILE = "preguntas.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileManager fm = new FileManager(USERS_FILE, QUESTIONS_FILE);

        // Cargar datos desde archivos (si existen)
        ArrayList<Usuario> usuarios = fm.loadUsers();
        ArrayList<Question> preguntas = fm.loadQuestions();

        System.out.println("=== Bienvenido al Juego de Trivia ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menu principal ---");
            System.out.println("1. Registrarse / seleccionar usuario");
            System.out.println("2. Jugar trivia");
            System.out.println("3. Administrar preguntas (agregar / listar)");
            System.out.println("4. Guardar datos");
            System.out.println("5. Cargar datos");
            System.out.println("6. Salir");
            try {
                int opcion = InputUtils.leerEntero(sc, "Elige una opcion: ");
                switch (opcion) {
                    case 1:
                        Usuario u = gestionarUsuarios(sc, usuarios);
                        // mostrar usuario seleccionado
                        if (u != null) {
                            System.out.println("Usuario activo: " + u.getNombre());
                        }
                        break;
                    case 2:
                        if (usuarios.isEmpty()) {
                            System.out.println("No hay usuarios registrados. Registrate primero.");
                        } else if (preguntas.isEmpty()) {
                            System.out.println("No hay preguntas cargadas. Agrega preguntas primero.");
                        } else {
                            jugar(sc, usuarios, preguntas);
                        }
                        break;
                    case 3:
                        administrarPreguntas(sc, preguntas);
                        break;
                    case 4:
                        fm.saveUsers(usuarios);
                        fm.saveQuestions(preguntas);
                        System.out.println("Datos guardados correctamente.");
                        break;
                    case 5:
                        usuarios = fm.loadUsers();
                        preguntas = fm.loadQuestions();
                        System.out.println("Datos cargados desde archivos.");
                        break;
                    case 6:
                        fm.saveUsers(usuarios);
                        fm.saveQuestions(preguntas);
                        System.out.println("Guardado automatico realizado. ¡Hasta luego!");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opcion invalida. Intenta de nuevo.");
                }
            } catch (InvalidOptionException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Ocurrio un error inesperado: " + ex.getMessage());
            }
        }
        sc.close();
    }

    // Gestión de usuarios: crear o seleccionar
    private static Usuario gestionarUsuarios(Scanner sc, ArrayList<Usuario> usuarios) {
        System.out.println("\n--- Gestion de usuarios ---");
        System.out.println("1. Crear nuevo usuario");
        System.out.println("2. Seleccionar usuario existente");
        try {
            int opt = InputUtils.leerEntero(sc, "Elige: ");
            if (opt == 1) {
                String nombre = InputUtils.leerString(sc, "Nombre de usuario: ");
                Usuario u = new Usuario(nombre);
                usuarios.add(u);
                System.out.println("Usuario creado: " + nombre);
                return u;
            } else if (opt == 2) {
                if (usuarios.isEmpty()) {
                    System.out.println("No hay usuarios. Crea uno nuevo.");
                    return null;
                }
                System.out.println("Usuarios disponibles:");
                for (int i = 0; i < usuarios.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, usuarios.get(i).getNombre());
                }
                int sel = InputUtils.leerEntero(sc, "Selecciona numero de usuario: ");
                if (sel < 1 || sel > usuarios.size()) {
                    System.out.println("Seleccion invalida.");
                    return null;
                }
                return usuarios.get(sel - 1);
            } else {
                System.out.println("Opcion invalida.");
                return null;
            }
        } catch (InvalidOptionException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    // Menú para administrar preguntas
    private static void administrarPreguntas(Scanner sc, ArrayList<Question> preguntas) {
        System.out.println("\n--- Administrar preguntas ---");
        System.out.println("1. Agregar pregunta opcion multiple");
        System.out.println("2. Agregar pregunta verdadero/falso");
        System.out.println("3. Listar preguntas");
        try {
            int opt = InputUtils.leerEntero(sc, "Elige: ");
            if (opt == 1) {
                String texto = InputUtils.leerString(sc, "Enunciado: ");
                ArrayList<String> opciones = new ArrayList<>();
                opciones.add(InputUtils.leerString(sc, "Opcion A: "));
                opciones.add(InputUtils.leerString(sc, "Opcion B: "));
                opciones.add(InputUtils.leerString(sc, "Opcion C: "));
                opciones.add(InputUtils.leerString(sc, "Opcion D: "));
                int correcta = InputUtils.leerEntero(sc, "Numero de opcion correcta (1-4): ");
                int dificultad = InputUtils.leerEntero(sc, "Dificultad (1-facil,2-medio,3-dificil): ");
                MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(texto, opciones, correcta - 1, dificultad);
                preguntas.add(mcq);
                System.out.println("Pregunta añadida.");
            } else if (opt == 2) {
                String texto = InputUtils.leerString(sc, "Enunciado: ");
                boolean resp = InputUtils.leerBoolean(sc, "Respuesta correcta (true/false): ");
                int dificultad = InputUtils.leerEntero(sc, "Dificultad (1-fácil,2-medio,3-difícil): ");
                TrueFalseQuestion tfq = new TrueFalseQuestion(texto, resp, dificultad);
                preguntas.add(tfq);
                System.out.println("Pregunta añadida.");
            } else if (opt == 3) {
                if (preguntas.isEmpty()) {
                    System.out.println("No hay preguntas.");
                } else {
                    for (int i = 0; i < preguntas.size(); i++) {
                        System.out.println("\nPregunta " + (i + 1));
                        System.out.println(preguntas.get(i).display());
                    }
                }
            } else {
                System.out.println("Opcion invalida.");
            }
        } catch (InvalidOptionException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // Jugar: motor de juego simple que usa QuizSession
    private static void jugar(Scanner sc, ArrayList<Usuario> usuarios, ArrayList<Question> preguntas) {
        System.out.println("\n--- Jugar Trivia ---");
        // seleccionar usuario
        System.out.println("Selecciona usuario:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, usuarios.get(i).getNombre());
        }
        try {
            int sel = InputUtils.leerEntero(sc, "Selecciona: ");
            if (sel < 1 || sel > usuarios.size()) {
                System.out.println("Seleccion invalida.");
                return;
            }
            Usuario user = usuarios.get(sel - 1);

            // elegir dificultad
            int dificultad = InputUtils.leerEntero(sc, "Dificultad deseada (1-facil,2-medio,3-dificil): ");
            // crear un Quiz (agregación: contiene lista de preguntas)
            Quiz quiz = new Quiz("Quiz nivel " + dificultad);
            // filtrar preguntas por dificultad y agregarlas al quiz
            for (Question q : preguntas) {
                if (q.getDificultad() == dificultad) {
                    quiz.addQuestion(q);
                }
            }
            if (quiz.getSize() == 0) {
                System.out.println("No hay preguntas para esa dificultad.");
                return;
            }

            // iniciar sesion de juego (asociación con usuario y composición con Score)
            QuizSession session = new QuizSession(user, quiz, sc);
            session.start();
            System.out.println("Resultado: " + session.getScore().getCorrect() + " correctas de " + session.getScore().getTotal());
            System.out.println("Puntuacion obtenida: " + session.getScore().getPoints());
        } catch (InvalidOptionException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
