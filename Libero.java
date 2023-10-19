/** Juan Francisco Martínez 23617
  * Libero
 
  * @param recibosEfectivos,aparte_de_los_que_extiende_de_jugador
  * @throws Es la clase dedicada a los liberos

  */
public class Libero extends Jugador {
    private int recibosEfectivos;

    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibosEfectivos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibosEfectivos = recibosEfectivos;
    }

    public int getRecibosEfectivos() {
        return recibosEfectivos;
    }

    @Override
    public double calcularEfectividad() {
        return ((recibosEfectivos - getErrores()) * 100.0 / (recibosEfectivos + getErrores())) +
               (getAces() * 100.0 / getTotalServicios());
    }
    @Override//se overridea para hacer un to string
public String toString() {
    return super.toString() + "\n" +
           "Recibos Efectivos: " + getRecibosEfectivos();
}

}
