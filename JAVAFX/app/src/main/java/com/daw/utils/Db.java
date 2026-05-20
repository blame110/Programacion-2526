package com.daw.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class Db {

    // Carga única del .env al iniciar la clase.
    // Todos los conexiones comparten las mismas credenciales
    private static final Dotenv dotenv = Dotenv.load();

    // Constantes para ordenación ascendente/descendente
    public static final int ORDEN_ASC = 0;
    public static final int ORDEN_DESC = 1;

    // Constantes para filtrar por clasificación
    public static final int CLASIF_MENORES = 1;
    public static final int CLASIF_MAYORES = 2;

    // Lee las credenciales del .env y construye la URL JDBC automáticamente
    public static Connection conectar() {
        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String dbName = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        return conectar(url, user, password);
    }

    // Conexión directa con URL y credenciales explicitas.
    // Usa DriverManager.getConnection que en JDBC 4+ detecta el driver automáticamente
    public static Connection conectar(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
            return null;
        }
    }
}
