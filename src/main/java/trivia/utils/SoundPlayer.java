package trivia.utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Clase SoundPlayer.
 * Se encarga de reproducir sonidos durante el juego de trivia.
 * - Permite reproducir sonidos de respuesta correcta e incorrecta.
 * - Utiliza el sistema de audio de Java para cargar y reproducir archivos de sonido.
 */
public class SoundPlayer {

    /**
     * Ruta al archivo de sonido para respuesta correcta.
     */
    private static final String CORRECT_SOUND_PATH = "/sfx/correct-156911.wav";

    /**
     * Ruta al archivo de sonido para respuesta incorrecta.
     */
    private static final String INCORRECT_SOUND_PATH = "/sfx/error-mistake-sound-effect-incorrect-answer-437420.wav";

    /**
     * Reproduce el sonido de respuesta correcta.
     */
    public static void playCorrectSound() {
        playSound(CORRECT_SOUND_PATH);
    }

    /**
     * Reproduce el sonido de respuesta incorrecta.
     */
    public static void playIncorrectSound() {
        playSound(INCORRECT_SOUND_PATH);
    }

    /**
     * Metodo privado para reproducir un archivo de sonido.
     * @param soundPath Ruta del archivo de sonido a reproducir.
     */
    private static void playSound(String soundPath) {
    new Thread(() -> {
        try {
            java.net.URL soundURL = SoundPlayer.class.getResource(soundPath);

            if (soundURL != null) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);

                // Debug opcional
                System.out.println("Formato detectado: " + audioIn.getFormat());

                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();

            } else {
                System.err.println("No se encontró el archivo de sonido: " + soundPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }).start();
}

        
}