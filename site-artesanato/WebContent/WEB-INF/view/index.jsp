<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,br.com.projeto.modelo.Produto"%>

<c:import url="public/cabecalho.jsp"></c:import>
<c:import url="public/header.jsp"></c:import>

<style type="text/css">
@import url("css/home.css");
</style>

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
	<div class="col-8">
		<div class="container-fluid">
			<div class="py-5">
		<c:if test="${produto_1 != null }">
			<a
				href="/site-artesanato/entrada?acao=PublicProduto&id=${produto_1.id_produto}">
				<div class="card text-white mb-5 tx-dest-a">
					<c:forEach items="${produto_1.lista_imagens }" var="img">
						<img class="card-img w-100 cover" src="img/${img.nome_img}.jpg"
							alt="Produto em destaque">
					</c:forEach>
					<div class="card-img-overlay">
						<h5 class="card-title ">${produto_1.nome_produto }</h5>
						<p class="card-text  text-truncate tx-p">${produto_1.descricao_produto }</p>
					</div>
				</div>
			</a>
		</c:if>
		<div class="row border-top">
			<div class="col-4 dst-b">
				<a
					href="/site-artesanato/entrada?acao=PublicProduto&id=${produto_2.id_produto}">
					<c:if test="${produto_2 != null }">
						<div class="card text-white">
							<c:forEach items="${produto_2.lista_imagens }" var="img">
								<img class="card-img w-100 cover-sm"
									src="<c:url value="img/${img.nome_img}.jpg"/>"
									alt="Produto em destaque">
							</c:forEach>
						</div>
					</c:if>
				</a>
			</div>
			<div class="col-8 dst-b center text-truncate">
				<p class="lead font-weight-normal">${produto_2.categoria.nome_categoria }</p>
				<p class="lead font-weight-bold">${produto_2.nome_produto }</p>
				<p class="lead font-italic text-truncate tx-p">${produto_2.descricao_produto }</p>
			</div>
		</div>
		<div class="row border-top">
			<div class="col-4 dst-b">
				<c:if test="${produto_3 != null }">
					<a
						href="/site-artesanato/entrada?acao=PublicProduto&id=${produto_3.id_produto}">

						<div class="card text-white">
							<c:forEach items="${produto_3.lista_imagens }" var="img">
								<img class="card-img w-100 cover-sm"
									src="img/${img.nome_img}.jpg" alt="Produto em destaque">
							</c:forEach>
						</div>

					</a>
				</c:if>
			</div>
			<div class="col-8 dst-b center text-truncate">
				<p class="lead font-weight-normal">${produto_3.categoria.nome_categoria }</p>
				<p class="lead font-weight-bold">${produto_3.nome_produto }</p>
				<p class="lead font-italic text-truncate tx-p">${produto_3.descricao_produto }</p>
			</div>
		</div>
		<div class="row border-top">
			<div class="col-4 dst-b">
				<c:if test="${produto_4 != null }">
					<a
						href="/site-artesanato/entrada?acao=PublicProduto&id=${produto_4.id_produto}">

						<div class="card text-white">
							<c:forEach items="${produto_4.lista_imagens }" var="img">
								<img class="card-img w-100 cover-sm"
									src="img/${img.nome_img}.jpg" alt="Produto em destaque">
							</c:forEach>
						</div>

					</a>
				</c:if>
			</div>
			<div class="col-8 dst-b center text-truncate">
				<p class="lead font-weight-normal">${produto_4.categoria.nome_categoria }</p>
				<p class="lead font-weight-bold">${produto_4.nome_produto }</p>
				<p class="lead font-italic text-truncate tx-p">${produto_4.descricao_produto }</p>
			</div>
		</div>
		<div class="row border-top">
			<div class="col-4 dst-b">
				<c:if test="${produto_5 != null }">
					<a
						href="/site-artesanato/entrada?acao=PublicProduto&id=${produto_5.id_produto}">

						<div class="card text-white">
							<c:forEach items="${produto_5.lista_imagens }" var="img">
								<img class="card-img w-100 cover-sm"
									src="img/${img.nome_img}.jpg" alt="Produto em destaque">
							</c:forEach>
						</div>

					</a>
				</c:if>
			</div>
			<div class="col-8 dst-b center text-truncate">
				<p class="lead font-weight-normal">${produto_5.categoria.nome_categoria }</p>
				<p class="lead font-weight-bold">${produto_5.nome_produto }</p>
				<p class="lead font-italic text-truncate tx-p">${produto_5.descricao_produto }</p>
			</div>
		</div>
		</div>
		</div>
	</div>

	<div class="col-2"></div>
</div>

<c:import url="public/footer.jsp"></c:import>
<c:import url="public/rodape.jsp"></c:import>