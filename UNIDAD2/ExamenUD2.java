package UNIDAD2;

import java.util.Scanner;

/**
 * Realizar un programa en java que haga los siguientes cálculos.
 * 
 * Leerá un conjunto de n videojuegos de teclado, con los siguientes datos:
 * 
 * Nombre
 * Precio
 * Categoría (Aventura, plataformas, Terror, Shooter)
 * Stock
 * Plataforma (switch, xbox, playstation, pc)
 * Puntuación (entre 1 y 10)
 * 
 * El usuario introducirá primero la cantidad de videojuegos que va a introducir
 * por teclado.
 * 
 * Y con dichos datos comprobará los siguiente una vez leídos todos los datos:
 * 
 * 
 * La media de precio y el nombre del videojuego más caro y más barato.
 * 
 * Mostrar el nombre de los juegos de switch que sean de categoría aventura o
 * aquellos cuya puntuación sea superior a 9 y cuesten mas de 39 euros
 * 
 * Mostrará el Stock total de los juegos de playstation
 * 
 * Según se leen los datos se comprobará que los valores de categoría y
 * plataforma están dentro de los valores posibles entre paréntesis, sino se le
 * seguirá pidiendo dicho dato hasta que introduzca un valor correcto.
 * 
 * Cuando el nombre un producto empieze por z y tenga stock inferior a 10 y
 * puntuación superior a 6, guardará su nombre en un array y mostrará al final
 * la lista de productos sin stock a pedir de nuevo.
 * 
 * La correcta lectura y cada uno de los apartados tienen valores iguales, se
 * utilizará la rúbrica de classroom para valorar el exámen.
 * 
 */
