package com.unidad4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unidad4.utils.Db;

public class CrudDAO {

    public Connection con;
    public String nombreTabla;
    public List<String> campos;

    public CrudDAO() {
        this.con = Db.conectar();
    }

    public ResultSet cargarPorId(Object id) {
        ResultSet rs = null;

        try {
            // Creamos la consulta sql
            String query = "select * from " + nombreTabla + " where id = ?";

            // Creamos la sentencia
            PreparedStatement stmt = this.con.prepareStatement(query);

            stmt.setObject(1, id);

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery();

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;
    }

    public ResultSet cargarTodos() {
        ResultSet rs = null;

        try {
            // Creamos la consulta sql
            String query = "select * from " + nombreTabla;

            // Creamos la sentencia
            PreparedStatement stmt = this.con.prepareStatement(query);

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery();

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;
    }

}
