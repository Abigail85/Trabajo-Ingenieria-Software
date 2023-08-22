package com.co.TakeCarePets.apirest.models;


import com.co.TakeCarePets.apirest.util.Enum_RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name = "mascota")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EntityMascota {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idMascota", nullable = false)
    private Long idMascota;

    @Column(name = "nameMascota", nullable = false)
    private String nameMascota;

    @Column(name = "edadMascota", nullable = false)
    private int edadMascota;

    @Column(name = "peso", nullable = false)
    private int peso;

    @Column(name = "raza", nullable = false)
    private String raza;

    @Column(name = "tipo_mascota")
    Enum_RoleName tipo_mascota;

    @Column(name = "createdAtMascota", nullable = true)
    private LocalDate createdAtMascota;

    @Column(name = "updateAtMascota")
    private LocalDate updateAtMascota;


    @ManyToOne(optional = false)
    @JoinColumn(name = "idSalud", referencedColumnName = "idSalud")
    private EntitySalud idSalud;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idMascota")
    private EntityProfile idProfile;
}



