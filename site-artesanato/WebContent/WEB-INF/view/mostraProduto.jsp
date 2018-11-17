<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.projeto.modelo.Produto"%>
<%@ page import="java.util.List,br.com.projeto.app.ConstantesApp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Site Artesanato</title>
</head>
<body>
	<h1>${produto.nome_produto }</h1>
	<a
		href="/site-artesanato/entrada?acao=ListaProdutos">Lista de Produtos</a>
	<a
		href="/site-artesanato/entrada?acao=EditarProduto&id=${produto.id_produto}">Editar</a>
	<a
		href="/site-artesanato/entrada?acao=RemoveProduto&id=${produto.id_produto}">Remover</a>
	<ul>
		<li>${produto.valor_produto }</li>
		<li>${produto.descricao_produto }</li>
		
		<c:forEach items="${listaImagens}" var="img">
    	<img alt="imagem" src="img/${img.nome_img }.jpg" style="width: 100px;">
    	<p>
    </c:forEach>
	</ul>

</body>
</html>