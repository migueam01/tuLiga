package com.tuligapro.controller;

import java.util.ArrayList;
import java.util.List;

import com.tuligapro.dtos.TablaPosicionesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuligapro.exception.ModeloNotFoundException;
import com.tuligapro.jpa.Partido;
import com.tuligapro.service.IPartidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

	@Autowired
	private IPartidoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Partido>> listarTodo() {
		List<Partido> partidos = service.listarTodo();
		return new ResponseEntity<List<Partido>>(partidos, HttpStatus.OK);
	}

	@GetMapping(value = "/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Partido>> listarPaginado(Pageable pageable) {
		Page<Partido> partidos = service.listarPaginado(pageable);
		return new ResponseEntity<Page<Partido>>(partidos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Partido> listarPorId(@PathVariable("id") Integer idPartido) {
		Partido partido = new Partido();
		partido = service.leerPorId(idPartido);
		if (partido.getId() == null) {
			throw new ModeloNotFoundException("Id no encontrado: " + idPartido);
		}
		return new ResponseEntity<Partido>(partido, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Partido> guardar(@Valid @RequestBody Partido partido) {
		Partido p = service.guardar(partido);
		return new ResponseEntity<Partido>(p, HttpStatus.CREATED);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@Valid @RequestBody Partido p) {
		Partido partidoAnterior = service.leerPorId(p.getId());
		if (partidoAnterior.getId() == null) {
			throw new ModeloNotFoundException("Id no encontrado: " + p.getId());
		} else {
			service.modificar(p);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer idPartido) {
		Partido partido = service.leerPorId(idPartido);
		if (partido.getId() == null) {
			throw new ModeloNotFoundException("Id no encontrado: " + idPartido);
		} else {
			service.eliminar(idPartido);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping(value = "/tabla_posiciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TablaPosicionesDTO>> listarTablaPosiciones() {
		List<TablaPosicionesDTO> tablaPosiciones = new ArrayList<>();
		tablaPosiciones = service.listarTablaPosiciones();
		return new ResponseEntity<List<TablaPosicionesDTO>>(tablaPosiciones, HttpStatus.OK);
	}

	@GetMapping(value = "/generar_posiciones", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte() {
		byte[] data = null;
		data = service.generarPosiciones();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}

}
