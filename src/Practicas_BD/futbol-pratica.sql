SELECT e.NOMBRE LOCAL, GOLES_CASA,
CASE
           WHEN goles_casa>goles_fuera THEN 3
           WHEN goles_casa<goles_fuera THEN 0
           ELSE 1
       END puntos_casa ,
    F.nombre visitante,goles_fuera,
           CASE
           WHEN goles_casa<goles_fuera THEN 3
           WHEN goles_casa>goles_fuera THEN 0
           ELSE 1
       END puntos_fuera ,
    to_char(fecha,'dd/mm/yyyy') fecha_partido
FROM EQUIPOS e
JOIN PARTIDOS p ON (id_equipo_casa=e.id_equipo)
JOIN equipos f ON (id_equipo_fuera=f.id_equipo);

--EJERCICIO2
SELECT j.NOMBRE Jugador, e.NOMBRE Equipo, COUNT(*)
FROM JUGADORES j
JOIN EQUIPOS e USING (ID_EQUIPO)
JOIN GOLES g USING (ID_JUGADOR)
GROUP BY j.NOMBRE, e.NOMBRE
ORDER BY COUNT(*) DESC;

--EJERCICIO3
SELECT DESCRIPCION, MINUTO, j.NOMBRE
FROM GOLES
JOIN JUGADORES j USING (ID_JUGADOR)
CROSS JOIN JUGADORES j2
WHERE DESCRIPCION LIKE '%'||j2.NOMBRE||'%'

--EJERCICIO4
SELECT NOMBRE
FROM JUGADORES j
WHERE ID_EQUIPO IN (
    SELECT ID_EQUIPO
    FROM JUGADORES j
    JOIN EQUIPOS e USING (ID_EQUIPO)
    WHERE e.NOMBRE = 'Tornado F.C.'
    )

