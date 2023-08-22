package com.co.TakeCarePets.apirest.services;


import com.co.TakeCarePets.apirest.models.EntityMascota;
import com.co.TakeCarePets.apirest.models.EntityProfile;
import com.co.TakeCarePets.apirest.repository.RepositoryProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



@Service

public class ServicesProfile {
private String mensaje;
    @Autowired
    RepositoryProfile repositoryProfile;


    public List<EntityProfile> listOfAllProfile() {
        List<EntityProfile> listProfiles = repositoryProfile.findAll();
        return listProfiles;
    }
    public EntityProfile searchProfile(Long id){
        EntityProfile searchProfile = repositoryProfile.findById(id).orElse(null);
        return searchProfile;
    }

    public EntityProfile insertProfile(EntityMascota mascota) {
         EntityProfile profile = new EntityProfile();
          profile.setCreatedAtProfile(LocalDate.now());
          profile.setIdProfile(mascota.getIdMascota());
          profile.setIdMascota(mascota);
          repositoryProfile.save(profile);
         return profile;
    }
    public EntityProfile updateProfile( EntityProfile profile) {


        EntityProfile updateProfile = repositoryProfile.findById(profile.getIdProfile()).orElse(null);


        if(updateProfile ==  null){
            updateProfile.setMensaje("Algo fallo, intentelo nuevamente");
            }else if (profile.getImageProfile()!=null) {
                updateProfile.setUpdateAtProfile(LocalDate.now());
                repositoryProfile.existsById(profile.getIdProfile());

           } else if (profile.getPhoneProfile() != null) {
                updateProfile.setPhoneProfile(profile.getPhoneProfile());
                repositoryProfile.existsById(profile.getIdProfile());


        }

        repositoryProfile.save(updateProfile);

        return updateProfile;

    }
    public void deleteProfile(EntityMascota idEmployee) {

         EntityProfile entityProfile = new EntityProfile();
         entityProfile.setIdProfile(idEmployee.getIdMascota());
          repositoryProfile.deleteById(entityProfile.getIdProfile());
          //return "Perfil eliminado exitosamente";
    }



}
