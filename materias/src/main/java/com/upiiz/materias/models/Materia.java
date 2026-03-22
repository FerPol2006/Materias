package com.upiiz.materias.models;

public class Materia {
    private Long id;
    private String nombre;
    private float creditos;

    //Constructor
    public Materia(Long id, String nombre, float creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    //Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }
}

