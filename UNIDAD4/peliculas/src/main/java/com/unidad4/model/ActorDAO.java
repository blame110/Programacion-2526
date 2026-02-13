package com.unidad4.model;

import java.util.Arrays;

public class ActorDAO extends CrudDAO {

    public ActorDAO() {
        // llamamos al constructor de CrudDAO Con super
        // Para conectar a bd
        super();
        this.nombreTabla = "actor";
        this.campos = Arrays.asList("id", "nombre", "nacionalidad", "fec_nac");
    }

}
