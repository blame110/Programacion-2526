package com.unidad4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.unidad4.utils.Db;

public class PeliculasDAO {

    private Connection con;

    public PeliculasDAO() {
        // Cuando creamos el objeto nos conectamos a la bd
        this.con = Db.conectar();
    }

    public ResultSet getPeliculas() {

        ResultSet rs = null;

        try {
            // Creamos la consulta sql
            String query = "select * from pelicula";

            // Creamos la sentencia
            Statement stmt = this.con.createStatement();

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;

    }

    public ResultSet getPeliculasClasificación(int clasificacion) {
        ResultSet rs = null;

        try {
            // Creamos la consulta sql ponemos interrogaciones ? en los sitios donde vamos
            // a introducir datos externos de variables
            String query = "select * from pelicula where clasificacion = ?";

            // Creamos la sentencia
            PreparedStatement stmt = this.con.prepareStatement(query);

            stmt.setInt(1, clasificacion);

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery();

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;

    }

    /**
     * Devuelve numelementos de la pagina selecionada que recibe o null si no hay
     * elementos
     * 
     * @param pagina
     * @param numElementos
     * @return
     */
    public ResultSet getPeliculas(int pagina, int numElementos, String orden, int sentidoOrden) {

        ResultSet rs = null;

        try {
            // El offset es el registro a partir del cual vamos a mostrar elementos
            // si recibo pagina y numElementos la formula seria
            // (pagina-1)*numelementos, asi, la pagina 4 que deberia de mostrar desde el 31
            // al 40
            // seria (4-1)*10=30 y el primer elemento que mostraria seria el 31
            int offset = (pagina - 1) * numElementos;

            // Creamos la consulta sql
            String query = "select * from pelicula";

            // Si tenemos campo a ordenar
            if (orden != null) {
                query += " order by " + orden;
                if (sentidoOrden == Db.ORDEN_DESC)
                    query += " desc ";
            }

            // Al final añadimos la paginacion
            query += " limit " + numElementos + " offset " + offset;

            System.out.println(query);

            // Creamos la sentencia
            Statement stmt = this.con.createStatement();

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery(query);

        } catch (

        Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;

    }

    public int modificarPelicula(int id, HashMap<String, String> campos) {

        int columnasModificadas = -1;

        try {
            String query = "update pelicula set ";

            boolean primerCampo = true;
            for (Map.Entry<String, String> campo : campos.entrySet()) {
                // Si es el primer campo no pongo coma y marco que ya no va a ser el primer
                // Campo para el siguiente campo
                if (primerCampo) {
                    primerCampo = false;
                } else {
                    query += ",";
                }

                query += campo.getKey() + "=?";
            }

            query += " where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);

            int posicion = 1;
            for (Map.Entry<String, String> campo : campos.entrySet()) {

                if (campo.getKey().equals("titulo") || campo.getKey().equals("sinopsis"))
                    stmt.setString(posicion, campo.getValue());
                else
                    stmt.setInt(posicion, Integer.valueOf(campo.getValue()));

                posicion++;
            }

            System.out.println(query);
            stmt.setInt(posicion, id);

            columnasModificadas = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return columnasModificadas;

    }

    public int crearPelicula(String titulo, int clasificacion, int duracion, String sinopsis) {

        int columnasModificadas = -1;
        try {
            String query = "insert into pelicula (titulo,clasificacion,duracion,sinopsis) values (?, ?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, titulo);
            stmt.setInt(2, clasificacion);
            stmt.setInt(3, duracion);
            stmt.setString(4, sinopsis);

            // Ejecutamos y guardamos los datos en un resultset
            columnasModificadas = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
        return columnasModificadas;
    }

    // delete from pelicula where id=?
    /**
     * Funcion que recibe un id de pelicula y borra el registro
     * 
     * @param id
     * @return 1 si pudo borrarla o -1 sino
     */
    public int eliminarPeliculas(int id) {
        int columnasBorradas = -1;
        try {
            String query = "delete from pelicula where id=?";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1, id);
            columnasBorradas = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("hubo un problema al borrar la id " + id);
            e.printStackTrace();
        }

        return columnasBorradas;
    }

}
