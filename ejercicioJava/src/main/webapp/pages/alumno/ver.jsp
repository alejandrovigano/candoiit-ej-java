<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="content">

	<div class="titulo">
		<h1>Ver Alumnos</h1>
	</div>
	
	<div class="filtros seccion">
		<jsp:include page="filtro.jsp" />
	</div>
	<div class="grilla seccion" id="grillaAlumnos"></div>

</div>