package com.unidad4;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.unidad4.model.ActorDAO;

public class EjemplosDAO {
    public static void main(String[] args) {

        ActorDAO actordb = new ActorDAO();

        ResultSet rs = actordb.cargarPorId(2);

        try {
            // Recorremos el resultset y mostramos los datos
            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id"));
                System.out.println("nombre:" + rs.getString("nombre"));
                System.out.println("nacionalidad:" + rs.getString("nacionalidad"));
                System.out.println("Fecha Nacimiento:" + rs.getDate("fec_nac").toString());
                System.out.println("-----------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Map<String, Object>> listaDatos = actordb.cargarListaTodos();

        try {
            // Recorremos el resultset y mostramos los datos
            for (Map<String, Object> dato : listaDatos) {
                System.out.println("id:" + dato.get("id"));
                System.out.println("nombre:" + dato.get("nombre"));
                System.out.println("nacionalidad:" + dato.get("nacionalidad"));
                System.out.println("Fecha Nacimiento:" + dato.get("fec_nac").toString());
                System.out.println("-----------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
