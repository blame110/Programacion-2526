package UNIDAD3;

// Declaración de la clase PruebasObjetos.
// Esta clase contiene el método main, que es el punto de entrada de la aplicación.
public class PruebasObjetos {

    public static void main(String[] args) {

        // Declaración de una variable local 'categoria'.
        // Su ámbito se limita al método main.
        String categoria;

        /**
         * Creación de objetos (instanciación de clases).
         * Para crear un objeto de una clase, se sigue la sintaxis:
         * NombreClase nombreObjeto = new ConstructorClase();
         *
         * El operador 'new' reserva memoria para el nuevo objeto y llama al
         * constructor.
         * En este caso, "fran" es una instancia de la clase Personaje.
         */
        Personaje fran = new Personaje(); // Llama al constructor por defecto de Personaje.

        // Creación de otro objeto Personaje, "maria", utilizando el constructor con
        // argumentos.
        // Se pasan valores específicos para inicializar sus atributos.
        Personaje maria = new Personaje("Maria", 95, 0, 50, Personaje.CORTA_DISTANCIA);

        // Acceso a atributos a través de métodos "getter".
        // Demuestra la encapsulación: no se accede directamente a 'nombre', sino a
        // través de 'getNombre()'.
        System.out.println("Nombre previo " + fran.getNombre());

        // Modificación de atributos a través de métodos "setter".
        // 'setNombre()' permite cambiar el nombre del objeto 'fran' de forma
        // controlada.
        fran.setNombre("Francisco");

        // fran.armadura = 100; // Esto daría un error de compilación si 'armadura' es
        // privado (encapsulación).
        // La línea está comentada para ilustrar la protección del atributo 'armadura'.

        // Ámbito de variables:
        // 'vidaTemp' es una variable local al método main. Su existencia está limitada
        // a este método.
        int vidaTemp = 200;
        fran.setVida(vidaTemp); // Se pasa el valor de 'vidaTemp' al método 'setVida()'.

        System.out.println("Fran tiene " + fran.getVida() + " puntos de vida");

        fran.setVida(304);

        System.out.println("Fran tiene " + fran.getVida() + " puntos de vida");

        // Llamada implícita al método toString().
        // Cuando se imprime un objeto directamente, Java automáticamente llama a su
        // método toString()
        // para obtener una representación en cadena del objeto.
        // Esto es útil para mostrar el estado actual de un objeto.
        System.out.println("Datos de Fran " + fran);

    }
}
