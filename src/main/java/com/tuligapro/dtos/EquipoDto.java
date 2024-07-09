package com.tuligapro.dtos;

import java.time.LocalDate;

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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPartidosJugados() {
		return partidosJugados;
	}
	public void setPartidosJugados(Integer partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	public Integer getPartidosGanados() {
		return partidosGanados;
	}
	public void setPartidosGanados(Integer partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	public Integer getPartidosPerdidos() {
		return partidosPerdidos;
	}
	public void setPartidosPerdidos(Integer partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	public Integer getPartidosEmpatados() {
		return partidosEmpatados;
	}
	public void setPartidosEmpatados(Integer partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	public Integer getGolesMarcados() {
		return golesMarcados;
	}
	public void setGolesMarcados(Integer golesMarcados) {
		this.golesMarcados = golesMarcados;
	}
	public Integer getGolesRecibidos() {
		return golesRecibidos;
	}
	public void setGolesRecibidos(Integer golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}
	public Integer getGolesDiferencia() {
		return golesDiferencia;
	}
	public void setGolesDiferencia(Integer golesDiferencia) {
		this.golesDiferencia = golesDiferencia;
	}
	public Integer getTarjetasRoja() {
		return tarjetasRoja;
	}
	public void setTarjetasRoja(Integer tarjetasRoja) {
		this.tarjetasRoja = tarjetasRoja;
	}
	public Integer getTarjetasAmarilla() {
		return tarjetasAmarilla;
	}
	public void setTarjetasAmarilla(Integer tarjetasAmarilla) {
		this.tarjetasAmarilla = tarjetasAmarilla;
	}
	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}
	public void setFechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public LocalDate getCreateOn() {
		return createOn;
	}
	public void setCreateOn(LocalDate createOn) {
		this.createOn = createOn;
	}
	
	

}