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
		Nome: <input type="text" name="nome"/>
		Descrição: <input type="text" name="descricao"/>
		Valor: <input type="text" name="valor"/>
		Categoria: <input type="text" name="categoria"/>
		<input type="hidden" name="id"/>
		<input type="hidden" name="acao" value="NovoProduto" />
		<input type="submit"/>
	</form>
	<p>Categorias disponíveis:</p>
	<c:forEach items="${categorias}" var="categoria">
	<ul>
		<li>${categoria.id_categoria } - ${categoria.nome_categoria }</li>
	</ul>
	</c:forEach>
</body>
</html>