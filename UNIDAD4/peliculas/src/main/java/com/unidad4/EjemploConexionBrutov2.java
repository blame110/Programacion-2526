package com.unidad4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import io.github.cdimascio.dotenv.Dotenv;

import com.unidad4.model.PeliculasDAO;
import com.unidad4.utils.Db;

public class EjemploConexionBrutov2 {
    public static void main(String[] args) {

        // Creamos el objeto para acceder a la entidad peliculas de bd
        PeliculasDAO BDPeliculas = new PeliculasDAO();

        // Sacamos todas las peliculas de BD
        ResultSet rs = BDPeliculas.getPeliculas(5, 20, "duracion", Db.ORDEN_DESC);

        try {
            // Recorremos el resultset y mostramos los datos
            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id"));
                System.out.println("titulo:" + rs.getString("titulo"));
                System.out.println("duracion:" + rs.getString("duracion"));
                System.out.println("clasificacion:" + rs.getInt("clasificacion"));
                System.out.println("sinopsis:" + rs.getString("sinopsis"));
                System.out.println("-----------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        rs = BDPeliculas.getPeliculasClasificación(Db.CLASIF_MENORES);

        try {

            int cantidad = BDPeliculas.crearPelicula("Spiderman spiderverse", 1, 140, "Rayada total de dimensiones");

            HashMap<String, String> listaCampos = new HashMap<>();

            listaCampos.put("titulo", "Estela en la luna");
            listaCampos.put("duracion", "127");
            listaCampos.put("sinopsis", "Estela se va a la luna");

            // Recorremos el resultset y mostramos los datos

            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id"));
                System.out.println("titulo:" + rs.getString("titulo"));
                System.out.println("duracion:" + rs.getString("duracion"));
                System.out.println("clasificacion:" + rs.getInt("clasificacion"));
                System.out.println("sinopsis:" + rs.getString("sinopsis"));
                System.out.println("-----------------------------------\n");
            }

            cantidad = BDPeliculas.modificarPelicula(17, listaCampos);

            cantidad = BDPeliculas.eliminarPeliculas(15);

            if (cantidad == 1)
                System.out.println("Se borro bien la peli");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
