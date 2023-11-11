
CREATE table departamentos(
	codigo int,
    nombre VARCHAR(100),
    presupuesto int,
    primary key (codigo)
);
CREATE table empleados(
	dni VARCHAR(8),
    nombre VARCHAR(100),
    apellidos VARCHAR(255),
    codigo_departamento int,
    foreign key (codigo_departamento) REFERENCES departamentos (codigo)
	ON DELETE CASCADE ON UPDATE CASCADE,
	primary key (dni)
);
INSERT INTO `departamentos` VALUES (14,'IT',65000),(37,'Accounting',15000),(59,'Human Resources',240000),(77,'Research',55000);
INSERT INTO `empleados` VALUES (12323487,'Michael','Rogers',14),(15294485,'Anand','Manikutty',14),(22234883,'Carol','Smith',37),(32657417,'Joe','Stevens',37),(33214719,'Mary-Anne','Foster',14),(33569843,'George','Donnell',77),(54523478,'John','Doe',59),(63123482,'David','Smith',77),(65483219,'Zacary','Efron',59),(74568214,'Eric','Goldsmith',59),(84565233,'Luis','López',14),(84565745,'Elizabeth','Doe',14),(84567246,'Kumar','Swamy',14),(84565766,'Jose','Pérez',77);

