package com.tuligapro.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @Column(name = "rol_id", nullable = false)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Short estado;

}