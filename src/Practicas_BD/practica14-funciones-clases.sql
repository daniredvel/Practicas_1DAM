--------------------------Ejercicio 1
SELECT 57 FROM DUAL;
--------------------------Ejercicio 2
SELECT SQRT(23) FROM DUAL;
--------------------------Ejercicio 3
SELECT TO_CHAR(SQRT(23),'90D000') FROM DUAL;
--------------------------Ejercicio 4
SELECT nombre, UPPER(SUBSTR(nombre,-3,3))  AS tresLetras
FROM alumnos ORDER BY tresLetras desc;

--------------------------Ejercicio 5
SELECT dni, nombre, apellido1, apellido2, direccion,
  SUBSTR(telefono,1,3) || ' ' || SUBSTR(telefono,4,3) || ' ' || SUBSTR(telefono,7) AS telefono,
  edad, cif
FROM alumnos
ORDER BY 3,4,2;
--------------------------Ejercicio 6
--Primera forma:
SELECT n_curso, ADD_MONTHS(fecha_inicio,1),ADD_MONTHS(fecha_fin,1),cod_curso,dni_profesor
FROM cursos;
--Segunda forma:
SELECT n_curso,
  fecha_inicio + interval '1' month,
  fecha_fin + interval '1' month,
  cod_curso,dni_profesor
FROM cursos;

--------------------------Ejercicio 7
SELECT n_curso, fecha_inicio+INTERVAL '45' MINUTE AS fecha_inicio,
  fecha_fin+INTERVAL '45' MINUTE AS fecha_fin,cod_curso,dni_profesor
FROM cursos;

--------------------------Ejercicio 8
SELECT n_curso, fecha_inicio, fecha_fin, EXTRACT(DAY FROM fecha_fin-fecha_inicio) AS diasDiferencia
FROM cursos;


--------------------------Ejercicio 9
SELECT n_curso, TO_CHAR(fecha_inicio,'fmDay dd "de" Month "de" yyyy, hh12:mi am') as fecha_inicio ,
  TO_CHAR(fecha_fin,'fmDay dd "de" Month "de" yyyy, hh12:mi am') as fecha_fin,
  EXTRACT(DAY from fecha_fin-fecha_inicio) AS diasDiferencia
FROM cursos;

--------------------------Ejercicio 10
SELECT EXTRACT(day FROM last_day(SYSDATE)) dias_este_mes FROM dual;

--------------------------Ejercicio 11
SELECT ABS(SYSDATE-TRUNC(sysdate + interval '1' year,'YEAR')) dias_fin_año
  FROM DUAL;

--------------------------Ejercicio 12
SELECT trunc(SYSDATE-TO_DATE('1/1/2000','DD/MM/YYYY')) dias_desde_2000
  FROM DUAL;


--------------------------Ejercicio 13
--Forma 1:
SELECT nombre,APELLIDO1,APELLIDO2
from ALUMNOS
where substr(apellido1,1,1)='S' and substr(apellido2,1,1)='S';
--Forma 2:
SELECT nombre,APELLIDO1,APELLIDO2
from ALUMNOS
where regexp_like(apellido1,'^S') and regexp_like(apellido2,'^S');
--Forma 3:
SELECT nombre,APELLIDO1,APELLIDO2
from ALUMNOS
where apellido1 LIKE 'S%' AND apellido2 LIKE 'S%'

--------------------------Ejercicio 14
SELECT nombre,APELLIDO1,APELLIDO2
from ALUMNOS
where substr(apellido1,1,1)=substr(apellido2,1,1);

--------------------------Ejercicio 15
SELECT nombre,apellido1,apellido2, REPLACE(direccion,' ') AS direccion
FROM alumnos;

--------------------------Ejercicio 16
SELECT n_curso, cod_curso,
  EXTRACT(HOUR FROM fecha_fin)-EXTRACT(HOUR FROM fecha_inicio) AS "Horas Diarias"
FROM cursos;


--------------------------Ejercicio 17
SELECT nombre,apellido1,apellido2,
  nvl(DECODE(SUBSTR(telefono,1,1),'6','Móvil','7','Móvil','9','Fijo'),'Sin Teléfono') AS tipo_telefono
FROM alumnos;

--------------------------Ejercicio 18
--version 1
SELECT nombre,apellido1,apellido2,
    SUBSTR(direccion,1,INSTR(direccion,' ')-1) AS tipo_via,
    SUBSTR(direccion,INSTR(direccion,' '),INSTR(direccion,' ',-1)-INSTR(direccion,' ')+1) AS nombre_via, 
    --Usando los dos INSTR del tipo y el número de la vía, calculamos la anchura
    SUBSTR(direccion,INSTR(direccion,' ',-1)+1) AS numero_via 
    --Seleccionamos la posición del último espacio y recortamos desde ahí
