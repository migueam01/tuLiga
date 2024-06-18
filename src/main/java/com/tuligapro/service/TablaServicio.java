package com.tuligapro.service;

import com.tuligapro.dtos.EquipoDto;

import java.util.List;

public interface TablaServicio {

    List<EquipoDto> findTablaPosiciones(int cmpId);
}
