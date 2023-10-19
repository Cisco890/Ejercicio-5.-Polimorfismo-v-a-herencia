/** Juan Francisco Martínez 23617
  * Jugador
 
  * @param Nombre,pais,errores,aces,totalservicios
  * @throws Es la clase dedicada a los jugadores, la padre del programa

  */
public abstract class Jugador {
    private String nombre;
    private String pais;
    private int errores;
    private int aces;
    private int totalServicios;

    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getErrores() {
        return errores;
    }

    public int getAces() {
        return aces;
    }

    public int getTotalServicios() {
        return totalServicios;
    }

    public abstract double calcularEfectividad();

    @Override//se overridea para hacer un to string
    public String toString() {
        return "Tipo: " + this.getClass().getSimpleName() + "\n" +
               "Nombre: " + getNombre() + "\n" +
               "País: " + getPais() + "\n" +
               "Errores: " + getErrores() + "\n" +
               "Aces: " + getAces() + "\n" +
               "Total Servicios: " + getTotalServicios() + "\n" +
               "Efectividad: " + calcularEfectividad();
    }
    
}
