package com.tuligapro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tuligapro.dtos.TablaPosicionesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Partido> listarPaginado(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<TablaPosicionesDTO> listarTablaPosiciones() {
        List<TablaPosicionesDTO> tablaposiciones = new ArrayList<>();
        repo.listarTablaPosiciones().forEach(t -> {
            TablaPosicionesDTO tp = new TablaPosicionesDTO();
            tp.setPosicion(Integer.parseInt(String.valueOf(t[0])));
            tp.setEquipo(String.valueOf(t[1]));
            tp.setPuntos(Integer.parseInt(String.valueOf(t[2])));
            tp.setPartidosJugados(Integer.parseInt(String.valueOf(t[3])));
            tp.setPartidosGanados(Integer.parseInt(String.valueOf(t[4])));
            tp.setPartidosEmpatados(Integer.parseInt(String.valueOf(t[5])));
            tp.setPartidosPerdidos(Integer.parseInt(String.valueOf(t[6])));
            tp.setGolesMarcados(Integer.parseInt(String.valueOf(t[7])));
            tp.setGolesRecibidos(Integer.parseInt(String.valueOf(t[8])));
            tp.setGolDiferencia(Integer.parseInt(String.valueOf(t[9])));
            tablaposiciones.add(tp);
        });
        return tablaposiciones;
    }
}
