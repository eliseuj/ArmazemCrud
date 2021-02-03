<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar produto</title>
</head>
<body>
	<h1>Editar produto</h1>
	<form name="formProduto" action="atualizar">
		<table>
			<tr>
				<td><input type="text" name="id" readonly="readonly"
					placeholder="Identificador" value="<c:out value="${produto.id}"/>" /></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" placeholder="Nome"
					value="<c:out value="${produto.nome}"/>" /></td>
			</tr>
			<tr>
				<td><input type="number" min="0" step="1" name="quantidade"
					placeholder="Quantidade"
					value="<c:out value="${produto.quantidade}"/>" /></td>
			</tr>
			<tr>
				<td><input type="number" min="0" step=".01" name="preco"
					placeholder="Preço" value="<c:out value="${produto.preco}"/>" /></td>
			</tr>
		</table>
		<input type="submit" value="Editar" />
	</form>
</body>
</html>