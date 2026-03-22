package com.upiiz.materias.services;

import com.upiiz.materias.DTO.MateriaDTO;
import com.upiiz.materias.models.Materia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {
    private List<Materia> listadoMaterias = new ArrayList<Materia>(); //Lista de materias
    private Long contadorId=3L;

    //Constructor
    public MateriaService() {
    listadoMaterias.add(new Materia(1L, "Matemáticas", 7.5f));
    listadoMaterias.add(new Materia(2L, "Química", 7.2f));
    }

    //---CRUD---
    // Leer -- Read
    public List<Materia> getListadoMaterias() {
        return listadoMaterias;
    }

    public Optional<Materia> getMateriaById(Long id) {
        return listadoMaterias.stream().filter(materia -> materia.getId().equals(id)).findFirst();
    }

    //Crear-- Create
    public Materia crearMateria(MateriaDTO materiaDTO) {
        Materia nuevaMateria = new Materia(contadorId, materiaDTO.getNombre(), materiaDTO.getCreditos());
        listadoMaterias.add(nuevaMateria);
        contadorId++;
        return nuevaMateria;
    }

    //Modificar -- Update
    public Optional<Materia> modificarMateria(Long id, MateriaDTO materiaDTO) {
        Optional<Materia> materiaActualizar = getMateriaById(id);
        if (materiaActualizar.isPresent())
        {
            Materia materiaActual = materiaActualizar.get();
            materiaActual.setNombre(materiaDTO.getNombre());
            materiaActual.setCreditos(materiaDTO.getCreditos());
            return Optional.of(materiaActual);
        }

        else {
            return Optional.empty();
        }
    }

    //Eliminar--Delete
    public boolean eliminarMateria(Long id) {
        return listadoMaterias.removeIf(materia -> materia.getId().equals(id));
    }

}
