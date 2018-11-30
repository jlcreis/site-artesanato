<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="cabecalho.jsp"></c:import>
<c:import url="header.jsp"></c:import>

<style type="text/css">
@import url("css/index.css");
</style>
<div class="row justify-content-center">
	<div class="col-sm-2">
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
				<c:if test="${c.id_categoria == produto.categoria.id_categoria}">active</c:if>
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
	<div class="col-sm-8">
		<div class="container-fluid">
			<div class="py-5">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col">
								<p class="lead font-weight-bold">${produto.nome_produto}</p>
								<p class="lead text-justify font-italic">${produto.descricao_produto }</p>
								<p class="lead font-weight-normal">
									<fmt:formatNumber value="${produto.valor_produto }"
										type="currency" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<div id="carouselExampleControls" class="carousel slide"
									data-ride="carousel" data-interval="false">
									<div class="carousel-inner badge-dark hwx-400">
										<c:forEach items="${listaImagens}" var="img" varStatus="st">
											<div
												class="carousel-item <c:if test="${st.count == 1}">active</c:if>">
												<img class="d-block img-carousel" alt="Slide_${st.count}"
													src="img/${img.nome_img }.jpg">
											</div>
										</c:forEach>
									</div>
									<a class="carousel-control-prev"
										href="#carouselExampleControls" role="button"
										data-slide="prev"> <span
										class="carousel-control-prev-icon" aria-hidden="true"></span>
										<span class="sr-only">Previous</span>
									</a> <a class="carousel-control-next"
										href="#carouselExampleControls" role="button"
										data-slide="next"> <span
										class="carousel-control-next-icon" aria-hidden="true"></span>
										<span class="sr-only">Next</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col-sm-2"></div>
</div>

<c:import url="footer.jsp"></c:import>
<c:import url="rodape.jsp"></c:import>