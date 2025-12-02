package UNIDAD3;

import java.util.ArrayList;
import java.util.Iterator;

// Declaración de la clase Personaje
public class Personaje {

    /****************
     * CONSTANTES *
     *****************/
    public static final int MAX_ARMAS = 3;
    public static final int EXITO = 0;
    public static final int FRACASO = -1;
    public static final int ERROR_CARGADO = -1;

    public static final int GUERRERO = 1;
    public static final int MAGO = 2;
    public static final int FRANCOTIRADOR = 3;
    public static final int LADRON = 4;
    /************************
     * VARIABLES MIEMBRO *
     *************************/
    // Atributos de la clase (encapsulación)
    // Son privados para restringir el acceso directo desde fuera de la clase.
    // Solo se pueden modificar o acceder a través de métodos públicos (getters y
    // setters).
    private String nombre; // Variable de instancia: cada objeto Personaje tendrá su propio nombre
    private int vida; // Variable de instancia: cada objeto Personaje tendrá su propia vida
    private int armadura; // Variable de instancia: cada objeto Personaje tendrá su propia armadura
    private int clase;
    // Modificador de acceso 'protected': Permite el acceso a esta variable
    // desde la misma clase, clases del mismo paquete y subclases (herencia).
    protected int creditos; // Variable de instancia

    private ArrayList<Arma> listaArmas;

    /************************
     * CONSTRUCTORES *
     *************************/
    // Constructor por defecto o sin argumentos.
    // Se invoca cuando se crea un objeto sin especificar valores iniciales.
    // Inicializa los atributos con valores predeterminados.
    public Personaje() {
        this.nombre = "Generado"; // 'this' se refiere a la instancia actual del objeto.
        this.vida = (int) (Math.random() * 100) + 1; // Asigna una vida aleatoria.
        this.armadura = 100;
        this.creditos = 30;
        this.listaArmas = new ArrayList<Arma>();
    }

    // Constructor con argumentos.
    // Permite crear un objeto Personaje con valores específicos para sus atributos.
    // El ámbito de las variables 'nombre', 'vida', 'armadura', 'creditos'
    // (parámetros)
    // es local a este constructor.
    public Personaje(String nombre, int vida, int armadura, int creditos, int clase) {
        this.nombre = nombre; // Asigna el valor del parámetro 'nombre' al atributo 'nombre' del objeto.
        this.vida = vida;
        this.armadura = armadura;
        this.creditos = creditos;
        this.clase = clase;
        this.listaArmas = new ArrayList<Arma>();

    }

    /**********************************************************************************
     * FUNCIONES *
     **********************************************************************************/
    /**
     * Esta funcion recibe un arma y se la intenta asignar al personaje, los magos
     * sólo
     * equipan armas de largo alcance, los francotiradores largo alcance o explosiva
     * si no lleva armadura en caso de explosiva
     * y los guerreros corto alcance y explosiva si tiene mas de 20 puntos de vida.
     * Sólo puede equipar el arma si no ha alcanzado la cantidad de armas máximas
     * 
     * @param arma El arma que quiere equiparse
     * @return exito o fracaso o cargado
     * @
     */
    public int equiparArma(Arma arma) {

        // Comprobamos si el arma es valida para el personaje
        if ((clase == MAGO && arma.getTipo() == Arma.LARGA_DISTANCIA)
                || (clase == FRANCOTIRADOR && (arma.getTipo() == Arma.LARGA_DISTANCIA
                        || (arma.getTipo() == Arma.EXPLOSIVA && this.armadura == 0)))
                || (clase == GUERRERO && (arma.getTipo() == Arma.CORTA_DISTANCIA
                        || (arma.getTipo() == Arma.EXPLOSIVA && this.vida > 20)))) {
            // Si no se pasa de capacidad se equipa
            if (listaArmas.size() < MAX_ARMAS) {
                this.listaArmas.add(arma);
            } else
                return ERROR_CARGADO;
        } else
            return FRACASO;

        return EXITO;
    }

