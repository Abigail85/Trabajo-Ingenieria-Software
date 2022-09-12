package com.co.lineadevida.apirest.repository;

import com.co.lineadevida.apirest.models.EntityEnterprise;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface RepositoryEnterprise extends JpaRepository <EntityEnterprise, Long> {
    //List<EntityEnterprise> findEntityEnterpriseBy(Long idEnterprise);


}
