<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%@ page import="java.util.List,br.com.projeto.app.ConstantesApp"%>


<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Site Artesanato</title>
</head>
<body>
	<c:forEach items="${listaImagens}" var="img">
    	<p><img alt="imagem" src="img/${img.nome_img }.jpg" style="width: 100px;">
    	
    	<a href="/site-artesanato/entrada?acao=RemoveImagemProduto&id_img=${img.id_img}&nome=${img.nome_img }&id=${id_produto}">X</a></p> 
    	
    </c:forEach>

	<form action="upload" method="post" enctype="multipart/form-data">
		<p>Nova Imagem: <input type="file" name="${id_produto}" accept="image/jpg"/></p>
		<input type="submit"/>
		
		<a href="/site-artesanato/entrada?acao=MostraProduto&id=${id_produto}">Ver Produto</a> 
	</form>
	
    <label>${message}</label>
    
</body>
</html>