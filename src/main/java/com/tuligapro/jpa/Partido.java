package com.tuligapro.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "partido")
public class Partido {
    @Id
    @Column(name = "prt_id", nullable = false)
    private Integer id;

    @Column(name = "eqp_a")
    private Integer eqpA;

    @Column(name = "eqp_b")
    private Integer eqpB;

    @Column(name = "eqp_v")
    private Integer eqpV;

    @Column(name = "gol_a")
    private Integer golA;

    @Column(name = "gol_b")
    private Integer golB;

    @Column(name = "puntos_a")
    private Integer puntosA;

    @Column(name = "puntos_b")
    private Integer puntosB;

    @Column(name = "fecha_hora")
    private Instant fechaHora;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "create_on")
    private Instant createOn;

    @Column(name = "create_by", length = 64)
    private String createBy;

}