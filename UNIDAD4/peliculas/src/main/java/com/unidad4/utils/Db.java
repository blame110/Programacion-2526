package com.unidad4.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class Db {

    // Constantes de la BD
    public static final int ORDEN_ASC = 0;
    public static final int ORDEN_DESC = 1;

    public static final int CLASIF_MENORES = 1;
    public static final int CLASIF_MAYORES = 2;

    public static Connection conectar() {
        // Al crear el dotenv cargamos todas las variables
        Dotenv dotenv = Dotenv.load();

        // Asigno las variables desde el fichero .env
        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String dbName = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        // Creamos la url de conexion con el formato para mysql
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        Connection con = null;

        try {

            // Comprobamos si tenemos el driver de conexion a bd en el proyecto
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Nos conectamos a la bd usando los datos necesarios
            con = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException ce) {
            System.out.println("No tenemos el driver de conexion a bd instalado");
            ce.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        // Devolvemos la conexion, si no pudo conectarse se queda null
        return con;

    }

    public static Connection conectar(String url, String user, String password) {

        Connection con = null;

        try {

            // Comprobamos si tenemos el driver de conexion a bd en el proyecto
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Nos conectamos a la bd usando los datos necesarios
            con = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException ce) {
            System.out.println("No tenemos el driver de conexion a bd instalado");
            ce.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        // Devolvemos la conexion, si no pudo conectarse se queda null
        return con;

    }
}
