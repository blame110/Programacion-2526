package com.unidad4;

import java.util.Scanner;

import com.unidad4.model.CriticoDAO;
import com.unidad4.model.CriticoDO;

/**
 * Se proporciona el código SQL para crear la nueva tabla critico y sus datos
 * iniciales. El programa al ejecutarse mostrará el siguiente menú:
 * Bienvenido a CineManager
 * Gestión de Críticos
 * 1. Añadir crítico
 * 2. Modificar crítico
 * 3. Consultar críticos
 * 4. Eliminar crítico
 * 5. Salir
 * 
 * 
 * Opción (1-5):
 * Si la opción no está entre 1 y 5 se volverá a mostrar el menú. Si se elige 5
 * el programa termina. (Máx. 1 punto – navegación completa de todas las
 * opciones y lectura)
 * 
 * 
 * Opción 1 – Añadir crítico (Máx. 2 puntos)
 * Se pedirán por consola todos los datos de la tabla critico:
 * nombre (texto)
 * medio (texto: nombre del periódico/revista/web donde escribe)
 * anyo_inicio (entero: año en que empezó a ejercer la crítica)
 * Si algún dato tiene formato incorrecto o la inserción falla, no debe terminar
 * la ejecución: se mostrará un mensaje de error y se volverá al menú principal.
 * 
 * 
 * Opción 2 – Modificar crítico (Máx. 2 puntos)
 * Se pedirá el id del crítico. Si existe, se mostrarán sus datos por pantalla.
 * A continuación se pedirá:
 * El nombre del campo a modificar (nombre, medio o anyo_inicio)
 * El nuevo valor
 * Si la operación falla por valor incorrecto, se mostrará el error y se volverá
 * al menú sin cerrar el programa.
 * Opción 3 – Consultar críticos (Máx. 3 puntos)
 * Aparecerá un submenú:
 * 1. Mostrar todos ordenados por nombre (A-Z)
 * 2. Mostrar todos ordenados por año de inicio (mayor a menor)
 * 3. Mostrar críticos por medio
 * 4. Mostrar reseñas de un crítico
 * 5. Mostrar número de críticos de un medio
 * 6. Volver
 * Opción (1-6):
 * Opción 3: se pedirá el nombre del medio (ej: El País) y se mostrarán los
 * críticos de ese medio sin tener en cuenta mayúsculas ni minúsculas. Se
 * devuelve List<CriticoDO>.
 * Opción 4: se pedirá el nombre del crítico y se mostrarán todas las películas
 * que ha reseñado (id, título, duración, clasificación) junto con su
 * puntuación. Si no tiene reseñas o no existe, se mostrará un mensaje
 * informativo.
 * Opción 5: se pedirá un medio y se mostrará el número total de críticos que
 * escriben en dicho medio.
 * 
 * 
 * Opción 4 – Eliminar crítico (Máx. 2 puntos)
 * Se pedirá el id del crítico y se eliminará de la base de datos. Si no existe
 * o la operación falla, se mostrará un mensaje de error y se volverá al menú.
 * Si el crítico tiene reseñas asociadas, la base de datos impedirá eliminarlo
 * por la clave foránea. El programa debe capturar ese error y mostrar un
 * mensaje claro al usuario.
 * 
 * 
 * Notas a tener en cuenta
 * Se valorará la claridad del código y la correcta denominación de variables y
 * métodos.
 * Se exige modularidad: la clase Db ya está dada. El alumno debe crear
 * CriticoDO y CriticoDAO. Cada opción del menú debe utilizar su propio método;
 * los resultados de datos se devuelven como List<CriticoDO>.
 * Se deben usar PreparedStatement para todas las consultas con parámetros.
 * No debe romperse la ejecución ante entradas erróneas ni fallos SQL: siempre
 * se capturan excepciones y se vuelve al menú.
 * 
 */
public class ExamenUD4 {

    private static Scanner teclado;
    private static CriticoDAO criticoDAO;

    public static void main(String[] args) {
        int opcion = -1;
        teclado = new Scanner(System.in);

        criticoDAO = new CriticoDAO();

        do {
            mostrarMenu();
            opcion = leerEntero();

            // Tenemos la opcion elegida
            switch (opcion) {
                case 1:
                    insertarCritico();
                    break;
                case 3:
                    consultarCriticos();
                    break;
            }

        } while (opcion != 5);

    }

    public static int leerEntero() {

        int numero = -1;
        try {
            numero = Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException nfe) {
            System.out.println("No se introdujo un número");
        }

        return numero;
    }

    public static void mostrarMenu() {
        System.out.println("\n\n Gestión de Críticos \r\n" + //
                "1. Añadir crítico\r\n" + //
                "2. Modificar crítico\r\n" + //
                "3. Consultar críticos\r\n" + //
                "4. Eliminar crítico\r\n" + //
                "5. Salir\n\n" +
                "Elige una Opcion (1-5):");
    }

    /**
     * Si se selecciona insertar critico tenemos
     * que leer todos los datos de un critico y insertarlo en bd
     * Se pedirán por consola todos los datos de la tabla critico:
     * nombre (texto)
     * medio (texto: nombre del periódico/revista/web donde escribe)
     * anyo_inicio (entero: año en que empezó a ejercer la crítica)
     * Si algún dato tiene formato incorrecto o la inserción falla, no debe terminar
     * la ejecución: se mostrará un mensaje de error y se volverá al menú principal.
     */
    public static void insertarCritico() {

        // Creamos un criticoDO
        CriticoDO criticoDO = new CriticoDO();
        System.out.println("Introduce el nombre:");
        criticoDO.setNombre(teclado.nextLine());
        System.out.println("Introduce el medio:");
        criticoDO.setMedio(teclado.nextLine());
        criticoDO.setAnyoInicio(leerEntero());
        // Una vez cargado el criticoDO
        criticoDAO.crearCritico(criticoDO);

    }

    public static void consultarCriticos() {

        int opcion = -1;
        do {
            System.out.println("1. Mostrar todos ordenados por nombre (A-Z)\r\n" + //
                    "2. Mostrar todos ordenados por año de inicio (mayor a menor)\r\n" + //
                    "3. Mostrar críticos por medio\r\n" + //
                    "4. Mostrar reseñas de un crítico\r\n" + //
                    "5. Mostrar número de críticos de un medio\r\n" + //
                    "6. Volver\r\n" + //
                    "Opción (1-6):");

            opcion = leerEntero();

            // Tenemos la opcion elegida
            switch (opcion) {
                case 4:
                    consultarResenas();
                case 3:
                    numeroCriticosMedio();
            }

        } while (opcion != 6);

    }

    public static void consultarResenas() {
        String nombreCritico = "";
        System.out.print("Introduce el nombre del critico del cual quieres ver reseñas");
        nombreCritico = teclado.nextLine().trim();

        criticoDAO.mostrarResenasCritico(nombreCritico);
    }

    public static void numeroCriticosMedio() {

        String nombreMedio = "";
        System.out.print("Introduce el nombre del medio para sacar la cantidad de criticos");
        nombreMedio = teclado.nextLine().trim();

        int numeroCriticos = criticoDAO.cantidadCriticosMedio(nombreMedio);
        System.out.println("El número de críticos que escriben en " + nombreMedio + " es: " + numeroCriticos);

    }
}
