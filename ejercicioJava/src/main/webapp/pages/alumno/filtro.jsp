<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="filter" method="POST"
	action="alumno/buscar.htm" cssClass="formulario" id="buscarAlumnosForm">
	<table>
		<tbody>
			<tr>
				<td><form:label path="nombre">Nombre:</form:label></td>
				<td><form:input path="nombre"></form:input></td>
				<td colspan="1"></td>
				<td><form:label path="apellido">Apellido:</form:label></td>
				<td><form:input path="apellido"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="dni">Dni:</form:label></td>
				<td><form:input path="dni"></form:input></td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4"></td>
				<td><input type="submit" value="Buscar"></td>
			</tr>
		</tbody>
	</table>
</form:form>