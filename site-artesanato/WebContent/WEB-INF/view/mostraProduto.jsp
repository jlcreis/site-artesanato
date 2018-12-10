<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List,br.com.projeto.modelo.Produto"%>

<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

<style type="text/css">
	@import url("css/mostraProduto.css");
</style>

<div>

	<div class="row align-items-top">
		<div class="col-6">
			<h1 class="display-4">${produto.nome_produto }</h1>
		</div>
		<div class="col">
			<c:if test="${mensagem }">
				<div class="alert alert-info" role="alert">teste de alerta
					${mensagem }</div>
			</c:if>
		</div>
		<div class="col-2">
			<ul class="nav justify-content-end">
				<li class="nav-item">
					<div class="btn-group" role="group" aria-label="Basic example">
						<a class="btn btn-secondary" role="button"
							href="/site-artesanato/entrada?acao=ListaProdutos">Voltar</a> <a
							class="btn btn-secondary" role="button"
							href="/site-artesanato/entrada?acao=EditarProduto&id=${produto.id_produto}">Editar</a>
						<!-- Modal Button removeProduto -->
						<button type="button" class="btn btn-secondary"
							data-toggle="modal"
							data-target="#removeProduto_${produto.id_produto}">
							Remover</button>
					</div>
				</li>
			</ul>
		</div>
	</div>

<div class="row justify-content-center">
	<div class="col-2"></div>
	<div class="col-8">
	<div class="card">
<div class="card-body">
<div class="row">
		<div class="col">
			<p class="lead">
		Categoria: ${produto.categoria.nome_categoria}
	</p>
	<p class="lead">${produto.descricao_produto }</p>
	<p class="lead">
		<fmt:formatNumber value="${produto.valor_produto }" type="currency" />
	</p>
		</div>
		
		<div class="col">
		<div class="card">
		<div class="card-body">
			<h5 class="card-title">Imagens</h5>
			<c:forEach items="${listaImagens}" var="img">
				<!-- Button trigger modal ver Imagem -->
				<img data-toggle="modal"
					data-target="#verImagemModal_${img.id_img }" class="img-thumbnail"
					alt="imagem" src="img/${img.nome_img }.jpg">

				<!-- Modal ver imagem -->

				<div class="modal fade" id="verImagemModal_${img.id_img }"
					tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog modal-lg" role="document">
						<div class="modal-content">
							<div class="modal-header">
							<h5 class="modal-title" id="exampleModalCenterTitle">${produto.nome_produto }</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<!-- início carousel -->
								<div id="carouselProduto_${img.id_img}Controls"
									class="carousel slide" data-ride="carousel"
									data-interval="false">
									<div class="carousel-inner">
										<c:forEach items="${listaImagens }" var="img1">
											<div
												class="carousel-item <c:if test="${img.id_img == img1.id_img }">active</c:if>">
												<img class="d-block w-100 img-modal" src="img/${img1.nome_img}.jpg"
													alt="${img1.id_img }_slide">
											</div>
										</c:forEach>
									</div>
									<a class="carousel-control-prev"
										href="#carouselProduto_${img.id_img}Controls" role="button"
										data-slide="prev"> <span
										class="carousel-control-prev-icon" aria-hidden="true"></span>
										<span class="sr-only">Previous</span>
									</a> <a class="carousel-control-next"
										href="#carouselProduto_${img.id_img}Controls" role="button"
										data-slide="next"> <span
										class="carousel-control-next-icon" aria-hidden="true"></span>
										<span class="sr-only">Next</span>
									</a>
								</div>
								<!-- fim carousel -->
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
		</div>
	</div>
</div>
</div>
	</div>
	<div class="col-2"></div>
</div>

	
	
</div>	
	<!-- Modal removeProduto -->
	<div class="modal fade" id="removeProduto_${produto.id_produto}"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Atenção!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Tem certeza que deseja remover o produto <strong>${produto.nome_produto }</strong>
					?
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Não</button>
					<a class="btn btn-danger" role="button"
						href="/site-artesanato/entrada?acao=RemoveProduto&id=${produto.id_produto}">Sim</a>
				</div>
			</div>
		</div>
	</div>
</div>

<c:import url="rodape.jsp"></c:import>