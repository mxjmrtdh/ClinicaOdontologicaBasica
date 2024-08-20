drop table Odontologos if exists;

create table Odontologos
(
    Id int Auto_Increment PRIMARY KEY,
    NumeroMatricula INT NOT NULL,
    Nombre VARCHAR(25) NOT NULL,
    Apellido VARCHAR(50) NOT NULL
);

insert into Odontologos values(DEFAULT,12345,'juan','perez');
insert into Odontologos values(DEFAULT,12346,'ana','ronda');
insert into Odontologos values(DEFAULT,12347,'miguel','rojo');
insert into Odontologos values(DEFAULT,12348,'laura','pomelo');
insert into Odontologos values(DEFAULT,12349,'tulio','rodriguez');

---------------------------------------------------------------------------------------------------------------------------------------
--Profesora

DROP TABLE DOMICILIOS IF EXISTS;
DROP TABLE PACIENTES IF EXISTS;

CREATE TABLE DOMICILIOS(
ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE VARCHAR(50) NOT NULL,
NUMERO INT NOT NULL,
LOCALIDAD VARCHAR(50) NOT NULL,
PROVINCIA VARCHAR(50) NOT NULL
);

CREATE TABLE PACIENTES(
ID INT AUTO_INCREMENT PRIMARY KEY,
APELLIDO VARCHAR(50) NOT NULL,
NOMBRE VARCHAR(50) NOT NULL,
DNI VARCHAR(10) NOT NULL,
FECHA_INGRESO DATE NOT NULL,
ID_DOMICILIO INT NOT NULL
);

INSERT INTO DOMICILIOS VALUES (DEFAULT,'SIEMPRE VIVA', 123, 'SAN SALVADOR', 'JUJUY');
INSERT INTO PACIENTES VALUES (DEFAULT, 'PEREZ', 'JUAN', '4654666', '2024-07-15',1);
INSERT INTO PACIENTES VALUES (DEFAULT, 'Robles', 'Victor', '25253636', '2024-07-15',1);