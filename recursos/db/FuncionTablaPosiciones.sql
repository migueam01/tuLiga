CREATE OR REPLACE FUNCTION fn_tabla_posiciones()
RETURNS TABLE (
	equipo_fn varchar,
	puntos_fn INT,
	partidos_jugados_fn INT,
	partidos_ganados_fn INT,
	partidos_empatados_fn INT,
	partidos_perdidos_fn INT,
	goles_marcados_fn INT,
	goles_recibidos_fn INT,
	gol_diferencia_fn INT
)
AS $$
BEGIN
	RETURN query
	SELECT equipo, SUM ( puntos )::int puntos, COUNT ( partido )::int partidos_jugados, SUM ( pg )::int partidos_ganados,
	SUM ( pe )::int partidos_empatados, SUM ( pp )::int partidos_perdidos, SUM ( gol_a )::int goles_marcados, SUM ( gol_b )::int goles_recibidos,
	SUM ( gol_a - gol_b)::int gol_diferencia FROM((SELECT cmp.descripcion campeonato, prt.prt_id partido, prt.fecha_hora fecha, 
	eqa.nombre equipo, prt.puntos_a puntos, prt.gol_a gol_a, prt.gol_b gol_b, CASE WHEN sum(prt.gol_a - prt.gol_b)>0 THEN 1 ELSE 0 END pg, 
	CASE WHEN sum(prt.gol_a - prt.gol_b)=0 THEN 1 ELSE 0 END pe, CASE WHEN sum(prt.gol_a - prt.gol_b)<0 THEN 1 ELSE 0 END pp 
	FROM partido prt INNER JOIN inscripcion insa ON insa.ins_id = prt.eqp_a INNER JOIN inscripcion insb ON insb.ins_id = prt.eqp_b 
	LEFT JOIN inscripcion insv ON insv.ins_id = prt.eqp_v INNER JOIN equipo eqa ON eqa.eqp_id = insa.eqp_id 
	INNER JOIN equipo eqb ON eqb.eqp_id = insb.eqp_id LEFT JOIN equipo eqv ON eqv.eqp_id = insv.eqp_id 
	INNER JOIN campeonato cmp ON cmp.cmp_id = insa.cmp_id AND cmp.cmp_id = insb.cmp_id 
	GROUP BY campeonato, partido, fecha, equipo, puntos, gol_a, gol_b ORDER BY 3 DESC) 
	UNION (SELECT cmp.descripcion campeonato, prt.prt_id partido, prt.fecha_hora fecha, eqb.nombre equipo, prt.puntos_b puntos, 
	prt.gol_b gol_b, prt.gol_a gol_a, CASE WHEN sum(prt.gol_b - prt.gol_a)>0 THEN 1 ELSE 0 END pg, 
	CASE WHEN sum(prt.gol_b - prt.gol_a)=0 THEN 1 ELSE 0 END pe, 
	CASE WHEN sum(prt.gol_b - prt.gol_a)<0 THEN 1 ELSE 0 END pp FROM partido prt INNER JOIN inscripcion insa ON insa.ins_id = prt.eqp_a 
	INNER JOIN inscripcion insb ON insb.ins_id = prt.eqp_b LEFT JOIN inscripcion insv ON insv.ins_id = prt.eqp_v 
	INNER JOIN equipo eqa ON eqa.eqp_id = insa.eqp_id INNER JOIN equipo eqb ON eqb.eqp_id = insb.eqp_id LEFT JOIN equipo eqv ON eqv.eqp_id = insv.eqp_id 
	INNER JOIN campeonato cmp ON cmp.cmp_id = insa.cmp_id AND cmp.cmp_id = insb.cmp_id GROUP BY campeonato, partido, fecha, equipo, puntos, gol_a, gol_b 
	ORDER BY 3 DESC)) tabla_posiciones GROUP BY equipo ORDER BY puntos DESC, gol_diferencia DESC;
END;

$$ LANGUAGE 'plpgsql';