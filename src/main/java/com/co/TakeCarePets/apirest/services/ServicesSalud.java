package com.co.TakeCarePets.apirest.services;


import com.co.TakeCarePets.apirest.models.EntitySalud;
import com.co.TakeCarePets.apirest.repository.RepositorySalud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicesSalud {


 @Autowired
 RepositorySalud repositorySalud;



    public List<EntitySalud> listOfAllCondicionesSalud(){
    List<EntitySalud> listCondicionesSalud = repositorySalud.findAll();
    return listCondicionesSalud;
    }


public String insertEnterprise(EntitySalud enterprise){
    try{
        enterprise.setCreatedAtEnterprise(LocalDate.now());
        repositorySalud.save(enterprise);

    }catch (Exception e){
        return "Algo falló, por gavor intente nuevamente";
    }
    return "Empresa creada exitosamente";
}

    public EntitySalud searchEnterpriseId(Long idEnterprise) {
        EntitySalud searchId = repositorySalud.findById(idEnterprise).orElse(null);
        return searchId;

    }


    public String updateEnterprise(EntitySalud enterprise) {

        EntitySalud updateEnterprise = repositorySalud.findById(enterprise.getIdEnterprise()).orElse(null);

        if (enterprise.getNameEnterprise() != null) {
            updateEnterprise.setNameEnterprise(enterprise.getNameEnterprise());
            updateEnterprise.setUpdateAtEnterprise(LocalDate.now());
        } else if (enterprise.getNroDocumentEnterprise() != null) {
            updateEnterprise.setNroDocumentEnterprise(enterprise.getNroDocumentEnterprise());
            updateEnterprise.setUpdateAtEnterprise(LocalDate.now());
        } else if (enterprise.getAddressEnterprise() != null) {
            updateEnterprise.setAddressEnterprise(enterprise.getAddressEnterprise());
            updateEnterprise.setUpdateAtEnterprise(LocalDate.now());
        } else if (enterprise.getPhoneEnterprise() != null) {
            updateEnterprise.setPhoneEnterprise(enterprise.getPhoneEnterprise());
            updateEnterprise.setUpdateAtEnterprise(LocalDate.now());

        }else {
           return  "Algo falló no se pudo realizar la actualizaciòn";
        }
        repositorySalud.save(updateEnterprise);
        return "Se actualizo exitosamente";
    }
    public String deleteEnterprise(Long idEnterprise){
        try {
            repositorySalud.deleteById(idEnterprise);
        }catch (Exception e){
          return "Algo falló, por favor intente nuevamente";

        }
         return "Empresa Eliminada exitosamente";
    }
}
