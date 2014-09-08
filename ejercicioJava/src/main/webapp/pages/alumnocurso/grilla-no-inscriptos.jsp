<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<display:table uid="noInscripto" name="alumnos" class="grilla">
		<display:column title="-">
			<a class="verMas" href="#"><i class="fa fa-plus"></i><input
				type="checkbox" name="ids"
				value="<c:out value="${noInscripto.id}"/>" /></a>
		</display:column>
		<display:column property="dni" title="DNI" />
		<display:column property="nombre" title="Nombre" />
		<display:column property="apellido" title="Apellido" />
	</display:table>
