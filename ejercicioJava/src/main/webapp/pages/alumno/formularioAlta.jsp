<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="alumno" method="POST"
	action="alumno/guardar.htm" cssClass="formulario" id="altaAlumnoForm">
	<table>
		<tbody>
			<tr>
				<td><form:label path="nombre">Nombre:</form:label></td>
				<td><form:input path="nombre"></form:input></td>
				<td colspan="1"></td>

			</tr>
			<tr>
				<td><form:label path="apellido">Apellido:</form:label></td>
				<td><form:input path="apellido"></form:input></td>
				<td colspan="1"></td>

			</tr>
			<tr>
				<td><form:label path="dni">Dni:</form:label></td>
				<td><form:input path="dni"></form:input></td>
				<td colspan="1"></td>

			</tr>
			<tr>
				<td><form:label path="fechaNacimiento" >Fecha Nacimiento:</form:label></td>
				<td><form:input path="fechaNacimiento"cssClass="datepicker"></form:input></td>
				<td colspan="1"></td>
			</tr>
			<tr>
				<td colspan=21"></td>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</tbody>
	</table>
</form:form>