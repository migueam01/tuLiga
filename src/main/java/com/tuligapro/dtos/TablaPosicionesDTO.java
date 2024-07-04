package com.tuligapro.dtos;

import java.io.Serializable;

public class TablaPosicionesDTO implements Serializable {
    private String equipo;
    private int puntos;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesMarcados;
    private int golesRecibidos;
    private int golDiferencia;

    public TablaPosicionesDTO() {
    }

    public TablaPosicionesDTO(String equipo, int puntos, int partidosJugados, int partidosGanados, int partidosEmpatados,
                              int partidosPerdidos, int golesMarcados, int golesRecibidos, int golDiferencia) {
        this.equipo = equipo;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosEmpatados = partidosEmpatados;
        this.partidosPerdidos = partidosPerdidos;
        this.golesMarcados = golesMarcados;
        this.golesRecibidos = golesRecibidos;
        this.golDiferencia = golDiferencia;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getGolesMarcados() {
        return golesMarcados;
    }

    public void setGolesMarcados(int golesMarcados) {
        this.golesMarcados = golesMarcados;
    }

    public int getGolesRecibidos() {
        return golesRecibidos;
    }

    public void setGolesRecibidos(int golesRecibidos) {
        this.golesRecibidos = golesRecibidos;
    }

    public int getGolDiferencia() {
        return golDiferencia;
    }

    public void setGolDiferencia(int golDiferencia) {
        this.golDiferencia = golDiferencia;
    }
}
