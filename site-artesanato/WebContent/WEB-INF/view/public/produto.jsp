<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List,br.com.projeto.app.ConstantesApp"%>

<c:import url="cabecalho.jsp"></c:import>
<c:import url="header.jsp"></c:import>

<style type="text/css">
@import url("css/index.css");
</style>
<div class="row justify-content-center">
	<div class="col-lg-2 bg-light">
		<c:import url="menu_filtros.jsp">
			<c:param name="id" value="${id}" />
			<c:param name="categorias" value="${categorias }" />
		</c:import>
	</div>
	<div class="col-lg-8">
		<div class="container-fluid">
			<div class="py-5">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col">
								<p class="lead font-weight-bold">${produto.nome_produto}</p>
								<p class="lead text-justify font-italic">${produto.descricao_produto }</p>
								<div class="row">
									<div class="col-auto mr-auto">
										<p class="lead font-weight-normal">
											<fmt:formatNumber value="${produto.valor_produto }"
												type="currency" />
										</p>
									</div>
									<div class="col-auto">
										<button type="button" class="btn btn-info"
											data-container="body" data-toggle="popover"
											data-placement="top"
											data-content="${ConstantesApp.ONDE_COMPRAR }">
											Onde comprar</button>
									</div>
								</div>
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
													src="${ConstantesApp.CAMINHO_IMG }/${img.nome_img }.jpg">
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

	<div class="col-lg-2"></div>
</div>
<c:import url="footer.jsp"></c:import>
<c:import url="rodape.jsp"></c:import>