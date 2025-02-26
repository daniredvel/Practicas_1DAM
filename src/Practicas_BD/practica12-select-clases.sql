--1
SELECT nombre,apellido1,apellido2 FROM alumnos
WHERE edad<25;
--2
SELECT apellido1 || ' ' || apellido2 || ', ' || nombre  as "Nombre Completo"
FROM alumnos
order by apellido1,apellido2,nombre;

--3
SELECT nombre,apellido1,apellido2
FROM ALUMNOS
WHERE telefono IS NULL;

--4
SELECT nombre,apellido1,apellido2
FROM ALUMNOS
WHERE apellido1='Sánchez' AND apellido2='Sánchez';

--5
SELECT nombre,apellido1,apellido2
FROM ALUMNOS
WHERE apellido1=apellido2;

--6
SELECT nombre,apellido1,apellido2,telefono
FROM ALUMNOS
WHERE telefono LIKE '6%' OR telefono LIKE '7%';

--7
SELECT nombre,apellido1,apellido2,telefono,edad
FROM ALUMNOS
WHERE telefono LIKE '%5%5%';

--8
SELECT nombre,apellido1,apellido2,telefono,edad
FROM ALUMNOS
WHERE telefono LIKE '%5%5%' and edad>50;

--9
SELECT nombre,apellido1,apellido2, DIRECCION
FROM ALUMNOS
WHERE direccion LIKE 'c%mayor%' or direccion LIKE 'c%Mayor%'
      or direccion LIKE 'C%mayor%' or direccion LIKE 'C%Mayor%';

--10
SELECT nombre,apellido1,apellido2,EDAD
FROM alumnos
WHERE edad IN (20,35,45);

--11
SELECT nombre,apellido1,apellido2,EDAD
FROM alumnos
WHERE apellidO1 LIKE 'C%' or
      apellido1 LIKE 'H%' OR
      apellido1 LIKE 'S%';

--12
SELECT nombre,apellido1,apellido2,EDAD,EDAD+10
FROM alumnos;

--13
SELECT nombre,apellido1,apellido2
FROM alumnos
WHERE apellido1 BETWEEN 'M' AND 'TZZZ'
ORDER BY 2 DESC;


--14
delete alumnos where telefono is null;
rollback;

--15
ALTER TABLE alumnos ADD email VARCHAR2(100);
UPDATE alumnos SET email=nombre||APELLIDO1||'@academiabosco.es';

--16
ALTER TABLE alumnos ADD CONSTRAINT alumnos_ck1
CHECK(telefono like '6%' or telefono like '7%' or telefono like '9%');



