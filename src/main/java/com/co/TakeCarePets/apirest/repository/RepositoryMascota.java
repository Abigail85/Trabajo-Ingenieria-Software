package com.co.TakeCarePets.apirest.repository;

import com.co.TakeCarePets.apirest.models.EntityMascota;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RepositoryMascota extends JpaRepository <EntityMascota, Long> {



}
