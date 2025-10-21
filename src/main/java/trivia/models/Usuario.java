package trivia.models;

/*
* - Ejemplo de encapsulamiento (campos privados, getters/setters).
 * - Asociacion: un Usuario puede jugar en una QuizSession. 
*/

public class Usuario {
    private String nombre;
    private int partidasJugadas;
    private int puntajeTotal;
            
    
    public Usuario(String nombre) {
        this.nombre=nombre;
        this.partidasJugadas=0;
        this.puntajeTotal=0;        
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void incrementarPartida() {
        this.partidasJugadas++;
    }

    public void agregarPuntaje(int puntos) {
        this.puntajeTotal += puntos;
    }

    @Override
    public String toString() {
        return String.format("%s (Partidas: %d, Puntos: %d)", nombre, partidasJugadas, puntajeTotal);
    }

    
    
}
