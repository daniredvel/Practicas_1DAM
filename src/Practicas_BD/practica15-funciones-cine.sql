select * from peliculas_completo;
----1
SELECT
  upper(TITULO)||': crítica de '||substr(NOMBRE_CRITICO,1,1)||'.'||
  APELLIDO_CRITICO||', '||
  to_char(fecha,'fmday dd "de" month "de" yyyy')||', '||
  decode(estrellas,
        1,'*',
        2,'**',
        3,'***',
        4,'****',
        5,'*****'
  ) as reseña
FROM PELICULAS_COMPLETO
ORDER BY LENGTH(TITULO),fecha desc;

----2
SELECT distinct TITULO,DURACION
FROM PELICULAS_COMPLETO
WHERE duracion BETWEEN INTERVAL '1:15' HOUR TO MINUTE AND
    INTERVAL '1:45' HOUR TO MINUTE
ORDER BY titulo;

----3
SELECT INITCAP(titulo) as titulo,
  extract(hour from DURACION)*60+extract(minute from DURACION) as minutos,
  NOMBRE_CRITICO as nombre,
  APELLIDO_CRITICO as apellido,
  to_char(fecha,'dd-mm-yyyy') as fecha
from PELICULAS_COMPLETO
where extract(year from fecha) =2018
order by 2 desc,3,4;

----4
SELECT distinct titulo,paises,lengua
FROM PELICULAS_COMPLETO
WHERE lengua!='Inglés' AND paises like '%Estados Unidos%'
order by titulo;

----5
SELECT DISTINCT TITULO,REGEXP_COUNT(paises,',')+1||' paises' PRODUCCION
FROM PELICULAS_COMPLETO
WHERE REGEXP_COUNT(paises,',')>0
ORDER BY TITULO;

----6

SELECT DISTINCT titulo,paises
FROM PELICULAS_COMPLETO
WHERE (regexp_like(paises,'^[[:alnum:]]+ [[:alnum:]]+') or
    regexp_like(paises,', [[:alnum:]]+ [[:alnum:]]+'))
  and paises not like '%Estados Unidos%'
order by titulo;
