package com.tuligapro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuligapro.jpa.Partido;

public interface IPartidoRepo extends JpaRepository<Partido, Integer> {

}
