package com.unidad4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.unidad4.utils.Db;

public class CineDAO {

    private Connection con;

    public CineDAO() {
        this.con = Db.conectar();
    }

    /**
     * Esta función recibe las localidades y va a devolver los cines que tengan mas
     * localidades que
     * las que se reciben como parametro
     * 
     * 
     * @param localidades
     * @return
     */
    public ArrayList<CineDO> cineMasLocalidades(int localidades) {

        String query = "SELECT * FROM cine where localidades > ?";
        ArrayList<CineDO> listaCines = null;

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, localidades);

            ResultSet rs = ps.executeQuery();

            listaCines = new ArrayList<CineDO>();

            // Recorremos los datos de Resultset y los metemos en el arrayList
            // Recorremos el resultset mientras haya datos, es decir mientras next() me
            // devuelva true

            while (rs.next()) {
                // Creamos un cineDO NUEVO para guardar el registro actual
                CineDO cine = new CineDO();
                cine.setId(rs.getInt("id"));
                cine.setNombre(rs.getString("nombre"));
                cine.setDireccion(rs.getString("direccion"));
                cine.setLocalidades(rs.getInt("localidades"));

                // Añadimos el cineDO al arrayList
                listaCines.add(cine);
            }

        } catch (SQLException sq) {
            sq.printStackTrace();
            listaCines = null;
        }
        return listaCines;

    }

}
