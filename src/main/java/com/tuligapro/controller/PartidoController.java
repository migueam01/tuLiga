package com.tuligapro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuligapro.jpa.Partido;
import com.tuligapro.service.IPartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

	@Autowired
	private IPartidoService service;

	@GetMapping
	public List<Partido> listarTodo() {
		return service.listarTodo();
	}

	@GetMapping("/{id}")
	public Optional<Partido> listarPorId(@PathVariable("id") Integer idPartido) {
		return service.leerPorId(idPartido);
	}

	@PostMapping
	public Partido guardar(@RequestBody Partido p) {
		return service.guardar(p);
	}

	@PutMapping
	public Partido modificar(@RequestBody Partido p) {
		return service.guardar(p);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer idPartido) {
		service.eliminar(idPartido);
	}

}
