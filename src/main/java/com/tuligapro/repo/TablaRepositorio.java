package com.tuligapro.repo;

import com.tuligapro.dtos.EquipoDto;
import com.tuligapro.repo.excepciones.EquipoException;
import com.tuligapro.repo.excepciones.EquipoNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TablaRepositorio {

    @Autowired
     JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    public List<EquipoDto> listarTablaPosiciones(int campeonatoId) throws EquipoNoEncontradoException, EquipoException {
        List<EquipoDto> retorno = null;
        PreparedStatement pstmt = null;
        Connection con = null;
        ResultSet rs = null;

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append(" equipo, ");
        sql.append(" SUM ( puntos ) puntos, ");
        sql.append(" COUNT ( partido ) partidos_jugados, ");
        sql.append(" SUM ( pg ) partidos_ganados, ");
        sql.append(" SUM ( pe ) partidos_empatados, ");
        sql.append(" SUM ( pp ) partidos_perdidos, ");
        sql.append(" SUM ( gol_a ) goles_marcados, ");
        sql.append(" SUM ( gol_b ) goles_recibidos, ");
        sql.append(" SUM ( gol_a - gol_b) gol_diferencia ");
        sql.append(" FROM ");
        sql.append(" ( ");
        sql.append("  ");
        sql.append(" (SELECT ");
        sql.append(" cmp.descripcion campeonato, ");
        sql.append(" prt.prt_id partido, ");
        sql.append(" prt.fecha_hora fecha, ");
        sql.append(" eqa.nombre equipo, ");
        sql.append(" prt.puntos_a puntos, ");
        sql.append(" prt.gol_a gol_a, ");
        sql.append(" prt.gol_b gol_b, ");
        sql.append(" CASE WHEN sum(prt.gol_a - prt.gol_b)>0 THEN 1 ELSE 0 END pg, ");
        sql.append(" CASE WHEN sum(prt.gol_a - prt.gol_b)=0 THEN 1 ELSE 0 END pe, ");
        sql.append(" CASE WHEN sum(prt.gol_a - prt.gol_b)<0 THEN 1 ELSE 0 END pp ");
        sql.append(" FROM ");
        sql.append(" partido prt ");
        sql.append(" INNER JOIN inscripcion insa ON insa.ins_id = prt.eqp_a ");
        sql.append(" INNER JOIN inscripcion insb ON insb.ins_id = prt.eqp_b ");
        sql.append(" LEFT JOIN inscripcion insv ON insv.ins_id = prt.eqp_v ");
        sql.append(" INNER JOIN equipo eqa ON eqa.eqp_id = insa.eqp_id ");
        sql.append(" INNER JOIN equipo eqb ON eqb.eqp_id = insb.eqp_id ");
        sql.append(" LEFT JOIN equipo eqv ON eqv.eqp_id = insv.eqp_id ");
        sql.append(" INNER JOIN campeonato cmp ON cmp.cmp_id = insa.cmp_id AND cmp.cmp_id = insb.cmp_id  ");
        sql.append(" GROUP BY campeonato, partido, fecha, equipo, puntos, gol_a, gol_b ");
        sql.append(" ORDER BY 3 DESC)  ");
        sql.append("  ");
        sql.append(" UNION ");
        sql.append("  ");
        sql.append(" (SELECT ");
        sql.append(" cmp.descripcion campeonato, ");
        sql.append(" prt.prt_id partido, ");
        sql.append(" prt.fecha_hora fecha, ");
        sql.append(" eqb.nombre equipo, ");
        sql.append(" prt.puntos_b puntos, ");
        sql.append(" prt.gol_b gol_b, ");
        sql.append(" prt.gol_a gol_a, ");
        sql.append(" CASE WHEN sum(prt.gol_b - prt.gol_a)>0 THEN 1 ELSE 0 END pg, ");
        sql.append(" CASE WHEN sum(prt.gol_b - prt.gol_a)=0 THEN 1 ELSE 0 END pe, ");
        sql.append(" CASE WHEN sum(prt.gol_b - prt.gol_a)<0 THEN 1 ELSE 0 END pp ");
        sql.append(" FROM ");
        sql.append(" partido prt ");
        sql.append(" INNER JOIN inscripcion insa ON insa.ins_id = prt.eqp_a ");
        sql.append(" INNER JOIN inscripcion insb ON insb.ins_id = prt.eqp_b ");
        sql.append(" LEFT JOIN inscripcion insv ON insv.ins_id = prt.eqp_v ");
        sql.append(" INNER JOIN equipo eqa ON eqa.eqp_id = insa.eqp_id ");
        sql.append(" INNER JOIN equipo eqb ON eqb.eqp_id = insb.eqp_id ");
        sql.append(" LEFT JOIN equipo eqv ON eqv.eqp_id = insv.eqp_id ");
        sql.append(" INNER JOIN campeonato cmp ON cmp.cmp_id = insa.cmp_id AND cmp.cmp_id = insb.cmp_id  ");
        sql.append(" GROUP BY campeonato, partido, fecha, equipo, puntos, gol_a, gol_b ");
        sql.append(" ORDER BY 3 DESC) ");
        sql.append("  ");
        sql.append(" ) tabla_posiciones  ");
        sql.append(" GROUP BY ");
        sql.append(" equipo ");
        sql.append(" order by 2 desc ");


        try {

            con = dataSource.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();

            retorno = new ArrayList<>();
            while (rs.next()) {
                retorno.add(rsAlistarTablaPosiciones(rs));
            }

        } catch (Exception e) {
            throw new EquipoException("Error de conexión, comuníquese con el administrador del sistema.");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (retorno.isEmpty()) {
            throw new EquipoNoEncontradoException("No se encontró resultados con los parámetros ingresados.");
        }

        return retorno;
    }

    private EquipoDto rsAlistarTablaPosiciones(ResultSet rs) throws SQLException {
        EquipoDto retorno = new EquipoDto();
        retorno.setNombre(rs.getString(1));
        retorno.setPuntos(rs.getInt(2));
        retorno.setPartidosJugados(rs.getInt(3));
        retorno.setPartidosGanados(rs.getInt(4));
        retorno.setPartidosEmpatados(rs.getInt(5));
        retorno.setPartidosPerdidos(rs.getInt(6));
        retorno.setGolesMarcados(rs.getInt(7));
        retorno.setGolesRecibidos(rs.getInt(8));
        retorno.setGolesDiferencia(rs.getInt(9));
        return retorno;
    }

}
