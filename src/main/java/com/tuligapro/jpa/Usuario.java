package com.tuligapro.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "usr_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prs_id")
    private Persona prs;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "nick")
    private String nick;

    @Column(name = "password")
    private String password;

    @Column(name = "estado")
    private Short estado;

}