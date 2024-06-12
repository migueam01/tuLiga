package com.tuligapro.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prs_id", nullable = false)
	private Integer id;

	@Column(name = "identificacion")
	private String identificacion;

	@Column(name = "primer_apellido")
	private String primerApellido;

	@Column(name = "segundo_apellido")
	private String segundoApellido;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "sexo")
	private Short sexo;

	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;

	@Column(name = "email")
	private String email;

	@Column(name = "telefono_movil")
	private String telefonoMovil;

	@Column(name = "telefono_fijo")
	private String telefonoFijo;

	@Column(name = "estado")
	private Short estado;

	@Column(name = "create_on")
	private Instant createOn;

	@Column(name = "create_by")
	private String createBy;

}