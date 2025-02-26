CREATE MATERIALIZED VIEW partidos_completos AS
SELECT l.nombre equipo_casa, l.ciudad ciudad_casa, p.goles_casa goles_casa,
       v.nombre equipo_fuera, v.ciudad ciudad_fuera, p.goles_fuera goles_fuera,
       p.fecha fecha,
       p.observaciones observaciones, l.estadio estadio, l.aforo aforo
FROM partidos p
JOIN EQUIPOS l ON(p.id_equipo_casa = l.id_equipo)
JOIN EQUIPOS v ON(p.id_equipo_fuera = v.id_equipo);