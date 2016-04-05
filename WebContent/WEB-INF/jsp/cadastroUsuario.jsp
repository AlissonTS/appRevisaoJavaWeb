<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastrar Usuário</title>
	</head>
	<body>
		<h1>Cadastro de Usuário: </h1>
		
		<section>
			<form action="/appRevisaoJavaWeb/mvc?logica=CriarUsuario" method="post">
			
				<c:if test="${not empty usuario }">
					<h2>Alterar Usuário: ${usuario.login}</h2>
					<input type="hidden" name="id" value="${usuario.id }"/>
				</c:if>
				
				<label for="login">Login: </label>
				<input type="text" id="Login" name="login" value="${usuario.login }"/> <br/>
				<label for="senha">Senha: </label>
				<input type="text" id="senha" name="senha" value="${usuario.senha }"/> <br/>
				<button type="submit" name="opcao" value="cadastroUsuario">Cadastrar:</button>
			</form>
		</section>
		
		<c:if test="${not empty msg }">
			<h2>${msg}</h2>
		</c:if>
		
		<section>

			<table class="table table-striped table-bordered">
				<thead>
					<tr>
					<tr>
						<th>Login</th>
						<th>Senha</th>
						
						<th>Ações</th>
					</tr>
		
				</thead>
				<tfoot>
					<tr>
					<tr>
						<th>Login</th>
						<th>Senha</th>				
						<th>Ações</th>
					</tr>
				</tfoot>
				<tbody>
		
					<c:forEach var="usuario" items="${usuarios}">
						<tr>
							<td>${usuario.login}</td>
							<td>${usuario.senha}</td>
							
							<td><a class="btn btn-danger"
								href="mvc?logica=BuscarUsuario&&id=${usuario.id}">Alterar</a>
								<a class="btn btn-danger"
								href="mvc?logica=RemoverUsuario&&id=${usuario.id}">Remover</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
		</section>
		
	</body>
</html>