package com.co.TakeCarePets.apirest.controller;

import com.co.TakeCarePets.apirest.models.EntitySalud;
import com.co.TakeCarePets.apirest.services.ServicesSalud;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControllerFrontEndMascotas {

    @Autowired
    ServicesSalud servicesSalud;

    @GetMapping(path = "/")
    public String home(){

        return "index";
    }

    @GetMapping (path = "/listaCondicionesDeSalud")
    public String pagina2(Model modelo){

        List<EntitySalud> listCondicionesDeSalud = servicesSalud.listOfAllCondicionesSalud();
        modelo.addAttribute("listaCondicionesDeSalud", listCondicionesDeSalud);

        return "listaCondicionesDeSalud";
    }

    @PostMapping (path = "Salud")
    public String insertMascota (Model modelo){

        modelo.addAttribute("insertMascota", new EntitySalud() );

        return "Salud";

    }

    @GetMapping (path = "/editarMascota/{id}")
    public String editarMascota (Model modelo, @PathVariable("id") Long id){

        EntitySalud pTemp = servicesSalud.searchEnterpriseId(id);
        modelo.addAttribute("Emascota", pTemp );

        return "editarMascota";

    }

}
