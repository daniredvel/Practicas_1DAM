CREATE MATERIALIZED VIEW partidos_completos AS
SELECT l.nombre equipo_casa, l.ciudad ciudad_casa, p.goles_casa goles_casa,
       v.nombre equipo_fuera, v.ciudad ciudad_fuera, p.goles_fuera goles_fuera,
       p.fecha fecha,
       p.observaciones observaciones, l.estadio estadio, l.aforo aforo
FROM partidos p
JOIN EQUIPOS l ON(p.id_equipo_casa = l.id_equipo)
JOIN EQUIPOS v ON(p.id_equipo_fuera = v.id_equipo);
---1
SELECT SYSDATE FROM DUAL;

-----2
SELECT 673 * 134 FROM DUAL;

----3
select EQUIPO_CASA, EQUIPO_FUERA, '('||GOLES_CASA||'-' ||GOLES_FUERA||')'  RESULTADO,
 TO_CHAR(FECHA,'fmdd "de" month "de" yyyy') fecha_partido,
 TO_CHAR(aforo,'9G990') aforo
FROM PARTIDOS_COMPLETOS
ORDER BY FECHA DESC, equipo_casa;

----4
select EQUIPO_CASA, EQUIPO_FUERA, '('||GOLES_CASA||'-' ||GOLES_FUERA||')'  RESULTADO,
 TO_CHAR(FECHA,'fmdd "de" month "de" yyyy') fecha,
 TO_CHAR(aforo,'9G990') aforo
FROM PARTIDOS_COMPLETOS
WHERE EXTRACT(MONTH FROM FECHA)=10;

----5
select EQUIPO_CASA, EQUIPO_FUERA, '('||GOLES_CASA||'-' ||GOLES_FUERA||')'  RESULTADO,
 TO_CHAR(FECHA,'fmdd "de" month "de" yyyy') fecha,
 TO_CHAR(aforo,'9G990') aforo
FROM PARTIDOS_COMPLETOS
WHERE TO_CHAR(fecha,'fmday')='domingo';

-----6
SELECT DISTINCT ESTADIO
FROM PARTIDOS_COMPLETOS;


----7
SELECT equipo_casa, to_char(fecha,'DD/MM/YYYY') fecha,
       UPPER(SUBSTR(EQUIPO_CASA,1,3))||UPPER(SUBSTR(EQUIPO_CASA,-3))
              ||TO_CHAR(FECHA,'fmDDMONTH') CLAVE
FROM  PARTIDOS_COMPLETOS
ORDER BY FECHA, equipo_casa

----8
SELECT DISTINCT EQUIPO_CASA,CIUDAD_CASA
FROM PARTIDOS_COMPLETOS
WHERE SUBSTR(CIUDAD_CASA,1,1)=SUBSTR(EQUIPO_CASA,1,1);

----9
SELECT DISTINCT EQUIPO_CASA
FROM PARTIDOS_COMPLETOS
WHERE SUBSTR(UPPER(EQUIPO_CASA),1,1)=SUBSTR(UPPER(EQUIPO_CASA),LENGTH(EQUIPO_CASA));

----10
SELECT DISTINCT EQUIPO_CASA
FROM PARTIDOS_COMPLETOS
WHERE UPPER(EQUIPO_CASA) LIKE SUBSTR(UPPER(EQUIPO_CASA),1,1)||'%'||SUBSTR(UPPER(EQUIPO_CASA),1,1)||'%';

-----11
SELECT fecha, equipo_casa, equipo_fuera, NVL(observaciones,'(Sin observaciones)') observaciones
FROM PARTIDOS_COMPLETOS;

---12
SELECT NOMBRE, FECHA_NAC
FROM JUGADORES
WHERE FECHA_NAC = LAST_DAY(FECHA_NAC);

