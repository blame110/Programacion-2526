package com.unidad4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import io.github.cdimascio.dotenv.Dotenv;

public class EjemploConexionBruto {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String dbName = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        Connection con = null;
        try {
            // Comprobamos si tenemos el driver de conexion a bd en el proyecto
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Nos conectamos a la bd usando los datos necesarios
            con = DriverManager.getConnection(url, user, password);

            // Creamos la consulta sql
            String query = "select * from pelicula";

            // Creamos la sentencia
            Statement stmt = con.createStatement();

            // Ejecutamos y guardamos los datos en un resultset
            ResultSet rs = stmt.executeQuery(query);

            // Al hacer next sobre los resultados nos posicionamos en el primer
            // elemento/registro
            rs.next();

            // Con rs.getxxx('campo') nos devuelve el valor
            System.out.println("Titulo " + rs.getString("titulo") + " y duracion " + rs.getString("duracion"));

            con.close();

        } catch (ClassNotFoundException ce) {
            System.out.println("No tenemos el driver de conexion a bd instalado");
            ce.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

    }
}
