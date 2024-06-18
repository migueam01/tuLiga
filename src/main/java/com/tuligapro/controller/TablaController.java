package com.tuligapro.controller;

import com.tuligapro.dtos.EquipoDto;
import com.tuligapro.service.TablaServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CONTROLLER -> Conecta el backend con las solicitudes de afuera de los clientes
 */
@RestController
@RequestMapping("/tabla")
public class TablaController {

	private final TablaServicio servicioTabla;

    public TablaController(TablaServicio servicioTabla) {
        this.servicioTabla = servicioTabla;
    }

    @GetMapping
	public List<EquipoDto> listarTabla() {
		return servicioTabla.findTablaPosiciones(1);
	}

}
