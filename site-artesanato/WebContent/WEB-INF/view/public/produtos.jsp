<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,br.com.projeto.app.ConstantesApp"%>

<c:import url="cabecalho.jsp"></c:import>
<c:import url="header.jsp"></c:import>

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
				<div class="card-columns">
					<c:forEach items="${produtos }" var="p">
						<div class="card">
							<c:forEach items="${p.lista_imagens }" var="img">
								<a
									href="/site-artesanato/entrada?acao=PublicProduto&id=${p.id_produto}">
									<img class="card-img-top"
									src="${ConstantesApp.CAMINHO_IMG }/thumbnail/tb_${img.nome_img }.jpg"
									alt="Card_${p.nome_produto }">
								</a>
							</c:forEach>
							<div class="card-body">
								<p class="card-text">${p.nome_produto }</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-2"></div>
</div>



<c:import url="footer.jsp"></c:import>
<c:import url="rodape.jsp"></c:import>