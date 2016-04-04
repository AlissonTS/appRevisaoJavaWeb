<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>LOGAR NA APLICAÇÃO</title>
	</head>
	<body>
	
		<form action="/appRevisaoJavaWeb/mvc?logica=LogarLogica" method="post">
			<label for="login">Login: </label>
			<input type="text" id="Login" name="login" /> <br/>
			<label for="senha">Senha: </label>
			<input type="text" id="senha" name="senha" /> <br/>
			<button type="submit" name="opcao" value="logar">Logar:</button>
		</form>
		
		<c:if test="${not empty msg }">
			<h2>${msg}</h2>
		</c:if>
		
	</body>
</html>