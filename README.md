candoiit-ej-java
================

Ejercicio Java para Candoit

================

Alumnos

- Ver Alumnos (Grilla de alumnos, Filtro alumnos)  
- + Filtro Alumnos (Nombre, Apellido, Dni)  
- + Grilla Alumno (Datos : Dni, Nombre, Apellido)  

- Alta Alumnos (Formulario de alta con datos por: Nombre, Apellido, Dni, Fecha de Nacimiento )   

Cursos

- Ver Cursos (Grilla de cursos con filtro por: Denominación, ID)  
- + Grilla Cursos (Datos : ID, Denominacion, Alumnos(Clickeable))  
- + + Click en "Ver/Agregar Alumnos" (Abre seccion "Alumno Curso" con el grupo como parametro)  

AlumnoCurso (Grilla de alumnos inscriptos al curso, Grilla de alumnos no inscriptos al curso, Filtro alumnos)

- Filtro Alumnos (Nombre, Apellido, Dni)  
- Grilla Alumnos Inscriptos (Check, DNI, Nombre, Apellido)  
- + Al seleccionar alumnos inscriptos y clickear "Borrar selección del curso" elimina los alumnos del curso  
- Grilla Alumnos No Inscriptos (Check, DNI, Nombre, Apellido)  
- ++ Al seleccionar alumnos no inscriptos y clickear "Inscribir selección a curso" inscribe los alumnos al curso  

================

Modelo entidades:

ALUMNO
-Nombre
-Apellido
-Dni
-Fecha Nacimiento
-Fecha Alta (del sistema)
-Fecha Baja (del sistema)

CURSO
-Descripcion
-Fecha Alta (del sistema)
-Lista de AlumnoCurso

ALUMNO_CURSO
-Alumno
-Curso
-FechaAlta

================

Modelo de tablas:

TABLE `ALUMNO` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(255) NOT NULL,
  `APELLIDO` VARCHAR(255) NOT NULL,
  `DNI` BIGINT UNSIGNED NOT NULL,
  `FECHA_NACIMIENTO` TIMESTAMP NOT NULL,
  `FECHA_ALTA` TIMESTAMP NOT NULL,
  `FECHA_BAJA` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`ID`));

TABLE `CURSO` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` VARCHAR(255) NULL,
  `FECHA_ALTA` TIMESTAMP NOT NULL,
  PRIMARY KEY (`ID`));

TABLE `ALUMNO_CURSO` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `ID_CURSO` BIGINT NOT NULL,
  `ID_ALUMNO` BIGINT NOT NULL,
  `FECHA_ALTA` TIMESTAMP NULL,
  PRIMARY KEY (`ID`));


================

DEMO
http://ejjava-almepsonline.rhcloud.com/
