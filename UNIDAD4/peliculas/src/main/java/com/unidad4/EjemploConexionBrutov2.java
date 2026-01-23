package com.unidad4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import io.github.cdimascio.dotenv.Dotenv;

import com.unidad4.model.PeliculasDAO;
import com.unidad4.utils.Db;

public class EjemploConexionBrutov2 {
    public static void main(String[] args) {

        // Creamos el objeto para acceder a la entidad peliculas de bd
        PeliculasDAO BDPeliculas = new PeliculasDAO();

        // Sacamos todas las peliculas de BD
        ResultSet rs = BDPeliculas.getPeliculas();

        try {
            // Recorremos el resultset y mostramos los datos
            while (rs.next()) {
                System.out.println("titulo:" + rs.getString("titulo"));
                System.out.println("duracion:" + rs.getString("duracion"));
                System.out.println("clasificacion:" + rs.getInt("clasificacion"));
                System.out.println("sinopsis:" + rs.getString("sinopsis"));
                System.out.println("-----------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
