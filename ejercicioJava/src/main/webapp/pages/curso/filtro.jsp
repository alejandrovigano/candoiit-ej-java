<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="filter" method="POST"
	action="curso/buscar.htm" cssClass="formulario" id="buscarCursosForm">
	<table>
		<tbody>
			<tr>
				<td><form:label path="denominacion">Denominación:</form:label></td>
				<td><form:input path="denominacion"></form:input></td>
				<td colspan="1"></td>
				<td><form:label path="id">ID:</form:label></td>
				<td><form:input path="id"></form:input></td>
			</tr>
			<tr>
				<td colspan="4"></td>
				<td><input type="submit" value="Buscar"></td>
			</tr>
		</tbody>
	</table>
</form:form>