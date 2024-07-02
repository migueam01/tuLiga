package com.tuligapro.service;

import com.tuligapro.jpa.Partido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPartidoService extends ICRUD<Partido> {

    Page<Partido> listarPaginado(Pageable pageable);

}