    /**
     * Busca el arma entre el arsenal del personaje y si esta en su lista de armas
     * la eliminar
     * 
     * @param arma
     * @return EXITO Si existe el arma y la ha podido quitar y FRACASO Sino
     */
    public int desarmar(Arma arma) {

        if (arma == null || this.listaArmas.isEmpty())
            return FRACASO;

        // Ejemplo de eliminar elementos de un arrayList con condiciones usando removeIf
        // listaArmas.removeIf(a -> a.equals(arma));

        // Comprobamos si el arma esta en el array
        if (listaArmas.contains(arma)) {
            listaArmas.remove(arma);
            return EXITO;
        } else
            return FRACASO;

    }

    /**
     * Funcion que devuelve el arma que mas pesa
     * 
     * @return El arma que mas pesa o null si no hay armas
     */
    public Arma armaMasPesada() {
        // Creamos un iterator para recorrer las armas
        // El iterator contiene al arrayList de armas y funciones para recorrerlo
        Iterator<Arma> it = this.listaArmas.iterator();
        double maxPeso = Double.MIN_VALUE;
        Arma armaMax = null;

        // hasNext es true mientras queden elementos por recorrer en la lista
        while (it.hasNext()) {
            // next() nos devuelve el elemento de la posicion actual y pasa al siguiente
            // elemento
            Arma arma = it.next();
            if (arma.getPeso() > maxPeso) {
                maxPeso = arma.getPeso();
                armaMax = arma;
            }
        }

        // Devolvemos el arma con mas peso
        return armaMax;

    }

    // Métodos "getter" (accesores) para obtener el valor de los atributos privados.
    // Son públicos para permitir el acceso controlado a los atributos desde otras
    // clases (encapsulación).
    public int getVida() {
        return vida; // Devuelve el valor del atributo 'vida'.
    }

    // Método "setter" (mutador) para establecer el valor del atributo privado
    // 'vida'.
    // Permite modificar el atributo de forma controlada.
    public void setVida(int vida) { // El parámetro 'vida' es una variable local al método.

        this.vida = vida; // Asigna el valor del parámetro 'vida' al atributo 'vida' del objeto.
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreRecibido) { // 'nombreRecibido' es el parámetro local.
        nombre = nombreRecibido; // Asigna el valor del parámetro 'nombreRecibido' al atributo 'nombre'.
    }

    public int getCreditos() {
        return this.creditos;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public ArrayList<Arma> getListaArmas() {
        return listaArmas;
    }

    public void setListaArmas(ArrayList<Arma> listaArmas) {
        this.listaArmas = listaArmas;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    private String claseDescripcion() {
        switch (this.clase) {
            case GUERRERO:
                return "Guerrero";
            case MAGO:
                return "Mago";
            case FRANCOTIRADOR:
                return "Francotirador";
            case LADRON:
                return "Ladrón";
            default:
                return "Desconocida";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Personaje {");
        sb.append("nombre='").append(this.nombre).append('\'');
        sb.append(", vida=").append(this.vida);
        sb.append(", armadura=").append(this.armadura);
        sb.append(", creditos=").append(this.creditos);
        sb.append(", clase=").append(claseDescripcion()).append(" (" + this.clase + ")");

        sb.append("\nArmas:");
        if (this.listaArmas == null || this.listaArmas.isEmpty()) {
            sb.append(" []");
        } else {
            for (Arma a : this.listaArmas) {
                sb.append("\n  - ").append(a == null ? "null" : a.toString());
            }
        }

        sb.append("\n}");
        return sb.toString();
    }

    // Método para comparar dos objetos Personaje basándose en su vida.
    // Implementa una lógica similar a la interfaz Comparable (aunque no la
    // implementa explícitamente aquí).
    public int compareTo(Personaje p) { // 'p' es una variable local al método.
        if (this.vida > p.vida) // Compara la vida del objeto actual con la vida del objeto 'p'.
            return 1; // Retorna 1 si el objeto actual tiene más vida.
        else if (this.vida < p.vida)
            return -1; // Retorna -1 si el objeto actual tiene menos vida.
        else
            return 0; // Retorna 0 si tienen la misma vida.
    }

}
