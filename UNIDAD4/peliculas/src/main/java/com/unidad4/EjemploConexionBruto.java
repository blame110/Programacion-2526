package com.unidad4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EjemploConexionBruto {
    public static void main(String[] args) {

        Connection con = null;
        try {
            // Comprobamos si tenemos el driver de conexion a bd en el proyecto
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Nos conectamos a la bd usando los datos necesarios
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/peliculas_marcadiz", "root", "toor");

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
