<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.projeto.modelo.Produto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Site Artesanato</title>
</head>
<body>
	<h1>Produtos</h1>
	<p><a href="/site-artesanato/entrada?acao=NovoProdutoForm">Novo Produto</a></p>
	<ul>
		<c:forEach items="${produtos}" var="produto">
			<li> 
				${produto.nome_produto } - ${produto.valor_produto }
				<a href="/site-artesanato/entrada?acao=MostraProduto&id=${produto.id_produto}">Mostrar</a> 
				<a href="/site-artesanato/entrada?acao=RemoveProduto&id=${produto.id_produto}">Remover</a> 
			</li>
		</c:forEach>
	</ul>

</body>
</html>