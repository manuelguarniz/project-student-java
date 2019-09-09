<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div>
		<h3>Acceso al Sistema</h3>
		<br/><br/>
		<form:form method="POST" action="VerificarAcceso">
			<table>
				<tr>
					<td><form:label path="Login">Usuario:</form:label>
					<td><form:input path="Login"></form:input>
				<tr/>
				<tr>
					<td><form:label path="Password">Password:</form:label>
					<td><form:input path="Password"></form:input>
				<tr/>
				<tr>
					<td colspan="2">
						<input type="submit" value="Ingresar" name="btnIngresar"/>
						<input type="reset" value="Limpiar"/>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
