package com.unidad4.model;

public class CineDO {

    private int id;
    private String nombre;
    private String direccion;
    private int localidades;

    public int getId() {
        return this.id;
    }

    public void setId(int idRecibido) {
        this.id = idRecibido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidades(int localidades) {
        this.localidades = localidades;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getLocalidades() {
        return localidades;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return " id " + this.id + " nombre: " + this.nombre + " direccion: " + this.direccion + " localidades: "
                + this.localidades;
    }

}