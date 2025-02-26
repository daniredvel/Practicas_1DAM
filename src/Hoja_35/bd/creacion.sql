USE GEOGRAFIA;
SELECT * FROM LOCALIDADES;
CREATE USER geografia@localhost IDENTIFIED BY 'A12345a';
GRANT SELECT ON geografia.* TO geografia@localhost;

