<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administración</title>
<script type="text/javascript">
	$(document).ready(function() {
		var universidad = new Universidad({
			verAlumnosUrl : "alumno/ver.htm",
			altaAlumnosUrl : "alumno/alta.htm",
			verCursosUrl : "curso/ver.htm",
			altaCursosUrl : "curso/alta.htm",
			alumnosCursoUrl : "alumnocurso/ver.htm",
			buscarInscriptosUrl : "alumnocurso/buscarinscriptos.htm",
			buscarNoInscriptosUrl : "alumnocurso/buscarnoinscriptos.htm",
			inscribirUrl : "alumnocurso/inscribir.htm",
			borrarUrl : "alumnocurso/borrar.htm",
		});
		universidad.init();
	})
</script>
</head>
<body>

	<div id="reloadContainer"></div>
	<div id="dialog"></div>
</body>
</html>