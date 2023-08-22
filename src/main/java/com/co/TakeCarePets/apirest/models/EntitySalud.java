package com.co.TakeCarePets.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "Salud")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EntitySalud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSalud", nullable = false)
    private Long idEnterprise;

    @Column(name = "nameEnterprise", nullable = false)
    private String nameEnterprise;

    @Column(name = "nroDocumentEnterprise", nullable = false)
    private String nroDocumentEnterprise;

    @Column(name = "phoneEnterprise", nullable = false)
    private String phoneEnterprise;

    @Column(name = "addressEnterprise", nullable = false)
    private String addressEnterprise;

    @Column(name = "createdAtEnterprise", nullable = true)
    private LocalDate createdAtEnterprise ;

    @Column(name = "updateAtEnterprise", nullable = true)
    private LocalDate updateAtEnterprise ;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idEnterprise")
    private Collection<EntityMascota> employeesCollection;




}