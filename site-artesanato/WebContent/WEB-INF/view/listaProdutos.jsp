<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="java.util.List,br.com.projeto.modelo.Produto"%>
<%@ page import="java.util.List,br.com.projeto.app.ConstantesApp"%>

<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

<style>
@import url("css/home.css");

.card {
	background-color: #e9ecef;
}

.card-columns {
	column-count: 5;
	column-gap: 0.4rem;
}

.card-body {
	padding: 0.5rem;
}
</style>

<div class="row align-items-center">
	<div class="col">
		<h1 class="display-4">Produtos</h1>
	</div>
	<div class="col-6">
		<c:if test="${mensagem }">
			<div class="alert alert-info" role="alert">${mensagem }</div>
		</c:if>
	</div>
	<div class="col">
		<ul class="nav justify-content-end">
			<li class="nav-item"><a class="btn btn-outline-secondary"
				role="button" href="/site-artesanato/entrada?acao=NovoProdutoForm">Adicionar
					Produto</a></li>
		</ul>
	</div>
</div>

<div class="row justify-content-center">
	<div class="col-lg-2 bg-light">
		<c:import url="menu_filtros.jsp">
			<c:param name="id" value="${id}" />
			<c:param name="categorias" value="${categorias }" />
		</c:import>
	</div>
	<div class="col-8">
		<c:forEach items="${produtos}" var="p">
			<div class="row border-top">
				<div class="col-4 dst-b">
					<div class="card text-white">
						<a href="/site-artesanato/entrada?acao=EditarProduto&id=${p.id_produto}">
							<c:forEach items="${p.lista_imagens }" var="img">
								<img class="card-img w-100 cover-sm"
									src="<c:url value="${ConstantesApp.CAMINHO_IMG }/${img.nome_img}.jpg"/>"
									alt="Produto em destaque">
							</c:forEach>
						</a>
					</div>
				</div>
				<div class="col-6 center">
					<p class="lead">${p.categoria.nome_categoria }</p>
					<p class="lead">
						<strong>${p.nome_produto }</strong>
					</p>
					<p class="lead">${p.descricao_produto }</p>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col-2"></div>
</div>

<c:import url="rodape.jsp"></c:import>