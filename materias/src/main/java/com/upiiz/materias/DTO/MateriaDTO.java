package com.upiiz.materias.DTO;

//Data transfer Object (DTO)
public class MateriaDTO {
    private String nombre;
    private float creditos;

    public MateriaDTO(){}


    //Constructor
    public MateriaDTO(String nombre, float creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    //Getters y setters
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
