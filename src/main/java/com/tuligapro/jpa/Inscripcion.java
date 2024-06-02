package com.tuligapro.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    @Id
    @Column(name = "ins_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "eqp_id", nullable = false)
    private Equipo eqp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "cmp_id", nullable = false)
    private Campeonato cmp;

    @Column(name = "presidente")
    private Integer presidente;

    @Column(name = "vicepresidente")
    private Integer vicepresidente;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "create_on")
    private LocalDate createOn;

    @Column(name = "create_by")
    private String createBy;

}