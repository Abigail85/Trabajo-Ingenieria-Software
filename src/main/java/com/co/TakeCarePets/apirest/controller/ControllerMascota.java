package com.co.TakeCarePets.apirest.controller;




import com.co.TakeCarePets.apirest.models.EntityMascota;
import com.co.TakeCarePets.apirest.services.ServicesMascota;
import com.co.TakeCarePets.apirest.services.ServicesProfile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;




@Api(tags = "Mascota",description = "Metodos para el api mascota")
@RestController
@RequestMapping(value ="/TakeCarePets/mascota")
public class ControllerMascota {

    @Autowired
    ServicesMascota servicesMascota;

    @Autowired
    ServicesProfile servicesProfile;


    @ApiOperation(value = "End point to list Mascota ")
    @GetMapping(path = "/listOfAllMascotas",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listOfAllMascotas(){

        return new ResponseEntity<Object>(servicesMascota.listOfAllMascotas(), HttpStatus.OK) ;


    }

    @ApiOperation(value = "End point insert mascota")
    @PostMapping(path = "/insertMascota",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <EntityMascota> insertMascota(@RequestBody EntityMascota mascota){

        return new ResponseEntity(servicesMascota.insertMascota(mascota),HttpStatus.OK);

    }

    @ApiOperation(value = "End point search mascota")
    @GetMapping(path = "/searchMascota/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchMascota(@PathVariable Long id){

        return new ResponseEntity(servicesMascota.searchMascota(id), HttpStatus.OK) ;

    }
    @ApiOperation(value = "End point search mascota")
    @GetMapping(path = "/searchMascota/{id}/profile",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchMascotaIdProfile(@PathVariable Long id){

        return new ResponseEntity(servicesProfile.searchProfile(id), HttpStatus.OK) ;

    }
    @ApiOperation(value = "End point search mascota por le iD")
    @PatchMapping(value = "/updateMascota",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateMascotaId( @RequestBody EntityMascota mascota){

       return servicesMascota.updateMascota(mascota);

    }
    @ApiOperation(value = "End point delete mascota por le iD")
    @DeleteMapping(value = "/deleteMascota")
    public String deleteEmployeeId( @RequestBody EntityMascota idMascota){

       return servicesMascota.deleteMascota(idMascota);


    }


}
