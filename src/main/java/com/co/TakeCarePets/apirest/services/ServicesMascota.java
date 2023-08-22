package com.co.TakeCarePets.apirest.services;



import com.co.TakeCarePets.apirest.models.EntityMascota;
import com.co.TakeCarePets.apirest.models.EntityProfile;
import com.co.TakeCarePets.apirest.repository.RepositoryMascota;
import com.co.TakeCarePets.apirest.repository.RepositoryProfile;
import com.co.TakeCarePets.apirest.util.Enum_RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicesMascota {


    @Autowired
    RepositoryMascota repositoryMascota;


    @Autowired
    RepositoryProfile repositoryProfile;




@Autowired
ServicesProfile servicesProfile;



    public List<EntityMascota> listOfAllMascotas() {
        List<EntityMascota> listMascota = repositoryMascota.findAll();
        return listMascota;
    }


    public String insertMascota(EntityMascota mascota){

        try{
            mascota.setCreatedAtMascota(LocalDate.now());
            repositoryMascota.save(mascota);
            servicesProfile.insertProfile(mascota);
            EntityProfile profile =servicesProfile.insertProfile(mascota);
            mascota.setIdProfile(profile);

        }catch (Exception e){
            return "Algo falló, por favor intente nuevamente";
        }
        return "mascota creada existosamente";
    }



    public EntityMascota searchMascota(Long idMascota) {
        EntityMascota searchMascotaId;
        if(idMascota != null) {
            searchMascotaId = repositoryMascota.findById(idMascota).orElse(null);
        }else {
           searchMascotaId = searchMascota(null);
        }
        return searchMascotaId;

    }

    public String updateMascota(EntityMascota mascota) {

        EntityMascota updateMascota = repositoryMascota.findById(mascota.getIdMascota()).orElse(null);

        if (mascota.getNameMascota() != null) {
        } else if (mascota.getRaza() != null) {
            updateMascota.setRaza(mascota.getRaza());
        }else {
            return "Algo fallo no se pudo altualizar el empleado";
        }
        repositoryMascota.save(updateMascota);
        return "La mascota " + mascota.getNameMascota() + " se actualizo existosamente";
    }

    public String deleteMascota(EntityMascota idMascota){
        servicesProfile.deleteProfile(idMascota);
        try {
            repositoryMascota.delete(idMascota);

        }catch (Exception e){
            return "El id = " + idMascota +" No existe";
        }

        return "La mascota se elimino exitosamente";

    }



}











