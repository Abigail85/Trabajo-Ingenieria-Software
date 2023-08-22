package com.co.TakeCarePets.apirest.repository;


import com.co.TakeCarePets.apirest.models.EntitySalud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySalud extends JpaRepository<EntitySalud, Long> {
    //List<EntityEnterprise> findEntityEnterpriseBy(Long idEnterprise);


}
