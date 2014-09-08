<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<display:table uid="curso" name="cursos" class="grilla">
	<display:column property="id" title="ID" />
	<display:column property="denominacion" title="Denominación" />
	<display:column title="Alumnos">
		<a class="verMas" href="#"><input id="cursoRowId" type="hidden" value="<c:out value="${curso.id}"/>" /><i
			class="fa fa-plus"></i>Ver/Agregar Alumnos</a>
	</display:column>

</display:table>