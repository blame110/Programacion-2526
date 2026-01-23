package com.unidad4.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

}
