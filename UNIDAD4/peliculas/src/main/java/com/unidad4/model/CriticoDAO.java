package com.unidad4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.unidad4.utils.Db;

public class CriticoDAO {

    private Connection con;

    public CriticoDAO() {
        // Conectamos a la BD cuando creamos el objeto
        // CriticoDAO
        con = Db.conectar();
    }

    public int crearCritico(CriticoDO critico) {

        int columnasModificadas = -1;
        try {
            String query = "insert into critico (nombre,medio,anyo_inicio) values (?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, critico.getNombre());
            stmt.setString(2, critico.getMedio());
            stmt.setInt(3, critico.getAnyoInicio());

            // Ejecutamos y guardamos los datos en un resultset
            columnasModificadas = stmt.executeUpdate();

        } catch (SQLException se) {
            System.out.println("Hubo un problema con la BD");
            se.printStackTrace();
        }
        return columnasModificadas;
    }

    public void mostrarResenasCritico(String nombreCritico) {

        try {

            // Guardo la query en un string una vez se que funciona
            String query = "SELECT c.nombre as nombre,cp.puntuacion as puntuacion ,p.titulo as titulo\n" + //
                    "FROM critico c\n" + //
                    "inner join critico_has_pelicula cp\n" + //
                    "on c.id = cp.critico_id\n" + //
                    "inner join pelicula p\n" + //
                    "on cp.pelicula_id= p.id\n" + //
                    "where LOWER(c.nombre) = LOWER(?) ";

            // Creo la instruccion a ejecutar con la query utilizando la conexion activa
            PreparedStatement ps = con.prepareStatement(query);
            // Asigno valor a la interrogacion del nombre del critico
            ps.setString(1, nombreCritico);
            // Ejecuto la query
            ResultSet rs = ps.executeQuery();

            // Recorremos el resultset con rs.next que devuelve null si no hay mas y se
            // acaba
            while (rs.next()) {
                String nombreC = rs.getString("nombre");
                String tituloP = rs.getString("titulo");
                int puntuacion = rs.getInt("puntuacion");

                System.out.println(" El critico " + nombreC + " Le ha puesto a la pelicula  "
                        + tituloP + " la puntuacion " + puntuacion);
            }

        } catch (SQLException sqe) {
            System.out.println("Fallo al ejecutar la query " + sqe.getMessage());
        }
    }

    public int cantidadCriticosMedio(String nombreMedio) {

        int cantidadCriticos = -1;
        try {

            // Guardo la query en un string una vez se que funciona
            String query = "SELECT count(*) as cantidad " +
                    " FROM critico c " +
                    "where LOWER(c.medio) = LOWER(?)";

            // Creo la instruccion a ejecutar con la query utilizando la conexion activa
            PreparedStatement ps = con.prepareStatement(query);
            // Asigno valor a la interrogacion del nombre del critico
            ps.setString(1, nombreMedio);
            // Ejecuto la query
            ResultSet rs = ps.executeQuery();

            cantidadCriticos = rs.getInt("cantidad");

        } catch (SQLException sqe) {
            System.out.println("Fallo al ejecutar la query " + sqe.getMessage());
        }

        return cantidadCriticos;
    }

}
