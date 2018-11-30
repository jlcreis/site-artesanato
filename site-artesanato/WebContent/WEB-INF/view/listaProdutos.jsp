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
				
  </div>
</div>


</c:forEach>
</div>

<c:import url="rodape.jsp"></c:import>