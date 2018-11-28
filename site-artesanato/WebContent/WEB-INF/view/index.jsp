<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,br.com.projeto.modelo.Produto"%>

<c:import url="cabecalho.jsp"></c:import>
<c:import url="public/menuIndex.jsp"></c:import>

<style type="text/css">
@import url("css/home.css");
</style>

<div class="row justify-content-center">
	<div class="col-2"></div>
	<div class="col-8">
		<c:if test="${produto_1 != null }">
			<a
				href="/site-artesanato/entrada?acao=MostraProduto&id=${produto_1.id_produto}">
				<div class="card text-white mb-5">
					<c:forEach items="${produto_1.lista_imagens }" var="img">
						<img class="card-img w-100 cover" src="img/${img.nome_img}.jpg"
							alt="Produto em destaque">
					</c:forEach>
					<div class="card-img-overlay">
						<h5 class="card-title">${produto_1.nome_produto }</h5>
						<p class="card-text">${produto_1.descricao_produto }</p>
					</div>
				</div>
			</a>
		</c:if>
		<div class="row border-top">
			<div class="col-4 dst-b">
				<a
					href="/site-artesanato/entrada?acao=MostraProduto&id=${produto_2.id_produto}">
					<c:if test="${produto_2 != null }">
						<div class="card text-white">
							<c:forEach items="${produto_2.lista_imagens }" var="img">
								<img class="card-img w-100 cover-sm"
									src="<c:url value="img/${img.nome_img}.jpg"/>" alt="Produto em destaque">
							</c:forEach>
						</div>
					</c:if>
				</a>
			</div>
			<div class="col-6 center">
				<p class="lead">${produto_2.categoria.nome_categoria }</p>
				<p class="lead">
					<strong>${produto_2.nome_produto }</strong>
				</p>
				<p class="lead">${produto_2.descricao_produto }</p>
			</div>
		</div>
		<div class="row border-top">
			<div class="col-4 dst-b">
				<c:if test="${produto_3 != null }">
					<a
						href="/site-artesanato/entrada?acao=MostraProduto&id=${produto_3.id_produto}">

						<div class="card text-white">
							<c:forEach items="${produto_3.lista_imagens }" var="img">
								<img class="card-img w-100 cover-sm"
									src="img/${img.nome_img}.jpg" alt="Produto em destaque">
							</c:forEach>
						</div>

					</a>
				</c:if>
			</div>
			<div class="col-6 center">
				<p class="lead">${produto_3.categoria.nome_categoria }</p>
				<p class="lead">
					<strong>${produto_3.nome_produto }</strong>
				</p>
				<p class="lead">${produto_3.descricao_produto }</p>
			</div>
		</div>
		<div class="row border-top">
			<div class="col-4 dst-b">
				<c:if test="${produto_4 != null }">
					<a
						href="/site-artesanato/entrada?acao=MostraProduto&id=${produto_4.id_produto}">

						<div class="card text-white">
							<c:forEach items="${produto_4.lista_imagens }" var="img">
								<img class="card-img w-100 cover-sm"
									src="img/${img.nome_img}.jpg" alt="Produto em destaque">
							</c:forEach>
						</div>

					</a>
				</c:if>
			</div>
			<div class="col-6 center">
				<p class="lead">${produto_4.categoria.nome_categoria }</p>
				<p class="lead">
					<strong>${produto_4.nome_produto }</strong>
				</p>
				<p class="lead">${produto_4.descricao_produto }</p>
			</div>
		</div>
		<div class="row border-top">
			<div class="col-4 dst-b">
				<c:if test="${produto_5 != null }">
					<a
						href="/site-artesanato/entrada?acao=MostraProduto&id=${produto_5.id_produto}">

						<div class="card text-white">
							<c:forEach items="${produto_5.lista_imagens }" var="img">
								<img class="card-img w-100 cover-sm"
									src="img/${img.nome_img}.jpg" alt="Produto em destaque">
							</c:forEach>
						</div>

					</a>
				</c:if>
			</div>
			<div class="col-6 center">
				<p class="lead">${produto_5.categoria.nome_categoria }</p>
				<p class="lead">
					<strong>${produto_5.nome_produto }</strong>
				</p>
				<p class="lead">${produto_5.descricao_produto }</p>
			</div>
		</div>
	</div>

	<div class="col-2"></div>
</div>

<c:import url="footer.jsp"></c:import>
<c:import url="rodape.jsp"></c:import>