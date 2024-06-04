package com.tuligapro.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {

	T guardar(T t);

	T modificar(T t);

	Optional<T> leerPorId(Integer id);

	List<T> listarTodo();

	void eliminar(Integer id);
}