public class ExamenUD2 {
    public static void main(String[] args) {

        int numVideojuegos = 0;
        Scanner teclado = new Scanner(System.in);
        // Comentarios generales: este programa lee "numVideojuegos" registros
        // desde teclado. Para cada videojuego valida algunos campos usando
        // bucles do-while (garantizan al menos una lectura) y acumula valores
        // para calcular medias, máximos y mínimos. Al final muestra resultados
        // y una lista filtrada de nombres que empiezan por 'z'.
        String nombre = "";
        double precio = 0, sumaPrecio = 0;
        String categoria = "";
        int stock = 0, sumaStockPlay = 0;
        String plataforma = "";
        byte puntuacion = 0;
        double maxPrecio = Integer.MIN_VALUE, minPrecio = Integer.MAX_VALUE;
        String nombreMax = "", nombreMin = "";
        String videojuegosCond = "";
        String listaNombresZ[];

        // Leemos de teclado la cantidad de videojuegos
        // Nota: sería buena idea validar que numVideojuegos>0 aquí para evitar
        // divisiones por cero más adelante al calcular la media.
        System.out.print("Cuantos Videojuegos quieres tratar:");
        numVideojuegos = teclado.nextInt();
        teclado.nextLine();
        // Creamos el array con espacio para numVideojuegos
        listaNombresZ = new String[numVideojuegos];

        // Para cada videojuego
        // Bucle for: se usa cuando conocemos el número de iteraciones
        // (numVideojuegos). Itera desde i=0 hasta i=numVideojuegos-1 y
        // procesa cada entrada.
        for (int i = 0; i < numVideojuegos; i++) {

            System.out.println("Introduce los datos del Juego numero " + (i + 1));
            System.out.print("Nombre: ");
            nombre = teclado.nextLine().toLowerCase();

            System.out.print("Precio: ");
            precio = teclado.nextDouble();
            System.out.print("Stock: ");
            stock = teclado.nextInt();

            // Mientras la plataforma no sea una de las validas le seguiemos preguntando de
            // nuevo
            // Validación con do-while: garantiza que el usuario introduzca una
            // plataforma válida. El cuerpo se ejecuta al menos una vez y se
            // repite hasta que la condición de salida sea verdadera.
            do {
                System.out.print("Plataforma: ");
                // Lo leemos y lo pasamos a minuscula
                plataforma = teclado.next().toLowerCase();
            } while (!plataforma.equals("switch") && !plataforma.equals("xbox") && !plataforma.equals("playstation")
                    && !plataforma.equals("pc"));

            // Validación de categoría: se asegura que el valor esté dentro de
            // las opciones permitidas antes de continuar.
            do {
                System.out.print("Categoría: ");
                // Lo leemos y lo pasamos a minuscula
                categoria = teclado.next().toLowerCase();
            } while (!categoria.equals("aventura") && !categoria.equals("plataformas") && !categoria.equals("terror")
                    && !categoria.equals("shooter"));

            // Validación de puntuación: obliga a que la puntuación esté en el
            // rango [1,10]. Si el usuario introduce un valor fuera de rango se
            // le pedirá de nuevo.
            do {
                System.out.println("Puntuación: ");
                puntuacion = teclado.nextByte();
            } while (puntuacion < 1 || puntuacion > 10);
            // Consumir el salto de línea restante tras nextByte/nextInt
            teclado.nextLine();

            // La media de precio y el nombre del videojuego más caro y más barato.
            // Actualización de máximos y mínimos: comparaciones simples dentro
            // del bucle. Se guarda también el nombre asociado al extremo.
            if (precio > maxPrecio) {
                maxPrecio = precio;
                // Cada vez que haya un nuevo maximo guardamos su nombre
                nombreMax = nombre;
            }

            if (precio < minPrecio) {
                minPrecio = precio;
                // Cada vez que haya un nuevo minimo guardamos su nombre
                nombreMin = nombre;
            }

            // Acumulador para la media
            sumaPrecio = sumaPrecio + precio;

            // Mostrar el nombre de los juegos de switch que sean de categoría aventura o
            // aquellos cuya puntuación sea superior a 9 y cuesten mas de 39 euros
            // Condición compuesta: atención a la prioridad de operadores. La
            // condición actual requiere que la plataforma sea 'switch' Y (que la
            // categoría sea 'aventura' O que (puntuación>9 Y precio>39)). Si la
            // intención fuera distinta (por ejemplo, mostrar juegos con
            // puntuación>9 y precio>39 independientemente de la plataforma), se
            // debería reescribir la expresión con paréntesis diferentes.
            if (plataforma.equalsIgnoreCase("switch")
                    && (categoria.equalsIgnoreCase("aventura") || (puntuacion > 9 && precio > 39))) {
                System.out.println("El videojuego " + nombre + " cumple las condiciones");
                videojuegosCond += nombre + " ";
            }

            // Sumamos los stock de playstation
            if (plataforma.equalsIgnoreCase("playstation"))
                sumaStockPlay = sumaStockPlay + stock;

            /*
             * Cuando el nombre un producto empieze por z y tenga stock inferior a 10 y
             * puntuación superior a 6, guardará su nombre en un array y mostrará al final
             * la lista de productos sin stock a pedir de nuevo.
             */

            if (stock < 10 && puntuacion > 6 && nombre.startsWith("z")) {
                // Almacena el nombre en el array listaNombresZ en la misma
                // posición del bucle. Esto deja huecos nulos cuando la
                // condición no se cumple; al imprimir se filtran con una
                // comprobación de null.
                listaNombresZ[i] = nombre;
            }

        }

        // Cálculo de la media: ojo con numVideojuegos == 0 (división por cero).
        // En la versión actual se asume que el usuario introducirá >=1.
        System.out.println("La media del precio es: " + (sumaPrecio / numVideojuegos));
        System.out.println("El nombre del videojuego mas caro es " + nombreMax + " , cuesta " + maxPrecio);
        System.out.println("El nombre del videojuego mas barato es " + nombreMin + " , cuesta " + minPrecio);

        System.out.println("Nombres que empiezan por z");

        for (int i = 0; i < listaNombresZ.length; i++) {
            // Si es nulo no se muestra
            if (listaNombresZ[i] != null)
                System.out.println(listaNombresZ[i]);
        }

        teclado.close();

    }
}
