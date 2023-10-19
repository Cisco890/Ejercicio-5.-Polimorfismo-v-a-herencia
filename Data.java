/** Juan Francisco Martínez 23617
  * Libero
 
  * @param jugadores-y-clases-hijas,csv
  * @throws métodos para obtener los rankins de los jugadores, aparte de cargar y escribir los csv

  */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Jugador> jugadores;

    public Data() {
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public Jugador jugadorMasValioso() {
        Jugador masValioso = null;
        double maxEfectividad = -1;

        for (Jugador jugador : jugadores) {
            double efectividad = jugador.calcularEfectividad();
            if (efectividad > maxEfectividad) {
                maxEfectividad = efectividad;
                masValioso = jugador;
            }
        }

        return masValioso;
    }// jugador mas valioso del campeonato

    public void mostrarTodosLosJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
    }

    public List<Jugador> obtenerTop3Liberos() {
        List<Jugador> topLiberos = new ArrayList<>();
        List<Jugador> jugadoresLibero = new ArrayList<>();

        for (Jugador jugador : jugadores) {
            if (jugador instanceof Libero) {
                jugadoresLibero.add(jugador);
            }
        }

        jugadoresLibero.sort((j1, j2) -> Double.compare(j2.calcularEfectividad(), j1.calcularEfectividad()));

        topLiberos.addAll(jugadoresLibero.subList(0, Math.min(3, jugadoresLibero.size())));

        return topLiberos;
    }//sacar el top liberos

    public int contarPasadoresCon80PorCientoEfectividad() {
        int count = 0;

        for (Jugador jugador : jugadores) {
            if (jugador instanceof Pasador) {
                double efectividad = jugador.calcularEfectividad();
                if (efectividad > 80.0) {
                    count++;
                }
            }
        }

        return count;
    }// pasadores con el 80 porciento de efectividad

    public void guardarDatosCSV(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo, true))) {
            if (new File(nombreArchivo).length() == 0) {
                writer.println("Tipo,Nombre,Pais,Errores,Aces,TotalServicios,RecibosEfectivos,Pases,Fintas,Ataques,BloqueosEfectivos,BloqueosNoEfectivos,Efectividad");
            }

            for (Jugador jugador : jugadores) {
                String tipo = jugador.getClass().getSimpleName();
                writer.print(tipo + "," + jugador.getNombre() + "," + jugador.getPais() + "," +
                        jugador.getErrores() + "," + jugador.getAces() + "," + jugador.getTotalServicios());

                if (jugador instanceof Libero) {
                    writer.println("," + ((Libero) jugador).getRecibosEfectivos() + ",,,,," + jugador.calcularEfectividad());
                } else if (jugador instanceof Pasador) {
                    writer.println(",," + ((Pasador) jugador).getPases() + "," + ((Pasador) jugador).getFintas() + ",,," + jugador.calcularEfectividad());
                } else if (jugador instanceof Auxiliar) {
                    writer.println(",,,,," + ((Auxiliar) jugador).getAtaques() + "," + ((Auxiliar) jugador).getBloqueosEfectivos() + "," + ((Auxiliar) jugador).getBloqueosNoEfectivos() + "," + jugador.calcularEfectividad());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// guardar datos en un csv

    public void cargarDatosCSV(String nombreArchivo) {
        jugadores.clear();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            boolean primeraLinea = true;
    
            while ((line = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;  // Saltar la primera línea 
                }
    
                String[] data = line.split(",");
    
                if (data.length < 7) {
                    continue;  // Ignorar líneas que no tienen suficientes campos
                }
    
                String tipo = data[0];
                String nombre = data[1];
                String pais = data[2];
                int errores = Integer.parseInt(data[3]);
                int aces = Integer.parseInt(data[4]);
                int totalServicios = Integer.parseInt(data[5]);
                int recibosEfectivos = 0; // Valor predeterminado
                int pases = 0; // Valor predeterminado
                int fintas = 0; // Valor predeterminado
                int ataques = 0; // Valor predeterminado
                int bloqueosEfectivos = 0; // Valor predeterminado
                int bloqueosNoEfectivos = 0; // Valor predeterminado
    
                if (data.length >= 8) {
                    recibosEfectivos = Integer.parseInt(data[7]);
                }
                if (data.length >= 9) {
                    pases = Integer.parseInt(data[8]);
                }
                if (data.length >= 10) {
                    fintas = Integer.parseInt(data[9]);
                }
                if (data.length >= 11) {
                    ataques = Integer.parseInt(data[10]);
                }
                if (data.length >= 12) {
                    bloqueosEfectivos = Integer.parseInt(data[11]);
                }
                if (data.length >= 13) {
                    bloqueosNoEfectivos = Integer.parseInt(data[12]);
                }

    
                // creación de un jugador Libero:
                if (tipo.equals("Libero")) {
                    Libero libero = new Libero(nombre, pais, errores, aces, totalServicios, recibosEfectivos);
                    jugadores.add(libero);
                }
    
                //  creación de un jugador Pasador:
                if (tipo.equals("Pasador")) {
                    Pasador pasador = new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintas);
                    jugadores.add(pasador);
                }
    
                //creación de un jugador Auxiliar:
                if (tipo.equals("Auxiliar")) {
                    Auxiliar auxiliar = new Auxiliar(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosNoEfectivos);
                    jugadores.add(auxiliar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}