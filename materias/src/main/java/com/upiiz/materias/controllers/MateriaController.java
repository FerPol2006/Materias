package com.upiiz.materias.controllers;
import com.upiiz.materias.DTO.MateriaDTO;
import com.upiiz.materias.models.Materia;
import org.springframework.ui.Model;
import com.upiiz.materias.services.MateriaService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    //listar materias
    @GetMapping
    public String listarMaterias(Model model){
        model.addAttribute("materias", materiaService.getListadoMaterias());
        return "listado.html";
    }

    //Eliminar materia
    @GetMapping("/eliminar/{id}")
    public String eliminarMateria(@PathVariable Long id){
        materiaService.eliminarMateria(id);
        return "redirect:/materias";
    }

    //Mostrar el formulario
    @GetMapping("/nueva")
    public String mostrarFormularioCrear(Model model){
        model.addAttribute("materia", new MateriaDTO());
        return "formulario-crear";
    }

    //Mostrar form para actualizar
    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model){
        Optional<Materia> materia = materiaService.getMateriaById(id);
        if (materia.isPresent()){
            model.addAttribute("materia", materia.get());
            return "formulario-actualizar";
        }

        return "redirect:/materias";
    }


    @PostMapping("/actualizar")
    public String actualizarMateria(@ModelAttribute Materia materia){
        MateriaDTO materiaDTO = new MateriaDTO(materia.getNombre(), materia.getCreditos());
        materiaService.modificarMateria(materia.getId(), materiaDTO);
        return "redirect:/materias";
    }


    //Guardar materia por el metodo POST
    @PostMapping
    public String guardarMateria(@ModelAttribute MateriaDTO materiaDTO){
        materiaService.crearMateria(materiaDTO);
        return "redirect:/materias";
    }
}
