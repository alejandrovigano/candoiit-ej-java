<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="content">
	<input type="hidden" name="idCurso" id="cursoIdHidden">
	<div class="titulo">
		<h1>Alumno Curso</h1>
	</div>
	<div class="filtros seccion">
		<jsp:include page="filtro.jsp" />
	</div>

	<div class="seccion">
		<h2>Alumnos inscriptos</h2>
		<div>
			<a href="#" id="borrarSeleccion"><i class="fa fa-arrow-down"></i>Borrar
				selección del curso</a>
		</div>
		<form method="POST" id="borrarAlumnosForm">
			<div class="grilla" id="grillaAlumnosInscriptos"></div>
		</form>
	</div>
	<div class="seccion">
		<h2>Alumnos no inscriptos</h2>
		<div>
			<a href="#" id="inscribirSeleccion"><i class="fa fa-arrow-up"></i>Inscribir
				selección a curso</a>
		</div>

		<form method="POST" id="inscribirAlumnosForm">
			<div class="grilla" id="grillaAlumnosNoInscriptos"></div>
		</form>
	</div>
</div>