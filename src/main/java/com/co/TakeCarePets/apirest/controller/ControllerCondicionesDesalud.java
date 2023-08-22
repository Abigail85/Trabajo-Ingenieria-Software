package com.co.TakeCarePets.apirest.controller;

import com.co.TakeCarePets.apirest.models.EntitySalud;
import com.co.TakeCarePets.apirest.services.ServicesSalud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Api(tags = "salud",description = "Metodos para el api Condisciones de salud")
@RestController
@RequestMapping(value ="/takecarePets/Salus")
public class ControllerCondicionesDesalud {

    @Autowired
    ServicesSalud servicesSalud;

    @ApiOperation(value = "End point to Consult list enterprise create ")
    @GetMapping(path = "/listOfAllEnterprises",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listOfAllEnterprises(){

        return new ResponseEntity<Object>(servicesSalud.listOfAllCondicionesSalud(), HttpStatus.OK) ;
    }

    @ApiOperation(value = "End point permite crear una  enterprise")
    @PostMapping(path = "/insertCondicionSalud",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>insertEnterprise(@RequestBody EntitySalud enterprise){
        return new ResponseEntity<String>(servicesSalud.insertEnterprise(enterprise),HttpStatus.OK);
    }

    @ApiOperation(value = "End point to consult enterprise id")
    @GetMapping(path = "/searchEnterprise/{id}",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity searchEnterprise(@PathVariable Long id){

        return new ResponseEntity(servicesSalud.searchEnterpriseId(id), HttpStatus.OK) ;

    }
    @ApiOperation(value = "End point editar una empresa  por le iD")
    @PutMapping(value = "/updateEnterprise")
    public RedirectView updateEnterprise(@ModelAttribute EntitySalud enterprise, Model model){

        model.addAttribute(enterprise);
        if(servicesSalud.updateEnterprise(enterprise).equals(Boolean.TRUE)){
            return new RedirectView("enterprise");
        }else {
            return new RedirectView("404");
        }

    }
    @ApiOperation(value = "End point delete enterprise por le iD")
    @DeleteMapping(value = "/deleteEnterprise/{id}")
    public String deleteEnterpriseId( @PathVariable Long id){

        return servicesSalud.deleteEnterprise(id);


    }

}
