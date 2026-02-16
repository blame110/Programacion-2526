package com.unidad4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Object> cargarListaPorId(Object id) {
        ResultSet rs = null;
        Map registro = null;

        try {
            // Creamos la consulta sql
            String query = "select * from " + nombreTabla + " where id = ?";

            // Creamos la sentencia
            PreparedStatement stmt = this.con.prepareStatement(query);

            stmt.setObject(1, id);

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery();

            // Ejemplo de crear un único registro, actor
            /*
             * Map actor = new HashMap<String,Object>();
             * actor.put("id",3);
             * actor.put("nombre","Juan José");
             * actor.put("nacionalidad", "Frances");
             * actor.put("fecha_nac",LocalDate.now().minusYears(18));
             */
            registro = new HashMap<String, Object>();
            for (String campo : campos) {
                registro.put(campo, rs.getObject(campo));
            }

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return registro;
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

    public List<Map<String, Object>> cargarListaTodos() {
        ResultSet rs = null;
        List<Map<String, Object>> listaDatos = null;

        try {
            // Creamos la consulta sql
            String query = "select * from " + nombreTabla;

            // Creamos la sentencia
            PreparedStatement stmt = this.con.prepareStatement(query);

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery();

            listaDatos = new ArrayList<Map<String, Object>>();

            // Recorremos todo el resultset
            while (rs.next()) {

                // Cargamos en un map los datos del resultset actual
                // utilizando la lista de campos que tenemos
                Map<String, Object> registro = new HashMap<String, Object>();
                for (String campo : campos) {
                    registro.put(campo, rs.getObject(campo));
                }

                // Añadimos a la lista el registro actual
                listaDatos.add(registro);

            }

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return listaDatos;
    }

}
