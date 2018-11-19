<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.projeto.modelo.Categoria" %>
<%@ page import="java.util.List,br.com.projeto.app.Mensagem" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Categorias</h1>
	<p><a href="/site-artesanato/entrada?acao=NovaCategoriaForm">Nova Categoria</a></p>
	<ul>
		<c:forEach items="${categorias}" var="categoria">
			<li> 
				${categoria.nome_categoria } 
				<a href="/site-artesanato/entrada?acao=MostraCategoria&id=${categoria.id_categoria}">Editar</a> 
				<a href="/site-artesanato/entrada?acao=RemoveCategoria&id=${categoria.id_categoria}">Remover</a>
			</li>
		</c:forEach>
	</ul>
	
	<label>${message}</label>

</body>
</html>