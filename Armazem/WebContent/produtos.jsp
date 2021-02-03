<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Armazem</title>
</head>
<body>
	<h1>Lista de Produtos</h1>
	<a href="novo.html">Adicionar Produto</a>
	<p>
		<br></br>
	</p>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Quantidade</th>
			<th>Preço</th>
			<th colspan=2>Ações</th>
		</tr>
		<c:forEach items="${produto}" var="produto">
			<tr>
				<td>${produto.nome}</td>
				<td>${produto.quantidade}</td>
				<td>${produto.preco}</td>
				<td><a href="editar?id=<c:out value="${produto.id}"/>">Editar</a></td>
				<td><a href="deletar?id=<c:out value="${produto.id}"/>">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>