/**
 * Javascrip Universidad - EjercicioJava
 */
function Universidad(args) {
	this.options = args;
}

Universidad.prototype.init = function() {
	var self = this;
	$(document).ready(function() {
		$('#menu').multilevelpushmenu({
			backText : "Volver",
			menuWidth : "100%"
		});

		$("#verAlumnos").click(function() {
			self.reloadContainer(self.options.verAlumnosUrl, function() {
				self.initAlumnos();
			});
		})
		$("#altaAlumnos").click(function() {
			self.reloadContainer(self.options.altaAlumnosUrl, function() {
				self.altaAlumnos();
			});
		})
		$("#verCursos").click(function() {
			self.reloadContainer(self.options.verCursosUrl, function() {
				self.initCursos();
			});
		})
		$("#altaCursos").click(function() {
			self.reloadContainer(self.options.altaCursosUrl, function() {
				self.altaCursos();
			});
		})

		self.adaptUI();
	});
}

Universidad.prototype.adaptUI = function() {
	$("#reloadContainer").addClass("ui-tabs ui-widget ui-widget-content ui-corner-all");
	$(".content").addClass("ui-widget-content ui-corner-bottom");
	$(".titulo").addClass("ui-widget-header");
	$(".datepicker").datepicker();
}

Universidad.prototype.reloadContainer = function(url, callback) {
	var self = this;
	$("#reloadContainer").load(url, function() {
		if (callback != undefined) {
			callback(this);
		}
		self.adaptUI();
	});
}

/* Alumnos */

Universidad.prototype.initAlumnos = function() {
	$('#buscarAlumnosForm').ajaxForm({
		target : '#grillaAlumnos',
		success : function() {
			$("#grillaAlumnos").customTable({});
		}
	});
}

Universidad.prototype.altaAlumnos = function() {
	var self = this;
	$('#altaAlumnoForm').ajaxForm(function() {
		self.reloadContainer(self.options.verAlumnosUrl, function() {
			self.initAlumnos();
		});
	});
}

/* Cursos */

Universidad.prototype.initCursos = function() {
	var self = this;
	$('#buscarCursosForm').ajaxForm({
		target : '#grillaCursos',
		success : function() {
			$("#grillaCursos").customTable();
			$(".verMas").click(function() {
				var rowId = $(this).find("#cursoRowId");
				var id = rowId.val();
				self.adminAlumnoCurso(id);
			})
			self.adaptUI();
		}
	});
}

Universidad.prototype.altaCursos = function() {
	var self = this;
	$('#altaCursoForm').ajaxForm(function() {
		self.reloadContainer(self.options.verCursosUrl, function() {
			self.initCursos();
		});
	});
}

/* CursoAlumno */
/**
 * id - id del curso a administrar
 */
Universidad.prototype.adminAlumnoCurso = function(id) {
	var self = this;

	self.reloadContainer(self.options.alumnosCursoUrl, function() {
		$("#cursoIdHidden").val(id);
		self.buscarNoInscriptos(id);
		self.buscarInscriptos(id);
		$("#borrarSeleccion").click(function() {
			self.borrar();
		})
		$("#inscribirSeleccion").click(function() {
			self.inscribir();
		})

		$("#buscarAlumnosCurso").click(function() {
			self.buscarNoInscriptos(id);
			self.buscarInscriptos(id);
			return false;
		})
	});
}

Universidad.prototype.buscarNoInscriptos = function(id) {
	var self = this;

	var curso = $("#cursoIdHidden").val();
	$('#buscarAlumnosForm').ajaxSubmit({
		url : self.options.buscarNoInscriptosUrl,
		data : {
			idCurso : curso
		},
		target : '#grillaAlumnosNoInscriptos',
		success : function() {
			$("#grillaAlumnosNoInscriptos").customTable();
		}
	});
}

Universidad.prototype.buscarInscriptos = function(id) {
	var self = this;

	var curso = $("#cursoIdHidden").val();
	$('#buscarAlumnosForm').ajaxSubmit({
		url : self.options.buscarInscriptosUrl,
		target : '#grillaAlumnosInscriptos',
		data : {
			idCurso : curso
		},
		success : function() {
			$("#grillaAlumnosInscriptos").customTable();
		}
	});

}

Universidad.prototype.inscribir = function() {
	var self = this;

	var curso = $("#cursoIdHidden").val();

	$('#inscribirAlumnosForm').ajaxSubmit({
		url : self.options.inscribirUrl,
		data : {
			idCurso : curso
		},
		success : function() {
			self.adminAlumnoCurso(curso);
		}
	});
}
Universidad.prototype.borrar = function() {
	var self = this;

	var curso = $("#cursoIdHidden").val();

	$('#borrarAlumnosForm').ajaxSubmit({
		url : self.options.borrarUrl,
		data : {
			idCurso : curso
		},
		success : function() {
			self.adminAlumnoCurso(curso);
		}
	});
}