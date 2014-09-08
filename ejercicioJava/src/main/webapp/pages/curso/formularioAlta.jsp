<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="curso" method="POST"
	action="curso/guardar.htm" cssClass="formulario" id="altaCursoForm">
	<table>
		<tbody>
			<tr>
				<td><form:label path="denominacion">Denominación:</form:label></td>
				<td><form:input path="denominacion"></form:input></td>
				<td colspan="1"></td>
			</tr>
<!-- 			<tr> -->
<%-- 				<td><form:label path="alumnos">Alumnos:</form:label></td> --%>
<%-- 				<td><form:input path="nombre"></form:input></td> --%>
<!-- 				<td colspan="1"></td> -->
<!-- 			</tr> -->
			<tr>
				<td colspan=2"></td>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</tbody>
	</table>
</form:form>