package com.daw.springboot.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Nullable
    private String marca;
    private String modelo;
    private int anio;
    private int potencia;

    public Long getId() {
        return id;
    }

    public int getAnio() {
        return anio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Coche(Long id, String marca, String modelo, int anio, int potencia) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.potencia = potencia;
    }

    public Coche() {

    }

}
