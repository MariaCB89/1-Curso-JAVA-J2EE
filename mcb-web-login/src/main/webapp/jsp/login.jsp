<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Login" method="post">
		<table>
		 <tr>
		  <td>Nombre usuario</td>
		  <td><input type="text" name="nombre_usuario"></td><%--el formulario envía este componente con un parámetro que hay que capturar--%>
		 </tr>
		 <tr>
		  <td>Clave usuario</td>
		  <td><input type="password" name="clave_usuario"></td><%--el formulario envía este componente con un parámetro que hay que capturar--%>
		 </tr>
		 <tr>
		  <td colspan="2"><input type="submit" name="Comprobar"></td><%--esto es el botón--%>
		 </tr>
		</table>
	</form>
</body>
</html>