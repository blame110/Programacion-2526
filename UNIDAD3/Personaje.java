package UNIDAD3;

import java.util.ArrayList;

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
    // Constructor por defecto o sin argumentos.
    // Se invoca cuando se crea un objeto sin especificar valores iniciales.
    // Inicializa los atributos con valores predeterminados.

    private ArrayList<Arma> listaArmas;

    /************************
     * CONSTRUCTORES *
     *************************/

    public Personaje() {
        this.nombre = "Generado"; // 'this' se refiere a la instancia actual del objeto.
        this.vida = (int) (Math.random() * 100) + 1; // Asigna una vida aleatoria.
        this.armadura = 100;
        this.creditos = 30;
    }

    // Constructor con argumentos.
    // Permite crear un objeto Personaje con valores específicos para sus atributos.
    // El ámbito de las variables 'nombre', 'vida', 'armadura', 'creditos'
    // (parámetros)
    // es local a este constructor.
    public Personaje(String nombre, int vida, int armadura, int creditos) {
        this.nombre = nombre; // Asigna el valor del parámetro 'nombre' al atributo 'nombre' del objeto.
        this.vida = vida;
        this.armadura = armadura;
        this.creditos = creditos;

    }

    /**********************************************************************************
     * FUNCIONES *
     **********************************************************************************/
    /**
     * Esta funcion recibe un arma y se la intenta asignar al personaje, los magos
     * sólo
     * equipan armas de largo alcance, los francotiradores largo alcance o explosiva
     * si no lleva armadura
     * y los guerreros corto alcance y explosiva si tiene mas de 20 puntos de vida.
     * Sólo puede equipar el arma si no a alcanzado la cantidad de armas máximas
     * 
     * @param arma El arma que quiere equiparse
     * @return exito 1 o fracaso -1 o maxima cantidad -2
     */
    public int cargarArma(Arma arma) {
        return 0;
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

    // Sobrescritura del método toString() de la clase Object.
    // Proporciona una representación en cadena del objeto Personaje,
    // útil para depuración y visualización.
    @Override // Indica que este método sobrescribe un método de la clase padre.
    public String toString() {

        // TODO Auto-generated method stub
        String salida = "*************************************\n";
        salida += "Nombre: " + this.nombre + "\n"; // Accede al atributo 'nombre' del objeto actual.
        salida += " Vida: " + this.vida + "\n";
        salida += " Armadura: " + this.armadura + "\n";
        salida += " Creditos: " + this.creditos + "\n";
        salida += "*************************************";

        return salida; // Devuelve la cadena formateada.

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
