package com.tuligapro.service;

import java.util.List;

public interface ICRUD<T> {

	T guardar(T t);

	T modificar(T t);

	T leerPorId(Integer id);

	List<T> listarTodo();

	void eliminar(Integer id);
}
