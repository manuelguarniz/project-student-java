<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br/><br/><br/>
	<form method="post" action="seg_verificaracceso">
		<div align="center">
			<table border=1>
				<tr>
					<td>Usuario:</td>
					<td><input type="text" name="txtUsuario"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="txtPassword"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" name="btnIngresar" value="Ingresar"/>
						<input type="reset" value="Limpiar"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>