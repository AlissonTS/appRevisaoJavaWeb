<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PRINCIPAL</title>
	</head>
	<body>
		<h1 style="font-size: 20px">${usuario.login}  - Usu�rio Autenticado!</h1>
		
		<a href="/appRevisaoJavaWeb/mvc?logica=RedirecionaCadastraUsuarioLogica">Cadastrar Usu�rio</a> 
		
	</body>
</html>