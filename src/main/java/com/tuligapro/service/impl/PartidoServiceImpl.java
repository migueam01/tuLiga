package com.tuligapro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuligapro.jpa.Partido;
import com.tuligapro.repo.IPartidoRepo;
import com.tuligapro.service.IPartidoService;

@Service
public class PartidoServiceImpl implements IPartidoService {

	@Autowired
	private IPartidoRepo repo;

	@Override
	public Partido guardar(Partido t) {
		return repo.save(t);
	}

	@Override
	public Partido modificar(Partido t) {
		return repo.save(t);
	}

	@Override
	public Partido leerPorId(Integer id) {
		Optional<Partido> partido = repo.findById(id);
		return partido.isPresent() ? partido.get() : new Partido();
	}

	@Override
	public List<Partido> listarTodo() {
		return repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
