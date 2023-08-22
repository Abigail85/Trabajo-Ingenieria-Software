package com.co.TakeCarePets.apirest.controller;

import com.co.TakeCarePets.apirest.models.EntitySalud;
import com.co.TakeCarePets.apirest.services.ServicesSalud;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Enterprise",description = "Metodos para el api empresa")
@RestController
@RequestMapping(value ="/lineadevida/Enterprise")
public class ControllerFrontEndCondicionesDeSalud {

    @Autowired
    ServicesSalud servicesSalud;


    @GetMapping(path = "/listOfAllEnterprises")
    public String listOfAllEnterprises(Model model){
        List<EntitySalud> listEnterprise = servicesSalud.listOfAllCondicionesSalud();
        model.addAttribute("listEnterprise",listEnterprise);
        return "enterprise";
    }


    @PostMapping (path = "/insertEnterprise")
    public String  insertEnterprise (Model model){
       model.addAttribute("insertEntreprise",new EntitySalud());
        return "enterprise";
    }

    @GetMapping(path = "/searchEnterprise/{id}",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity searchEnterprise(@PathVariable Long id){

        return new ResponseEntity(servicesSalud.searchEnterpriseId(id), HttpStatus.OK) ;

    }

    @GetMapping(value = "/updateEnterprise")
    public String updateEnterpriseId(Model model,@PathVariable("id") EntitySalud enterprise){
        String pTemp = servicesSalud.updateEnterprise(enterprise);
        model.addAttribute("updateEnterpriseId",pTemp);
        return "enterprise";

    }

    @DeleteMapping(value = "/deleteEnterprise/{id}")
    public String deleteEnterpriseId( @PathVariable Long id){

        return servicesSalud.deleteEnterprise(id);


    }

}