FROM alumnos;

--version 2
SELECT nombre, apellido1, apellido2,
       REGEXP_SUBSTR(direccion,'^[[:alpha:]]+ '),
       REGEXP_REPLACE(REGEXP_REPLACE(direccion,'^[[:alpha:]]+ '),' ([0-9]|s/n)+$'),
       REGEXP_SUBSTR(direccion,' ([0-9]|s/n)+$'),
       direccion
from alumnos;


--------------------------Ejercicio 19
SELECT nombre,apellido1,apellido2,
    DECODE(SUBSTR(direccion,1,INSTR(direccion,' ')-1),'c','Calle','C','Calle',
       SUBSTR(direccion,1,INSTR(direccion,' ')-1))  AS tipo_via,
    SUBSTR(direccion,INSTR(direccion,' '),INSTR(direccion,' ',-1)-INSTR(direccion,' ')+1) AS nombre_via,
    SUBSTR(direccion,INSTR(direccion,' ',-1)+1) AS numero_via
FROM alumnos;

-------------------------Ejercicio 20
--Forma1 (sin expresiones regulares)
SELECT nombre,apellido1,apellido2,
    UPPER(SUBSTR(
        REPLACE(
            TRANSLATE(apellido1,'aeiouAEIOUáéíóúüÁÉÍÓÚÜ','*') --Cambia todas las vocales por un asterisco
            ,'*'), --El REPLACE Elimina el asterisco
        1,3)) --Recogemos los tres primeros caracteres y les ponemos mayúsculas
     ||
    UPPER(SUBSTR(apellido2,1,3)) || UPPER(SUBSTR(nombre,1,1)) --añadirmos las 3 del apellido2 y la primera del nombre
    AS NOMBRE_USUARIO --Alias de esa misma columna
FROM alumnos
ORDER BY NOMBRE_USUARIO;  --Ordena usando el alias

--Forma2 (con expresiones regulares)
SELECT nombre,apellido1,apellido2,
    REGEXP_REPLACE(upper(apellido1),'[AEIOUÁÉÍÓÚÜ]') --Cambia todas las vocales por un asterisco
     ||
    UPPER(SUBSTR(apellido2,1,3)) || UPPER(SUBSTR(nombre,1,1)) --añadirmos las 3 del apellido2 y la primera del nombre
    AS NOMBRE_USUARIO --Alias de esa misma columna
FROM alumnos
ORDER BY NOMBRE_USUARIO;  --Ordena usando el alias

--------------------------Ejercicio 21
SELECT n_curso, fecha_inicio, fecha_fin
FROM  cursos
WHERE TO_CHAR(fecha_inicio,'D')<=3;

--------------------------Ejercicio 22
SELECT
  --La forma de obtener los días de febrero de este año es usar como fecha 1/2 de este año (usamos EXTRACT para obtener el año actual)
	--y después usar LAST_DAY  para obtener como fecha la del último día de febrero
  EXTRACT(DAY FROM LAST_DAY(TO_DATE('1/2/'||(EXTRACT(YEAR FROM SYSDATE)),'dd/mm/yyyy'))) diasFebrero,
  --Si ese día es el 29, decimos Bisiesto
  DECODE(EXTRACT(DAY FROM LAST_DAY(TO_DATE('1/2/'||(EXTRACT(YEAR FROM SYSDATE)),'dd/mm/yyyy'))),29,'Bisiesto','No Bisiesto') EsBisiesto
FROM dual;

--------------------------Ejercicio 23
--Con expresiones regulares es fácil
SELECT nombre,apellido1,APELLIDO2,
  regexp_count(UPPER(nombre||apellido1||apellido2),'[ÁÉÍÓÚ]') as NumeroTildes
FROM alumnos;

--Sin expresiones regulares el truco es quitar las letras con tilde (primero se cambian por un asterisco y luego se quitan con replace)
--Despúes basta con restar el tamaño del texto original menos el tamaño de ese texto sin sus letras con tildes
SELECT nombre,apellido1,apellido2,
      LENGTH(nombre||apellido1||apellido2)-LENGTH(
          REPLACE(
            TRANSLATE(nombre||apellido1||apellido2,'áéíóúüÁÉÍÓÚÜ','*')
          ,'*')
         ) as NumeroTildes
FROM alumnos ;