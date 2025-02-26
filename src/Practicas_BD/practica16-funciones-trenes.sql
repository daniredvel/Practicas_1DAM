select * from TRENES_COMPLETO;

--1
select cod_tren, 'De '||initcap(localidad_inicio)||' a '|| initcap(localidad_fin) recorrido,
       to_char(hora_inicio,'hh24:mi')||'-'||to_char(hora_fin,'hh24:mi') inicio_fin
from TRENES_COMPLETO
where localidad_inicio is not null
order by cod_tren desc;


--2
select cod_tren,
       decode(substr(COD_TREN, 1, 2),
              'RR', 'Regional',
              'RE', 'Regional Express',
              'TA', 'Talgo',
              'AV', 'Ave',
              'ES', 'Estrella'
         ) as tipo_tren,
       to_number(substr(cod_tren,3),'999999') as numero
from TRENES_COMPLETO
order by tipo_tren;



--3
--Primera opción
SELECT cod_tren,descripcion
FROM trenes_completo
where not regexp_like(upper(descripcion),'(TURISTA|LUJO)');

--Segunda opción
SELECT cod_tren,descripcion
FROM trenes_completo
where upper(descripcion) not like '%TURISTA%' AND upper(descripcion) not like '%LUJO%' ;

--4
select cod_tren,dias_paso,
       nvl(regexp_count(dias_paso,',')+1,0) total_dias
from TRENES_COMPLETO
order by total_dias desc,cod_tren;


--5
select cod_tren,dias_paso,
       replace(replace(replace(replace(replace(dias_paso,'L, M, X, '),'J','Jueves'),'V','Viernes'),'S','Sábado'),'D','Domingo')
        otros_dias
from TRENES_COMPLETO
where regexp_like(dias_paso,'L, M, X');


--6
--Hay que tener cuidado porque hay trenes que salen a las 23 y llegan a las 6
--un mal cálculo podría indicar que el tren ha durado 17 horas
--y no 7 horas, que es la realidad
select cod_tren,localidad_inicio,localidad_fin,
       decode(sign(extract(hour from hora_fin - hora_inicio)),
              -1, 24 + extract(hour from hora_fin - hora_inicio),
              1, extract(hour from hora_fin - hora_inicio),
              0,0
         ) "Duración en Horas"
from TRENES_COMPLETO
where localidad_inicio is  not null
ORDER BY 4 desc,1;



