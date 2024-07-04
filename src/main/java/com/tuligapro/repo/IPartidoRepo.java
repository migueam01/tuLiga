package com.tuligapro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuligapro.jpa.Partido;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPartidoRepo extends JpaRepository<Partido, Integer> {
    @Query(value = "SELECT * FROM fn_tabla_posiciones()", nativeQuery = true)
    List<Object[]> listarTablaPosiciones();
}
