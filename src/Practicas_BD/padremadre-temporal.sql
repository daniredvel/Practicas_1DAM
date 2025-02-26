--EJERCICIO5
SELECT m.nombre   madre, COUNT (*)
FROM PERSONAS h
JOIN personas m ON(m.n_persona=h.n_madre)
WHERE h.SEXO = 'M'
GROUP BY m.nombre
HAVING COUNT(*)=2
ORDER BY 1,2;



--EJERCICIO9 CON SUBSELECT
SELECT NOMBRE
FROM PERSONAS
WHERE SEXO='H' AND NOMBRE NOT IN
                   (SELECT p.nombre PADRES
                    FROM PERSONAS h
                    JOIN PERSONAS p ON(p.N_PERSONA=h.N_PADRE)
                    );




--EJERCICIO9 COMBINACIONES ESPECIALES
SELECT NOMBRE
FROM PERSONAS
WHERE SEXO='H'
MINUS
SELECT p.nombre PADRES
                    FROM PERSONAS h
                    JOIN PERSONAS p ON(p.N_PERSONA=h.N_PADRE);

--COMBINACIONES ESPECIALES
--Para poder usarlas las columnas del select han de ser las mismas
--MINUS
--UNION
--INTERSECT