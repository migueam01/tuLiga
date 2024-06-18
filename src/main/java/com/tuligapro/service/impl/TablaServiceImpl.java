package com.tuligapro.service.impl;

import com.tuligapro.dtos.EquipoDto;
import com.tuligapro.repo.TablaRepositorio;
import com.tuligapro.repo.excepciones.EquipoException;
import com.tuligapro.repo.excepciones.EquipoNoEncontradoException;
import com.tuligapro.service.TablaServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

/**
 * Clase para modificar los resultados obtenidos antes de enviar.
 */
@Service
public class TablaServiceImpl implements TablaServicio {

	private final TablaRepositorio tablaRepositorio;

    public TablaServiceImpl(TablaRepositorio tablaRepositorio) {
        this.tablaRepositorio = tablaRepositorio;
    }

	@Override
	@Transactional(readOnly = true)
	public List<EquipoDto> findTablaPosiciones(int cmpId) {
        try {
			List<EquipoDto> retorno = tablaRepositorio.listarTablaPosiciones(cmpId);
			retorno.stream().sorted(Comparator.comparing(EquipoDto::getPuntos).thenComparing(Comparator.comparing(EquipoDto::getGolesDiferencia).reversed()).reversed());
			return retorno;
        } catch (EquipoNoEncontradoException e) {
            throw new RuntimeException(e);
        } catch (EquipoException e) {
            throw new RuntimeException(e);
        }
    }

}
