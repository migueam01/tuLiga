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
@Table(name = "campeonato")
public class Campeonato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cmp_id", nullable = false)
	private Integer id;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "grupo")
	private Integer grupo;

	@Column(name = "categoria")
	private Integer categoria;

	@Column(name = "sub")
	private Integer sub;

	@Column(name = "edicion")
	private String edicion;

	@Column(name = "inicio")
	private LocalDate inicio;

	@Column(name = "fin")
	private LocalDate fin;

	@Column(name = "estado")
	private Integer estado;

	@Column(name = "create_by")
	private String createBy;

	@Column(name = "create_on")
	private LocalDate createOn;

}