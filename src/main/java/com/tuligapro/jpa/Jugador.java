package com.tuligapro.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "jugador")
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jgd_id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.RESTRICT)
	@JoinColumn(name = "prs_id")
	private Persona prs;

	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.RESTRICT)
	@JoinColumn(name = "ins_id")
	private Inscripcion ins;

	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.RESTRICT)
	@JoinColumn(name = "eqp_id")
	private Equipo eqp;

	@Column(name = "estado")
	private Integer estado;

	@Column(name = "observacion")
	private String observacion;

}