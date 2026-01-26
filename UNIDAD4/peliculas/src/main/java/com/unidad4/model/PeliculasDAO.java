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

}
