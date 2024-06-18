package com.tuligapro.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EquipoDto {
	private Integer id;
	private String nombre;

	private Integer partidosJugados;
	private Integer partidosGanados;
	private Integer partidosPerdidos;
	private Integer partidosEmpatados;

	private Integer puntos;

	private Integer golesMarcados;
	private Integer golesRecibidos;
	private Integer golesDiferencia;

	private Integer tarjetasRoja;
	private Integer tarjetasAmarilla;

	private LocalDate fechaFundacion;
	private Integer estado;
	private String createBy;
	private LocalDate createOn;

}