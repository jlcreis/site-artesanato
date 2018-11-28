<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="java.util.List,br.com.projeto.modelo.Produto" %>

<c:import url="cabecalho.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

<style>

.card {
	background-color: #e9ecef;
}
.card-columns {
	column-count: 5;
	column-gap: 0.4rem;
}

.card-body{
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
			<li class="nav-item">
				<a class="btn btn-primary" role="button" href="/site-artesanato/entrada?acao=NovoProdutoForm">Adicionar Produto</a>
			</li>
		</ul>
	</div>
</div>

<div class="card-columns">
<c:forEach items="${produtos}" var="produto">


<div class="card">
	<c:forEach items="${produto.lista_imagens }" var="img">
	<a href="/site-artesanato/entrada?acao=MostraProduto&id=${produto.id_produto}">
  <img class="card-img-top" src="img/${img.nome_img }.jpg" alt="Card image cap"></a></c:forEach>
  <div class="card-body">
    <h5 class="card-title"><span class="lead">${produto.nome_produto }</span></h5>
<%--     <p class="card-text">${produto.descricao_produto }</p> --%>
    				<!-- Modal Button removeProduto -->
<!-- 				<button type="button" class="btn btn-outline-secondary btn-sm" -->
<!-- 					data-toggle="modal" -->
<%-- 					data-target="#removeProduto_${produto.id_produto}"> --%>
<!-- 					X</button>   -->
				
  </div>
</div>


</c:forEach>
</div>
<ul class="list-group">
		<c:forEach items="${produtos}" var="produto">
			<li class="list-group-item"> 
			<div class="row align-items-top">
	<div class="col">
				<p class="lead"><strong>${produto.nome_produto }</strong></p>
				<p class="lead">${produto.descricao_produto }. </p>
				<p class="lead">
         			<fmt:formatNumber value = "${produto.valor_produto }" type = "currency"/>.
         			<label>Categoria </label>
					${produto.categoria.nome_categoria }.</p> </div>
					<div class="col">
				<div class="btn-group float-right" role="group">
				<a class="btn btn-outline-secondary btn-sm" role="button" href="/site-artesanato/entrada?acao=MostraProduto&id=${produto.id_produto}">Ver</a>
				<!-- Modal Button removeProduto -->
				<button type="button" class="btn btn-outline-secondary btn-sm"
					data-toggle="modal"
					data-target="#removeProduto_${produto.id_produto}">
					Remover</button>  
				</div></div></div>
			</li>
			
			<!-- Modal removeProduto -->
<%-- 		<div class="modal fade" id="removeProduto_${produto.id_produto}" --%>
<!-- 			tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" -->
<!-- 			aria-hidden="true"> -->
<!-- 			<div class="modal-dialog" role="document"> -->
<!-- 				<div class="modal-content"> -->
<!-- 					<div class="modal-header"> -->
<!-- 						<h5 class="modal-title" id="exampleModalLabel">Atenção!</h5> -->
<!-- 						<button type="button" class="close" data-dismiss="modal" -->
<!-- 							aria-label="Close"> -->
<!-- 							<span aria-hidden="true">&times;</span> -->
<!-- 						</button> -->
<!-- 					</div> -->
<!-- 					<div class="modal-body"> -->
<%-- 						Tem certeza que deseja remover o produto <strong>${produto.nome_produto }</strong> --%>
<!-- 						? -->
<!-- 					</div> -->
<!-- 					<div class="modal-footer"> -->
<!-- 						<button type="button" class="btn btn-secondary" -->
<!-- 							data-dismiss="modal">Não</button> -->
<!-- 						<a class="btn btn-danger" role="button" -->
<%-- 							href="/site-artesanato/entrada?acao=RemoveProduto&id=${produto.id_produto}">Sim</a> --%>
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		</c:forEach>
</ul>

<c:import url="rodape.jsp"></c:import>