package com.tuligapro.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usro_id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usr_id")
	private Usuario usr;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id")
	private Rol rol;

	@Column(name = "estado")
	private String estado;

	@Column(name = "create_on")
	private Instant createOn;

	@Column(name = "create_by")
	private String createBy;

}