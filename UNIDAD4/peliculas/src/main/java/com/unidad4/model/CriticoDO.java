package com.unidad4.model;

/**
 * Data Object que representa una fila de la tabla "critico".
 */
public class CriticoDO {

    private int id;
    private String nombre;
    private String medio;
    private int anyoInicio;

    // ── Constructor vacío ─────────────────────────────────────────────────────
    public CriticoDO() {
    }

    // ── Constructor completo ──────────────────────────────────────────────────
    public CriticoDO(int id, String nombre, String medio, int anyoInicio) {
        this.id = id;
        this.nombre = nombre;
        this.medio = medio;
        this.anyoInicio = anyoInicio;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String m) {
        this.medio = m;
    }

    public int getAnyoInicio() {
        return anyoInicio;
    }

    public void setAnyoInicio(int a) {
        this.anyoInicio = a;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-25s | %-15s | Desde: %d",
                id, nombre, medio, anyoInicio);
    }
}