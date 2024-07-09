package com.tuligapro.service;

import com.tuligapro.dtos.TablaPosicionesDTO;
import com.tuligapro.jpa.Partido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPartidoService extends ICRUD<Partido> {

	Page<Partido> listarPaginado(Pageable pageable);

	List<TablaPosicionesDTO> listarTablaPosiciones();

	byte[] generarPosiciones();
}
