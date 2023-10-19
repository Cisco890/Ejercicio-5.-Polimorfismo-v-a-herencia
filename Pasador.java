/** Juan Francisco Martínez 23617
  * Pasador
 
  * @param pases,fintas,aparte_de_los_que_extiende_de_jugador
  * @throws Es la clase dedicada a los pasadores

  */
public class Pasador extends Jugador {
    private int pases;
    private int fintas;

    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintas = fintas;
    }

    public int getPases() {
        return pases;
    }

    public int getFintas() {
        return fintas;
    }

    @Override
    public double calcularEfectividad() {
        return ((pases + fintas - getErrores()) * 100.0 / (pases + fintas + getErrores())) +
               (getAces() * 100.0 / getTotalServicios());//manera de sacar la efectividad
    }
    @Override//se overridea para hacer un to string
    public String toString() {
    return super.toString() + "\n" +
           "Pases: " + getPases() + "\n" +
           "Fintas: " + getFintas();
}

}

