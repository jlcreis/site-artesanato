<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Site Artesanato</title>
</head>
<body>
	<form action="${linkEntradaServlet}" method="post">
		Nome: <input type="text" name="nome" value="${produto.nome_produto}"/>
		Descrição: <input type="text" name="descricao" value="${produto.descricao_produto}"/>
		Valor: <input type="text" name="valor" value="${produto.valor_produto}"/>
		Categoria: <input type="text" name="categoria" value="${produto.categoria_produto}"/>
		<input type="hidden" name="id" value="${produto.id_produto }" />
		<input type="hidden" name="acao" value="AlteraProduto" />
		<input type="submit"/>
	</form>
	<p>Categorias disponíveis:</p>
	<c:forEach items="${categorias}" var="categoria">
	<ul>
		<li>${categoria.id_categoria } - ${categoria.nome_categoria }</li>
	</ul>
	</c:forEach>
	
	<a href="/site-artesanato/entrada?acao=NovaImagemForm&id=${produto.id_produto}">Editar imagens</a> 
</body>
</html>