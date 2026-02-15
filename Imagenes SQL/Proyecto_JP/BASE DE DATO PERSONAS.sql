USE MASTER
GO
CREATE DATABASE PERSONAS
GO
USE PERSONAS
GO
CREATE TABLE IMAGEN_PERSONA
(
ID_Codigo char (10) primary key,
Nombre varchar (25),
Apellido varchar (25),
Sexo char (1),
Foto image
)
GO
SELECT * FROM IMAGEN_PERSONA