/** Juan Francisco Martínez 23617
  * Torneo
 
  * @param Data
  * @throws Es el main del programa, aca se realiza todo

  */ //Como comentario extra, no sé porque cuando hay un valor en efectividad el codigo deja de funcionar, así que por favor borrenlo cuando corra otra vez :(
import java.util.List;

public class Torneo {
    public static void main(String[] args) {
        Data torneoData = new Data();
        torneoData.cargarDatosCSV("jugadores.csv");


        //  obtener el jugador más valioso
        Jugador jugadorMasValioso = torneoData.jugadorMasValioso();
        if (jugadorMasValioso != null) {
            System.out.println("Jugador más valioso: " + jugadorMasValioso.getNombre());
        } else {
            System.out.println("No hay jugadores en el torneo.");
        }

        //  obtener los 3 mejores líberos
        List<Jugador> topLiberos = torneoData.obtenerTop3Liberos();
        System.out.println("Top 3 Liberos:");
        for (Jugador jugador : topLiberos) {
            if (jugador != null) {
                System.out.println(jugador.getNombre());
            }
        }

        //  contar pasadores con más de 80% de efectividad
        int pasadoresCon80PorCiento = torneoData.contarPasadoresCon80PorCientoEfectividad();
        System.out.println("Pasadores con más del 80% de efectividad: " + pasadoresCon80PorCiento);
        torneoData.mostrarTodosLosJugadores();

        // guardar datos en CSV )
        torneoData.guardarDatosCSV("jugadores.csv");
    }
}




