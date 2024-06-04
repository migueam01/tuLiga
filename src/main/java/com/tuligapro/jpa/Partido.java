package com.tuligapro.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "partido")
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEqpA() {
		return eqpA;
	}

	public void setEqpA(Integer eqpA) {
		this.eqpA = eqpA;
	}

	public Integer getEqpB() {
		return eqpB;
	}

	public void setEqpB(Integer eqpB) {
		this.eqpB = eqpB;
	}

	public Integer getEqpV() {
		return eqpV;
	}

	public void setEqpV(Integer eqpV) {
		this.eqpV = eqpV;
	}

	public Integer getGolA() {
		return golA;
	}

	public void setGolA(Integer golA) {
		this.golA = golA;
	}

	public Integer getGolB() {
		return golB;
	}

	public void setGolB(Integer golB) {
		this.golB = golB;
	}

	public Integer getPuntosA() {
		return puntosA;
	}

	public void setPuntosA(Integer puntosA) {
		this.puntosA = puntosA;
	}

	public Integer getPuntosB() {
		return puntosB;
	}

	public void setPuntosB(Integer puntosB) {
		this.puntosB = puntosB;
	}

	public Instant getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Instant fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Instant getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Instant createOn) {
		this.createOn = createOn;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

}