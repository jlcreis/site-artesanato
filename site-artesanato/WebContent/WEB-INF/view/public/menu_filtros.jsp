
<%@ page import="java.util.List,br.com.projeto.modelo.Categoria"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarVertical" aria-controls="navbarVertical"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarVertical">
		<ul class="navbar-nav mr-auto flex-column">
			<li
				class="nav-item border-bottom
						<c:if test="${param.id == 0}">active</c:if>
					"><a
				class="nav-link"
				href="/site-artesanato/entrada?acao=PublicProdutos&id=0">Produtos
					<span class="sr-only">(current)</span>
			</a></li>
			<c:forEach items="${categorias }" var="c">
				<li class="nav-item border-bottom <c:if test="${c.id_categoria == param.id}">active</c:if>
			"><a
					class="nav-link"
					href="/site-artesanato/entrada?acao=PublicProdutos&id=${c.id_categoria }">
						- ${c.nome_categoria } <span class="sr-only">(current)</span>
				</a></li>
			</c:forEach>
		</ul>
	</div>
</nav>

