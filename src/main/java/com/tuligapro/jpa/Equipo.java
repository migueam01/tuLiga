package com.tuligapro.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "equipo")
public class Equipo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eqp_id", nullable = false)
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fecha_fundacion")
	private LocalDate fechaFundacion;

	@Column(name = "estado")
	private Integer estado;

	@Column(name = "create_by", length = 64)
	private String createBy;

	@Column(name = "create_on")
	private LocalDate createOn;

}