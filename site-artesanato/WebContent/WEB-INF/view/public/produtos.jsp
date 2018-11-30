<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="cabecalho.jsp"></c:import>
<c:import url="header.jsp"></c:import>

<div class="row justify-content-center">
	<div class="col-2">
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
						<c:if test="${id == 0}">active</c:if>
					"><a
						class="nav-link"
						href="/site-artesanato/entrada?acao=PublicProdutos&id=0">Produtos
							<span class="sr-only">(current)</span>
					</a></li>
					<c:forEach items="${categorias }" var="c">
						<li
							class="nav-item border-bottom
				<c:if test="${c.id_categoria == id}">active</c:if>
			"><a
							class="nav-link"
							href="/site-artesanato/entrada?acao=PublicProdutos&id=${c.id_categoria }"> - ${c.nome_categoria }
								<span class="sr-only">(current)</span>
						</a></li>
					</c:forEach>
				</ul>
			</div>
		</nav>
	</div>
	<div class="col-8">
		<div class="container-fluid">
			<div class="py-5">
				<div class="card-columns">
					<c:forEach items="${produtos }" var="p">
						<pg:item>
							<div class="card">
								<c:forEach items="${p.lista_imagens }" var="img">
									<a
										href="/site-artesanato/entrada?acao=PublicProduto&id=${p.id_produto}">
										<img class="card-img-top" src="img/${img.nome_img }.jpg"
										alt="Card_${p.nome_produto }">
									</a>
								</c:forEach>
								<div class="card-body">
									<p class="card-text">${p.nome_produto }</p>
								</div>
							</div>
						</pg:item>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="col-2"></div>
</div>


<c:import url="footer.jsp"></c:import>
<c:import url="rodape.jsp"></c:import>