/** Juan Francisco Martínez 23617
  * Auxiliar
 
  * @param ataques,bloqueosEfectivos,bloqueosnoefectivos,fintas,aparte_de_los_que_extiende_de_jugador
  * @throws Es la clase dedicada a los auxiliares

  */
public class Auxiliar extends Jugador {
    private int ataques;
    private int bloqueosEfectivos;
    private int bloqueosNoEfectivos;

    public Auxiliar(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosNoEfectivos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosNoEfectivos = bloqueosNoEfectivos;
    }

    public int getAtaques() {
        return ataques;
    }

    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    public int getBloqueosNoEfectivos() {
        return bloqueosNoEfectivos;
    }

    @Override
    public double calcularEfectividad() {
        return ((ataques + bloqueosEfectivos - bloqueosNoEfectivos - getErrores()) * 100.0 / 
                (ataques + bloqueosEfectivos + bloqueosNoEfectivos + getErrores())) +
               (getAces() * 100.0 / getTotalServicios());
    }
    @Override//se overridea para hacer un to string
    public String toString() {
    return super.toString() + "\n" +
           "Ataques: " + getAtaques() + "\n" +
           "Bloqueos Efectivos: " + getBloqueosEfectivos() + "\n" +
           "Bloqueos No Efectivos: " + getBloqueosNoEfectivos();
}

}
