package com.unidad4.model;

import java.time.LocalDate;

public class ActorDO {

    private int id;
    private String nombre;
    private String nacionalidad;
    private LocalDate fec_nac;

    public LocalDate getFec_nac() {
        return fec_nac;
    }

    public int getId() {
        return id;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFec_nac(LocalDate fec_nac) {
        this.fec_nac = fec_nac;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
