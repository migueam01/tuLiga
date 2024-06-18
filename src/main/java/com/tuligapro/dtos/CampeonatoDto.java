package com.tuligapro.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CampeonatoDto {

	private Integer id;
	private String descripcion;
	private Integer grupo;
	private Integer categoria;
	private Integer sub;
	private String edicion;
	private LocalDate inicio;
	private LocalDate fin;
	private Integer estado;
	private String createBy;
	private LocalDate createOn;

}