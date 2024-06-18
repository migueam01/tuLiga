package com.tuligapro.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
public class PartidoDto implements Serializable {

	private Integer id;
	private EquipoDto equipoA;
	private EquipoDto equipoB;
	private EquipoDto equipoVocal;
	private Instant fechaHora;
	private String observacion;
	private Integer estado;
	private Instant createOn;
	private String createBy;
}