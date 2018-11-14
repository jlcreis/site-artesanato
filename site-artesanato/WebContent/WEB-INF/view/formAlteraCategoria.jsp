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
		Nome: <input type="text" name="nome" value="${categoria.nome_categoria}"/>
		<input type="hidden" name="id" value="${categoria.id_categoria }" />
		<input type="hidden" name="acao" value="AlteraCategoria" />
		<input type="submit"/>
	</form>
</body>
</html>